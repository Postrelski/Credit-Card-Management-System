package app;

import client.Person;
import goods.Item;
import payment.CreditCard;

import java.util.Random;

public class Controller {

    public static void main(String[] args) throws InterruptedException {

        yourInfoHeader();

        Person john = new Person("john","Doe",
                "1100 Brickell Ave",
                "Apt 102",
                "Miami",
                "Florida");

        //------------------------------------------------------------------
        //step 11
        //------------------------------------------------------------------

        CreditCard masterCard = new CreditCard
                //does not use cardHolder when using instance John
                (john,
                "Mastercard",
                2500.00);

        CreditCard ax = new CreditCard
                //same issue here
                (john,
                "American Express",
                5000.00);


        john.getCreditCards().add(masterCard);

        john.getCreditCards().add(ax);

        Item cafeMocha = new Item
                ("Food", "Cafe Mocha", 4.77);

        Item gucciSlipper = new Item ("Clothing",
                "Gucci Princetown", 2650.00);

        Item coke = new Item("Food",
                "Coke", 1.99);

        Item airlinesTicket = new Item("Travel",
                "MIA-SFO", 823.26);

        //------------------------------------------------------------------
        //step 12
        //------------------------------------------------------------------

        //john buying cafeMocha with MasterCard
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);

        //john buy Gucci Slipper with masterCard
        ((CreditCard)john.getCreditCards().get(0)).makeCharge(gucciSlipper);

        //john buy Gucci Slipper with amex
        ((CreditCard)john.getCreditCards().get(1)).makeCharge(gucciSlipper);

        //john running transaction report on mastercard
        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();

        //john running transaction report on Amex
        ((CreditCard)john.getCreditCards().get(1)).transactionsReport();
        // "0" = masterCard, "1" = Amex? = yes...

        //------------------------------------------------------------------
        //step 13
        //------------------------------------------------------------------

        Random generator = new Random();

        //------------------------------------------------------------------
        //buying 7 cafeMocha using different credit cards
        //------------------------------------------------------------------

        for(int i=1; i <= 7; i++){

            Thread.sleep(generator.nextInt(1001));

            if(i % 3 == 0){
                // "0" = masterCard
                // "1" = Amex
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(cafeMocha);

            } else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(cafeMocha);
            }

        }//end for loop for 7 rnd gen Cafe Mocha's

        //------------------------------------------------------------------
        //buying 5 airline tickets using different credit cards
        //------------------------------------------------------------------

        for(int i=1; i <= 5; i++){

            Thread.sleep(generator.nextInt(1001));

            if(i % 2 == 0){
                // "0" = masterCard
                // "1" = Amex
                ((CreditCard)john.getCreditCards().get(0)).makeCharge(airlinesTicket);

            } else{
                ((CreditCard)john.getCreditCards().get(1)).makeCharge(airlinesTicket);
            }

        }//end for loop for 5 rnd gen Airline Tickets

        //------------------------------------------------------------------
        //buying 10 cokes using different credit cards
        //------------------------------------------------------------------


        for(int i=1; i <= 10; i++){

            //sleep for a random time up to 1 second
            Thread.sleep(generator.nextInt(1001));

            //used to randomly select a credit card
            int randomSelectCard = generator.nextInt(2);

            //if randomSelectCard is 0, use master card
            if(randomSelectCard == 0){
                // "0" = masterCard
                // "1" = Amex
                System.out.println("randomSelectCard: MasterCard");

                ((CreditCard)john.getCreditCards().get(0)).makeCharge(coke);

            }else{

                System.out.println("randomSelectCard: American Express");

                ((CreditCard)john.getCreditCards().get(1)).makeCharge(coke);
            }

        }//end for loop for rnd gen cokes

        //------------------------------------------------------------------
        //step 13
        //------------------------------------------------------------------

        // john is running a transaction Report on his masterCard
        ((CreditCard)john.getCreditCards().get(0)).transactionsReport();

        // john is running a transaction Report on his Amex
        ((CreditCard)john.getCreditCards().get(1)).transactionsReport();

        // john is running displayInfo method
        john.displayInfo();


//        System.out.println("---------------------------");
//        System.out.println("Credit Card Info");
//        System.out.println("---------------------------");
//
//        System.out.println("CreditCard: " + masterCard.getType());
//        System.out.println("Credit Limit: " + masterCard.getCreditLimit());
//        System.out.println("Current Balance: " + masterCard.getCurrentBalance());
//        System.out.println();
//        System.out.println("CreditCard: " + ax.getType());
//        System.out.println("Credit Limit: " + ax.getCreditLimit());
//        System.out.printf("Current Balance: %.2f" , ax.getCurrentBalance());

    }// end of main

    public static void yourInfoHeader(){

        System.out.println("=================================================");
        System.out.println("PROGRAMMER: " + "Matthew Postrel");
        System.out.println("PANTHER ID: " + "4003773");
        System.out.println();
        System.out.println("CLASS: \t\tCOP2210");
        System.out.println("SECTION: \t" + "U02");
        System.out.println("SEMESTER: \t" + "Fall 2021");
        System.out.println("CLASSTIME: \t" + "TuTh 5:00 pm - 7:40 pm");
        System.out.println();
        System.out.println("Assignment: " + "Project 2");
        System.out.println();
        System.out.println("CERTIFICATION: \nI understand FIU's academic policies, and I certify");
        System.out.println("that this work is my own and that none of it is the");
        System.out.println("work of any other person.");
        System.out.println("=================================================");
        System.out.println();

    }// end yourInfoHeader
}// end Controller class
