package com.adidtdh.McCoordsMod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ClientModInitializer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.PlayerEntity;

public class KeyboardHandeler implements ClientModInitializer {

	static boolean up = false;
	static boolean down = false;
	static boolean left = false;
	static boolean right = false;

	@Override
	public void onInitializeClient() {

	}

	public static void tick() {


	}

	public static boolean getUp(){
		return up;
	}
	public static boolean getDown(){
		return down;
	}
	public static boolean getLeft(){
		return left;
	}
	public static boolean getRight(){
		return right;
	}

	public static void setMovement(byte bufdata){
		up = (bufdata & (1 << 0)) == 1;
		down = (bufdata & (1 << 1)) == 1;
		left = (bufdata & (1 << 2)) == 1;
		right = (bufdata & (1 << 3)) == 1;

		System.out.println(bufdata);
	}
}

