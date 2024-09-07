import java.util.*;

public class QuizApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Quiz quiz = new Quiz();
    private static AdminPanel adminPanel = new AdminPanel(quiz);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Take Quiz");
            System.out.println("2. Admin Panel");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    quiz.startQuiz();
                    break;
                case 2:
                    adminPanel.showAdminMenu();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
    }
}
