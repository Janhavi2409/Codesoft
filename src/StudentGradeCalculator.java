import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of subjects: ");
        int subNum = sc.nextInt();
        String grade;
        double totalMarks = 0;
        for (int i = 1; i <= subNum; i++) {
            System.out.print("Enter marks in subject " + i + " (out of 100): ");
            int marks = sc.nextInt();
            totalMarks += marks;
        }
        double avgPercentage = (totalMarks / subNum);
        if (avgPercentage >= 90 && avgPercentage <= 100) {
            grade = "A1";
        } else if (avgPercentage >= 80 && avgPercentage <= 89) {
            grade = "A2";
        } else if (avgPercentage >= 70 && avgPercentage <= 79) {
            grade = "B1";
        } else if (avgPercentage >= 60 && avgPercentage <= 69) {
            grade = "B2";
        } else if (avgPercentage >= 50 && avgPercentage <= 59) {
            grade = "C1";
        } else if (avgPercentage >= 40 && avgPercentage <= 49) {
            grade = "C2";
        } else if (avgPercentage >= 30 && avgPercentage <= 39) {
            grade = "D1";
        } else if (avgPercentage >= 20 && avgPercentage <= 29) {
            grade = "D2";
        } else {
            grade = "E";
        }
        System.out.println("**********************Result**********************");
        System.out.println("Total marks obtained (out of " + (subNum * 100) + "): " + totalMarks);
        System.out.println("Average percentage: " + avgPercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
