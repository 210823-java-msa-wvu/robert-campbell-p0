package dev.campbell.menus;

import dev.campbell.models.Duelist;
import dev.campbell.repos.DuelistRepo;
import dev.campbell.menus.TradeMenu;


import java.util.Scanner;

public class DuelistMenu {

    private static DuelistRepo dr = new DuelistRepo();

    public static void DuelistMenu (Duelist d) {

        Scanner scan = new Scanner(System.in);

        boolean running = true;

        while (running) {

            System.out.println("Welcome Duelist " + d.getFirstName());
            System.out.println("What would you like to do?");
            System.out.println("--------------------------");
            System.out.println("1)View Profile" +
                    "\n2)Apply for duel" +
                    "\n3)Access Trade Market" +
                    "\n4)Logout");
            int selection = scan.nextInt();
            scan.nextLine();

            switch (selection) {
                case 1:
                    System.out.println("Your duelist profile: ");
                    System.out.println("First Name: " + d.getFirstName());
                    System.out.println("Last Name: " + d.getLastName());
                    System.out.println("Deck Name: " + d.getDeckName());
                    System.out.println("Deck Type: " + d.getDeckType());
                    System.out.println("Username: " + d.getUsername());
                    break;
                case 2:
                    System.out.println("Thank you for applying to duel!");
                    dr.updateAvailable(true, d);
                    break;
                case 3:
                    System.out.println("Transferring you to the trade menu.");
                    TradeMenu.TradeMenu(d);
                    break;
                case 4:
                    System.out.println("Logging out. Thank you for coming!!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select one of the available options.");
                    break;



            }


        }
    }

}
