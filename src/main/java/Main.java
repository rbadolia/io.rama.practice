import in.rama.practise.array.CustomeShuffle;
import in.rama.practise.array.FindNumberOfSlices;
import in.rama.practise.array.UniqueCombinations;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(new UniqueCombinations().solution(1010));
        System.out.println(new CustomeShuffle().solution(0));
        System.out.println(new CustomeShuffle().solution(130));
        System.out.println(new CustomeShuffle().solution(1234567890));
        System.out.println(new FindNumberOfSlices().solution(new int[]{-3, -14, -5, 7, 8, 42, 8, 3}));
        System.out.println(new FindNumberOfSlices().solution(new int[]{2, 4, 1, 6, 5, 9, 7}));

        //Merge sorted array
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        a.add(1);
        a.add(5);
        a.add(7);
        a.add(7);

        b.add(0);
        b.add(1);
        b.add(2);
        b.add(3);
        System.out.println(mergeSortedArrays(a,b));

        //Longest even word
        System.out.println(longestEvenWord("It is a pleasant day today"));
        System.out.println(longestEvenWord("hey"));
    }

    static List<Integer> mergeSortedArrays(List<Integer> a, List<Integer> b) {
        int i = 0;
        int j = 0;

        List<Integer> result = new ArrayList();

        if (a.size() == 0) {
            return b;
        }

        if (b.size() == 0) {
            return a;
        }

        while (i < a.size() && j < b.size()) {
            if (a.get(i) < b.get(j)) {
                result.add(a.get(i));
                i++;
            } else {
                result.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) {
            result.add(a.get(i));
            i++;
        }

        while (j < b.size()) {
            result.add(b.get(j));
            j++;
        }

        return result;
    }

    static String longestEvenWord(String sentence) {

        if(sentence == null || sentence.trim().equals("")){
            return "";
        }

        String[] words = sentence.trim().split(" ");

        int maxLengthInAEvenWord = 0;
        String longestEvenWord = "00";

        for(String word : words){
            int wordLength = word.length();
            if(wordLength % 2 == 0){
                if(maxLengthInAEvenWord < wordLength){
                    maxLengthInAEvenWord = wordLength;
                    longestEvenWord = word;
                }
            }
        }

        return longestEvenWord;
    }

    static SinglyLinkedListNode distinct(SinglyLinkedListNode head) {
        if(head == null){
            return null;
        }

        SinglyLinkedList newList = new SinglyLinkedList();
        Set<Integer> set = new HashSet<>();
        set.add(head.data);
        newList.insertNode(head.data);

        SinglyLinkedListNode next = head.next;

        while(next != null){
            if(!set.contains(next.data)){
                newList.insertNode(next.data);
                next = next.next;
            }
        }

        return newList.head;
    }

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}
