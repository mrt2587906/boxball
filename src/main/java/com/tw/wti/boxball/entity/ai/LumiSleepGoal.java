package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.entity.ai.goal.Goal;



public class LumiSleepGoal
extends Goal {



    private final LumiEntity lumi;





    public LumiSleepGoal(
            LumiEntity entity
    ){

        lumi = entity;

    }






    @Override
    public boolean canStart(){


        return lumi.getWorld()
        .isNight()

        &&

        !lumi.isSitting();

    }






    @Override
    public void start(){


        lumi.setSleeping(true);


        lumi.getNavigation()
        .stop();


    }





    @Override
    public boolean shouldContinue(){


        return lumi.getWorld()
        .isNight();


    }





    @Override
    public void stop(){


        lumi.setSleeping(false);


    }



}