package dev.campbell.errors;

import java.sql.SQLException;

public class invalidloginException extends Exception {

    public invalidloginException(){
        super("username or password does not match. Please try again.");
    }

}
