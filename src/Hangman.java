import java.util.ArrayList;
import java.util.List;

public class Hangman {
    private List<Character> correctChars;
    private List<Character> wrongChars;
    private final String word;
    private StringBuilder textToDisplay;
    int guessesLeft;

    public Hangman(String word) {
        this.word = word;
        this.correctChars = new ArrayList<>();
        this.wrongChars = new ArrayList<>();
        this.textToDisplay = new StringBuilder();
        this.guessesLeft = 10;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) !=' ' ) {
                this.textToDisplay.append("_");
            } else {
                this.textToDisplay.append(" ");
            }
        }
    }

    public int getWordLength() {
        return this.word.length();
    }


    public boolean charIsAlreadyUsed(char guess) {
        return this.correctChars.contains(guess) || this.wrongChars.contains(guess);
    }

    public boolean charIsCorrect(char guess) {
        if (this.word.indexOf(guess) >= 0) {
            // fix SB display here
            for (int i = 0; i < getWordLength(); i++) {
                if (this.word.charAt(i) == guess) {
                    this.textToDisplay.setCharAt(i, guess);
                }
            }
            // add to correctCharList
            this.correctChars.add(guess);
            return true;
        }
        // ADD TO incorrectList
        this.wrongChars.add(guess);
        this.guessesLeft--;
        return false;
    }

    @Override
    public String toString() {
        return this.textToDisplay.toString();
    }

    public int getGuessesLeft() {
        return guessesLeft;
    }

    public List<Character> getWrongChars() {
        if (wrongChars.size() == 0) {
            return null;
        }
        return this.wrongChars;
    }

    public String getWord() {
        return word;
    }

    public boolean gameIsOver() {
        return this.textToDisplay.indexOf("_") < 0;
    }

    public boolean haveGuessesLeft() {
        return this.guessesLeft > 0;
    }

    public boolean charIsValid(char guess) {
        return guess >= 1072 && guess <=1103;
    }
}
