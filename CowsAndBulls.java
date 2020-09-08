package com.Games;
/*
in this game (two player ) the player one enters a number and the player two plays this game to guess
the number
first the number of digits is given
and then the player one makes a desicion of the number
then the player two guesse the number by ramdom guesses
if the guessed number has a digit coinciding ( same number same posotion)  the choosen(by player 1)
then returns bull
(same number different position the it returns cow)
when three bulls are appeared then player two wins
NO REPEATING DIGITS AND NO 100OR 200LIKE THAT
 */

import java.util.Scanner;
public class CowsAndBulls {
   static   Scanner read =new Scanner(System.in);
   static int gameNUmber;
   static int digitsNumber;
   static int[] gameDigits;
   static int[] getDigits(int x)
   {
       int no=x;
       int[] arr=new int[digitsNumber];
       for( int j=0;no!=0;j++)
       {
           arr[j]=no%10;
           no=no/10;
       }
       return arr;
   }
   static
    {
        System.out.println("PLAYER ONE");
        System.out.println("enter the game number");
        gameNUmber=read.nextInt();
        System.out.println("enter the game digitscount");
        digitsNumber=read.nextInt();
        gameDigits=new int[digitsNumber];
        gameDigits=getDigits(gameNUmber);
    }
    static int[] guessNumber(int x)
    {
        int bullCount=0;
        int cowCount=0;
        int[] guessdigits = getDigits(x);
       for(int i=0;i<digitsNumber;i++)
       {
           for(int j=0;j<digitsNumber;j++)
           {
               if(gameDigits[i]==guessdigits[j]&&i==j)
               {
                  bullCount++;
               }
               else if(gameDigits[i]==guessdigits[j])
                          cowCount++;
           }
       }
        int[] returnArray=new int[2];
        returnArray[0]=bullCount;
        returnArray[1]=cowCount;
        return returnArray;
    }
    public static void main(String[] args)
    {
        System.out.println("PLAYER 2");
        System.out.println("start guessing");
        int guessNo;
        int[] response;
        int guessCount=0;
        char YN='N';
        do
        {
            guessNo=read.nextInt();
            guessCount++;
            response=guessNumber(guessNo);
            System.out.println(response[0]+" bulls "+response[1]+" cows");
            if(response[0]!=digitsNumber){
            System.out.println("guess again?(Y/N)");
            YN=read.next().charAt(0);}
        }while(YN=='Y'&& response[0]!=digitsNumber);
        if(response[0]==digitsNumber)
        {
            System.out.println("PLayer two wins in "+guessCount+" steps");
        }
     }
}
