package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.entity.LivingEntity;

import net.minecraft.entity.ai.goal.Goal;



public class LumiProtectGoal
extends Goal {



    private final LumiEntity lumi;


    private LivingEntity target;




    public LumiProtectGoal(
            LumiEntity entity
    ){

        lumi = entity;

    }







    @Override
    public boolean canStart(){


        target =
        lumi.getTarget();



        return target != null;


    }







    @Override
    public void start(){


        lumi.getNavigation()
        .startMovingTo(

            target,

            1.2D

        );


    }



}