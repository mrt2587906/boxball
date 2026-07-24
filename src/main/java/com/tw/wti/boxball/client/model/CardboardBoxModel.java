package com.tw.wti.boxball.client.model;


import com.tw.wti.boxball.entity.CardboardBoxEntity;

import com.tw.wti.boxball.BoxBallMod;

import net.minecraft.client.render.entity.model.EntityModelLayer;

import net.minecraft.util.Identifier;


import net.minecraft.client.model.*;

import net.minecraft.client.render.VertexConsumer;

import net.minecraft.client.util.math.MatrixStack;

import net.minecraft.client.render.entity.model.EntityModel;



public class CardboardBoxModel
extends EntityModel<CardboardBoxEntity>{



    public static final EntityModelLayer LAYER =	
	        new EntityModelLayer(
	            new Identifier(	
		            "boxball",		
			        "cardboard_box"			
		        ),	
		        "main"	
	        );



    private final ModelPart box;





    public CardboardBoxModel(

            ModelPart root

    ){


        box = root.getChild(

            "box"

        );


    }






    public static TexturedModelData getTexturedModelData(){


        ModelData data =
        new ModelData();


        ModelPartData root =
        data.getRoot();



        root.addChild(

            "box",

            ModelPartBuilder.create()

            .cuboid(

                -5,

                -5,

                -5,

                10,

                10,

                10

            ),

            ModelTransform.NONE

        );



        return TexturedModelData.of(

            data,

            32,

            32

        );


    }






    @Override
    public void setAngles(

        CardboardBoxEntity entity,

        float limbAngle,

        float limbDistance,

        float animationProgress,

        float headYaw,

        float headPitch

    ){



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


        box.render(

            matrices,

            vertices,

            light,

            overlay

        );


    }



}