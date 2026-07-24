package com.tw.wti.boxball.registry;


import com.tw.wti.boxball.BoxBallMod;


import net.minecraft.block.Block;
import net.minecraft.block.Blocks;


import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;


import net.minecraft.util.Identifier;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;



public class ModBlocks {



    public static Block CARDBOARD_BOX;


    public static void registerModBlocks() {
        BoxBallMod.LOGGER.info("Registering Mod Blocks");
    }




    public static void register(){



        CARDBOARD_BOX = registerBlock(

            "cardboard_box",

            new Block(
                Block.Settings.create()
				     .strength(1.5F)				 
            )

        );



    }









    private static Block registerBlock(

            String name,

            Block block

    ){



        return Registry.register(


            Registries.BLOCK,


            new Identifier(

                BoxBallMod.MOD_ID,

                name

            ),


            block


        );



    }





}