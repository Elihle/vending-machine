package exceptions.custom_exceptions;

public class SoftDrinksOutOfStockException extends ProductNotFoundException {
    public SoftDrinksOutOfStockException () {
        System.out.println("SoftDrinksOutOfStockException");
    }
}
