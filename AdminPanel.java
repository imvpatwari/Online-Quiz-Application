import java.util.*;

public class AdminPanel {
    private Quiz quiz;

    public AdminPanel(Quiz quiz) {
        this.quiz = quiz;
    }

    public void showAdminMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAdmin Panel:");
            System.out.println("1. Add Question");
            System.out.println("2. Go Back");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addQuestion();
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }

    private void addQuestion() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter question text: ");
        String questionText = scanner.nextLine();

        List<String> options = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            System.out.print("Enter option " + (i + 1) + ": ");
            options.add(scanner.nextLine());
        }

        System.out.print("Enter the correct option number (1-4): ");
        int correctAnswerIndex = scanner.nextInt() - 1;

        quiz.addQuestion(new Question(questionText, options, correctAnswerIndex));
        System.out.println("Question added successfully!");
    }
}
