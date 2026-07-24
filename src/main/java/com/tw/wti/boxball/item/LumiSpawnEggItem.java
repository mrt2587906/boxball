package com.tw.wti.boxball.item;


import com.tw.wti.boxball.entity.LumiEntity;
import com.tw.wti.boxball.registry.ModEntities;
import com.tw.wti.boxball.registry.ModSounds;


import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.Item;

import net.minecraft.util.ActionResult;

import net.minecraft.util.Hand;

import net.minecraft.util.hit.BlockHitResult;

import net.minecraft.util.hit.HitResult;

import net.minecraft.util.math.BlockPos;

import net.minecraft.world.World;

import net.minecraft.util.TypedActionResult;

import net.minecraft.item.SpawnEggItem;

import net.minecraft.item.ItemStack;
import net.minecraft.util.TypedActionResult;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import com.tw.wti.boxball.item.LumiSpawnEggItem;




public class LumiSpawnEggItem extends Item {



    public LumiSpawnEggItem(
            Settings settings
    ){

        super(settings);

    }





    @Override
    public TypedActionResult<ItemStack> use(

        World world,

        PlayerEntity player,

        Hand hand

    ){



        if(!world.isClient){



            LumiEntity lumi =

            new LumiEntity(

                ModEntities.LUMI,

                world

            );




            BlockPos pos =

            player.getBlockPos()
            .up();




            lumi.refreshPositionAndAngles(

                pos,

                player.getYaw(),

                0

            );




            lumi.setOwner(
                player
            );




            world.spawnEntity(
                lumi
            );





            world.playSound(

                null,

                pos,

                ModSounds.LUMI_HAPPY,

                net.minecraft.sound.SoundCategory.NEUTRAL,

                1F,

                1F

            );



        }



        return TypedActionResult.success(
            player.getStackInHand(hand)
        );


    }


}