package me.cryrobyte.expensive.mixin;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.client.gui.screen.ingame.ForgingScreen;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.AnvilScreenHandler;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(AnvilScreen.class)
public class MixinAnvilScreen extends ForgingScreen<AnvilScreenHandler> {

    @Shadow @Final private PlayerEntity player;

    public MixinAnvilScreen(AnvilScreenHandler handler, PlayerInventory playerInventory, Text title, Identifier texture) {
        super(handler, playerInventory, title, texture);
    }

    /**
     * @author Mojang - CryroByte
     * @reason Needed to overwrite due to the int J value not being set correctly
     */
    @Overwrite
    public void drawForeground(MatrixStack matrices, int mouseX, int mouseY) {
        RenderSystem.disableBlend();
        super.drawForeground(matrices, mouseX, mouseY);

        int i = this.handler.getLevelCost();
        if (i > 0) {
            int j = 8453920;
            Object text;
            if (!this.handler.getSlot(2).hasStack()) {
                text = null;
            } else {
                text = Text.translatable("container.repair.cost", i);
                if (!this.handler.getSlot(2).canTakeItems(this.player)) {
                    j = 16736352;
                }
            }

            if (text != null) {
                int k = this.backgroundWidth - 8 - this.textRenderer.getWidth((StringVisitable)text) - 2;
                fill(matrices, k - 2, 67, this.backgroundWidth - 8, 79, 1325400064);
                this.textRenderer.drawWithShadow(matrices, (Text)text, (float)k, 69.0F, j);
            }
        }
    }

}
