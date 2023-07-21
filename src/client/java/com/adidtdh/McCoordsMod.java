package com.adidtdh.McCoordsMod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.ClientModInitializer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.Camera;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.player.PlayerEntity;

import java.io.*;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Scanner;

import java.util.Arrays;

public class McCoordsMod implements ClientModInitializer {

	public static final Logger LOGGER = LogManager.getLogger("McCoordsMod");
	static RandomAccessFile sc;
	static MappedByteBuffer out;


	@Override
	public void onInitializeClient() {

		try{
		sc = new RandomAccessFile("/tmp/gamepos.bin", "rw");
		out = sc.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 16);
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(32);
		}


	}

	public static void tick() {
		PlayerEntity p = MinecraftClient.getInstance().player;

		float[] posarr = new float[]{(float)p.getX(), (float)p.getY(), (float)p.getZ(), (float)p.getYaw()};

		try{
			out.asFloatBuffer().put(posarr);
			System.out.println(Arrays.toString(posarr));
		}
		catch(Exception e){
			System.out.println(e);
			System.exit(33);
		}

	}
}

