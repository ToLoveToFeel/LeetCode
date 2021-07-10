package _0981_Time_Based_Key_Value_Store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Date: 2021/7/10 16:46
 * Content:
 */
public class Solution {

    static class TimeMap {

        HashMap<String, List<Integer>> hash_time;
        HashMap<String, List<String>> hash_value;

        /** Initialize your data structure here. */
        public TimeMap() {
            hash_time = new HashMap<>();
            hash_value = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if (!hash_time.containsKey(key)) hash_time.put(key, new ArrayList<>());
            if (!hash_value.containsKey(key)) hash_value.put(key, new ArrayList<>());
            hash_time.get(key).add(timestamp);
            hash_value.get(key).add(value);
        }

        public String get(String key, int timestamp) {
            if (!hash_time.containsKey(key) || timestamp < hash_time.get(key).get(0)) return "";
            List<Integer> t = hash_time.get(key);
            if (timestamp >= t.get(t.size() - 1)) return hash_value.get(key).get(t.size() - 1);

            int l = 0, r = t.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (t.get(mid) <= timestamp) l = mid;
                else r = mid - 1;
            }
            return hash_value.get(key).get(l);
        }
    }

    public static void main(String[] args) {

        TimeMap t = new TimeMap();
        t.set("a", "bar", 1);
        t.set("x", "b", 3);
        System.out.println(t.get("b", 3));
        t.set("foo", "bar2", 4);
        System.out.println(t.get("foo", 4));
        System.out.println(t.get("foo", 5));
    }
}
