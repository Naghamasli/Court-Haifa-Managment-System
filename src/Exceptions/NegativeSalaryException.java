package Exceptions;


public class NegativeSalaryException extends Exception {
    public NegativeSalaryException() {
        super("Error: Salary cannot be negative.");
    }

    public NegativeSalaryException(double salary) {
        super("Error: Salary cannot be negative. Entered salary: " + salary);
    }
}

