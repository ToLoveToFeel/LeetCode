package _0914_X_of_a_Kind_in_a_Deck_of_Cards;

public class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2)
            return false;
        int[] freq = new int[10000];
        for (int num : deck)
            freq[num]++;

        int g = -1;
        for (int count : freq){
            if (g == -1 && count != 0)
                g = count;
            else if (count != 0)
                g = gcd(g, count);
        }

        return g > 1;
    }

    private int gcd(int a, int b){
        if (a < b){
            int temp = a;
            a = b;
            b = temp;
        }
        if (a % b == 0)
            return b;
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int[] deck = new int[]{1,1,1,1,2,2,2,2,2,2};
        System.out.println((new Solution()).hasGroupsSizeX(deck));
    }
}
