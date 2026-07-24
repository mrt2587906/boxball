package com.tw.wti.boxball;


import com.tw.wti.boxball.registry.ModEntities;
import com.tw.wti.boxball.registry.ModItems;
import com.tw.wti.boxball.registry.ModSounds;
import com.tw.wti.boxball.registry.ModCreativeTabs;


import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tw.wti.boxball.registry.ModBlocks;


public class BoxBallMod implements ModInitializer {



    public static final String MOD_ID =
            "boxball";
			
    public static final Logger LOGGER =
            LoggerFactory.getLogger(MOD_ID);




    @Override
    public void onInitialize(){
		
		
		ModBlocks.registerModBlocks();


        ModItems.registerModItems();
		
		
		ModEntities.registerModEntities();


        ModItems.registerModItems();


        ModSounds.register();


        ModCreativeTabs.register();


    }


}