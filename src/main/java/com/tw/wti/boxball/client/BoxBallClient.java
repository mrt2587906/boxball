package com.tw.wti.boxball.client;


import com.tw.wti.boxball.registry.ModEntities;


import com.tw.wti.boxball.client.model.LumiModel;
import com.tw.wti.boxball.client.model.LumiModelLayers;
import com.tw.wti.boxball.client.model.CardboardBoxModel;


import net.fabricmc.api.ClientModInitializer;


import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;


import net.minecraft.client.render.entity.model.EntityModelLayer;


import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;



public class BoxBallClient
implements ClientModInitializer {



    @Override
    public void onInitializeClient(){



        /*
         * Entity Renderer
         */


        EntityRendererRegistry.register(


            ModEntities.LUMI,


            LumiRenderer::new


        );





        EntityRendererRegistry.register(


            ModEntities.CARDBOARD_BOX,


            CardboardBoxRenderer::new


        );










        /*
         * Lumi Model Layer
         */


        EntityModelLayerRegistry.registerModelLayer(

            LumiModelLayers.LUMI,


            LumiModel::getTexturedModelData

        );





        /*
         * Cardboard Box Model Layer
         */


        EntityModelLayerRegistry.registerModelLayer(

            CardboardBoxModel.LAYER,


            CardboardBoxModel::getTexturedModelData

        );



    }



}