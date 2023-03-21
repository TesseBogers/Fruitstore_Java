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

        System.out.println("Welcome to the not so original FruitStore, to exit and go to basket: ENTER q.");
        while (!isInteger || (index < 2)) {
            try {
                index = 0;
                for(Fruit f : fruits) {
                    System.out.println(f.index + ") \t" + f.name + "\tPrice: \t " + "€" +f.price );
                }

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
            System.out.println(f.index + ") \t" + f.name + "\tPrice: \t " + "€" +f.price + " \t Quantity: \t" + f.amount);
            totalPrice += f.price;
            totalAmount += f.amount;
            totalWithTaxes = totalPrice * 1.21;
        }

        int temp;
        String tempName;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = i+1; j < fruits.length; j++) {
                if(fruits[i].price < fruits[j].price) {
                    temp = fruits[i].price;
                    tempName = fruits[i].name;
                    fruits[i].price = fruits[j].price;
                    fruits[i].name = fruits[j].name;
                    fruits[j].price = temp;
                    fruits[j].name = tempName;
                }
            }
        }

        for (Fruit fruit : fruits) {
            System.out.print(fruit.price + " " + fruit.name + "\t");
        }

        System.out.println("\nTotal price of: " + totalPrice);
        System.out.println("Total price with taxes: " + totalWithTaxes);
        System.out.println("Total amount of items ordered: " + totalAmount);
    }
}