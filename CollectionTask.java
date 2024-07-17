import org.w3c.dom.ls.LSInput;

import java.util.*;

public class CollectionTask {


    public static void main(String[] args) {

        String yellowSubmarineLyrics, noPuncLyrics;
        String[] wordArray;
        List<String> wordList, noDupWordList = new ArrayList<>();
        HashMap<String, Integer> countMap;

        yellowSubmarineLyrics = loadLyrics();
        noPuncLyrics =  yellowSubmarineLyrics.replaceAll("[\\p{Punct}\\n]+","").toLowerCase();

        wordArray = noPuncLyrics.split("\\s+");

        System.out.println("\n####### P A R T  O N E #######\n");
        //Printing each word and how often it was seen
        countMap = countWords(wordArray);

        //Converting array of words to list
        wordList = new ArrayList<>(Arrays.asList(wordArray));

        //Removing duplicates in List
        Set<String> wordSet = new HashSet<>(wordList);
        noDupWordList.addAll(wordSet);

        System.out.println("\n####### P A R T  T W O #######\n");
        //Printing sorted(by length) list of words
        noDupWordList = printSortedList(noDupWordList);

        wordList = removeWord("yellow", wordList);
        wordList = removeWord("submarine", wordList);

        System.out.println("\n####### P A R T  T H R E E #######\n");
        printList(wordList);

    }

    //Function created to load song lyrics into a string
    public static String loadLyrics(){

        String lyrics = """
                In the town where I was born
                Lived a man who sailed to sea
                And he told us of his life
                In the land of submarines
                
                So we sailed up to the sun
                'Til we found the sea of green
                And we lived beneath the waves
                In our yellow submarine
                
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                
                And our friends are all aboard
                Many more of them live next door
                And the band begins to play
                
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                
                Full speed ahead, Mr. Boatswain, full speed ahead!
                Full speed it is, Sergeant!
                Cut the cable, drop the cable!
                Aye-aye, sir, aye-aye!
                Captain, Captain!
                
                As we live a life of ease (a life of ease)
                Everyone of us (everyone of us) has all we need (has all we need)
                Sky of blue (sky of blue) and sea of green (sea of green)
                In our yellow (in our yellow) submarine (submarine, ah-ha)
                
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
                We all live in a yellow submarine
                Yellow submarine, yellow submarine
            """;

        return lyrics;
    }

    //Function to count word occurrences in an array of words
    public static HashMap<String, Integer> countWords(String[] wordArray) {

        HashMap<String, Integer> countMap = new HashMap<>();

        for (String word : wordArray) {
            countMap.put(word.strip(), 0);
        }

        for (String word : wordArray) {
            countMap.put(word.strip(), countMap.get(word) + 1);
        }

        for (String word : countMap.keySet()) {
            System.out.println("\"" + word+ "\" appeared: " + countMap.get(word) + " time(s)");
        }

        return countMap;

    }

    //Function to sort words in List<String> in ascending order by string length
    public static List<String> printSortedList(List<String> wordList) {

        Comparator<String> lengthComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {

                int len1, len2;

                len1 = s1.length();
                len2 = s2.length();

                return len1 - len2;
            }
        };

        Collections.sort(wordList, lengthComparator);

        for (String word : wordList){
            System.out.println(word);
        }

        return wordList;
    }

    public static List<String> removeWord(String keyword, List<String> wordList) {
        List<String> resultList = new ArrayList<>();

        for (String word : wordList) {
            if (word.equals(keyword)) {
                continue;
            } else {
                resultList.add(word);
            }
        }

        return resultList;
    }

    public static void printList(List<String> wordList) {
        for (String word : wordList) {
            System.out.println(word);
        }
        return;
    }
}

