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

    public static double LUCKSTATMULTIPLIER;

    public static boolean USEXPSTAT;
    public static boolean USELUCKSTAT;

    public static boolean DIRECTBONUS;

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

        configs.addKeyValuePair(new Pair<>("luck_stat_multiplier", 0.0));

        configs.addKeyValuePair(new Pair<>("use_xp_stat", true));
        configs.addKeyValuePair(new Pair<>("use_luck_stat", false));

        configs.addKeyValuePair(new Pair<>("direct_bonus", false));
    }

    private static void assignConfigs() {
        BLOCKSMAXLEVELCAP = CONFIG.getOrDefault("blocks_max_level_cap", 10);
        BLOCKSLEVELFACTOR = CONFIG.getOrDefault("blocks_level_factor", 0.1);

        ENTITIESMAXLEVELCAP = CONFIG.getOrDefault("entities_max_level_cap", 10);
        ENTITIESLEVELFACTOR = CONFIG.getOrDefault("entities_level_factor", 0.1);

        LUCKSTATMULTIPLIER = CONFIG.getOrDefault("luck_stat_multiplier", 0.0);

        USEXPSTAT = CONFIG.getOrDefault("use_xp_stat", true);
        USELUCKSTAT = CONFIG.getOrDefault("use_luck_stat", false);

        DIRECTBONUS = CONFIG.getOrDefault("direct_bonus", false);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}