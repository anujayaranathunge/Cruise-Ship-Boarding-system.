package com.company;
import java.io.IOException;
import java.util.Scanner;;

public class Main {

    public static void main(String[] args) throws IOException {

        Passenger[][] customer = new Passenger[4][2];

        for(int l=1;l< customer.length;l++){
            for (int d=1;d<customer[l].length;d++){
                customer[l][d] = new Passenger();
            }
        }
        Main main = new Main();

        main.initiolise(customer);
        main.menuOption(customer);
    }

    public static void menuOption(Passenger[][]customer) throws IOException{
        int cabinNum = 1;
        Scanner input = new Scanner(System.in);
        while (cabinNum<13) {
            System.out.println();
            System.out.println("Welcome to the Cruise Ship Boarding !");
            System.out.println("------------Menu------------");
            System.out.println("V - View all cabins");
            System.out.println("A - add a customer to a cabin");
            System.out.println("E - Display Empty cabins");
            System.out.println("D - Delete customer from cabin");
            System.out.println("F - Find cabin from customer name ");
            System.out.println("S - Store program data into file ");
            System.out.println("L - Load program data from file");
            System.out.println("O - View passengers ordered alphabetically by name");
            System.out.println("T - View Total Expenses");
            System.out.println("X - Enter to stop the programme");
            System.out.println("------------Thank You------------");
            String option = input.next().toUpperCase(); //to select menu option from the user.

                if (option.equalsIgnoreCase("V")) {
                    cabin.viewcabins(customer);
                } else if (option.equalsIgnoreCase("A")) {
                    cabin.addcustomer(customer);
                } else if (option.equalsIgnoreCase("D")) {
                    cabin.deletecustomer(customer);
                } else if (option.equalsIgnoreCase("E")) {
                    cabin.DisplayEmptyCabins(customer);
                } else if (option.equalsIgnoreCase("F")) {
                    cabin.FinecabinByCname(customer);
                } else if (option.equalsIgnoreCase("S")) {
                    cabin.store_program(customer);
                } else if (option.equalsIgnoreCase("L")) {
                    cabin.load_program(customer);
                } else if (option.equalsIgnoreCase("O")) {
                    cabin.sortProgram(customer);
                } else if (option.equals("T")) {
                    cabin.total_Expenses(customer);
                } else if (option.equalsIgnoreCase("X")) {
                    System.out.println("Thank You For Your Reservation");
                    break;
                } else {
                    System.out.println("Pleas Enter Valid Letter");
                }


        }
    }

    public static void initiolise(Passenger[][] customer){
        for(int cabin_num=1;cabin_num<customer.length;cabin_num++){
            for(int cabin_data =1;cabin_data<customer[cabin_num].length;cabin_data++){
                customer[cabin_num][cabin_data].setFirst_name("empty");
                customer[cabin_num][cabin_data].setSur_name("empty");
                customer[cabin_num][cabin_data].setExpenses(0.0);
            }
        }
    }
}

