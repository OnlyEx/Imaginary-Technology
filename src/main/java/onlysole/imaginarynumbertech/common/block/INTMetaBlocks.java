package onlysole.imaginarynumbertech.common.block;

import onlysole.imaginarynumbertech.common.block.blocks.*;
import onlysole.imaginarynumbertech.common.block.blocks.assembly.BlockAdvancedAssemblyLineCasing;
import onlysole.imaginarynumbertech.common.block.blocks.assembly.BlockComponentAssemblyLineCasing;
import onlysole.imaginarynumbertech.common.block.blocks.dimension.BlockDimensionCasing;
import onlysole.imaginarynumbertech.common.block.blocks.dimension.BlockDimensionWireCoil;
import onlysole.imaginarynumbertech.common.block.blocks.machinel.BlockMachinelCasing;
import onlysole.imaginarynumbertech.common.block.blocks.machinel.BlockMachinelCasingA;
import onlysole.imaginarynumbertech.common.block.blocks.machinel.BlockMachinelCasingB;
import onlysole.imaginarynumbertech.common.block.blocks.quantum.BlockQuantumForceTransformerCasing;
import onlysole.imaginarynumbertech.common.block.blocks.quantum.BlockQuantumForceTransformerGlassCasing;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static gregtech.common.blocks.MetaBlocks.statePropertiesToString;

public class INTMetaBlocks {
    //dimension
    public static BlockDimensionWireCoil NT_WIRE_COIL;//线圈
    public static BlockDimensionCasing DIMENSION_CASING;


    //glass
    public static BlockBoronSilicateGlassCasing BORON_SILICATE_GLASS_CASING;//强化硅酸盐硼玻璃-1

    //control
    public static BlockControlCasing CONTROL_CASING;//控制外壳-1

    //machinel
    public static BlockMachinelCasing MACHINE_CASING;//机械外壳-1
    public static BlockMachinelCasingA MACHINE_CASING_A;//机械外壳-2
    public static BlockMachinelCasingB MACHINE_CASING_B;//机械外壳-3

    //pipeline
    public static BlockPipelinelCasing PIPELINE_CASING;//管道外壳-1

    //quantum
    public static BlockQuantumForceTransformerCasing QUANTUM_FORCE_TRANSFORMER_CASING;//量子操纵者外壳
    public static BlockQuantumForceTransformerGlassCasing QUANTUM_FORCE_TRANSFORMER_GLASS_CASING;//量子操纵者玻璃 TODO XX

    //Assembly
    public static BlockComponentAssemblyLineCasing COMPONENT_ASSEMBLY_LINE_CASING;//部件装配线外壳
    public static BlockAdvancedAssemblyLineCasing ADVANCED_ASSEMBLY_LINE_CASING;//进阶装配线外壳

    public static BlockActiveMultiblockCasing ACTIVE_MULTIBLOCK_CASING;//活跃多块外壳 TODO XX
    public static BlockPackagingline PACKAGING_LINE;//封装线外壳
    public static BlockPCBFactoryCasing PCB_FACTORY_CASING;//PCB
    public static BlockADVFactoryCasing ADV_FACTORY_CASING;//ADV
    public static BlockDHPCAFactoryCasing DHPCA_FACTORY_CASING;//DHPCA TODO XX


    private INTMetaBlocks() {}
    public static void init() {
        NT_WIRE_COIL = new BlockDimensionWireCoil();
        NT_WIRE_COIL.setRegistryName("wire_coil");
        BORON_SILICATE_GLASS_CASING = new BlockBoronSilicateGlassCasing();
        BORON_SILICATE_GLASS_CASING.setRegistryName("boron_silicate_glasses_casing");
        CONTROL_CASING = new BlockControlCasing();
        CONTROL_CASING.setRegistryName("control_casing");
        MACHINE_CASING = new BlockMachinelCasing();
        MACHINE_CASING.setRegistryName("machine_casing");
        PACKAGING_LINE = new BlockPackagingline();
        PACKAGING_LINE.setRegistryName("packaging_line");
        COMPONENT_ASSEMBLY_LINE_CASING = new BlockComponentAssemblyLineCasing();
        COMPONENT_ASSEMBLY_LINE_CASING.setRegistryName("component_assembly_line_casing");
        ADVANCED_ASSEMBLY_LINE_CASING = new BlockAdvancedAssemblyLineCasing();
        ADVANCED_ASSEMBLY_LINE_CASING.setRegistryName("advanced_assembly_line_casing");
        PIPELINE_CASING = new BlockPipelinelCasing();
        PIPELINE_CASING.setRegistryName("pipelinel_casing");
        ACTIVE_MULTIBLOCK_CASING = new BlockActiveMultiblockCasing();
        ACTIVE_MULTIBLOCK_CASING.setRegistryName("active_multiblock_casing");
        QUANTUM_FORCE_TRANSFORMER_CASING = new BlockQuantumForceTransformerCasing();
        QUANTUM_FORCE_TRANSFORMER_CASING.setRegistryName("quantum_force_transformer_casing");
        QUANTUM_FORCE_TRANSFORMER_GLASS_CASING = new BlockQuantumForceTransformerGlassCasing();
        QUANTUM_FORCE_TRANSFORMER_GLASS_CASING.setRegistryName("quantum_force_transformer_glasses_casing");
        MACHINE_CASING_A = new BlockMachinelCasingA();
        MACHINE_CASING_A.setRegistryName("machine_casing_a");
        MACHINE_CASING_B = new BlockMachinelCasingB();
        MACHINE_CASING_B.setRegistryName("machine_casing_B");
        PCB_FACTORY_CASING = new BlockPCBFactoryCasing();
        PCB_FACTORY_CASING.setRegistryName("pcb_factory_casing");
        DIMENSION_CASING = new BlockDimensionCasing();
        DIMENSION_CASING.setRegistryName("dimension_casing");
        ADV_FACTORY_CASING = new BlockADVFactoryCasing();
        ADV_FACTORY_CASING.setRegistryName("adv_factory_casing");
        DHPCA_FACTORY_CASING = new BlockDHPCAFactoryCasing();
        DHPCA_FACTORY_CASING.setRegistryName("dhpca_factory_casing");

    }
    @SideOnly(Side.CLIENT)
    public static void registerItemModels() {
        registerItemModel(CONTROL_CASING);
        registerItemModel(MACHINE_CASING);
        registerItemModel(PACKAGING_LINE);
        registerItemModel(COMPONENT_ASSEMBLY_LINE_CASING);
        registerItemModel(ADVANCED_ASSEMBLY_LINE_CASING);
        registerItemModel(PIPELINE_CASING);
        registerItemModel(QUANTUM_FORCE_TRANSFORMER_CASING);
        registerItemModel(MACHINE_CASING_A);
        registerItemModel(MACHINE_CASING_B);
        registerItemModel(PCB_FACTORY_CASING);
        registerItemModel(DIMENSION_CASING);
        registerItemModel(ADV_FACTORY_CASING);
        registerItemModel(DHPCA_FACTORY_CASING);


        //  VariantActiveBlock Registry
        NT_WIRE_COIL.onModelRegister();
        BORON_SILICATE_GLASS_CASING.onModelRegister();
        ACTIVE_MULTIBLOCK_CASING.onModelRegister();
        QUANTUM_FORCE_TRANSFORMER_GLASS_CASING.onModelRegister();

    }

    @SideOnly(Side.CLIENT)
    private static void registerItemModel(Block block) {
        for (IBlockState state : block.getBlockState().getValidStates()) {
            // noinspection ConstantConditions
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block),
                    block.getMetaFromState(state),
                    new ModelResourceLocation(block.getRegistryName(),
                            statePropertiesToString(state.getProperties())));
        }
    }

}
