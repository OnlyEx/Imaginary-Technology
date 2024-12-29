package onlysole.imaginarynumbertech.common.block.blocks.dimension;

import gregtech.api.block.VariantBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

import static onlysole.imaginarynumbertech.common.CommonProxy.IMAGINARY_TAB;

public class BlockDimensionCasing extends VariantBlock<BlockDimensionCasing.CasingType> {


    public BlockDimensionCasing() {
        super(Material.IRON);
        this.setTranslationKey("dimension_casing");
        this.setHardness(5.0F);
        this.setResistance(10.0F);
        this.setSoundType(SoundType.METAL);
        this.setCreativeTab(IMAGINARY_TAB);
        this.setHarvestLevel("wrench", 5);
        this.setDefaultState(this.getState(CasingType.MOTOR_BLOCK));
    }

    public boolean canCreatureSpawn(@Nonnull IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, @Nonnull EntityLiving.SpawnPlacementType type) {
        return false;
    }



    public enum CasingType implements IStringSerializable {

        MOTOR_BLOCK("motor_block"),
        ANNIHILATION("annihilation"),
        DIMENSIONAL("dimensional"),
        FIELD_GENERATOR("field_generator"),
        DIMENSION("dimension"),
        DIMENSION_COMPUTER("dimension_computer"),
        ADVANCED_DIMENSION_ENERGY("advanced_dimension_energy"),
        ULTIMATE_DIMENSION_ENERGY("ultimate_dimension_energy"),
        HOLLOW("hollow"),
        SPACETIME("spacetime");

        private final String name;

        CasingType(String name) {
            this.name = name;
        }

        @Nonnull
        @Override
        public String getName() {
            return name;
        }
    }
}
