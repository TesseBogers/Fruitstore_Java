import java.util.Scanner;
public class Main {
    static boolean isInteger = false;
    static int index = 0;
    static int totalPrice = 0;
    static int totalAmount = 0;
    static double totalWithTaxes = 0;
    static Scanner scanner = new Scanner(System.in);

    public static int addAmount(int fruitAmount) {
        return fruitAmount + Integer.parseInt(scanner.next());
    }
    public static int addPrice(int amount, int startPrice, String fruitName) {
        System.out.println("ADDED TO BASKET: " + amount + " x " + fruitName + "\n");
        isInteger = true;
        return startPrice * amount;
    }
    public static void main (String[] args) {

        Fruit apple = new Fruit("Apple", 2, 0, 1);
        Fruit banana = new Fruit("Banana", 3, 0, 2);
        Fruit pear = new Fruit("Pear", 4, 0, 3);
        Fruit grape = new Fruit("Grape", 1, 0, 4);
        Fruit[] fruits = {apple, banana, pear, grape};

        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Welcome to the FruitStore, to exit and go to basket: q + ENTER");

        for(Fruit f : fruits) {
            System.out.println(f.index + ") \t" + f.name + "\tPrice: \t " + "€" +f.price + "\n");
        }

        apple.price = 0;
        pear.price = 0;
        banana.price = 0;
        grape.price = 0;

        while (!isInteger || (index < 2)) {
            try {
                index = 0;
                System.out.println("Which product do you want to add to your shopping basket? Select by number: ");
                String next = scanner.next();

                if (next.equals("q")) {
                    break;
                }
                int choice = Integer.parseInt(next);
                System.out.println("How many items of the product would you like to add? Enter in whole number: ");
                switch (choice) {
                    case 1 -> {
                        int amount = addAmount(pear.amount);
                        int price = addPrice(amount, 2, apple.name);
                        apple.amount = amount;
                        apple.price = price;
                    }
                    case 2 -> {
                        int amount = addAmount(pear.amount);
                        int price = addPrice(amount, 3, banana.name);
                        banana.amount = amount;
                        banana.price = price;
                    }
                    case 3 -> {
                        int amount = addAmount(pear.amount);
                        int price = addPrice(amount, 4, pear.name);
                        pear.amount = amount;
                        pear.price = price;
                    }
                    case 4 -> {
                        int amount = addAmount(grape.amount);
                        int price = addPrice(amount, 1, grape.name);
                        grape.amount = amount;
                        grape.price = price;
                    } default -> System.out.println("\nThis input is not an option - Please try again!\n");
                }
            } catch (NumberFormatException e ) {
                System.out.println("\nThis input is not a whole number - Please try again!\n");
            } ++index;
        }
        System.out.println("You ended the order process, here is your basket: \n");

        int temp;
        int tempQuantity;
        String tempName;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = i+1; j < fruits.length; j++) {
                if(fruits[i].price < fruits[j].price) {
                    temp = fruits[i].price;
                    tempName = fruits[i].name;
                    tempQuantity = fruits[i].amount;
                    fruits[i].amount = fruits[j].amount;
                    fruits[i].price = fruits[j].price;
                    fruits[i].name = fruits[j].name;
                    fruits[j].price = temp;
                    fruits[j].name = tempName;
                    fruits[j].amount = tempQuantity;
                }
            }
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Fruit\t\t\t  Quantity\t\t\t Price/fruit");
        System.out.println("-------------------------------------------------------------------");

        for (Fruit fruit : fruits) {
            System.out.print(fruit.name + "\t\t\t\tx " + fruit.amount+ "\t\t\t\t € "+fruit.price +"\n");
            totalPrice += fruit.price;
            totalAmount += fruit.amount;
            totalWithTaxes = totalPrice * 1.21;
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("\t\t\t\t\t" + "x " +  totalAmount+ "\t\t\t\t€ " +totalPrice  + "\n" );
        System.out.println("\t\t\t\t\t\t\t+ 21 %: " + "€ " + totalWithTaxes);
    }
}