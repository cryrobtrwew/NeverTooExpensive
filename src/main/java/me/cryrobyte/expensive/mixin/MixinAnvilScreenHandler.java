package me.cryrobyte.expensive.mixin;

import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AnvilScreenHandler.class)
public class MixinAnvilScreenHandler {

    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40, ordinal = 2))
    private int updateInt(int input) {
        return 9999999;
    }

}
