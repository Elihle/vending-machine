package exceptions.custom_exceptions;

public class SaltySnacksAllEatenException extends ProductNotFoundException {
    public SaltySnacksAllEatenException () {
        System.out.println("SaltySnacksAllEatenException");
    }
}
