package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;


import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;



public class LumiFollowGoal
extends Goal {



    private final LumiEntity lumi;


    private PlayerEntity owner;



    private double speed = 1.1D;





    public LumiFollowGoal(
            LumiEntity entity
    ){

        this.lumi = entity;

    }








    @Override
    public boolean canStart(){



        if(lumi.isSitting())

            return false;



        owner =
        lumi.getWorld()
        .getClosestPlayer(

            lumi,

            10

        );



        return owner != null

        &&

        lumi.isOwner(owner);



    }








    @Override
    public void start(){



        lumi.getNavigation()
        .startMovingTo(

            owner,

            speed

        );


    }







    @Override
    public void tick(){



        if(owner != null){


            lumi.getNavigation()
            .startMovingTo(

                owner,

                speed

            );


        }


    }



}