import java.util.Scanner;

enum Suit {
    DIAMONDS("♠"),
    HEARTS("♥"),
    CLUBS("♦"),
    SPADES("♣");

    private final String value;

    Suit(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

class Card {
    private final int value;
    private final Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return suit + "" + getValueAsString();
    }

    public String getValueAsString() {
        return switch (value) {
            case 1 -> "Ace";
            case 2 -> "2";
            case 3 -> "3";
            case 4 -> "4";
            case 5 -> "5";
            case 6 -> "6";
            case 7 -> "7";
            case 8 -> "8";
            case 9 -> "9";
            case 10 -> "10";
            case 11 -> "Jack";
            case 12 -> "Queen";
            default -> "King";
        };
    }
}

class Deck {
    private final Card[] cards;
    private int cardsUsed;

    public Deck() {
        this.cards = new Card[52];
        initializeDeck();
    }

    public void initializeDeck() {
        int count = 0;

        for(int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.HEARTS);
        }

        for(int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.SPADES);
        }

        for(int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.DIAMONDS);
        }

        for(int i = 1; i <= 13; i++) {
            cards[count++] = new Card(i, Suit.CLUBS);
        }
    }

    public void shuffleCard() {
        for(int i = 0; i < cards.length; i++) {
            int rand = (int) (Math.random() * (i));
            Card temp = cards[i];
            cards[i] = cards[rand];
            cards[rand] = temp;
        }
        cardsUsed = 0;
    }

    public Card dealCard() {
        cardsUsed++;
        return cards[cardsUsed - 1];
    }
}
class Game {
    private final Scanner input = new Scanner(System.in);
    private int correctGuesses = 0;

    public void play() {
        int gamesPlayed = 0;
        boolean playAgain;

        System.out.println("#### High Low Prediction Card Game");
        do {
            keepPlayUntilIncorrectGuess();
            gamesPlayed++;
            playAgain = askUserToPlayAgain();
        } while (playAgain);

        double averageScore = ((double) correctGuesses) / gamesPlayed;
        System.out.println();
        System.out.println("You Played "+gamesPlayed + "game.");
        System.out.printf("Your average score was %1.3f.\n", averageScore);
    }

    private void keepPlayUntilIncorrectGuess() {
        Deck deck = new Deck();
        deck.shuffleCard();

        Card currentCard = deck.dealCard();
        Card nextCard;

        System.out.println("The first card is "+currentCard);

        boolean keepPlaying = true;
        while(keepPlaying) {
            char guess = askForUserInput();
            nextCard = deck.dealCard();

            System.out.println("The next card is "+nextCard);

            if(nextCard.getValue() == currentCard.getValue()) {
                System.out.println("The value is the same as the previous card.");
                System.out.println("You lose on ties. Sorry!");
                keepPlaying = false;
            }
            else if(nextCard.getValue() > currentCard.getValue()) {
                if(guess == 'H') {
                    System.out.println("Your guess was correct");
                    correctGuesses++;
                }
                else {
                    System.out.println("Your guess was incorrect");
                    keepPlaying = false;
                }

            }
            else {
                if(guess == 'L') {
                    System.out.println("Your guess was correct");
                    correctGuesses++;
                }
                else {
                    System.out.println("Your guess was incorrect");
                    keepPlaying = false;
                }
            }
            currentCard = nextCard;
            System.out.println();
            System.out.println("The card is: "+currentCard);
        }
        System.out.println();
        System.out.println("\uD83C\uDFAE THE GAME IS OVER! \uD83C\uDFAE");
        System.out.println("You made "+correctGuesses + " correct Guesses");
        System.out.println();
    }

    private boolean askUserToPlayAgain() {
        System.out.println("Want to play again? if, "+ "please type YES, otherwise type anything to exit ");
        return input.nextLine().toUpperCase().contains("YES");
    }

    private char askForUserInput() {
        System.out.println("Will the next card be higher (H) " + "or Lower (L): ");
        char guess;
        do {
            guess = input.nextLine().toUpperCase().charAt(0);
            if(guess != 'H' && guess != 'L') {
                System.out.println("Please type H or L: ");
            }
        }while(guess != 'H' && guess != 'L');
        return guess;
    }
}

public class HighLowCardGame {
    public static void main(String[] args) {
        System.out.println("Welcome to world of JUA");
        Game game = new Game();
        game.play();
    }
}
