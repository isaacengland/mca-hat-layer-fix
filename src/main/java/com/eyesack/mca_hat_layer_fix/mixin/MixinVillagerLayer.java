package com.eyesack.mca_hat_layer_fix.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.conczin.mca.client.render.layer.VillagerLayer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings({"rawtypes", "unchecked"})
@Mixin(value = VillagerLayer.class, remap = false)
public abstract class MixinVillagerLayer {

    @Shadow
    public HumanoidModel model;

    @Unique
    private boolean mcaHatFix$savedHatVisible;

    @Inject(method = "renderFinal", at = @At("HEAD"))
    private void mcaHatFix$beforeRenderFinal(
            PoseStack transform,
            MultiBufferSource provider,
            int light,
            LivingEntity villager,
            float tickDelta,
            boolean visible,
            boolean glowing,
            CallbackInfo ci) {

        mcaHatFix$savedHatVisible = model.hat.visible;
        if (!villager.getItemBySlot(EquipmentSlot.HEAD).isEmpty()) {
            model.hat.visible = false;
        }
    }

    @Inject(method = "renderFinal", at = @At("RETURN"))
    private void mcaHatFix$afterRenderFinal(
            PoseStack transform,
            MultiBufferSource provider,
            int light,
            LivingEntity villager,
            float tickDelta,
            boolean visible,
            boolean glowing,
            CallbackInfo ci) {

        model.hat.visible = mcaHatFix$savedHatVisible;
    }
}