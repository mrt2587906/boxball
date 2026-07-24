package com.tw.wti.boxball.client.model;


import com.tw.wti.boxball.entity.LumiEntity;

import com.tw.wti.boxball.client.animation.AnimationHelper;


import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;

import net.minecraft.client.render.VertexConsumer;

import net.minecraft.client.util.math.MatrixStack;

import net.minecraft.client.render.entity.model.EntityModel;

import net.minecraft.util.math.MathHelper;



public class LumiModel
extends EntityModel<LumiEntity> {



    private final ModelPart body;

    private final ModelPart head;

    private final ModelPart leftLeg;

    private final ModelPart rightLeg;





    /*
     * 如果舊模型有手臂
     * 後續可接玩球動畫
     */

    private ModelPart leftArm;

    private ModelPart rightArm;








    public LumiModel(

            ModelPart root

    ){


        body =
        root.getChild("body");


        head =
        root.getChild("head");


        leftLeg =
        root.getChild("left_leg");


        rightLeg =
        root.getChild("right_leg");



        /*
         * 兼容舊模型
         */

        if(root.hasChild("left_arm")){

            leftArm =
            root.getChild("left_arm");

        }



        if(root.hasChild("right_arm")){

            rightArm =
            root.getChild("right_arm");

        }


    }









    /*
     * Lumi 模型資料
     */

    public static TexturedModelData getTexturedModelData(){



        ModelData modelData =
        new ModelData();



        ModelPartData root =
        modelData.getRoot();







        /*
         * 身體
         */

        root.addChild(

            "body",

            ModelPartBuilder.create()

            .uv(0,0)

            .cuboid(

                -4,

                -4,

                -3,

                8,

                8,

                6

            ),

            ModelTransform.NONE

        );









        /*
         * 頭
         */

        root.addChild(

            "head",

            ModelPartBuilder.create()

            .uv(0,14)

            .cuboid(

                -3,

                -3,

                -4,

                6,

                6,

                6

            ),

            ModelTransform.pivot(

                0,

                -4,

                0

            )

        );









        /*
         * 左腳
         */

        root.addChild(

            "left_leg",

            ModelPartBuilder.create()

            .uv(20,0)

            .cuboid(

                -1,

                0,

                -1,

                2,

                4,

                2

            ),

            ModelTransform.pivot(

                2,

                4,

                0

            )

        );









        /*
         * 右腳
         */

        root.addChild(

            "right_leg",

            ModelPartBuilder.create()

            .uv(20,6)

            .cuboid(

                -1,

                0,

                -1,

                2,

                4,

                2

            ),

            ModelTransform.pivot(

                -2,

                4,

                0

            )

        );










        /*
         * 手臂（新增動畫用）
         */

        root.addChild(

            "left_arm",

            ModelPartBuilder.create()

            .uv(24,0)

            .cuboid(

                -1,

                0,

                -1,

                2,

                5,

                2

            ),

            ModelTransform.pivot(

                5,

                -2,

                0

            )

        );






        root.addChild(

            "right_arm",

            ModelPartBuilder.create()

            .uv(24,7)

            .cuboid(

                -1,

                0,

                -1,

                2,

                5,

                2

            ),

            ModelTransform.pivot(

                -5,

                -2,

                0

            )

        );








        return TexturedModelData.of(

            modelData,

            32,

            32

        );



    }









    @Override
    public void setAngles(

            LumiEntity entity,

            float limbAngle,

            float limbDistance,

            float animationProgress,

            float headYaw,

            float headPitch

    ){



        /*
         * 頭部方向
         */

        head.yaw =

        headYaw *

        ((float)Math.PI /180F);



        head.pitch =

        headPitch *

        ((float)Math.PI /180F);








        /*
         * 行走動畫
         */

        leftLeg.pitch =

        MathHelper.cos(

            limbAngle

        )

        *

        limbDistance;



        rightLeg.pitch =

        MathHelper.cos(

            limbAngle + (float)Math.PI

        )

        *

        limbDistance;










        /*
         * 睡眠動畫
         */

        if(entity.isSleeping()){


            AnimationHelper.sleepAnimation(

                body,

                entity.age

            );


        }







        /*
         * 高好感開心動畫
         */

        if(entity.getHappiness() >= 80){


            AnimationHelper.happyAnimation(

                head,

                entity.age

            );


        }








        /*
         * 玩球動畫預留
         */

        if(leftArm != null

        &&

        rightArm != null){



            AnimationHelper.playAnimation(

                leftArm,

                entity.age

            );


        }



    }









    @Override
    public void render(

            MatrixStack matrices,

            VertexConsumer vertices,

            int light,

            int overlay,

            float red,

            float green,

            float blue,

            float alpha

    ){



        body.render(

            matrices,

            vertices,

            light,

            overlay

        );



        head.render(

            matrices,

            vertices,

            light,

            overlay

        );



        leftLeg.render(

            matrices,

            vertices,

            light,

            overlay

        );



        rightLeg.render(

            matrices,

            vertices,

            light,

            overlay

        );




        if(leftArm != null){

            leftArm.render(

                matrices,

                vertices,

                light,

                overlay

            );

        }



        if(rightArm != null){

            rightArm.render(

                matrices,

                vertices,

                light,

                overlay

            );

        }



    }


}