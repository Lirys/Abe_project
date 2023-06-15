package Exceptions;

public class IDError extends Exception {
    
    public IDError() {
        super("ID already exists.");
    }
}
