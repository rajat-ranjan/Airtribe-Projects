package org.example.LearnerManagementSystem.exception;

public class LearnerNotFoundException extends Exception {
    //this is Checked exception

    public LearnerNotFoundException(String message) {
        super(message);
    }
    public LearnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
