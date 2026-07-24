package com.tw.wti.boxball.entity.ai;


import com.tw.wti.boxball.entity.LumiEntity;
import com.tw.wti.boxball.entity.CardboardBoxEntity;
import com.tw.wti.boxball.registry.ModEntities;


import net.minecraft.entity.ai.goal.Goal;


import net.minecraft.util.math.BlockPos;



public class LumiBoxGoal
extends Goal {



    private final LumiEntity lumi;





    public LumiBoxGoal(
            LumiEntity entity
    ){

        lumi = entity;

    }








    @Override
    public boolean canStart(){



        return

        !lumi.isHidingBox()

        &&

        (

            lumi.getWorld()
            .isRaining()

            ||

            lumi.getWorld()
            .isNight()

        );



    }








    @Override
    public void start(){



        BlockPos pos =

        lumi.getBlockPos();





        CardboardBoxEntity box =


        new CardboardBoxEntity(

            ModEntities.CARDBOARD_BOX,

            lumi.getWorld()

        );





        box.refreshPositionAndAngles(

            pos,

            0,

            0

        );





        box.setLumiUUID(

            lumi.getUuid()

        );





        lumi.hideInBox();



        lumi.setSleeping(true);



        lumi.setInvisible(true);





        lumi.getWorld()
        .spawnEntity(box);



    }



}