
import java.io.File;
import java.io.FileNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("bg-geo-cyrillic.txt"));
        } catch (FileNotFoundException e) {
            //TODO Print some message for the exception
            System.out.println("Error. Dictionary file missing.");
            return;
        }
        //Read the word from file and add them to word list
        List<String> words = new ArrayList<>();
        while (scanner.hasNext()) {
            words.add(scanner.nextLine());
        }
        scanner.close();

        Scanner sysScanner = new Scanner(System.in);
        Random random = new Random();

        String word = words.get(random.nextInt(words.size()));
        Hangman hangman = new Hangman(word);

        System.out.println("Намислих си населено място с " + word.length() + " букви.");
        System.out.println(hangman);
        System.out.print("Въведи буква: ");

        while (true) {
            char guess = sysScanner.nextLine().toLowerCase(Locale.ROOT).charAt(0);
            if (hangman.charIsAlreadyUsed(guess)) {
                System.out.println("Буква " + (char) guess + " вече е въвеждана!");

            } else if (hangman.charIsCorrect(guess)) {
                System.out.println("Браво позна!");
                if (hangman.gameIsOver()) {
                    System.out.println("Браво! Позна \"" + hangman.getWord() + "\".");
                    return;
                }
            } else {
                System.out.println("Не позна, опитай пак!");

            }
            System.out.println("Думата не съдържа: " + hangman.getWrongChars().stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println(hangman);
            System.out.print("Въведи буква: ");
        }
    }
}

