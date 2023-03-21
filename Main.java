import java.util.HashMap;
import java.util.Scanner;
public class Main {

    public static void main (String[] args) {

        HashMap<String, Integer> fruits = new HashMap<>();
        fruits.put("Apple", 2);
        fruits.put("Banana", 3);
        fruits.put("Orange", 1);
        fruits.put("Grape", 4);

        int index = 0;

        for (String i : fruits.keySet()) {
            ++index;
            System.out.println(index + ") " + i + " price: " + fruits.get(i));
        }
        Scanner scanner = new Scanner(System.in);

        boolean isInteger = false;

        while (!isInteger) {
            System.out.println("Enter the amount you'd like, whole number only: ");
            String next = scanner.next();
            try {
                int amount = Integer.parseInt(next);
                System.out.println("Your amount is: " + amount);
                isInteger = true;
            } catch (NumberFormatException e) {
                System.out.println("This input is not a whole number - Please try again!");
            }
        }
    }
}