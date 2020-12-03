package _0000_study._algorithm.binarysearch;

/**
 * Date: 2020/12/3 16:33
 * Content: 二分搜索法
 * 下面的后缀 ceil 表示 : 不存在的话取> target 的数据最小索引值
 * upper_ceil : 如果data中存在 target, 返回相等数据的最大索引，否则返回 > target 的数据最小索引值
 * lower_ceil : 返回 >= target 的数据最小索引值
 * <p>
 * 下面的后缀 floor 表示 : 不存在的话取< target 的数据最大索引值
 * upper_floor : 返回 <= target 的数据最大索引值
 * lower_floor : 如果data中存在 target, 返回相等数据的最小索引，否则返回 < target 的数据最大索引值
 * <p>
 * 前缀 upper 表示：如果data中存在 target，取最下标最大的哪一个
 * 前缀 lower 表示：如果data中存在 target，取最下标最小的哪一个
 */
public class BinarySearch {

    private BinarySearch() {

    }

    // 递归实现二分查找法
    public static <E extends Comparable<E>> int searchR(E[] data, E target) {

        return searchR(data, 0, data.length - 1, target);
    }

    // 在 data[l...r] 中搜索 target
    public static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target) {

        if (l > r)
            return -1;

        int mid = l + (r - l) / 2;

        if (data[mid].compareTo(target) == 0)
            return mid;

        if (data[mid].compareTo(target) < 0)  // 到右半边寻找
            return searchR(data, mid + 1, r, target);

        return searchR(data, l, mid - 1, target);
    }

    // 非递归实现二分查找法
    public static <E extends Comparable<E>> int search(E[] data, E target) {

        int l = 0, r = data.length - 1;

        // 在 data[l...r] 中搜索 target
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0)
                return mid;
            if (data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
    }


    // > target 的数据的最小索引值
    // 如果大于 target 的最小数据存在多个，则会返回索引最小的那个
    public static <E extends Comparable<E>> int upper(E[] data, E target) {

        int l = 0, r = data.length;  // r设为data.length，如果返回data.length代表所有的数据都小于等于target

        // 在 data[l...r] 中寻找解
        while (l < r) {  // 一定会存在解，当 l == r 的时候，就找到了解

            int mid = l + (r - l) / 2;  // 对于r-l为偶数，结果不变；对于r-l为奇数，下取整
            if (data[mid].compareTo(target) <= 0)
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }

    // 如果data中存在 target, 返回相等数据的最大索引，否则返回 > target 的数据最小索引值
    public static <E extends Comparable<E>> int upper_ceil(E[] data, E target) {

        int u = upper(data, target);  // 获取大于 target 的数据的最小索引
        // 如果存在相等的数据，返回相等数据的最大索引
        if (u - 1 >= 0 && data[u - 1].compareTo(target) == 0)
            return u - 1;

        return u;
    }

    // 返回 >= target 的数据最小索引值
    public static <E extends Comparable<E>> int lower_ceil(E[] data, E target) {

        int l = 0, r = data.length;  // r设为data.length，如果返回data.length代表所有的数据都小于target

        // 在 data[l...r] 中寻找解
        while (l < r) {  // 一定会存在解，当 l == r 的时候，就找到了解

            int mid = l + (r - l) / 2;
            if (data[mid].compareTo(target) < 0)  // 此处和 upper 存在区别，也是唯一一处区别
                l = mid + 1;
            else
                r = mid;
        }

        return l;
    }


    // < target 的数据的最大索引
    // 如果小于 target 的最大数据存在多个，则会返回索引最大的那个
    public static <E extends Comparable<E>> int lower(E[] data, E target) {

        int l = -1, r = data.length - 1;  // l设为-1，如果返回-1代表所有数据都大于等于target

        // 在 data[l...r] 中寻找解
        while (l < r) {  // 一定会存在解，当 l == r 的时候，就找到了解

            int mid = l + (r - l + 1) / 2;  // 对于r-l为偶数，结果不变；对于r-l为奇数，上取整
            if (data[mid].compareTo(target) < 0)
                l = mid;
            else
                r = mid - 1;
        }

        return l;
    }

    // < target ，返回最大值索引
    // == target，返回最小索引
    public static <E extends Comparable<E>> int lower_floor(E[] data, E target) {

        int l = lower(data, target);
        // 注意，因为我们要访问 data[l + 1]，所以，我们要先确保 l + 1 不越界，
        // 即 l + 1 < data.length
        if (l + 1 < data.length && data[l + 1].compareTo(target) == 0)
            return l + 1;
        return l;
    }

    // <= target 最大索引
    public static <E extends Comparable<E>> int upper_floor(E[] data, E target) {

        int l = -1, r = data.length - 1;

        // 在 data[l, r] 中寻找解
        while (l < r) {

            int mid = l + (r - l + 1) / 2;
            // 请同学们根据下面的搜索范围的调整逻辑思考：
            // 为什么 upper_floor 同样需要使用上取整的方式来计算 mid?

            // 在 lower 中，这里是 data[mid].compareTo(target) < 0
            // 但是，对于 upper_floor 来说，在 data[mid] == target 的时候，有可能是解
            // 所以在等于的情况下，不能排除掉 data[mid] 的值，我们的搜索空间的变化，同样是 l = mid
            if (data[mid].compareTo(target) <= 0)  // 此处和 lower 存在区别，也是唯一一处区别
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }


    public static void main(String[] args) {

        Integer[] arr = {1, 1, 3, 3, 5, 5};

        // 测试 upper  0 2 2 4 4 6 6
        for (int i = 0; i <= 6; i++)
            System.out.print(BinarySearch.upper(arr, i) + " ");
        System.out.println();

        // 测试 ceil  0 1 2 3 4 5 6
        for (int i = 0; i <= 6; i++)
            System.out.print(BinarySearch.upper_ceil(arr, i) + " ");
        System.out.println();

        // 测试 lower_ceil  0 0 2 2 4 4 6
        for (int i = 0; i <= 6; i++)
            System.out.print(BinarySearch.lower_ceil(arr, i) + " ");
        System.out.println();

        // 测试 lower  -1 -1 1 1 3 3 5
        for (int i = 0; i <= 6; i++)
            System.out.print(BinarySearch.lower(arr, i) + " ");
        System.out.println();
    }
}










