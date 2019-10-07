package exceptions;

import exceptions.custom_exceptions.*;


public class VendingMachine extends Product {

private int stockCount = 0;
private int chocolateCount = 0;
private int saltySnackCount = 0;
private int softDrinkCount = 0;

    void buy(Product product) throws ProductNotFoundException {
        if (product instanceof SaltySnack) {
            if (saltySnackCount <= 0) {
                throw new SaltySnacksAllEatenException();
            } else {
                saltySnackCount--;
            }
        }

        else if (product instanceof Chocolate) {
            if (chocolateCount <= 0) {
                throw new ChocolatesAllGone();
            } else {
                chocolateCount--;
            }
        }

       else if (product instanceof SoftDrink) {
            if (softDrinkCount <= 0) {
                throw new SoftDrinksOutOfStockException();
            } else {
                softDrinkCount--;
            }
        } else {
           throw new InvalidProductException();
        }
    }

    void addStock(Product product, int newStock) {
        if (product instanceof SaltySnack) {
            saltySnackCount += newStock;
            stockCount+=newStock;
            System.out.println("SaltySnack Stock Count: " + stockCount);
            System.out.println("SaltySnack Count: " + saltySnackCount);
        }

        if (product instanceof SoftDrink) {
            softDrinkCount += newStock;
            stockCount+=newStock;
            System.out.println("SoftDrink Stock Count: " + stockCount);
            System.out.println("Softdrink Count: " + softDrinkCount);

        }

        if (product instanceof Chocolate) {
            chocolateCount += newStock;
            stockCount += newStock;
            System.out.println("Chocolate Stock Count: " + stockCount);
            System.out.println("Chocolate Count: " + chocolateCount);
        }
    }

    public int  getStock() {
        return stockCount;
    }

    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        Product saltySnack = new SaltySnack();
        Product softDrink = new SoftDrink();

        try {
            vendingMachine.addStock(saltySnack, 0);
            vendingMachine.buy(saltySnack);
        } catch (SaltySnacksAllEatenException e) {
            System.out.println("SaltySnacks Not Found");
        } catch (ProductNotFoundException ex){
            ex.printStackTrace();
        }

        try {
            System.out.println("------------");
            vendingMachine.addStock(softDrink, 1);
            vendingMachine.buy(softDrink);
            vendingMachine.buy(softDrink);
        } catch (SoftDrinksOutOfStockException e) {
            System.out.println("SoftDrink Not Found");
        } catch (ProductNotFoundException ex){
            ex.printStackTrace();
        }

//        try {
//            vendingMachine.addStock(salt, 1);
//            vendingMachine.buy(salt);
//        } catch (InvalidProductException e) {
//            System.out.println("Invalid Product");
//        } catch (InvalidProductException ex){
//            ex.printStackTrace();
//        }
        System.out.println("------------");
        vendingMachine.addStock(softDrink, 10);
        System.out.println(vendingMachine.getStock());

    }

   }