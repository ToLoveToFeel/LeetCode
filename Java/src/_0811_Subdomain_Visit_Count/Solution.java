package _0811_Subdomain_Visit_Count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: 2020/9/16 17:04
 * Content:
 * 哈希表
 */
public class Solution {
    // 根据域名，获得多个域名。比如域名为：www.baidu.com，会返回 [com, baidu.com, www.baidu.com]
    private List<String> getDomins(String domain) {
        List<String> res = new ArrayList<>();

        int index = domain.length() - 1;
        while (index >= 0) {
            while (index >= 0 && domain.charAt(index) != '.')
                index--;
            res.add(domain.substring(index + 1));
            index--;
        }
        return res;
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        if (cpdomains.length == 0)
            return res;
        // 第一步，根据空格将字符串拆分为两部分，分别放入两个 ArrayList 中
        List<Integer> times = new ArrayList<>();
        List<String> domains = new ArrayList<>();
        for (String cpdomain : cpdomains) {
//            String[] cp = cpdomain.split("\\s+");
            String[] cp = cpdomain.split(" ");  // 效率会提高不少
            times.add(Integer.parseInt(cp[0]));
            domains.add(cp[1]);
        }

        // 第二步，根据域名，将域名拆分为多个域名，并统计域名出现次数
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < domains.size(); i++) {
            List<String> splitDomins = getDomins(domains.get(i));  // 将域名拆分为多个域名
            for (String splitDomain : splitDomins) {
                if (!map.containsKey(splitDomain))
                    map.put(splitDomain, times.get(i));
                else
                    map.put(splitDomain, map.get(splitDomain) + times.get(i));
            }
        }

        // 第三步，将讲过转换为题目要求的返回类型
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            res.add(value + " " + key);
        }
        return res;
    }

    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println((new Solution()).subdomainVisits(cpdomains));
    }
}
