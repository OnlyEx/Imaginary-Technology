package onlysole.avaritia.api;

import gregtech.api.items.metaitem.stats.IItemComponent;
import net.minecraft.util.ResourceLocation;

public interface IItemRendererManager extends IItemComponent {
    void onRendererRegistry(ResourceLocation location);

}
