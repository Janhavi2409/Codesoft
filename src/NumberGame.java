import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    //    Initializing the score
    static int score = 0;
    //    Initializing user input
    static int userInput;
    //    Intializing exit control variable
    static String exit;

    public static void main(String[] args) {
//        Creating an object of Random class
        Random random = new Random();
//        Creating an object for Scanner class
        Scanner sc = new Scanner(System.in);
        do {
//            Declaring the range of random number (1 to 100) and generating it
            int randNum = (random.nextInt(100 - 1 + 1) + 1);
//            Initializing the number of attempts
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
        System.out.println("Score: " + score);
        sc.close();
    }
}