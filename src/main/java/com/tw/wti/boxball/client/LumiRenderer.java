package com.tw.wti.boxball.client;


import com.tw.wti.boxball.BoxBallMod;

import com.tw.wti.boxball.entity.LumiEntity;


import com.tw.wti.boxball.client.model.LumiModel;

import com.tw.wti.boxball.client.model.LumiModelLayers;


import net.minecraft.client.render.entity.EntityRendererFactory;

import net.minecraft.client.render.entity.MobEntityRenderer;

import net.minecraft.util.Identifier;




public class LumiRenderer
extends MobEntityRenderer
<
    LumiEntity,
    LumiModel
>{





    private static final Identifier TEXTURE =


    new Identifier(

        BoxBallMod.MOD_ID,

        "textures/entity/lumi.png"

    );







    public LumiRenderer(

            EntityRendererFactory.Context context

    ){


        super(

            context,

            new LumiModel(

                context.getPart(

                    LumiModelLayers.LUMI

                )

            ),

            0.35F

        );


    }









    @Override
    public Identifier getTexture(

            LumiEntity entity

    ){


        return TEXTURE;


    }










    /*
     * 紙箱中不渲染 Lumi
     */

    @Override
    public boolean shouldRender(

            LumiEntity entity,

            net.minecraft.client.render.Frustum frustum,

            double x,

            double y,

            double z

    ){



        if(entity.isHidingBox()){



            return false;


        }



        return super.shouldRender(

            entity,

            frustum,

            x,

            y,

            z

        );


    }



}