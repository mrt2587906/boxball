package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.entity.ai.goal.Goal;



public class LumiEmotionGoal
extends Goal {



    private final LumiEntity lumi;




    public LumiEmotionGoal(
            LumiEntity entity
    ){

        lumi = entity;

    }







    @Override
    public boolean canStart(){

        return true;

    }







    @Override
    public void tick(){



        int love =
        lumi.getHappiness();




        if(love >= 80){


            if(lumi.getRandom()
            .nextInt(200)==0){


                lumi.doJump();


            }


        }




    }



}