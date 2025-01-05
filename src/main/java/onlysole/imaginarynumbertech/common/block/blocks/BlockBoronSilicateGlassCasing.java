package onlysole.imaginarynumbertech.common.block.blocks;

import gregtech.api.GTValues;
import gregtech.api.block.VariantActiveBlock;
import gregtech.api.block.VariantItemBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import onlysole.imaginarynumbertech.api.block.ITierGlassBlockState;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

import static onlysole.imaginarynumbertech.common.CommonProxy.IMAGINARY_TAB;

public class BlockBoronSilicateGlassCasing extends VariantActiveBlock<BlockBoronSilicateGlassCasing.CasingType> {

    public BlockBoronSilicateGlassCasing() {
        super(Material.GLASS);
        this.setTranslationKey("boron_silicate_glasses_casing");
        this.setSoundType(SoundType.GLASS);
        this.setHarvestLevel("pickaxe", 3);
        this.setHardness(12.0F);
        this.setResistance(8.0F);
        this.setCreativeTab(IMAGINARY_TAB);
        this.setDefaultState(this.getState(CasingType.TI_BORON_SILICATE_GLASS_BLOCK));
        this.useNeighborBrightness = true;

    }//TODO 连接材质

    @Override
    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }

    @Override
    @Nonnull
    public BlockRenderLayer getRenderLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    public boolean canRenderInLayer(@Nonnull IBlockState state, @Nonnull BlockRenderLayer layer) {
//        EPBlockGlassCasing.CasingType type = getState(state);
//        if( type == CasingType.NAQ_BORON_SILICATE_GLASS
//        ) {
//            return super.canRenderInLayer(state, layer);
//        }
        return layer == BlockRenderLayer.TRANSLUCENT;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isOpaqueCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean isFullCube(@Nonnull IBlockState state) {
        return false;
    }

    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("deprecation")
    public boolean shouldSideBeRendered(@NotNull IBlockState state, IBlockAccess world, BlockPos pos,
                                        @NotNull EnumFacing side) {
        IBlockState sideState = world.getBlockState(pos.offset(side));

        return sideState.getBlock() == this ?
                getState(sideState) != getState(state) :
                super.shouldSideBeRendered(state, world, pos, side);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(@Nonnull ItemStack stack, @Nullable World player, @Nonnull List<String> tooltip, @Nonnull ITooltipFlag advanced) {
        super.addInformation(stack, player, tooltip, advanced);
        VariantItemBlock<CasingType, BlockBoronSilicateGlassCasing> itemBlock = (VariantItemBlock<CasingType, BlockBoronSilicateGlassCasing>) stack.getItem();
        IBlockState stackState = itemBlock.getBlockState(stack);
        CasingType casingType =  this.getState(stackState);
        tooltip.add(I18n.format("imaginarynumbertech.glass_tier.tooltip", casingType.getTireNameColored()));
        if (casingType.isOpticalGlass) {
            tooltip.add(casingType.getOpticalTierName());
        }
    }

    public enum CasingType implements IStringSerializable, ITierGlassBlockState {
        TI_BORON_SILICATE_GLASS_BLOCK("ti", GTValues.EV, true),
        W_BORON_SILICATE_GLASS_BLOCK("w", GTValues.IV, true),
        CTHY_BORON_SILICATE_GLASS_BLOCK("thy", GTValues.LuV, true),
        CR_BORON_SILICATE_GLASS_BLOCK("cr", GTValues.ZPM, true),
        IR_BORON_SILICATE_GLASS_BLOCK("ir", GTValues.UV, true),
        OS_BORON_SILICATE_GLASS_BLOCK("os", GTValues.UHV, true),
        NE_BORON_SILICATE_GLASS_BLOCK("ne", GTValues.UEV, true),
        SNE_BORON_SILICATE_GLASS_BLOCK("sne", GTValues.UIV, true);



        private final String name;
        private final int tier;
        private final boolean isOpticalGlass;

        CasingType(String name, int tier, boolean isOpticalGlass) {
            this.name = name;
            this.tier = tier;
            this.isOpticalGlass = isOpticalGlass;
        }

        @Nonnull
        @Override
        public String getName() {return this.name;}

        @Override
        public int getGlassTier() {return this.tier;}

        public boolean isOpticalGlass() {return isOpticalGlass;}

        @Nonnull
        @Override
        public String toString() {return getName();}
    }
}
