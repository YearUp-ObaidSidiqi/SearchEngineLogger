package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Main {

    static Scanner scanner = new Scanner(System.in);
    static LocalDateTime localDateTime = LocalDateTime.now();
    static DateTimeFormatter ftm = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Welcome to your Logger Application ");
        conditions();

    }

    public static void conditions() throws IOException, InterruptedException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Log.txt"));

            boolean temp = true;
            while (temp) {

                mainpage();
                String cammand = scanner.nextLine().toUpperCase();
                char y[] = cammand.toCharArray();
                switch (y[0])
                {   case 'A':
                        //launchingTheApplication();
                        String line = nowTxt()+ " launch : " +launchingTheApplication()+"\n";
                        bufferedWriter.write(line);
                        break;
                    case 'B':
                        //searchingForTerm();
                        String line1 = nowTxt()+" search : " +searchingForTerm()+"\n";
                        bufferedWriter.write(line1);
                        break;
                    case 'C':
                        //exitingTheApplication();
                        temp = false;
                        String line2 = nowTxt()+ "  Exiting . . . ";
                        bufferedWriter.write(line2);
                        break;
                }

            }

        bufferedWriter.close();
        }
    public static String launchingTheApplication(){
        System.out.print("Which Application you want to open? ");
        String x =  scanner.nextLine();
        System.out.println("The "+ x + "  is launching Thank you! ");
        return x;
    }
    public static String searchingForTerm(){
        System.out.print("What do you want me to search? ");
        String x =  scanner.nextLine();
        System.out.println(" You are searched for "+x);
       return x;
    }

    public static void exitingTheApplication() throws InterruptedException {
        System.out.print("Exiting the application ");
        Thread.sleep(2000);
    }
    public static void mainpage (){

        System.out.println("Please select from the followings:");
        System.out.println("a. Launching the application ");
        System.out.println("b. Searching for a term ");
        System.out.println("c. Exiting the application ");
    }

    public static String  nowTxt (){
       return localDateTime.format(ftm);
    }
}

