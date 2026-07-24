package com.tw.wti.boxball.item;



import com.tw.wti.boxball.entity.LumiEntity;

import com.tw.wti.boxball.registry.ModEntities;

import com.tw.wti.boxball.registry.ModSounds;



import net.minecraft.item.Item;

import net.minecraft.util.ActionResult;

import net.minecraft.util.Hand;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.world.World;

import net.minecraft.util.TypedActionResult;

import net.minecraft.item.ItemStack;





public class LumiSpawnItem
extends Item {



public LumiSpawnItem(
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




    lumi.setPosition(

        player.getX(),

        player.getY(),

        player.getZ()

    );





    lumi.setOwner(
        player
    );





    world.spawnEntity(
        lumi
    );





    world.playSound(

        null,

        player.getBlockPos(),

        ModSounds.LUMI_HAPPY,

        net.minecraft.sound.SoundCategory.NEUTRAL,

        1.0F,

        1.0F

    );



}





return TypedActionResult.success(
    player.getStackInHand(hand)
);


}


}