package com.tw.wti.boxball.registry;


import com.tw.wti.boxball.BoxBallMod;
import com.tw.wti.boxball.item.LumiSpawnItem;
import com.tw.wti.boxball.item.LumiSpawnEggItem;


import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import net.minecraft.util.Identifier;


public class ModItems {



    public static final Item LUMI_SPAWN = register(
            "lumi_spawn",
            new LumiSpawnItem(
                    new Item.Settings()
            )
    );



    public static final Item LUMI_BALL = register(
            "lumi_ball",
            new Item(
                    new Item.Settings()
            )
    );



    public static final Item CARDBOARD_BOX = register(
            "cardboard_box",
            new Item(
                    new Item.Settings()
            )
    );





    private static Item register(
            String name,
            Item item
    ){

        return Registry.register(

                Registries.ITEM,

                new Identifier(
                        BoxBallMod.MOD_ID,
                        name
                ),

                item
        );

    }






    public static void registerModItems(){

        BoxBallMod.LOGGER.info(
                "Registering Items for "
                + BoxBallMod.MOD_ID
        );

    }
	
	public static final Item LUMI_SPAWN_EGG =
        register(
                "lumi_spawn_egg",
                new LumiSpawnEggItem(
                        new Item.Settings()
                )
        );


}