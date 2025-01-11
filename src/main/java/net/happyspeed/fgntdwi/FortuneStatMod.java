package net.happyspeed.fgntdwi;

import net.fabricmc.api.ModInitializer;

import net.happyspeed.fgntdwi.config.ModConfigs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FortuneStatMod implements ModInitializer {
	public static final String MOD_ID = "fgntdwi";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("fgntdwi!");
		ModConfigs.registerConfigs();

		//Todo Mod Icon and Fabric.mod github info
	}
}