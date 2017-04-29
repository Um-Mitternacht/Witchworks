package com.witchworks.common.core.net;

import com.witchworks.api.BrewRegistry;
import com.witchworks.api.item.IBrew;
import com.witchworks.common.core.capability.potion.BrewStorageHandler;
import com.witchworks.common.core.capability.potion.IBrewStorage;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * This class was created by Arekkuusu on 24/04/2017.
 * It's distributed as part of Witchworks under
 * the MIT license.
 */
public class PotionMessage implements IMessage {

	private Set<IBrew> client;
	private UUID target;

	public PotionMessage() {
	}

	public PotionMessage(Set<IBrew> client, UUID uuid) {
		this.client = client;
		this.target = uuid;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		target = new UUID(buf.readLong(), buf.readLong());

		int size = buf.readInt();
		client = new HashSet<>(size);
		for (int i = 0; i < size; i++) {
			client.add(BrewRegistry.getBrewById(buf.readInt()));
		}
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeLong(target.getMostSignificantBits());
		buf.writeLong(target.getLeastSignificantBits());

		buf.writeInt(client.size());
		for (IBrew brew : client) {
			buf.writeInt(BrewRegistry.getBrewId(brew));
		}
	}

	public static class PotionMessageHandler implements IMessageHandler<PotionMessage, IMessage> {

		@Override
		public IMessage onMessage(PotionMessage message, MessageContext ctx) {
			Minecraft.getMinecraft().addScheduledTask(() -> {
				final EntityPlayer entityTarget = Minecraft.getMinecraft().world.getPlayerEntityByUUID(message.target);

				if (entityTarget != null) {
					Optional<IBrewStorage> optional = BrewStorageHandler.getBrewStorage(entityTarget);
					if (optional.isPresent()) {
						optional.get().setClient(message.client);
					}
				}
			});
			return null;
		}
	}
}
