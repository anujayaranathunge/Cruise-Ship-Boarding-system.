package com.company;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        int cabinsNum = 1;
        String[] cabins = new String[13];
        Scanner y = new Scanner(System.in);
        initialise(cabins);
        while (cabinsNum < 13) {
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
            System.out.println("X - Enter to stop the programme");
            System.out.println("------------Thank You------------");
            String manu = y.nextLine();
            if (manu.equalsIgnoreCase("V")) {
                viewcabins(cabins);
            }
            else if (manu.equalsIgnoreCase("A")) {
                addcustomer(cabins);
            }
            else if (manu.equalsIgnoreCase("D")) {
                deletecustomer(cabins);
            }
            else if (manu.equalsIgnoreCase("E")) {
                DisplayEmptycabins(cabins);
            }
            else if (manu.equalsIgnoreCase("F")) {
                FinecabinByCname(cabins);
            }
            else if (manu.equalsIgnoreCase("S")) {
                store_program(cabins);
            }
            else if (manu.equalsIgnoreCase("L")) {
                load_program(cabins);
            }
            else if (manu.equalsIgnoreCase("O")) {
                sortProgram(cabins);
            }

            else if (manu.equalsIgnoreCase("X")) {
                System.out.println("Thank You For Your Reservation");
                break;
            }
            else {
                System.out.println("Please Enter Valid Letter");
            }
        }

    }
             public static void viewcabins(String[]view_list){
                    for (int x = 1; x < view_list.length; x++) {
                        if (view_list[x].equalsIgnoreCase("empty")) {
                            System.out.println("Cabin " + x + " is empty");
                        }
                        else {
                            System.out.println("Cabin " +x+ " Booked by " + view_list[x]);
                        }
            }
    }
            public static void addcustomer(String[]add_customer){
                    Scanner A = new Scanner(System.in);
                    String cabinName;
                    int cabinNum = 0;
                try{
                    System.out.println("Enter cabin Number (0-12)");
                    cabinNum = A.nextInt();
                    if (add_customer[cabinNum]!="empty"){
                        System.out.println("This cabin is full");
                    }else {
                        System.out.println("Enter Name For Cabin " + cabinNum +":");
                        cabinName = A.next();
                        add_customer[cabinNum] = cabinName;
                    }
                   }catch (Exception e){
                    System.out.println("Invalid Input");
                }
            }
            public static void deletecustomer(String[]deletec){
                    Scanner D = new Scanner(System.in);
                    try {
                        System.out.println("Enter cabin number that you want to delete: ");
                        int cabinNum = D.nextInt();
                        deletec[cabinNum]= "empty";
                    }catch (Exception e){
                        System.out.println("Invalid Input");
                    }
            }
            public static void DisplayEmptycabins(String[]DisplayE) {
                for (int x = 1; x < DisplayE.length; x++) {
                    if (DisplayE[x].equalsIgnoreCase("empty")) {
                        System.out.println("Cabin " + x + " is empty");
                    }
                }

            }
            public static void FinecabinByCname(String[]fine){
            try {
                Scanner F = new Scanner(System.in);
                    System.out.println("Enter Customer Name");
                    String cabinName = F.next();
                    for (int x = 1; x < fine.length; x++) {

                        if (fine[x].equals(cabinName)) {
                            System.out.println(fine[x] + " is Booked by Cabin " + x);
                        }
                    }
                }catch (Exception e){
                     System.out.println("Invalid Input");
                }
         }
         public static void store_program(String[]storedata){
         try{
             BufferedWriter writter = new BufferedWriter(new FileWriter("output.txt"));
             for(int i=1; i<storedata.length;i++){
                 writter.write("cabin"+i+":"+storedata[i]+"\n");
             }
             writter.close();
         } catch (IOException ex) {
             Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
         }
         }

         public static void load_program(String[]loaddata) {
             try {
                 BufferedReader reader = new BufferedReader(new FileReader("output.txt"));
                 String linecounter = null;
                 try {
                     while ((linecounter = reader.readLine()) != null) {
                         System.out.println(linecounter);
                     }
                     reader.close();

                 } catch (IOException ex) {
                     Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                 }
             }catch (FileNotFoundException ex) {
             }
         }

    public static void sortProgram(String [] sortA)
    {
        for (int i = 1; i <sortA.length ; i++) {
            for (int j = i + 1; j < sortA.length; j++) {

                if (sortA[i].compareTo(sortA[j]) > 0) {
                    String temp;
                    temp = sortA[i];
                    sortA[i] = sortA[j];
                    sortA[j] = temp;
                }
            }
        }
        for (int i = 1; i < sortA.length; i++) {
            System.out.println(sortA [i]);
        }
    }
    private static void initialise(String[]viwec){
        for (int i = 1; i<viwec.length; i++)viwec[i]="empty";

            }

    }



