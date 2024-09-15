package net.chrqnos.more_vault;

import net.chrqnos.more_vault.effect.CustomEffects;
import net.fabricmc.api.ModInitializer;

public class MoreVault implements ModInitializer {
	public static final String MOD_ID = "more_vault";

	@Override
	public void onInitialize() {
		CustomEffects.registerStatusEffects();
	}
}