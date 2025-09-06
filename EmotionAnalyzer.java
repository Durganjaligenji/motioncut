import java.util.*;

public class EmotionAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Define emotion keywords mapping
        HashMap<String, String> keywordEmotionMap = new HashMap<>();
        keywordEmotionMap.put("happy", "joy");
        keywordEmotionMap.put("joyful", "joy");
        keywordEmotionMap.put("excited", "joy");
        keywordEmotionMap.put("smile", "joy");
        
        keywordEmotionMap.put("sad", "sadness");
        keywordEmotionMap.put("down", "sadness");
        keywordEmotionMap.put("depressed", "sadness");
        
        keywordEmotionMap.put("angry", "anger");
        keywordEmotionMap.put("mad", "anger");
        keywordEmotionMap.put("furious", "anger");
        
        keywordEmotionMap.put("tired", "fatigue");
        keywordEmotionMap.put("sleepy", "fatigue");
        keywordEmotionMap.put("exhausted", "fatigue");

        // Map emotions to emojis
        HashMap<String, String> emotionEmojiMap = new HashMap<>();
        emotionEmojiMap.put("joy", "😊🎉");
        emotionEmojiMap.put("sadness", "😢💔");
        emotionEmojiMap.put("anger", "😡🔥");
        emotionEmojiMap.put("fatigue", "😴🛏️");

        System.out.println("Welcome to the Emotion Analyzer!");
        System.out.println("Enter a sentence to analyze (type 'exit' to quit):");

        while (true) {
            System.out.print("\nYour input: ");
            String input = scanner.nextLine().toLowerCase();

            if (input.equals("exit")) {
                System.out.println("Goodbye! Take care!");
                break;
            }

            analyzeEmotion(input, keywordEmotionMap, emotionEmojiMap);
        }

        scanner.close();
    }

    public static void analyzeEmotion(String input, HashMap<String, String> keywordEmotionMap,
                                      HashMap<String, String> emotionEmojiMap) {
        // Remove punctuation
        input = input.replaceAll("[^a-zA-Z ]", " ");

        // Split into words
        String[] words = input.split("\\s+");

        // Count occurrences of emotions
        HashMap<String, Integer> emotionCount = new HashMap<>();

        for (String word : words) {
            if (keywordEmotionMap.containsKey(word)) {
                String emotion = keywordEmotionMap.get(word);
                emotionCount.put(emotion, emotionCount.getOrDefault(emotion, 0) + 1);
            }
        }

        if (emotionCount.isEmpty()) {
            System.out.println("No clear emotion detected. 😐");
            return;
        }

        // Find dominant emotion
        String dominantEmotion = Collections.max(emotionCount.entrySet(),
                Map.Entry.comparingByValue()).getKey();

        int count = emotionCount.get(dominantEmotion);

        // Highlight keywords
        System.out.println("Detected emotion: " + dominantEmotion.toUpperCase() +
                " " + emotionEmojiMap.getOrDefault(dominantEmotion, ""));
        System.out.println("Matching keywords found: " + count);
    }
}
