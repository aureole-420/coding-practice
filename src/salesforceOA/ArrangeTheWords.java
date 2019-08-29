package salesforceOA;
import java.util.*;


public class ArrangeTheWords {

    class Word {
        String word;
        int idx;
        Word(String word, int idx) {
            this.word = word;
            this.idx = idx;
        }
    }

    public String arrangeWords(String str) {
        String[] tokens = str.split("\\s+");
        for (int i = 0; i < tokens.length; i++) {
            tokens[i] = tokens[i].toLowerCase();
        }

        String lastToken = tokens[tokens.length - 1];
        String newlastToken = lastToken.substring(0, lastToken.length()-1);
        tokens[tokens.length-1] = newlastToken;

        Word[] words = new Word[tokens.length];
        for (int i =0; i < tokens.length;i++) {
            words[i] = new Word(tokens[i], i);
        }

        Arrays.sort(words, (a,b) -> a.word.length() == b.word.length() ? a.idx - b.idx : a.word.length() - b.word.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String token = words[i].word;
            if (i == 0) {
                sb.append(token.substring(0,1).toUpperCase());
                sb.append(token.substring(1,token.length()) + " ");
            } else if (i == tokens.length-1){
                sb.append(token+".");
            } else {
                sb.append(token + " ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "Cats and hats.";
        String s = "The line are printed in reverse order.";
        ArrangeTheWords atw = new ArrangeTheWords();
        String output = atw.arrangeWords(s);
        System.out.println(output); // should be "And cats hats."
    }
}
