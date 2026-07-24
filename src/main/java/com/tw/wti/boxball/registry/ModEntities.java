package com.tw.wti.boxball.registry;


import com.tw.wti.boxball.BoxBallMod;

import com.tw.wti.boxball.entity.LumiEntity;
import com.tw.wti.boxball.entity.CardboardBoxEntity;


import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;

import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

import net.minecraft.util.Identifier;
import com.tw.wti.boxball.registry.ModEntities;



public class ModEntities {



    public static EntityType<LumiEntity> LUMI;


    public static EntityType<CardboardBoxEntity> CARDBOARD_BOX;
	
	
	public static void registerModEntities() {
        BoxBallMod.LOGGER.info("Registering Mod Entities");
    }





    public static void register(){



        /*
         * Lumi
         */


        LUMI = Registry.register(


            Registries.ENTITY_TYPE,


            new Identifier(

                BoxBallMod.MOD_ID,

                "lumi"

            ),



            EntityType.Builder
            .create(

                LumiEntity::new,

                SpawnGroup.CREATURE

            )


            .setDimensions(

                0.55F,

                0.75F

            )


            .build(

                "lumi"

            )



        );









        /*
         * 紙箱 Entity
         */


        CARDBOARD_BOX = Registry.register(


            Registries.ENTITY_TYPE,


            new Identifier(

                BoxBallMod.MOD_ID,

                "cardboard_box"

            ),



            EntityType.Builder
            .create(

                CardboardBoxEntity::new,

                SpawnGroup.MISC

            )


            .setDimensions(

                0.8F,

                0.5F

            )


            .build(

                "cardboard_box"

            )



        );




    }



}