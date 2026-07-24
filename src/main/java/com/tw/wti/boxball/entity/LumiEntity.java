package com.tw.wti.boxball.entity;


import com.tw.wti.boxball.entity.ai.LumiBoxGoal;
import com.tw.wti.boxball.entity.ai.LumiEmotionGoal;
import com.tw.wti.boxball.entity.ai.LumiFollowGoal;
import com.tw.wti.boxball.entity.ai.LumiIdleGoal;
import com.tw.wti.boxball.entity.ai.LumiPlayGoal;
import com.tw.wti.boxball.entity.ai.LumiProtectGoal;
import com.tw.wti.boxball.entity.ai.LumiSleepGoal;


import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.SwimGoal;

import net.minecraft.entity.mob.PathAwareEntity;

import net.minecraft.entity.player.PlayerEntity;

import net.minecraft.item.ItemStack;

import net.minecraft.nbt.NbtCompound;

import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

import net.minecraft.world.World;


import java.util.UUID;



public class LumiEntity extends PathAwareEntity {

public void doJump(){

        this.jump();

    }



    /*
     * 主人
     */

    private UUID ownerUUID;





    /*
     * 狀態
     */

    private boolean sitting;


    private boolean sleeping;


    private boolean hidingBox;





    /*
     * 好感度 0~100
     */

    private int happiness = 50;









    public LumiEntity(

            EntityType<? extends PathAwareEntity> type,

            World world

    ){

        super(type, world);

    }










    /*
     * AI
     */

    @Override
    protected void initGoals(){



        /*
         * 游泳
         */

        this.goalSelector.add(

            0,

            new SwimGoal(this)

        );





        /*
         * 紙箱休息

         */

        this.goalSelector.add(

            1,

            new LumiBoxGoal(this)

        );





        /*
         * 睡眠

         */

        this.goalSelector.add(

            2,

            new LumiSleepGoal(this)

        );





        /*
         * 保護主人

         */

        this.goalSelector.add(

            3,

            new LumiProtectGoal(this)

        );





        /*
         * 跟隨主人

         */

        this.goalSelector.add(

            4,

            new LumiFollowGoal(this)

        );





        /*
         * 情緒

         */

        this.goalSelector.add(

            5,

            new LumiEmotionGoal(this)

        );





        /*
         * 玩耍

         */

        this.goalSelector.add(

            6,

            new LumiPlayGoal(this)

        );





        /*
         * 閒置

         */

        this.goalSelector.add(

            7,

            new LumiIdleGoal(this)

        );



    }









    /*
     * 主人系統
     */


    public void setOwner(

            PlayerEntity player

    ){


        ownerUUID =

        player.getUuid();


    }






    public boolean isOwner(

            PlayerEntity player

    ){


        return ownerUUID != null

        &&

        ownerUUID.equals(

            player.getUuid()

        );


    }









    /*
     * 坐下
     */


    public void setSitting(

            boolean value

    ){


        sitting = value;



        if(value){


            getNavigation()
            .stop();


        }


    }






    public boolean isSitting(){

        return sitting;

    }









    /*
     * 睡覺
     */


    public void setSleeping(

            boolean value

    ){


        sleeping=value;


    }






    public boolean isSleeping(){


        return sleeping;


    }










    /*
     * 紙箱
     */


    public void hideInBox(){


        hidingBox=true;


    }





    public void leaveBox(){


        hidingBox=false;


    }





    public boolean isHidingBox(){


        return hidingBox;


    }









    /*
     * 好感度
     */


    public int getHappiness(){


        return happiness;


    }






    public void addHappiness(

            int value

    ){



        happiness += value;




        if(happiness > 100)

            happiness = 100;




        if(happiness < 0)

            happiness = 0;



    }









    /*
     * 玩家互動
     */

    @Override
    public ActionResult interactMob(

            PlayerEntity player,

            Hand hand

    ){



        ItemStack item =

        player.getStackInHand(hand);





        /*
         * 餵食
         */

        if(item.isFood()){



            if(!getWorld().isClient){


                heal(4);


                addHappiness(10);



                item.decrement(1);



            }



            return ActionResult.SUCCESS;


        }









        /*
         * 第一次互動綁定主人
         */

        if(ownerUUID == null){



            setOwner(player);



            return ActionResult.SUCCESS;


        }








        /*
         * 主人控制坐下

         */

        if(isOwner(player)){



            setSitting(

                !sitting

            );



            return ActionResult.SUCCESS;


        }





        return ActionResult.PASS;



    }









    /*
     * NBT 保存
     */

    @Override
    public void writeCustomDataToNbt(

            NbtCompound nbt

    ){



        super.writeCustomDataToNbt(nbt);





        if(ownerUUID != null){



            nbt.putUuid(

                "Owner",

                ownerUUID

            );


        }





        nbt.putBoolean(

            "Sitting",

            sitting

        );



        nbt.putBoolean(

            "Sleeping",

            sleeping

        );



        nbt.putBoolean(

            "HidingBox",

            hidingBox

        );



        nbt.putInt(

            "Happiness",

            happiness

        );


    }










    @Override
    public void readCustomDataFromNbt(

            NbtCompound nbt

    ){



        super.readCustomDataFromNbt(nbt);





        if(nbt.containsUuid("Owner")){


            ownerUUID =

            nbt.getUuid("Owner");


        }






        sitting =

        nbt.getBoolean("Sitting");





        sleeping =

        nbt.getBoolean("Sleeping");





        hidingBox =

        nbt.getBoolean("HidingBox");





        happiness =

        nbt.getInt("Happiness");



    }







}