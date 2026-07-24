package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.entity.ai.goal.Goal;



public class LumiPlayGoal
extends Goal {



    private final LumiEntity lumi;



    public LumiPlayGoal(
            LumiEntity entity
    ){

        lumi = entity;

    }






    @Override
    public boolean canStart(){


        return lumi.getHappiness() > 70

        &&

        lumi.getRandom()
        .nextInt(300)==0;


    }







    @Override
    public void start(){


        lumi.doJump();


    }



}