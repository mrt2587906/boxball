package com.tw.wti.boxball.client;



import com.tw.wti.boxball.BoxBallMod;

import com.tw.wti.boxball.entity.CardboardBoxEntity;

import com.tw.wti.boxball.client.model.CardboardBoxModel;


import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.render.entity.MobEntityRenderer;


import net.minecraft.util.Identifier;



public class CardboardBoxRenderer
extends MobEntityRenderer
<
    CardboardBoxEntity,
    CardboardBoxModel
>{






    private static final Identifier TEXTURE =


    new Identifier(

        BoxBallMod.MOD_ID,

        "textures/entity/cardboard_box.png"

    );








    public CardboardBoxRenderer(

            EntityRendererFactory.Context context

    ){


        super(

            context,

            new CardboardBoxModel(

                context.getPart(

                    CardboardBoxModel.LAYER

                )

            ),

            0.0F

        );


    }








    @Override
    public Identifier getTexture(

            CardboardBoxEntity entity

    ){


        return TEXTURE;


    }



}