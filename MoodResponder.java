import java.util.Scanner;

public class MoodResponder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome! Tell me how you feel (type 'exit' to quit).");

        while (true) {
            System.out.print("Enter your mood: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Goodbye! Take care!");
                break;
            }

            respondToMood(input);
        }

        scanner.close();
    }

   
    public static void respondToMood(String input) {
        boolean matched = false;

        if (input.contains("happy")) {
            System.out.println("You seem cheerful! 😊🎉");
            matched = true;
        }
        if (input.contains("sad")) {
            System.out.println("Cheer up! Here’s a virtual hug 🤗💖");
            matched = true;
        }
        if (input.contains("angry")) {
            System.out.println("Take a deep breath 😤🧘‍♂️");
            matched = true;
        }
        if (input.contains("tired")) {
            System.out.println("Rest well 😴🛏️");
            matched = true;
        }
        if (input.contains("excited")) {
            System.out.println("Let’s celebrate! 🎊🥳");
            matched = true;
        }

        if (!matched) {
            System.out.println("I'm not sure how you're feeling. Tell me more! 🤔");
        }
    }
}
