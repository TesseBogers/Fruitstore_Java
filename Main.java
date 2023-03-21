import java.util.Scanner;
public class Main {
    public static void main (String[] args) {

        Fruit apple = new Fruit("apple", 0, 0, 1);
        Fruit banana = new Fruit("banana", 0, 0, 2);
        Fruit pear = new Fruit("pear", 0, 0, 3);
        Fruit grape = new Fruit("grape", 0, 0, 4);

        Fruit[] fruits = {apple, banana, pear, grape};

        Scanner scanner = new Scanner(System.in);

        boolean isInteger = false;
        int index = 0;
        int totalPrice = 0;
        int totalAmount = 0;

        while (!isInteger || index < 2) {
            try {
                for(Fruit f : fruits) {
                    System.out.println(f.index + ") " + f.name + " price: " + f.price + " amount: " + f.amount);
                }

                System.out.println("Which product do you want to add to your shopping basket? Select by number: ");
                String next = scanner.next();
                int choice = Integer.parseInt(next);

                System.out.println("How many items of the product would you like to add? Enter in whole number: ");

                String inputAmount = scanner.next();
                int amount = Integer.parseInt(inputAmount);

                if (choice == apple.index) {
                    int amountFruit = apple.amount + amount;
                    apple.price = 2;
                    int price = apple.price * amount;
                    System.out.println("you have " + amountFruit +" " + apple.name + " in your shopping basket");
                    apple.amount = amountFruit;
                    apple.price = price;
                    isInteger = true;
                } else if (choice == banana.index) {
                    int amountFruit = banana.amount + amount;
                    banana.price = 3;
                    int price = banana.price * amount;
                    System.out.println("you have " + amountFruit +" " + banana.name + " in your shopping basket");
                    banana.amount = amountFruit;
                    banana.price = price;
                    isInteger = true;
                } else if (choice == pear.index) {
                    int amountFruit = pear.amount + amount;
                    System.out.println("you have " + amountFruit +" " + pear.name + " in your shopping basket");
                    pear.amount = amountFruit;
                    isInteger = true;
                } else if (choice == grape.index) {
                    int amountFruit = grape.amount + amount;
                    System.out.println("You added " + amountFruit +" " + grape.name + " in your shopping basket");
                    grape.amount = amountFruit;
                    isInteger = true;
                } else System.out.println("This input is not an option - Please try again!");

            } catch (NumberFormatException e ) {
              System.out.println("This input is not a whole number - Please try again!");
            } ++index;
        }
        System.out.println("You ended the order process, here is your basket: ");
        for(Fruit f : fruits) {
            System.out.println(f.index + ") " + f.name + " price: " + f.price + " amount: " + f.amount);
            totalPrice += f.price;
            totalAmount += f.amount;
        }
        System.out.println("Total price of: " + totalPrice);
        System.out.println("Total amount of items ordered: " + totalAmount);
    }
}