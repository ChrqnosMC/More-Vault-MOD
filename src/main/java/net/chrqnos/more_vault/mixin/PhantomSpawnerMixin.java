package net.chrqnos.more_vault.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.chrqnos.more_vault.effect.CustomEffects;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.spawner.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import java.util.List;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {
    @ModifyExpressionValue(method = "spawn", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/world/ServerWorld;getPlayers()Ljava/util/List;"))
    private List<ServerPlayerEntity> filterOutPlayersWithEffect(List<ServerPlayerEntity> original) {
        return original.stream().filter(serverPlayer -> !serverPlayer.hasStatusEffect(CustomEffects.DREAMING)).toList();
    }
}