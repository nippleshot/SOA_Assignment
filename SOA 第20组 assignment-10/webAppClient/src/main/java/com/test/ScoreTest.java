package com.test;

import com.scoreservice.ScoreService;
import com.scoreservice.ScoreServiceService;

import javax.xml.ws.WebServiceException;

public class ScoreTest
{
    public static void main( String[] args ) {
        System.out.println( "Score Client Test Start" );
        try {
            ScoreService helloService = new ScoreServiceService().getScoreServicePort() ;

            //getScore  Success
            System.out.println(helloService.getScore("155250001"));
            //getScore Invalid Student Id
            //System.out.println(helloService.getScore("1552500a"));
            //getScore Not Exist Student Id
            //System.out.println(helloService.getScore("155259991"));
            //getScore Data Error
            //System.out.println(helloService.getScore("171250024"));

            //getClassAverage Success
            System.out.println(helloService.getClassAverage("00000001"));
            //getClassAverage Invalid Course Id
            //System.out.println(helloService.getClassAverage("000000a"));
            //getClassAverage Data Error
            //System.out.println(helloService.getClassAverage("00000002"));


            //addScore Success
            System.out.println(helloService.addScore("00000001", "155256666", "Daily_Score","40"));
            //addScore Invalid Course Id
            //System.out.println(helloService.addScore("000000x", "155256666", "Daily_Score","40")) ;
            //addScore Invalid Student Id
            //System.out.println(helloService.addScore("00000001", "155256xc66", "Daily_Score","40"));
            //addScore Invalid ScoreType
            //System.out.println(helloService.addScore("00000001", "155256666", "New_Score","40"));
            //addScore Invalid Score
           // System.out.println(helloService.addScore("00000001", "155256666", "Daily_Score","400"));
            //addScore Data Already Exist
            //System.out.println(helloService.addScore("00000001", "155256666", "Daily_Score","40"));

            //fixScore Success
            System.out.println(helloService.fixScore("00000001", "155256666", "Daily_Score","41"));
            //fixScore Not Exist Student Id Score match
            //System.out.println(helloService.fixScore("00000002", "155250001", "Daily_Score","41"));

            //deleteScore Success
            System.out.println(helloService.deleteScore("00000001", "155256666", "Daily_Score"));
            //deleteScore Not Exist Student Id Score match
            //System.out.println(helloService.deleteScore("00000002", "155250001", "Daily_Score"));



        }catch (WebServiceException wse){
            System.out.println("ERROR: Server not connected");
            wse.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}