package Exceptions;

import java.time.LocalDate;

public class FutureDateException extends Exception {
    public FutureDateException() {
        super("Error: The entered date cannot be in the future.");
    }

    public FutureDateException(String message) {
        super(message);
    }
}
