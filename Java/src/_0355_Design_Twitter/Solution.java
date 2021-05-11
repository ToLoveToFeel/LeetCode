package _0355_Design_Twitter;

import java.util.*;

/**
 * Date: 2021/5/11 23:11
 */
public class Solution {

    static class Twitter {

        HashMap<Integer, List<int[]>> tweets = new HashMap<>();  // (用户id, 发表的推特)
        HashMap<Integer, HashSet<Integer>> follows = new HashMap<>();  // (用户id, 该用户关注的人)
        int ts;

        /** Initialize your data structure here. */
        public Twitter() {
            ts = 0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            if (!tweets.containsKey(userId)) tweets.put(userId, new ArrayList<>());
            tweets.get(userId).add(new int[]{ts++, tweetId});
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int u) {
            PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
            if (!follows.containsKey(u)) follows.put(u, new HashSet<>());
            follows.get(u).add(u);
            for (int userId : follows.get(u)) {
                List<int[]> ts = tweets.get(userId);
                if (ts != null && !ts.isEmpty()) {
                    int i = ts.size() - 1;
                    heap.add(new int[]{ts.get(i)[0], ts.get(i)[1], i, userId});
                }
            }

            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < 10 && !heap.isEmpty(); i++) {
                int[] t = heap.remove();
                res.add(t[1]);

                int j = t[2];
                if (j > 0) {
                    j--;
                    int userId = t[3];
                    List<int[]> ts = tweets.get(userId);
                    heap.add(new int[]{ts.get(j)[0], ts.get(j)[1], j, userId});
                }
            }
            return res;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int x, int y) {
            if (!follows.containsKey(x)) follows.put(x, new HashSet<>());
            follows.get(x).add(y);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int x, int y) {
            if (follows.containsKey(x)) follows.get(x).remove(y);
        }
    }

    public static void main(String[] args) {

        Twitter t = new Twitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));
    }
}
