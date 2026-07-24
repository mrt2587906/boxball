package com.tw.wti.boxball.client.animation;



import net.minecraft.client.model.ModelPart;


import net.minecraft.util.math.MathHelper;





public class AnimationHelper {



    /*
     * 開心跳動
     */

    public static void happyAnimation(

            ModelPart head,

            float tick

    ){


        head.pitch =

        MathHelper.sin(

            tick * 0.3F

        )

        *0.15F;



    }










    /*
     * 睡覺呼吸
     */

    public static void sleepAnimation(

            ModelPart body,

            float tick

    ){


        float scale =


        1.0F +

        MathHelper.sin(

            tick * 0.1F

        )

        *

        0.02F;



        body.pivotY = scale;



    }











    /*
     * 玩球動作
     */

    public static void playAnimation(

            ModelPart arm,

            float tick

    ){



        arm.pitch =


        MathHelper.sin(

            tick * 0.5F

        )

        *

        0.8F;



    }




}