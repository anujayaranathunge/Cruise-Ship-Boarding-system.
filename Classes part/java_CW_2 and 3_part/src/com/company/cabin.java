package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class cabin {
    private int cabinNum;
    public static Scanner input = new Scanner(System.in);
    private static Queue watingQueue = new Queue();

    public cabin() {
        cabinNum = 0;
    }

    public int getCabinNum() {
        return cabinNum;
    }

    public void setCabinNum(int cabinNum) {
        this.cabinNum = cabinNum;
    }


    public static void addcustomer(Passenger[][] add_customer) throws IOException {
        int cabinNum = 1;
        int locat = 1;
        int loop = 1;

        //getting add_customer details.
        while (loop <= 36) {
            System.out.println("3 Passengers can stay in 1 cabin");
            System.out.println("\n");

            System.out.println("Select a cabin number between 1 and 12; ");
            if (input.hasNextInt()) {
                cabinNum = input.nextInt();
            } else {
                System.out.println("Please enter an integer! ");
                System.out.println();
            }
            if (isAnyCabinAvailable(add_customer)) {
                if ((cabinNum >= 13) || (locat >= 4)) {
                    System.out.println("Cabin number is Out of range..!! Please use between 1 and 12: ");
                    Main.menuOption(add_customer);
                } else {
                    System.out.println("Enter passenger location: ");
                    if (input.hasNextInt()) {
                        locat = input.nextInt();
                    } else {
                        System.out.println("Please enter an integer! ");
                        Main.menuOption(add_customer);
                    }
                    System.out.println("Enter first name: ");
                    if (input.hasNext()) {
                        String first_name = input.next();
                        add_customer[cabinNum][locat].setFirst_name(first_name);
                    } else {
                        System.out.println("Please enter a string : ");
                        Main.menuOption(add_customer);
                    }
                    System.out.println("Enter surname: ");
                    if (input.hasNext()) {
                        String sur_name = input.next();
                        add_customer[cabinNum][locat].setSur_name(sur_name);
                    } else {
                        System.out.println("Please enter a string: ");
                    }
                    System.out.println("Enter expenses: ");
                    if (input.hasNextDouble()) {
                        double expenses = input.nextDouble();
                        add_customer[cabinNum][locat].setExpenses(expenses);
                    } else {
                        System.out.println("Please enter a double: ");
                    }
                    //display add_customer details.
                    System.out.println("Cabin number: " + cabinNum);
                    System.out.println("Passenger location: " + locat + " First name: " + add_customer[cabinNum][locat].getFirst_name());
                    System.out.println("Passenger location: " + locat + " Surname: " + add_customer[cabinNum][locat].getSur_name());
                    System.out.println("Passenger location: " + locat + " Expenses: " + add_customer[cabinNum][locat].getExpenses());
                    loop++;
                    System.out.println("\n");
                    Main.menuOption(add_customer);
                }
            } else {
                System.out.println("cabin full");
                System.out.println("Enter first name: ");
                String first_name = input.next();

                System.out.println("Enter sur name: ");
                String sur_name = input.next();

                System.out.println("Enter expenses: ");
                double expenses = input.nextDouble();
                Passenger p = new Passenger();
                p.setFirst_name(first_name);
                p.setSur_name(sur_name);
                p.setExpenses(expenses);
                watingQueue.addQue(p);
                break;


            }

        }
    }


    public static boolean isAnyCabinAvailable(Passenger[][] customer) {
        for(int locat=1;locat<customer.length;locat++){
            for(int data=1;data<customer[locat].length;data++){
                if (customer[locat][data].getFirst_name().equals("empty")){
                    return true;
                }
            }
        }

        return false;
            }


    public static void viewcabins(Passenger[][] view_list){
        for(int locat=1;locat< view_list.length;locat++){
            for(int data=1;data<view_list[locat].length;data++){
                if(view_list[locat][data].getFirst_name().equals("empty")){  //checking empty or not.
                    System.out.println("Cabin "+locat+ " passenger "+data+ " is empty");
                }else {    ///display customer details.
                    System.out.println("Cabin "+locat+ " passenger " +data+ " details");
                    System.out.println("First Name: "+ view_list[locat][data].getFirst_name());
                    System.out.println("Sur Name: "+ view_list[locat][data].getSur_name());
                    System.out.println("Expenses: "+view_list[locat][data].getExpenses());
                    System.out.println();
                }
            }
        }
    }
    public static void DisplayEmptyCabins(Passenger[][]DisplayE){
        for(int locat=1;locat<DisplayE.length;locat++){
            for(int data=1;data<DisplayE[locat].length;data++){
                if (DisplayE[locat][data].getFirst_name().equals("empty")){     //checking empty or not.
                    System.out.println("Cabin " + locat + "passenger location " + data + " is empty.");
                }
            }
        }
    }
    public static void deletecustomer(Passenger[][] deletec){
        System.out.println("Enter  name that you want to delete: ");
        String first_name = input.next();
        for(int locat=1;locat<deletec.length;locat++){
            for(int data=1;data<deletec[locat].length;data++){
                String CustomerName =deletec[locat][data].getFirst_name();
                if(CustomerName.equalsIgnoreCase(first_name)){
                    deletec[locat][data].setFirst_name("empty");
                    deletec[locat][data].setSur_name("empty");
                    deletec[locat][data].setExpenses(0.0);
                    System.out.println("Delete complete, Now " + locat + " " + data + " is empty.");
                    if (!watingQueue.isEmpty()){
                        Passenger p = watingQueue.deQueue();
                        System.out.println("passenger " +p.getFirst_name()+" is add to the empty slot from wating queue " );
                        deletec[locat][data].setFirst_name(p.getFirst_name());
                        deletec[locat][data].setSur_name(p.getSur_name());
                        deletec[locat][data].setExpenses(p.getExpenses());
                    }
                }else{
                    System.out.println("This cabin is already empty!");
                }
            }
        }
    }
    public static void FinecabinByCname (Passenger[][] fine){
        System.out.println("Enter the fine name that you want to find");
        String first_name = input.next();
        for(int locat=1; locat<fine.length;locat++){
            for (int data=1;data<fine[locat].length;data++){
                String CustomerName = fine[locat][data].getFirst_name();
                if(CustomerName.equalsIgnoreCase(first_name)){
                    System.out.println("This Passenger is in cabin number " + locat);
                }else{
                    System.out.println("This passenger is not in our Cabins ");
                }
            }
        }
    }
    public static void store_program(Passenger[][] storedata){
        try(FileWriter myWriter = new FileWriter("Task2out.txt")){
            for(int locat=1; locat<storedata.length;locat++){
                for(int data=1; data<storedata[locat].length;data++){
                    String first_name = storedata[locat][data].getFirst_name();
                    String sur_name = storedata[locat][data].getSur_name();
                    double expenses = storedata[locat][data].getExpenses();
                    if(first_name != "empty" & sur_name != "empty"){
                        myWriter.write("  " + "\nCabin " + locat + " Passenger " + data + " details"
                                + " First Name: " + first_name
                                + " Sur Name: " + sur_name
                                + " Expenses: " + expenses);
                    }
                }
            }
            myWriter.close();
            System.out.println("Successfully added the data to the file ");
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static void load_program(Passenger[][] loaddata){
        System.out.println("Print data in text file: ");
        int Line = 1;
        try{
            File inputFle = new File("Task2out.txt");
            Scanner fline = new Scanner(inputFle);
            String fLine;
            while (fline.hasNext()){
                fLine = fline.nextLine();
                System.out.println(Line + " " + fline);
                Line++;
            }
            fline.close();
        }catch (IOException e){
            System.out.println(e);
        }
    }
    public static void sortProgram (Passenger[][] sortA){      // te get order.
        String[] first_name = new String[12];
        int length = first_name.length;
        String[] alphabeticallyGuest = new String[length];
        for (int i = 0; i < first_name.length; i++) {      // to initialize all customers.
            alphabeticallyGuest[i] = first_name[i];
        }
        for (int j = 0; j < length - 1; j++) {
            for (int i = 0; i < length - 1; i++) {
                int compare = alphabeticallyGuest[i].compareTo(alphabeticallyGuest[i + 1]);        //to check which index is greater than other
                if (compare > 0) {      // to swap the customers if it's required.
                    String temp = alphabeticallyGuest[i];
                    alphabeticallyGuest[i] = alphabeticallyGuest[i + 1];
                    alphabeticallyGuest[i + 1] = temp;
                }
            }
        }
        System.out.println("Guests name by alphabetically order.");
        for (int i = 0; i < length; i++) {      //to remove empty rooms from array
            if (alphabeticallyGuest[i] != "empty") {
                System.out.println(alphabeticallyGuest[i]);
            }
        }
    }
    public static void total_Expenses(Passenger[][] customer){
        double total=0.0;
        for(int locat = 1;locat<customer.length;locat++){
            for(int data=1;data<customer[locat].length;data++){
                System.out.println("Cabin " +locat+ "  passenger "+data+ "  entered expense is "+customer[locat][data].getExpenses());
                total=total+customer[locat][data].getExpenses();
            }
        }
        System.out.println("---------------------------");
        System.out.println("Total Expenses is = " + total);
    }
}
