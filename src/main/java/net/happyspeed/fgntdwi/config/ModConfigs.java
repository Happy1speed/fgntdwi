package net.happyspeed.fgntdwi.config;

import com.mojang.datafixers.util.Pair;
import net.happyspeed.fgntdwi.FortuneStatMod;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static int BLOCKSMAXLEVELCAP;
    public static double BLOCKSLEVELFACTOR;

    public static int ENTITIESMAXLEVELCAP;
    public static double ENTITIESLEVELFACTOR;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(FortuneStatMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("blocks_max_level_cap", 10));
        configs.addKeyValuePair(new Pair<>("blocks_level_factor", 0.1));

        configs.addKeyValuePair(new Pair<>("entities_max_level_cap", 10));
        configs.addKeyValuePair(new Pair<>("entities_level_factor", 0.1));
    }

    private static void assignConfigs() {
        BLOCKSMAXLEVELCAP = CONFIG.getOrDefault("blocks_max_level_cap", 10);
        BLOCKSLEVELFACTOR = CONFIG.getOrDefault("blocks_level_factor", 0.1);

        ENTITIESMAXLEVELCAP = CONFIG.getOrDefault("entities_max_level_cap", 10);
        ENTITIESLEVELFACTOR = CONFIG.getOrDefault("entities_level_factor", 0.1);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}