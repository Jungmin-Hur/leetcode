package amore;

import common.A;

import java.util.*;

@A
public class WordLadder {
    public static void main(String args[]) {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log")));
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog")));

    }

    //this code is good (63ms)
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int step = 1; //start index is 1 because beginword does not exist in wordList

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> dic = new HashSet<>();
        for(String word : wordList) dic.add(word);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String target = queue.poll();

                //find all combination words
                for(int j = 0; j < target.length(); j++) {
                    char[] charTarget = target.toCharArray();
                    /**
                     * alphabet consists of only 26 characters.
                     * it has more good performance than finding word having only one different character
                     */
                    for(char c = 'a' ; c <= 'z'; c++) {
                        charTarget[j] = c;
                        String retarget = String.valueOf(charTarget);
                        if(!target.equals(retarget) && dic.contains(retarget)) {
                            if(retarget.equals(endWord)) return step + 1;
                            queue.offer(retarget);
                            dic.remove(retarget);
                        }
                    }
                }
            }
            step++;
        }

        return 0; //not found
    }

    //this code has really bad performance (916ms in java)
    public static int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        int step = 1; //start index is 1 because beginword does not exist in wordList

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> checkedWord = new HashSet<>();

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String target = queue.poll();

                //below approach is TLE!!!
                for(String word : wordList) {
                    if(!target.contains(word) && isOnlyOneDifferent(word, target) && !checkedWord.contains(word)) {
                        if(word.equals(endWord)) {
                            return step + 1;
                        }
                        queue.offer(word); //wordList.remove(word); word of wordList cannot remove (ConcurrentModificationException)
                        checkedWord.add(word);
                    }
                }
            }
            step++;
        }

        return 0; //not found
    }

    public static boolean isOnlyOneDifferent(String a, String b) {
        int differCount = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) differCount++;
            if(differCount > 1) return false;
        }
        return true;
    }
}
