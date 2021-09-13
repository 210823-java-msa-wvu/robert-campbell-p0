package dev.campbell.services;


import dev.campbell.errors.usernameException;
import dev.campbell.models.Duelist;
import dev.campbell.repos.DuelistRepo;

import java.util.Scanner;

public class DuelistRegistration {

    public static void DuelistRegistration() {

        DuelistRepo dr = new DuelistRepo();

        Scanner scan = new Scanner(System.in);

        System.out.println("Please enter your first name: ");
        String fname = scan.nextLine();
        System.out.println("Please enter your last name: ");
        String lname = scan.nextLine();
        System.out.println("Please enter the name you use for your deck: ");
        String dname = scan.nextLine();
        System.out.println("Please select the type of deck you are using: "+
                "\n1) Aggro" +
                "\n2) Control" +
                "\n3) Defense");
        int selection = scan.nextInt();
        scan.nextLine();
        while ((selection <= 0) || (selection >= 4)){
            System.out.println("Bad Selection:"+
                    "\n1) Aggro" +
                    "\n2) Control" +
                    "\n3) Defense");
            selection = scan.nextInt();
            scan.nextLine();
        }
        String dtype = "";
        switch (selection){
            case 1:
                dtype = "Aggro";
                break;
            case 2:
                dtype = "Control";
                break;
            case 3:
                dtype = "Defense";
                break;
        }
        System.out.println("Please enter a username: ");
        String uname = scan.nextLine();
        System.out.println("Please enter a password: ");
        String pass = scan.nextLine();

        Duelist d = new Duelist(fname, lname, dname, dtype, uname, pass);

        try {
            dr.create(d);
        } catch (usernameException e){
            System.out.println(e.getMessage());
        }


        System.out.println("Thank you for registering with us. Please log in.");
    }



}
