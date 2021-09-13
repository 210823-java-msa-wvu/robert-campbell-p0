package dev.campbell.services;

import dev.campbell.errors.invalidloginException;
import dev.campbell.menus.EmployeeMenu;
import dev.campbell.models.Duelist;
import dev.campbell.models.Employee;
import dev.campbell.repos.DuelistRepo;
import dev.campbell.menus.DuelistMenu;
import dev.campbell.repos.EmployeeRepo;

import java.util.Scanner;

public class Login {

    private static DuelistRepo dr = new DuelistRepo();

    private static EmployeeRepo er = new EmployeeRepo();

    public static void DuelistLogin() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            Duelist d = dr.getbyUsername(username, password);

            System.out.println(1);

            DuelistMenu.DuelistMenu(d);

        } catch (invalidloginException e) {
            //System.out.println("reaching exception");
            System.out.println(e.getMessage());
        }


    }

    public static void EmployeeLogin() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        try {
            Employee e = er.getbyUsername(username, password);

            if (e.getTitle().equals("admin")){
                EmployeeMenu.AdminMenu();
            } else {
                EmployeeMenu.EmployeeMenu();
            }

        } catch (invalidloginException e) {
            System.out.println(e.getMessage());
        }

    }

}
