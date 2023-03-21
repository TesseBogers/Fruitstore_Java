import java.util.Scanner;
public class Main {


    public static void main (String[] args) {

        Fruit apple = new Fruit("apple", 2, 0, 1);
        Fruit banana = new Fruit("banana", 3, 0, 2);
        Fruit pear = new Fruit("pear", 1, 0, 3);
        Fruit grape = new Fruit("grape", 4, 0, 4);

        Fruit[] fruits = {apple, banana, pear, grape};

        Scanner scanner = new Scanner(System.in);


        boolean isInteger = false;
        int index = 0;
        while (!isInteger || index < 5) {
            for(Fruit f : fruits) System.out.println(f.index + ") " + f.name + " price: " + f.price + " amount: " + f.amount);
            System.out.println("Which product do you want to add to your shopping basket? Select by number: ");
            try {
                String next = scanner.next();
                int choice = Integer.parseInt(next);
                System.out.println("How many items of the product would you like to add? Enter in whole number: ");

                int amount = scanner.nextInt();

                if (choice == apple.index) {
                    int amountFruit = apple.amount + amount;
                    System.out.println("you have " + amountFruit +" " + apple.name + " in your shopping basket");
                    apple.amount = amountFruit;
                    isInteger = true;
                } else if (choice == banana.index) {
                    int amountFruit = banana.amount + amount;
                    System.out.println("you have " + amountFruit +" " + banana.name + " in your shopping basket");
                    banana.amount = amountFruit;
                    isInteger = true;
                } else if (choice == pear.index) {
                    int amountFruit = pear.amount + amount;
                    System.out.println("you have " + amountFruit +" " + pear.name + " in your shopping basket");
                    pear.amount = amountFruit;
                    isInteger = true;
                } else if (choice == grape.index) {
                    int amountFruit = grape.amount + amount;
                    System.out.println("you have " + amountFruit +" " + grape.name + " in your shopping basket");
                    grape.amount = amountFruit;
                    isInteger = true;
                } else System.out.println("This input is not correct - Please try again!");

            } catch (NumberFormatException e ) {
                System.out.println("This input is not a whole number - Please try again!");
            } ++index;
        }
    }
}
/*        HashMap<String, Integer> fruits = new HashMap<>();
        fruits.put("Apple", 2);
        fruits.put("Banana", 3);
        fruits.put("Orange", 1);
        fruits.put("Grape", 4);

        int index = 0;

        for (String i : fruits.keySet()) {
            ++index;
            int amountOfP = fruits.get(i) + 1;
            System.out.println(index + ") " + i + " price: " + fruits.get(i) + amountOfP);
        }*/