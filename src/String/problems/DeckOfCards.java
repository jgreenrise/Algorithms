package String.problems;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DeckOfCards {

    public static void main(String [] args){
        DeckOfCards cards = new DeckOfCards();
        cards.showCards();

        System.out.println("**********************\nShuffling cards");
        cards.shuffle();
        cards.showCards();
    }


    /**
     * Randoms are not random in nature: They are predicatbel
     * https://www.geeksforgeeks.org/random-vs-secure-random-numbers-java/
     */
    private void shuffle() {
        for (int i = 0; i < 52; i++) {
            /**
             * This will not work, as Random is predictable in nature
             *
             *
             * The Random class basically is a Psuedorandom Number Generator (also known as Deterministic random bit generator) that
             * generates a sequence of numbers that approximates the properties of random numbers.
             *
             * It's not generally random but deterministic as it can be determined by small random states
             * in the generator (such as seed). Because of the deterministic nature, you can generate identical
             * result if you the sequence of methods and seeds are identical on 2 generators.
             *

            Random rand = new Random();
            int random1 = ThreadLocalRandom.current().nextInt(0, 52);
            int random2 = ThreadLocalRandom.current().nextInt(0, 52);
             */

            SecureRandom random = new SecureRandom();
            int max =51;
            int min =0;
            int random1 = random.nextInt(max);
            int random2 = random.nextInt(max);
            System.out.println("*******Random range: "+random1 +", "+random2);

            swap(random1, random2);
        }
    }

    private void swap(int leftIdx, int rightIdx) {
        Pair left = deckOfCards.get(leftIdx);
        deckOfCards.add(leftIdx, deckOfCards.get(rightIdx));
        deckOfCards.add(rightIdx, deckOfCards.get(leftIdx));
    }

    final int size = 52;
    List<Pair> deckOfCards = null;

    public DeckOfCards(){
        String[] suits = {"Diamonds","Clubs","Hearts","Spades"};
        String[] ranks ={"King","Queen","Jack","Ten","Nine","Eight","Seven","Six","Five","Four","Three","Deuce","Ace",};
        deckOfCards = new ArrayList<>();

        for (String s:suits){
            for (String r:ranks){
                deckOfCards.add(new Pair(s, r));
            }
        }
    }

    void showCards(){
        System.out.println("---------------------------------------------");
        for (Pair card : deckOfCards){
            //you had been checking here if this was null, but there was no need for that check
            System.out.printf("%s  of %s\n", card.u, card.v);
        }
        System.out.println("---------------------------------------------");
    }

    public class Pair<U,V> {
        U u;
        V v;
        public Pair(U u, V v){
            this.u = u;
            this.v = v;
        }
    }
}
