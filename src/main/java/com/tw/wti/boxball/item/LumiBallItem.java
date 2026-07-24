package com.tw.wti.boxball.item;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.item.Item;

import net.minecraft.util.ActionResult;

import net.minecraft.util.Hand;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.world.World;



public class LumiBallItem
extends Item {



public LumiBallItem(
        Settings settings
){

super(settings);

}





@Override
public ActionResult useOnEntity(

        net.minecraft.item.ItemStack stack,

        PlayerEntity player,

        net.minecraft.entity.LivingEntity entity,

        Hand hand

){



if(entity instanceof LumiEntity lumi){



    lumi.addHappiness(
        5
    );


    lumi.doJump();



    return ActionResult.SUCCESS;

}



return ActionResult.PASS;


}



}