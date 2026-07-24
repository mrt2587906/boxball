package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.entity.ai.goal.WanderAroundFarGoal;



public class LumiIdleGoal
extends WanderAroundFarGoal {



    public LumiIdleGoal(

            LumiEntity lumi

    ){


        super(

            lumi,

            0.8D

        );


    }


}