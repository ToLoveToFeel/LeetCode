package _0208_Implement_Trie_Prefix_Tree;

public class Trie2 {
    private class Node{

        public boolean isWord;
        public Node[] next;

        public Node(boolean isWord){
            this.isWord = isWord;
            next = new Node[26];
        }

        public Node(){
            this(false);
        }
    }

    private Node root;

    public Trie2(){
        root = new Node();
    }

    // 向Trie中添加一个新的单词word
    public void insert(String word){

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next[c-'a'] == null)
                cur.next[c-'a'] = new Node();
            cur = cur.next[c-'a'];
        }
        cur.isWord = true;
    }

    // 查询单词word是否在Trie中
    public boolean search(String word){

        Node cur = root;
        for(int i = 0 ; i < word.length() ; i ++){
            char c = word.charAt(i);
            if(cur.next[c-'a'] == null)
                return false;
            cur = cur.next[c-'a'];
        }
        return cur.isWord;
    }

    // 查询是否在Trie中有单词以prefix为前缀
    public boolean startsWith(String isPrefix){

        Node cur = root;
        for(int i = 0 ; i < isPrefix.length() ; i ++){
            char c = isPrefix.charAt(i);
            if(cur.next[c-'a'] == null)
                return false;
            cur = cur.next[c-'a'];
        }

        return true;
    }
}
