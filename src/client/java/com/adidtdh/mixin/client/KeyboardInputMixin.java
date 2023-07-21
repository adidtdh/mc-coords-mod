package com.adidtdh.mixin.client;

import com.adidtdh.McCoordsMod.McCoordsMod;
import com.adidtdh.McCoordsMod.KeyboardHandeler;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.input.KeyboardInput;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(KeyboardInput.class)
public class KeyboardInputMixin {

	@Redirect(method = "tick", at = @At(
	value = "FIELD",
	target = "net/minecraft/client/input/KeyboardInput.pressingForward:Z",
	opcode = Opcodes.GETFIELD,
	ordinal = 0))
		private boolean onPressingForward(KeyboardInput input) {
			input.pressingForward = input.pressingForward || KeyboardHandeler.getUp();
			return input.pressingForward;
		}


	@Redirect(method = "tick", at = @At(
	value = "FIELD",
	target = "net/minecraft/client/input/KeyboardInput.pressingBack:Z",
	opcode = Opcodes.GETFIELD,
	ordinal = 0))
		private boolean onPressingBack(KeyboardInput input) {
			input.pressingBack = input.pressingBack || KeyboardHandeler.getDown();
			return input.pressingBack;
		}

	@Redirect(method = "tick", at = @At(
	value = "FIELD",
	target = "net/minecraft/client/input/KeyboardInput.pressingLeft:Z",
	opcode = Opcodes.GETFIELD,
	ordinal = 0))
		private boolean onPressingLeft(KeyboardInput input) {
			input.pressingLeft = input.pressingLeft || KeyboardHandeler.getLeft();
			return input.pressingLeft;
		}

	@Redirect(method = "tick", at = @At(
	value = "FIELD",
	target = "net/minecraft/client/input/KeyboardInput.pressingRight:Z",
	opcode = Opcodes.GETFIELD,
	ordinal = 0))
		private boolean onPressingRight(KeyboardInput input) {
			input.pressingRight = input.pressingRight || KeyboardHandeler.getRight();
			return input.pressingRight;
		}



}
