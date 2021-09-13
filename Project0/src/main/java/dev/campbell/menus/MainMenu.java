package dev.campbell.menus;

import dev.campbell.errors.usernameException;
import dev.campbell.models.Duelist;
import dev.campbell.models.Employee;
import dev.campbell.services.Login;
import dev.campbell.services.DuelistRegistration;
import sun.rmi.runtime.Log;

import java.util.Scanner;

public class MainMenu {

    public static void display(){

        Duelist duelist = new Duelist();
        Employee employee = new Employee();


        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while(running){

            System.out.println("Welcome to the Duelist Match-making and Trading System.");
            System.out.println("Please login as a Duelist or Employee.");
            System.out.println("1) Duelist Login");
            System.out.println("2) Duelist Registration");
            System.out.println("3) Employee Login");
            System.out.println("4) Exit");

            String choice = scanner.nextLine();

            switch (choice){
                case "1":
                    Login.DuelistLogin();
                    break;
                case "2":
                    DuelistRegistration.DuelistRegistration();
                    break;
                case "3":
                    Login.EmployeeLogin();
                    break;
                case "4":
                    System.out.println("Thank you for coming. Please join us again soon!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select one of the available options.");
                    break;



            }

        }
    }

}
