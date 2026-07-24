package com.tw.wti.boxball.entity;



import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;


import net.minecraft.entity.player.PlayerEntity;


import net.minecraft.nbt.NbtCompound;


import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;


import net.minecraft.world.World;


import java.util.UUID;
import java.util.List;




public class CardboardBoxEntity
extends PathAwareEntity {





    private UUID lumiUUID;






    public CardboardBoxEntity(

            EntityType<? extends CardboardBoxEntity> type,

            World world

    ){

        super(type, world);

    }









    @Override
    protected void initGoals(){


    }









    public void setLumiUUID(

            UUID uuid

    ){

        lumiUUID = uuid;


    }







    public UUID getLumiUUID(){


        return lumiUUID;


    }










    @Override
public ActionResult interactMob(
        PlayerEntity player,
        Hand hand
) {

    if (!getWorld().isClient) {

        if (lumiUUID != null) {

            List<LumiEntity> entities =
                    getWorld().getEntitiesByClass(
                            LumiEntity.class,
                            getBoundingBox().expand(128),
                            e -> e.getUuid().equals(lumiUUID)
                    );

            if (!entities.isEmpty()) {

                LumiEntity lumi = entities.get(0);

                lumi.leaveBox();

                lumi.setSleeping(false);

                lumi.setInvisible(false);

                lumi.refreshPositionAndAngles(
                        getX(),
                        getY(),
                        getZ(),
                        getYaw(),
                        getPitch()
                );
            }
        }

        discard();
    }

    return ActionResult.SUCCESS;
}









    @Override
    public void writeCustomDataToNbt(

            NbtCompound nbt

    ){



        super.writeCustomDataToNbt(nbt);




        if(lumiUUID != null){


            nbt.putUuid(

                "LumiUUID",

                lumiUUID

            );


        }



    }







    @Override
    public void readCustomDataFromNbt(

            NbtCompound nbt

    ){



        super.readCustomDataFromNbt(nbt);




        if(nbt.containsUuid("LumiUUID")){


            lumiUUID =

            nbt.getUuid(

                "LumiUUID"

            );


        }



    }



}