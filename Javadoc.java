public @interface Javadoc {

/*
*
* ULV = 0
*
* 基础 - basics -
* [Basics] - LV - MV = 1 - 2
*
* 进阶 - advanced -
* [Advanced] - HV - EV = 3 - 4
*
* 精英 - elite -
* [Elite] - IV - LuV = 5 - 6
*
* 生物 - gooware -
* [Gooware] - ZPM = 7
*
* 光学 - gooware -
* [Gooware] - UV = 8
*
* 自旋电子学 - spintronic -
* [Spintronic] - UHV = 9
*
* 寰宇 - cosmic -
* [Cosmic] - UEV = 10
*
* 虚空 - void -
 * [Void] - UIV = 11
*
* 超因果 - supra_causal -
* [Supra_Causal] - UXV = 12
*
* 超时空 - supra_chronal -
* [Supra_Chronal] - OpV = 13
*
* 超维度 - supra_dimension -
* [Supra_Dimension] - MAX = 14
*
* 虚数 - imaginary_number -
* [Imaginary_Number] - INT = ∞
*
*/
/*
.itemInputs()
.itemOutputs()
.fluidInputs()
.fluidOutputs()
*/
/*
  材料注册
  <p>
  所有材料建设者应遵循以下通用格式:
  <p>
  material = new MaterialBuilder(id, gregtechId("name"))
  .ingot()          <--- 类型:锭
  .fluid()          <--- 类型:流体
  .ore()            <--- 类型:矿石
  .dust()           <--- 类型:粉
  .plasma()         <--- 类型:等离子气体
  .liquid(new FluidBuilder()//液体
  .temperature(600)//自定义温度
  .customStill()//自定义材质
  .alternativeName("seed.oil")//替代名称
  .attribute(FluidAttributes.ACID)//属性（流体属性）
  .translation("tooltip=")
  )

  .color().iconSet()                    <--- 外观
  .flags()                              <--- 特殊生成
  .element() / .components()            <--- 成分
  .toolStats(ToolProperty.Builder.of(7.0F, 6.0F, 2560, 3) )  <---工具统计信息
  .oreByProducts()                         | 附加属性
  ...                                   <---
  .itemPipeProperties(2048, 1)          <---管道特性
  .rotorStats(15.0f, 7.0f, 3000)        <---转子统计
  .attackSpeed(0.1F).enchantability(21).build())             <---攻击速度
  .blast(1700, GasTier.LOW)
  .blast(b -> b
                .temp(temp, tier)
                .blastStats(blastEUt, blastDuration)//爆炸
                .vacuumStats(vacuumEUt, vacuumDuration));//真空              <--- 鼓风温度
  .build();
  .setFormula("NH4Cl", true);           <---设置公式
  <p>
  使用默认值对您有利！一些默认值:
  - iconSet: DULL
  - color: 0xFFFFFF
  .dust().iconSet(SHINY)
  .fluid().iconSet(METALLIC)
  常用上标 ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹ ⁺ ⁻ ⁼ ⁽ ⁾ ⁿ º ˙
  常用下标₀ ₁ ₂ ₃ ₄ ₅ ₆ ₇ ₈ ₉ ₊ ₋ ₌ ₍ ₎ ₐ ₑ ₒ ₓ ₔ
  中文上标 ㆒㆓㆔㆕㆖㆗㆘㆙㆚㆛㆜㆝㆞㆟
  更多上标 ᵃ ᵇ ᶜ ᵈ ᵉ ᵍ ʰ ⁱ ʲ ᵏ ˡ ᵐ ⁿ ᵒ ᵖ ᵒ ʳ ˢ
  ᵗ ᵘ ᵛ ʷ ˣ ʸ ᙆ ᴬ ᴮ ᒼ ᴰ ᴱ ᴳ ᴴ ᴵ ᴶ ᴷ ᴸ ᴹ ᴺ ᴼ
  ᴾ ᴼ̴ ᴿ ˢ ᵀ ᵁ ᵂ ˣ ᵞ ᙆ ˀ ˁ ˤ ʱ ʴ ʵ ʶ ˠ ᴭ ᴯ ᴲ
  ᴻ ᴽ ᵄ ᵅ ᵆ ᵊ ᵋ ᵌ ᵑ ᵓ ᵚ ᵝ ᵞ ᵟ ᵠ ᵡ ᵎ ᵔ ᵕ ᵙ ᵜ ᶛ
  ᶜ ᶝ ᶞ ᶟ ᶡ ᶣ ᶤ ᶥ ᶦ ᶧ ᶨ ᶩ ᶪ ᶫ ᶬ ᶭ ᶮ ᶯ ᶰ ᶱ ᶲ ᶳ ᶴ ᶵ ᶶ ᶷ ᶸ ᶹ ᶺ
  ᶼ ᶽ ᶾ ᶿ ჼ ᒃ ᕻ ᑦ ᒄ ᕪ ᑋ ᑊ ᔿ ᐢ ᣕ ᐤ ᣖ ᣴ ᣗ ᔆ ᙚ ᐡ ᘁ ᐜ ᕽ ᙆ ᙇ
  ᒼ ᣳ ᒢ ᒻ ᔿ ᐤ ᣖ ᣵ ᙚ ᐪ ᓑ ᘁ ᐜ ᕽ ᙆ ᙇ ⁰ ¹ ² ³ ⁴ ⁵ ⁶ ⁷ ⁸ ⁹ ⁺ ⁻ ⁼ ˂ ˃ ⁽ ⁾ ˙ * º
  更多下标 ₐ ₔ ₑ ᵢ ₒ ᵣ ᵤ ᵥ ₓ ᙮ ᵤ ᵩ ᵦ ˪ ៳ ៷ ₒ ᵨ ៴ ᵤ ᵪ ᵧ
 */
/*
⟁✯☯∞❆☒☾☽❅☸✩❄♛☠✻✭⁂✲✶❈✤✴❊✸✵✡✮✧ꕤ⇱⇲⇤⇥▣❖◈⋄⟁◬⧋⊘⦾◌◎⊛ℂ℈℄Ω∑∴∵¤۞✡☪

*/

/*
MaterialFlag

  .flags()

//GENERIC=通用

 NO_UNIFICATION=添加到材料以完全禁用其统一
 DECOMPOSITION_BY_ELECTROLYZING=能够生成电解机分解配方
 DECOMPOSITION_BY_CENTRIFUGING=能够生成离心机分解配方
 DISABLE_DECOMPOSITION=禁用此材料的分解配方生成
 EXPLOSIVE=添加到材料中，会有爆炸性
 FLAMMABLE=添加到材料中，会有易燃性
 STICKY=添加到材料中，会有粘性

//DUST=粉

          <---生成此材料的板
          <---如果是粉末材料，就会产生压缩机，板配方
          <---如果是金属材料，将生成卷板机配方
          <---如果是方块材料，还将生成切割机配方

GENERATE_PLATE=生成板
GENERATE_DOUBLE_PLATE=生成双重板
GENERATE_ROD=生成杆
GENERATE_BOLT_SCREW=生成螺栓螺钉
GENERATE_FRAME=生成框架
GENERATE_GEAR=生成齿轮
GENERATE_LONG_ROD=生成长杆
FORCE_GENERATE_BLOCK=强制生成块

EXCLUDE_BLOCK_CRAFTING_RECIPES=排除制作方块配方
EXCLUDE_PLATE_COMPRESSOR_RECIPE=排除压缩机，板配方

EXCLUDE_BLOCK_CRAFTING_BY_HAND_RECIPES=排除工作台制作的方块配方
MORTAR_GRINDABLE=研磨

NO_WORKING=不能通过除粉碎或熔炼以外的任何其他方式进行加工
NO_SMASHING=不能用于常规金属加工技术，禁用卷板机配方
NO_SMELTING=禁用合金炉配方

铁，黄铁矿，生铁，锻铁
BLAST_FURNACE_CALCITE_DOUBLE=高炉双倍
BLAST_FURNACE_CALCITE_TRIPLE=高炉三倍

//FLUID=流体

SOLDER_MATERIAL=焊接材料
SOLDER_MATERIAL_BAD=焊接材料不良
SOLDER_MATERIAL_GOOD=焊接材料良好

//INGOT=锭

GENERATE_FOIL=生成箔
GENERATE_RING=生成环
GENERATE_SPRING=生成弹簧
GENERATE_SPRING_SMALL=生成小弹簧
GENERATE_SMALL_GEAR=生成小齿轮
GENERATE_FINE_WIRE=生成细导线
GENERATE_ROTOR=生成转子
GENERATE_DENSE=生成致密板
GENERATE_ROUND=生成滚珠
IS_MAGNETIC=具有磁性

//GEM=宝石

CRYSTALLIZABLE=可结晶的
GENERATE_LENS=生成透镜

//ORE=矿石

HIGH_SIFTER_OUTPUT=筛选器

*/

/*
PropertyKey

INGOT=锭
DUST=粉
FLUID=流体
GEM=宝石
ORE=矿石


 */

/*
代码	官方名称
§0	黑色
§1	深蓝色
§2	深绿色
§3	湖蓝色
§4	深红色
§5	紫色
§6	金色
§7	灰色
§8	深灰色
§9	蓝色
§a	绿色
§b	天蓝色
§c	红色
§d	粉红色
§e	黄色
§f	白色
§k	随机字符
§l	粗体
§m	删除线
§n	下划线
§o	斜体
§r	重置
/n	换行
*/


//checkEnergyln: false/true
//检查能量输入
//checkMaintenance: false/true
//检查维护
//checkltemln: false/true
//检查物品输入
//checkltemOut: false/true
//检查物品输出
//checkFluidIn: false/true
//检查流体输入
//checkFluidOut: false/true
//检查液体输出
//checkMuffler: false/true
//检查消声器
}
