package _1600_Throne_Inheritance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Date: 2021/6/20 10:32
 */
public class Solution {

    static class ThroneInheritance {

        HashMap<String, List<String>> edges = new HashMap<>();
        HashSet<String> dead = new HashSet<>();
        String king;

        public ThroneInheritance(String kingName) {
            king = kingName;
        }

        public void birth(String p, String c) {
            List<String> children = edges.getOrDefault(p, new ArrayList<>());
            children.add(c);
            edges.put(p, children);
        }

        public void death(String name) {
            dead.add(name);
        }

        public List<String> getInheritanceOrder() {
            List<String> ans = new ArrayList<>();
            preorder(ans, king);
            return ans;
        }

        void preorder(List<String> ans, String name) {
            if (!dead.contains(name)) ans.add(name);
            for (String c : edges.getOrDefault(name, new ArrayList<>())) preorder(ans, c);
        }
    }

    public static void main(String[] args) {

        ThroneInheritance t= new ThroneInheritance("king");  // 继承顺序：king
        t.birth("king", "andy");  // 继承顺序：king > andy
        t.birth("king", "bob");  // 继承顺序：king > andy > bob
        t.birth("king", "catherine");  // 继承顺序：king > andy > bob > catherine
        t.birth("andy", "matthew");  // 继承顺序：king > andy > matthew > bob > catherine
        t.birth("bob", "alex");  // 继承顺序：king > andy > matthew > bob > alex > catherine
        t.birth("bob", "asha");  // 继承顺序：king > andy > matthew > bob > alex > asha > catherine
        System.out.println(t.getInheritanceOrder());  // [king, andy, matthew, bob, alex, asha, catherine]
        t.death("bob");  // 继承顺序：king > andy > matthew > bob（已经去世）> alex > asha > catherine
        System.out.println(t.getInheritanceOrder());  // [king, andy, matthew, alex, asha, catherine]
    }
}
