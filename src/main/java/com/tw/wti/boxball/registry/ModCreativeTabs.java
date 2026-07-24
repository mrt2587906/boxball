package com.tw.wti.boxball.registry;


import com.tw.wti.boxball.BoxBallMod;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;


import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;


import net.minecraft.text.Text;


import net.minecraft.util.Identifier;




public class ModCreativeTabs {



    public static ItemGroup BOXBALL_TAB;







    public static void register(){



        BOXBALL_TAB =



        Registry.register(


            Registries.ITEM_GROUP,


            new Identifier(

                BoxBallMod.MOD_ID,

                "boxball"

            ),



            FabricItemGroup.builder()



            .icon(

                () -> new ItemStack(

                    ModItems.LUMI_SPAWN_EGG

                )

            )



            .displayName(

                Text.literal(

                    "BoxBall - Lumi"

                )

            )





            .entries(

                (displayContext, entries) -> {



                    /*
                     * Lumi 生成蛋
                     */

                    entries.add(

                        ModItems.LUMI_SPAWN_EGG

                    );





                    /*
                     * Lumi 玩球
                     */

                    entries.add(

                        ModItems.LUMI_BALL

                    );
					
					
					
					
					/*
                    * Lumi 紙箱
                    */

                    entries.add(
                        ModItems.CARDBOARD_BOX
                    );



                }


            )



            .build()



        );



    }



}