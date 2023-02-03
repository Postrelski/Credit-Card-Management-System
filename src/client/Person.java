package client;

import java.util.ArrayList;
import payment.CreditCard;

public class Person {

    //instance variables
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String suiteAddress;
    private String cityAddress;
    private String stateAddress;
    ArrayList creditCards;

    //constructor
    public Person(String firstName,
                  String lastName,
                  String streetAddress,
                  String suiteAddress,
                  String cityAddress,
                  String stateAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.suiteAddress = suiteAddress;
        this.cityAddress = cityAddress;
        this.stateAddress = stateAddress;

        //generic array list *array list empty = anything can go in
        creditCards = new ArrayList<>();
    }

    //getters & setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getSuiteAddress() {
        return suiteAddress;
    }

    public void setSuiteAddress(String suiteAddress) {
        this.suiteAddress = suiteAddress;
    }

    public String getCityAddress() {
        return cityAddress;
    }

    public void setCityAddress(String cityAddress) {
        this.cityAddress = cityAddress;
    }

    public String getStateAddress() {
        return stateAddress;
    }

    public void setStateAddress(String stateAddress) {
        this.stateAddress = stateAddress;
    }

    public ArrayList getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(ArrayList creditCards) {
        this.creditCards = creditCards;
    }

    public void displayInfo(){
        System.out.println("============================================================================");
        System.out.println("Display Information");
        System.out.println("============================================================================");
        System.out.println("Name: \t\t\t\t\t\t" +  firstName + " " + lastName);
        System.out.println("Address: \t\t\t\t\t" + streetAddress);
        System.out.println("Suite: \t\t\t\t\t\t" + suiteAddress);
        System.out.println("City: \t\t\t\t\t\t" +  cityAddress);
        System.out.println("State: \t\t\t\t\t\t" + stateAddress);

        System.out.println("---------------------------");
        System.out.println("Credit Card Info");
        System.out.println("---------------------------");

        for (Object creditCard : creditCards) {

            String cardName = ((CreditCard) creditCard).getType();
            double creditLimit = ((CreditCard) creditCard).getCreditLimit();
            double balance = ((CreditCard) creditCard).getCurrentBalance();

            System.out.printf("CreditCard: %-20s\n", cardName);
            System.out.printf("Credit Limit: %-20.2f\n", creditLimit);
            System.out.printf("Current Balance: %-20.2f\n", balance);
            System.out.println();

        }// end for loop

    }//end display

}// end Person class
