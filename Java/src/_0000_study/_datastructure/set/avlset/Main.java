package _0000_study._datastructure.set.avlset;

import _0000_study._datastructure.utils.FileOperation;

import java.util.ArrayList;

/**
 * Date: 2020/9/7 18:30
 * Content:
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile(FileOperation.utilsLocation + "/pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            AVLSet<String> set1 = new AVLSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile(FileOperation.utilsLocation + "/a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            AVLSet<String> set2 = new AVLSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
