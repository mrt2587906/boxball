package com.tw.wti.boxball.registry;


import com.tw.wti.boxball.BoxBallMod;


import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;


import net.minecraft.sound.SoundEvent;


import net.minecraft.util.Identifier;




public class ModSounds {



    public static SoundEvent LUMI_IDLE;


    public static SoundEvent LUMI_HAPPY;


    public static SoundEvent LUMI_SLEEP;


    public static SoundEvent LUMI_HURT;








    public static void register(){



        LUMI_IDLE = registerSound(

            "lumi_idle"

        );




        LUMI_HAPPY = registerSound(

            "lumi_happy"

        );




        LUMI_SLEEP = registerSound(

            "lumi_sleep"

        );




        LUMI_HURT = registerSound(

            "lumi_hurt"

        );



    }









    private static SoundEvent registerSound(

            String name

    ){



        Identifier id =


        new Identifier(

            BoxBallMod.MOD_ID,

            name

        );




        return Registry.register(


            Registries.SOUND_EVENT,


            id,


            SoundEvent.of(id)


        );



    }



}