package _0000_study._datastructure.map.avlmap;

import _0000_study._datastructure.utils.FileOperation;

import java.util.ArrayList;

/**
 * Date: 2020/9/7 18:31
 * Content:
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(FileOperation.utilsLocation + "/pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            AVLMap<String, Integer> map = new AVLMap<>();
            for (String word : words) {
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }
}
