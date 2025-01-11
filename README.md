minecraft mod that eliminates the need for fortune and looting by giving loot drop bonuses based on XP level. Configurable.

Config Guide:

"blocks_max_level_cap": The max block "fortune" level you can get as
a player.

"blocks_level_factor": A percent number that influences the amount of levels
you need to reach "maximum effectiveness" or "blocks_max_level_cap".

Formula: fortune level = round (player_experience_level x "blocks_level_factor")

fortune level can't be more than "blocks_max_level_cap"


"entities_max_level_cap": The max entity "looting" level you can get as
a player.


"entities_level_factor": A percent number that influences the amount of levels
you need to reach "maximum effectiveness" or "entities_max_level_cap".

Formula: looting level = round (player_experience_level x "looting_level_factor")

looting level can't be more than "entities_max_level_cap"

ALL CONFIG OPTIONS ABOVE THIS ARE ONLY USEFUL IF "use_xp_stat" is true.


"luck_stat_multiplier": A percent number that influences the luck attribute level
you need to reach "maximum effectiveness" (UNCAPPED).
Only useful if "use_luck_stat" is true.


"use_xp_stat": If true, Xp increases block and entity drop bonuses.


"use_luck_stat": If true, Luck Attribute increases block and entity drop bonuses.

"use_xp_stat" and "use_luck_stat" STACK.


"direct_bonus": Levels Directly add to the Drop amount.
Example: You have 2 "fortune levels". All fortune affected ores drop 2 more ore, no rng.
Disables RNG of bonuses in favor for linear bonuses.