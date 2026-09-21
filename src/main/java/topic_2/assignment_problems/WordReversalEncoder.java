package topic_2.assignment_problems;

public class WordReversalEncoder {
    public String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }

        String[] words = sentence.split(" ", -1);
        StringBuilder reversedSentence = new StringBuilder();
        for (int index = 0; index < words.length; index++) {
            if (index > 0) {
                reversedSentence.append(' ');
            }
            reversedSentence.append(new StringBuilder(words[index]).reverse());
        }
        return reversedSentence.toString();
    }

    public static void main(String[] args) {
        WordReversalEncoder encoder = new WordReversalEncoder();
        System.out.println(encoder.reverseEachWord("hello club"));
    }
}
