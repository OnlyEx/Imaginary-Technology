package onlysole.imaginarynumbertech.mixin.gregtech;

import gregtech.api.items.metaitem.MetaItem;
import gregtech.api.util.GTUtility;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import onlysole.imaginarynumbertech.api.items.metaitem.IRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = MetaItem.class, remap = false)
public abstract class MixinMetaItem extends Item {

    @Shadow
    protected abstract String formatModelPath(MetaItem<?>.MetaValueItem metaValueItem);

    @Redirect(
            method = "registerModels()V",
            at = @At(
                    value = "INVOKE",
                    target = "Lgregtech/api/items/metaitem/MetaItem;createItemModelPath(Lgregtech/api/items/metaitem/MetaItem$MetaValueItem;Ljava/lang/String;)Lnet/minecraft/util/ResourceLocation;"
            )
    )
    private ResourceLocation registerModels(MetaItem<?> metaItem, MetaItem<?>.MetaValueItem metaValueItem, String postfix) {
        ResourceLocation resourceLocation = GTUtility.gregtechId(this.formatModelPath(metaValueItem) + postfix);
        IRenderer itemRenderer = (IRenderer)metaValueItem;
        if (itemRenderer.getRendererManager() != null) {
            itemRenderer.getRendererManager().onRendererRegistry(resourceLocation);
        }
        return resourceLocation;
    }
}
