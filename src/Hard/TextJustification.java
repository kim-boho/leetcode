package Hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> sentences = new ArrayList<>();
        if(words.length == 0) return sentences;
        List<String> wordsForOneSentence = new ArrayList<>();
        int lengthSumOfWords = 0;
        for(int i=0; i<words.length; i++){
            String word = words[i];
            int numOfSpacesAfterAddingWord = Math.max(wordsForOneSentence.size(),0);
            if(maxWidth - lengthSumOfWords - word.length() - numOfSpacesAfterAddingWord < 0){
                sentences.add(makeSentence(wordsForOneSentence,lengthSumOfWords,maxWidth));
                wordsForOneSentence = new ArrayList<>();
                lengthSumOfWords = 0;
            }
            wordsForOneSentence.add(word);
            lengthSumOfWords += word.length();
        }

        sentences.add(makeLeftJustifiedSentence(wordsForOneSentence,lengthSumOfWords,maxWidth));
        return sentences;
    }

    private String makeSentence(List<String> words, int lengthSumOfWords, int maxWidth){
        if(words.size() == 1) return makeLeftJustifiedSentence(words,lengthSumOfWords,maxWidth);
        int numOfSpaces = words.size()-1;
        int remainingLength = maxWidth - lengthSumOfWords;
        int commonSpace = remainingLength / numOfSpaces;
        int spacesAddToLeft = remainingLength-commonSpace*numOfSpaces;
        StringBuilder sentence = new StringBuilder();
        sentence.append(words.get(0));
        for(int i=1; i<words.size(); i++){
            String word = words.get(i);
            for(int j=0; j<commonSpace; j++) sentence.append(' ');
            if(spacesAddToLeft > 0){
                sentence.append(' ');
                spacesAddToLeft--;
            }
            sentence.append(word);
        }
        return sentence.toString();
    }

    private String makeLeftJustifiedSentence(List<String> words, int lengthSumOfWords, int maxWidth){
        StringBuilder sentence = new StringBuilder();
        for(int i=0; i<words.size(); i++){
            if(i != 0) sentence.append(' ');
            sentence.append(words.get(i));
        }
        int remainingLength = maxWidth-sentence.toString().length();
        while(remainingLength-- > 0) sentence.append(' ');
        return sentence.toString();
    }
}
