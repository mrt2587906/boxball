package com.tw.wti.boxball.client.model;



public class LumiAnimations {



public static float idle(
float tick
){


return (float)
Math.sin(tick*0.08f)
*2;


}



public static float walk(
float tick
){


return 
(float)
Math.sin(tick*0.5f)
*20;


}



public static float sleep(
float tick
){


return 0;


}



}