import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuizQuestion {
    String question;
    List<String> options;
    int correctAnswerIndex;

    public QuizQuestion(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public boolean isCorrect(int userAnswerIndex) {
        return userAnswerIndex == correctAnswerIndex;
    }
}

public class QuizApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<QuizQuestion> questions = new ArrayList<>();
        int score = 0;

        questions.add(new QuizQuestion("What is Java?", List.of("A type of coffee", "A programming language", "An operating system", "A web browser"), 1));
        questions.add(new QuizQuestion("In Java, what does the 'public static void main(String[] args)' method indicate?", List.of(" It is the starting point of the program.", "It is used for printing messages to the console.", " It is a constructor for the class.", " It is used to define a constant."), 0));
        questions.add(new QuizQuestion("What is the output of System.out.println(5 + \"10\") in Java?", List.of("510", "15", "510.0", "SyntaxError"), 0));
        questions.add(new QuizQuestion("In Java, which data type is used to store a single character?", List.of("String", "boolean", "char", "int"), 2));
        questions.add(new QuizQuestion("Which of the following Java access modifiers makes a class or method accessible only within the same package?", List.of("public", "private", "protected", "default"), 3));

        for (int i = 0; i < questions.size(); i++) {
            QuizQuestion currentQuestion = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + currentQuestion.getQuestion());

            List<String> options = currentQuestion.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((j + 1) + ". " + options.get(j));
            }

            System.out.print("Your answer (enter the option number): ");
            int userAnswerIndex = sc.nextInt() - 1;

            if (currentQuestion.isCorrect(userAnswerIndex)) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer was: " + options.get(currentQuestion.correctAnswerIndex) + "\n");
            }
        }

        System.out.println("Quiz completed! Your score: " + score + "/" + questions.size());

        sc.close();
    }
}

