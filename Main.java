import java.util.Scanner;
public class Main {
    public static void main (String[] args) {

        Fruit apple = new Fruit("Apple", 2, 0, 1);
        Fruit banana = new Fruit("Banana", 3, 0, 2);
        Fruit pear = new Fruit("Pear", 4, 0, 3);
        Fruit grape = new Fruit("Grape", 1, 0, 4);

        Fruit[] fruits = {apple, banana, pear, grape};

        Scanner scanner = new Scanner(System.in);

        boolean isInteger = false;
        int index = 0;
        int totalPrice = 0;
        int totalAmount = 0;
        double totalWithTaxes = 0;
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Welcome to the not so original FruitStore, to exit and go to basket: q + ENTER");

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

                String inputAmount = scanner.next();
                int amount = Integer.parseInt(inputAmount);

                if (choice == apple.index) {
                    int amountFruit = apple.amount + amount;
                    apple.price = 2;
                    int price = apple.price * amount;
                    System.out.println("ADDED TO BASKET: " + amountFruit + " x " + apple.name + "\n");
                    apple.amount = amountFruit;
                    apple.price = price;
                    isInteger = true;
                } else if (choice == banana.index) {
                    int amountFruit = banana.amount + amount;
                    banana.price = 3;
                    int price = banana.price * amount;
                    System.out.println("ADDED TO BASKET: " + amountFruit + " x " + banana.name + "\n");
                    banana.amount = amountFruit;
                    banana.price = price;
                    isInteger = true;
                } else if (choice == pear.index) {
                    int amountFruit = pear.amount + amount;
                    pear.price = 3;
                    int price = pear.price * amount;
                    System.out.println("ADDED TO BASKET: " + amountFruit + " x " + pear.name + "\n");
                    pear.amount = amountFruit;
                    pear.price = price;
                    isInteger = true;
                } else if (choice == grape.index) {
                    int amountFruit = grape.amount + amount;
                    grape.price = 1;
                    int price = grape.price * amount;
                    System.out.println("ADDED TO BASKET: " + amountFruit + " x " + grape.name + "\n");
                    grape.amount = amountFruit;
                    grape.price = price;
                    isInteger = true;
                } else System.out.println("\nThis input is not an option - Please try again!\n");

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
        System.out.println("\t\t\t\t\t\t\t\t+ 21 %: " + "€ " + totalWithTaxes);
    }
}