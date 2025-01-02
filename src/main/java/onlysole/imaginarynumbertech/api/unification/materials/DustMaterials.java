package onlysole.imaginarynumbertech.api.unification.materials;

import gregtech.api.unification.material.Material;

import static gregtech.api.unification.material.Materials.*;
import static gregtech.api.unification.material.info.MaterialIconSet.DULL;
import static gregtech.api.util.GTUtility.gregtechId;
import static onlysole.imaginarynumbertech.api.unification.INTMaterials.*;

public class DustMaterials {
    private static int startId = 27001;
    private static final int END_ID = startId + 1000;
    public static void register() {
        DragonDust = new Material.Builder(getMaterialsId(), gregtechId("dragon_dust"))
                .ore(1, 1, true)
                .addOreByproducts(Amethyst)
                .dust()
                //.color(Draconium.getMaterialRGB()) TODO
                .iconSet(DULL)
                .build()
                .setFormula("Dc₃Ac₃Se₄At₄", false);

        CopperSulfatePentahydrate = new Material.Builder(getMaterialsId(), gregtechId("copper_sulfate_pentahydrate"))
                .dust()
                .color(0x5AAAFF)
                .flags(NOR)
                .build()
                .setFormula("CuSO₄∙(H₂O)₅", true);

        CopperSulfate = new Material.Builder(getMaterialsId(), gregtechId("copper_sulfate"))
                .dust()
                .color(0xC8C8C8)
                .flags(NOR)
                .components(Copper, 1,Sulfur, 1,Oxygen, 4)//CuSO₄
                .build();

        CyanoaceticAcid = new Material.Builder(getMaterialsId(), gregtechId("cyanoacetic_acid"))
                .dust()
                .color(0x828228)
                .flags(NOR)
                .components(Carbon, 3,Hydrogen, 3,Nitrogen, 1,Oxygen, 2)//C₃H₃NO₂
                .build();

        SodiumCyanide = new Material.Builder(getMaterialsId(), gregtechId("sodium_cyanide"))
                .dust()
                .color(0xB4BEFF)
                .flags(NOR)
                .components(Sodium, 1,Carbon, 1,Nitrogen, 1)//NaCN
                .build();








    }

    private static int getMaterialsId() {
        if (startId < END_ID) {
            return startId++;
        }
        throw new ArrayIndexOutOfBoundsException();
    }
}
