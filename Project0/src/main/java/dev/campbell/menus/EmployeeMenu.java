package dev.campbell.menus;

import dev.campbell.errors.usernameException;
import dev.campbell.models.Duelist;
import dev.campbell.models.Employee;
import dev.campbell.repos.DuelistRepo;
import dev.campbell.repos.EmployeeRepo;
import dev.campbell.errors.noduelistavailableException;


import java.util.Scanner;

public class EmployeeMenu {

    private static Scanner scan = new Scanner(System.in);

    private static DuelistRepo dr = new DuelistRepo();

    private static EmployeeRepo er = new EmployeeRepo();

    private static Duelist d1 = new Duelist();

    private static Duelist d2 = new Duelist();


    public static void AdminMenu(){


        boolean running = true;

        while(running) {

            System.out.println("Welcome Admin");
            System.out.println("----------------");
            System.out.println("1)Create new employee" +
                    "\n2)Create duel between duelists" +
                    "\n3)Logout");

            int selection = scan.nextInt();
            scan.nextLine();

            switch (selection){
                case 1:
                    System.out.println("New Employee");
                    System.out.println("Enter Employee's First Name");
                    String fname = scan.nextLine();
                    System.out.println("Enter Employee's Last Name");
                    String lname = scan.nextLine();
                    System.out.println("Enter Employee's username");
                    String username = scan.nextLine();
                    System.out.println("Enter Employee's password");
                    String password = scan.nextLine();
                    System.out.println("Enter Employee's title");
                    String title = scan.nextLine();

                    Employee emp = new Employee(fname, lname, username, password, title);

                    try {
                        er.create(emp);
                        System.out.println("New Employee Created");
                    } catch (usernameException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Selecting duelists");
                    try {
                        d1 = er.getDuelist();

                        dr.updateAvailable(false, d1);

                        d2 = er.getDuelist();


                        dr.updateAvailable(false, d2);

                        System.out.println("Selected Duelists are: ");
                        System.out.println(d1.getFirstName() + " " + d1.getLastName() +
                                "\n vs " +
                                "\n" + d2.getFirstName() + " " + d2.getLastName());


                    } catch (noduelistavailableException e) {
                        System.out.println(e.getMessage());
                        dr.updateAvailable(true, d1);
                    }
                    break;
                case 3:
                    System.out.println("Logging Out");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;


            }


        }

    }

    public static void EmployeeMenu(){

        boolean running = true;

        while (running){

            System.out.println("Welcome Employee");
            System.out.println("-----------------");
            System.out.println("1) Create duel between duelists" +
                    "\n2) Logout");
            int selection = scan.nextInt();
            scan.nextLine();

            switch (selection){
                case 1:
                    System.out.println("Selecting duelists");
                    try {
                        d1 = er.getDuelist();

                        dr.updateAvailable(false, d1);

                        d2 = er.getDuelist();


                        dr.updateAvailable(false, d2);

                        System.out.println("Selected Duelists are: ");
                        System.out.println(d1.getFirstName() + " " + d1.getLastName() +
                                "\n vs " +
                                "\n" + d2.getFirstName() + " " + d2.getLastName());


                    } catch (noduelistavailableException e) {
                        System.out.println(e.getMessage());
                        dr.updateAvailable(true, d1);
                    }
                    break;
                case 2:
                    System.out.println("Logging Out");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        }

    }


}
