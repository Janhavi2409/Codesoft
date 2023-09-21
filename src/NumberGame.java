import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    static int score = 0;
    static int userInput;
    static String exit;

    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);

        do {
            int randNum = (random.nextInt(100 - 1 + 1) + 1);
            int attempts = 5;
            do {
                System.out.print("Guess the number: ");
                userInput = sc.nextInt();
                if (userInput == randNum) {
                    System.out.println("Congratulations!!! You guessed the number right");
                    score++;
                    break;
                } else if (userInput > randNum) {
                    System.out.println("You are too high!!! try again...");
                } else {
                    System.out.println("You are too low!!! try again...");
                }
                attempts--;
                if (attempts == 0) {
                    System.out.println("You are out of attempts!!!");
                }
            } while (userInput != randNum && attempts > 0);
            System.out.print("Do you want to continue?(y/n): ");
            exit = sc.next();
        } while (exit.charAt(0) == 'y' || exit.charAt(0) == 'Y');
        sc.close();
        System.out.println("Score: " + score);
    }
}