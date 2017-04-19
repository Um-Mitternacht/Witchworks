package com.wiccanarts.common.util;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by BerciTheBeast on 19.4.2017.
 */
public class CommandIncantation implements ICommand {

	@Override
	public String getName() {
		return "incant";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "/incant [incantation]";
	}

	@Override
	public List<String> getAliases() {
		List<String> list = new ArrayList<String>();
		list.add("i");
		list.add(getName());
		return list;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) return;
		System.out.println(args[0]);
		EntityPlayer caster;
		caster = (EntityPlayer) sender.getCommandSenderEntity();
		if (caster == null) return;
		if (args[0].equalsIgnoreCase("BURN!"))
		{
			RayTraceResult rez = caster.rayTrace(3, 1.0F);
			EnumFacing side = rez.sideHit;
			BlockPos block = rez.getBlockPos();
			if (block != null && caster.getEntityWorld().getBlockState(block.offset(side)) == Blocks.AIR.getDefaultState()) {
				caster.getEntityWorld().playSound(null, block, SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.BLOCKS, 1.0F, 2F);
				caster.getEntityWorld().setBlockState(block.offset(side), Blocks.FIRE.getDefaultState());
			}
		} else if (args[0].equalsIgnoreCase("HEAL!"));
		{
			caster = (EntityPlayer) sender.getCommandSenderEntity();
			caster.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 500, 0));
		}
	}

	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
		return true;
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos pos) {
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		return false;
	}

	@Override
	public int compareTo(ICommand o) {
		return 0;
	}
}
