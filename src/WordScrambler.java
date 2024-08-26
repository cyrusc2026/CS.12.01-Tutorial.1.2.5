import java.util.Arrays;

public class WordScrambler {
    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) throws IllegalArgumentException{
        if (wordArr.length%2 == 1) {
            throw new IllegalArgumentException ("Word Array must contain an even number of elements!");
        }
        for (int i = 0; i < wordArr.length; i++){
            for (int j = 0; j < wordArr[i].length(); j++){
                if (wordArr[i].charAt(j)==' '){
                    throw new IllegalArgumentException("Word Array must contain single words only! "+wordArr[i]+" contains more than one word!");
                }
            }
        }
        this.scrambledWords = mixedWords(wordArr);

    }

    private static String recombine(String word1, String word2) {

        String answer = word1.substring(0, word1.length() / 2) +
                word2.substring(word2.length() / 2);
        return answer;
    }

    private String[] mixedWords(String[] words) {
        String[] answer = new String[words.length];
        for (int i = 0; i < words.length; i++){
            if (i%2 == 0) {
                answer[i] = WordScrambler.recombine(words[i],words[i+1]);
            }
            if (i%2 != 0){
                answer[i] = WordScrambler.recombine(words[i],words[i-1]);
            }
        }
        return answer;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}
