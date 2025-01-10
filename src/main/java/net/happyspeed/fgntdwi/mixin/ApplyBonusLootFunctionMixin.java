package net.happyspeed.fgntdwi.mixin;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.happyspeed.fgntdwi.FortuneStatMod;
import net.happyspeed.fgntdwi.config.ModConfigs;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootingEnchantLootFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(value = ApplyBonusLootFunction.class, priority = 502)
abstract class ApplyBonusLootFunctionMixin extends ConditionalLootFunction {

    protected ApplyBonusLootFunctionMixin(LootCondition[] conditions) {
        super(conditions);
    }

    @ModifyExpressionValue(method = "process", at = @At(value = "INVOKE", target = "Lnet/minecraft/enchantment/EnchantmentHelper;getLevel(Lnet/minecraft/enchantment/Enchantment;Lnet/minecraft/item/ItemStack;)I"))
    public int playerFortuneLootMultiplier(int original, @Local(ordinal = 0, argsOnly = true) LootContext context) {
        if (context.get(LootContextParameters.THIS_ENTITY) instanceof PlayerEntity player) {
            return original + Math.round(Math.min(player.experienceLevel * (float) ModConfigs.BLOCKSLEVELFACTOR, ModConfigs.BLOCKSMAXLEVELCAP));
        }
        return original;
    }
}
