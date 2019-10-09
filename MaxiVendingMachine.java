package exceptions;

import exceptions.custom_exceptions.*;

public class MaxiVendingMachine extends VendingMachine {

    @Override
    void buy(Product product) throws ProductNotFoundException {
        if (product instanceof SaltySnack) {
            if (saltySnackCount <= 0) {
                throw new SaltySnacksAllEatenException();
            } else {
                saltySnackCount--;
            }
        } else if (product instanceof Chocolate) {
            if (chocolateCount <= 0) {
                throw new ChocolatesAllGone();
            } else {
                chocolateCount--;
            }
        } else if (product instanceof SoftDrink) {
            if (softDrinkCount <= 0) {
                throw new SoftDrinksOutOfStockException();
            } else {
                softDrinkCount--;
            }
        } else {
            throw new InvalidProductException();
        }
    }

    @Override
    void addStock(Product product, int newStock) {
        if (product instanceof SaltySnack) {
            saltySnackCount += newStock;
            System.out.println("SaltySnack Count: " + saltySnackCount);
        }

        if (product instanceof SoftDrink) {
            softDrinkCount += newStock;
            System.out.println("SoftDrink Count: " + softDrinkCount);

        }

        if (product instanceof Chocolate) {
            chocolateCount += newStock;
            System.out.println("Chocolate Count: " + chocolateCount);
        }
    }

    @Override
    public int getStock() {
        return chocolateCount + softDrinkCount + saltySnackCount;
    }

    public static void main(String[] args) {
        MaxiVendingMachine maxiVendingMachine = new MaxiVendingMachine();
        Product saltySnack = new SaltySnack();
        Product softDrink = new SoftDrink();
        Product chocolate = new Chocolate();

//        FOR SALTYSNACKS
        try {
            maxiVendingMachine.addStock(saltySnack, 4);
            maxiVendingMachine.buy(saltySnack);
            maxiVendingMachine.buy(saltySnack);
            maxiVendingMachine.buy(saltySnack);
            maxiVendingMachine.buy(saltySnack);
            maxiVendingMachine.buy(saltySnack);
        } catch (SaltySnacksAllEatenException e) {
            System.out.println("SaltySnacks Not Found");
        } catch (ProductNotFoundException ex) {
            ex.printStackTrace();
        }

        //      FOR SOFTDRINKS
        try {
            System.out.println("------------");
            maxiVendingMachine.addStock(softDrink, 2);
            maxiVendingMachine.buy(softDrink);
            maxiVendingMachine.buy(softDrink);
            maxiVendingMachine.buy(softDrink);
        } catch (SoftDrinksOutOfStockException e) {
            System.out.println("SoftDrink Not Found");
        } catch (ProductNotFoundException ex) {
            ex.printStackTrace();
        }

        //      FOR CHOCOLATES
        try {
            System.out.println("------------");
            maxiVendingMachine.addStock(chocolate, 0);
            maxiVendingMachine.buy(chocolate);
        } catch (ChocolatesAllGone ex) {
            System.out.println("Chocolates Not Found");
        } catch (ProductNotFoundException ex) {
            ex.printStackTrace();
        }

    }

}
