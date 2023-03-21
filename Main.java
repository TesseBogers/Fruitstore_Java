import java.util.HashMap;
import java.util.Scanner;
public class Main {


    static void myProduct(String nameFruit, int amountFruit, int scanner){

        System.out.println("How many " + nameFruit + "'s would you like? Enter the amount as a whole number");
        int amount = scanner;
        int amountApples = amount + amountFruit;
        System.out.println("you have " + amountApples +" apples in your shopping basket");

    }

    public static void main (String[] args) {

        Fruit apple = new Fruit("apple", 2, 0, 1);
        Fruit banana = new Fruit("banana", 3, 0, 2);
        Fruit pear = new Fruit("pear", 1, 0, 3);
        Fruit grape = new Fruit("grape", 4, 0, 4);

        Fruit[] fruits = {apple, banana, pear, grape};

        for(Fruit f : fruits) System.out.println(f.index + ") " + f.name + " price: " + f.price + " amount: " + f.amount);

        Scanner scanner = new Scanner(System.in);

        boolean isInteger = false;
        while (!isInteger) {
            try {
                System.out.println("Which product do you want to add to your shopping basket? Select by number: ");
                int next = scanner.nextInt();
                switch (next) {
                    case 1:
                        myProduct(apple.name, scanner.nextInt(), apple.amount);
                        break;
                    case 2:
                        myProduct(banana.name, scanner.nextInt(), banana.amount);
                        break;
                    case 3:
                        myProduct(pear.name, scanner.nextInt(), pear.amount);
                        break;
                    case 4:
                        myProduct(grape.name, scanner.nextInt(), grape.amount);
                        break;
                }
                isInteger = true;

            } catch (NumberFormatException e ) {
                System.out.println("This input is not a whole number - Please try again!");
            }
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