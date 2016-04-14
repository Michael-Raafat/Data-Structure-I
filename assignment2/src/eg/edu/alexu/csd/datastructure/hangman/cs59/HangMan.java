package eg.edu.alexu.csd.datastructure.hangman.cs59;

import java.util.Random;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;
/**
 * hangman game.
 * @author Michael
 *
 */

public class HangMan implements IHangman {
    /**
     * dictionary String.
     */
    private String[] dictionary = new String[1000];
    /**
     * maximum guesses.
     */
    private int maximum;
    /**
     * variables for switching.
     */
    private int j, m;
    /**
     * char array to use in converting from.
     * string to array
     */
    private char[] a = new char[1000];
    /**
     * string builder to append true guess.
     */
    private StringBuilder p = new StringBuilder("");
    @Override
    public final void setDictionary(final String[] words) {
        int i;
        j = words.length;
        for (i = 0; i < words.length; i++) {
             dictionary[i] = words[i];
        }
    }
    @Override
    public final String selectRandomSecretWord() {
        Random word = new Random();
        if (j == 0) {
           return null;
        }
        int right = word.nextInt(j);
        m = right;
        for (int i = 0; i < dictionary[right].length(); i++) {
             if (dictionary[right].charAt(i) != ' ') {
                 a[i] = '-';
            }
        }
        return dictionary[right];
    }
    @Override
    public final String guess(final Character c) {
        if (j == 0) {
           return "";
        }
        int k = 0, e = 0, w = 0;
        char[] b = dictionary[m].toUpperCase().toCharArray();
        String r = String.copyValueOf(a, 0, dictionary[m].length());
        if (c == null) {
           return r;
        }
        for (int i = 0; i < b.length; i++) {
           if (Character.toUpperCase(c) == b[i]) {
                if (e == 0) {
                    p = p.append(c);
                    e = 1;
                }
                a[i] = dictionary[m].charAt(i);
                k = 1;
            }
        }
        r = String.copyValueOf(a, 0, dictionary[m].length());
        if (k == 1) {
            return r;
            } else {
               if (k == 0) {
               for (int i = 0; i < dictionary[m].length(); i++) {
                 for (int y = 0; y < p.length(); y++) {
                        if (b[i] == p.charAt(y)) {
                            a[i] = dictionary[m].charAt(i);
                            w = 1;
                            }
                 }
                 if (w == 0) {
                    a[i] = '-';
                    }
                }
                 r = String.copyValueOf(
                 a, 0, dictionary[m].length());
                 maximum--;
                }
               }
             if (maximum <= 0) {
                return null;
              } else {
                return r;
                 }
             }
    @Override
    public final void setMaxWrongGuesses(final Integer max) {
        if (max == null) {
            maximum = 0;
            } else {
               maximum = max;
             }
          }
}
