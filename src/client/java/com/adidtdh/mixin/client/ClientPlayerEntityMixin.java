package com.adidtdh.mixin.client;

import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.adidtdh.McCoordsMod.McCoordsMod;
import net.minecraft.client.network.ClientPlayerEntity;



//@Mixin(ClientPlayerEntity.class)
@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

	@Inject(at = @At("HEAD"), method = "tick")
	private void onTick(CallbackInfo ci) {
		McCoordsMod.tick();
	}
}
