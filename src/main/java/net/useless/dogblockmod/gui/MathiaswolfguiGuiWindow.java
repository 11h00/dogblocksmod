
package net.useless.dogblockmod.gui;

import net.useless.dogblockmod.DogblockmodMod;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MathiaswolfguiGuiWindow extends ContainerScreen<MathiaswolfguiGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	private final static HashMap guistate = MathiaswolfguiGui.guistate;

	public MathiaswolfguiGuiWindow(MathiaswolfguiGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 184;
		this.ySize = 167;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.color4f(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "Mathias friend wolf", 43, 6, -1);
		this.font.drawString(ms, "Action", 77, 107, -1);
		this.font.drawString(ms, "Hi, i am a assistant wolf friend", 7, 21, -1);
		this.font.drawString(ms, "i am made just for you !", 7, 33, -1);
		this.font.drawString(ms, "Im unique and can't be obtained", 7, 45, -1);
		this.font.drawString(ms, "So please protect me !", 7, 59, -1);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 117, 46, 20, new StringTextComponent("bark"), e -> {
			if (true) {
				DogblockmodMod.PACKET_HANDLER.sendToServer(new MathiaswolfguiGui.ButtonPressedMessage(0, x, y, z));
				MathiaswolfguiGui.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 52, this.guiTop + 117, 46, 20, new StringTextComponent("howl"), e -> {
			if (true) {
				DogblockmodMod.PACKET_HANDLER.sendToServer(new MathiaswolfguiGui.ButtonPressedMessage(1, x, y, z));
				MathiaswolfguiGui.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 99, this.guiTop + 117, 40, 20, new StringTextComponent("Pet"), e -> {
			if (true) {
				DogblockmodMod.PACKET_HANDLER.sendToServer(new MathiaswolfguiGui.ButtonPressedMessage(2, x, y, z));
				MathiaswolfguiGui.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addButton(new Button(this.guiLeft + 5, this.guiTop + 140, 144, 20, new StringTextComponent("tp my friend wolf to me"), e -> {
			if (true) {
				DogblockmodMod.PACKET_HANDLER.sendToServer(new MathiaswolfguiGui.ButtonPressedMessage(3, x, y, z));
				MathiaswolfguiGui.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
