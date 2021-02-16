package _0561_Array_Partition_I;

/**
 * Date: 2020/9/20 20:24
 * Content: 哈希表：了解即可
 */
public class Solution2 {

    public int arrayPairSum(int[] nums) {
        // 因为题目中给了 数组中的元素范围在 [-10000, 10000].
        int[] arr = new int[20001];
        int d = 10000;
        for (int num : nums) arr[num + d]++;

        // 记录这次组合时是否用到不同的数据，
        // 如 [a，a，a，b，b，b]，（a，a），（a，b），（b，b），在组合 a 的过程，会消耗一个 b，之后会将 flag 置 1
        int flag = 0;
        int sum = 0;
        for (int num = -10000; num < 10000; num++) {
            int count = arr[num + d];
            if (count != 0) {
                sum += (count + 1 - flag) / 2 * num;
                flag = (count - flag + 2) & 1;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        int[] nums = {1, 4, 3, 2};
        System.out.println((new Solution2()).arrayPairSum(nums));
    }
}

/*
    if(count != 0) {
        //count + 1是为了让奇数在/2时能向上取整
        //如果d是1, 也就说明这个数的个数被上一次分配占用了一个, 对偶数没有影响
        //但是对奇数, 因为少了一个, 所以还剩偶数个, 所以需要再-d, 实质就是-1, 否则会多分配一对
        sum += (count + 1 - d) / 2 * i;
        //d就是用来说明这次分配有没有占用下个数的个数, 如果有, 则置1
        //要-d是因为要考虑上次分配有没有占用这次的个数, 如果占用了, 那就-1, 也就是-d
        //+2是因为  防止count == 1 || count == 0
        d = (count - d + 2) & 1;
    }
 */