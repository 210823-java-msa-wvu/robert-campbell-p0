package dev.campbell.menus;

import dev.campbell.models.Duelist;
import dev.campbell.models.TradeMarket;
import dev.campbell.repos.TradeRepo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TradeMenu {

    private static TradeRepo tr = new TradeRepo();

    private static ArrayList<TradeMarket> tm = new ArrayList<>();

    private static TradeMarket tmo = new TradeMarket();



    public static void TradeMenu(Duelist d) {



        boolean running = true;

        Scanner scan = new Scanner(System.in);

        while (running) {


            System.out.println("Welcome to the Trade Menu");
            System.out.println("What would you like to do?");
            System.out.println("---------------------------");
            System.out.println("1)View Market" +
                    "\n2)Create Trade" +
                    "\n3)Respond to Trade" +
                    "\n4)Accept or Reject Offers" +
                    "\n5)Return to Duelist Menu");
            int selection = scan.nextInt();
            scan.nextLine();

            switch (selection){
                case 1:
                    tm = tr.viewAllTrades();
                    tm.forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("What card are you looking for?");
                    String cardname = scan.nextLine();
                    tr.createTrade(d, cardname);
                    break;
                case 3:

                    System.out.println("What trade would you like to respond to?"+
                            "\n Please type the id number of the trade");
                    int tradechoice = scan.nextInt();
                    scan.nextLine();
                    try {
                        tmo = tr.getByTradeID(tradechoice);
                    } catch (SQLException throwables) {
                        System.out.println("Trade does not exist");
                    }
                    System.out.println("What card do you want in return?");
                    String requestedcard = scan.nextLine();

                    tr.respondToTrade(d, tmo, requestedcard);
                    break;
                case 4:
                    System.out.println("Enter the id of the trade offer you want to respond to.");
                    int tradeoffer = scan.nextInt();
                    scan.nextLine();
                    try {
                        tmo = tr.getByTradeID(tradeoffer);
                    } catch (SQLException throwables) {
                        System.out.println("Trade does not exist");
                    }
                    if (tmo.getCreatorId() == d.getId()){
                        System.out.println("Do you wish to 1) Accept or 2)Reject the trade? *Note: both options delete the current trade*");
                        int response = scan.nextInt();
                        scan.nextLine();
                        if (response == 1){
                            System.out.println("Trade Accepted!");
                            tr.deleteTrade(tmo);
                        } else {
                            System.out.println("Trade Rejected!");
                            tr.deleteTrade(tmo);
                        }

                    } else {
                        System.out.println("You don't have permission to Accept or Reject this trade. It is not yours.");
                    }
                    break;
                case 5:
                    System.out.println("Returning to Duelist Homepage!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;

            }

            }




        }


}

