package dev.campbell.errors;

public class usernameException extends Exception{

    public usernameException(){
        super("Username already exists. Please choose another.");
    }


}
