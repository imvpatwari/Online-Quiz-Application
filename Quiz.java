import java.util.*;

public class Quiz {
    private List<Question> questions = new ArrayList<>();
    private int score = 0;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void startQuiz() {
        score = 0;
        int timerSeconds = questions.size() * 30; // 30 seconds per question
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTime's up!");
                displayScore();
                System.exit(0);
            }
        }, timerSeconds * 1000);

        Scanner scanner = new Scanner(System.in);
        for (Question question : questions) {
            System.out.println("\n" + question.getQuestionText());
            List<String> options = question.getOptions();
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }
            System.out.print("Your answer: ");
            int answer = scanner.nextInt();

            if (question.isCorrect(answer - 1)) {
                score++;
            }
        }

        timer.cancel();
        displayScore();
    }

    private void displayScore() {
        System.out.println("\nYour score is: " + score + "/" + questions.size());
    }
}
