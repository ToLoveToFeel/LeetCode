package _0000_study._datastructure.heap.indexmaxheap;

/**
 * 在堆的有关操作中，需要比较堆中元素的大小，所以Item需要extends Comparable
 * 索引堆，数据在data中的位置不变。数据所在的索引在变化，即indexes在变化
 * <p>
 * data[i] : 数据
 * indexes[k] = i : 排名为 k 的数据为 data[i]
 * reverse[i] = k : 索引 i 在indexes中的位置
 * <p>
 * 第k大的数据是data[indexes[k]]
 */
public class IndexMaxHeap<Item extends Comparable> {

    protected Item[] data;  // 最大索引堆中的数据
    protected int[] indexes;        // 最大索引堆中的索引，indexes[1]=10表示的含义是最大的数据是data[indexes[1]] = data[10]
    protected int[] reverse;    // data[i]从大到小的排名是reverse[i]

    protected int count;  // 堆中数据的个数
    protected int capacity;  // 堆的容量

    // 构造函数, 构造一个空堆, 可容纳capacity个元素
    // data 从 data[1]开始存储数据
    public IndexMaxHeap(int capacity) {

        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;  // 表示 i 这个索引在堆中不存在，因为我们的索引是从 1 开始的
        }

        count = 0;
        this.capacity = capacity;
    }

    // 构造函数, 通过一个给定数组创建一个最大堆
    // 该构造堆的过程, 时间复杂度为O(n)
    public IndexMaxHeap(Item arr[]) {

        int n = arr.length;

        data = (Item[]) new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++)
            data[i + 1] = arr[i];
        count = n;

        for (int i = count / 2; i >= 1; i--)
            shiftDown(i);
    }

    // 返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值, 表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 1;
    }

    // 看索引i所在的位置是否存在元素
    public boolean contain(int i) {
        assert (i + 1 >= 1 && i + 1 <= capacity);
        return reverse[i + 1] != 0;
    }

    // 向最大索引堆中插入一个新的元素, 新元素的索引为i, 元素为item
    // 传入的i对用户而言,是从0索引的
    public void insert(int index, Item item) {

        assert count + 1 <= capacity;
        // 再插入一个新元素前,还需要保证索引i所在的位置是没有元素的。
        assert !contain(index);

        index += 1;
        data[index] = item;
        indexes[count + 1] = index;
        reverse[index] = count + 1;

        count++;
        shiftUp(count);
    }

    // 从最大堆中取出堆顶元素, 即堆中所存储的最大数据
    public Item extractMax() {
        assert count > 0;
        Item ret = data[indexes[1]];

        swap(1, count);  // 将最大元素对应索引交换到数组尾部
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;  // 删除最大值对应的索引
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取最大元素所在的索引
    public int extractMaxIndex() {
        assert count > 0;

        int ret = indexes[1] - 1;

        swap(1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);

        return ret;
    }

    // 获取索引index对应的元素
    public Item getItem(int index) {
        assert contain(index);
        return data[index + 1];
    }

    // 获取最大堆中的堆顶元素
    public Item getMax() {
        assert count >= 0;
        return data[indexes[1]];
    }

    // 将最大索引堆中索引为i的元素修改为newItem
    public void change(int i, Item newItem) {

        assert contain(i);
        i += 1;
        data[i] = newItem;

        // 找到indexes[j] = i, j表示data[i]在堆中的位置
        // 之后shiftUp(j), 再shiftDown(j)
//        for( int j = 1 ; j <= count ; j ++ )
//            if( indexes[j] == i ){
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }

        // 有了 reverse 之后,
        // 我们可以非常简单的通过reverse直接定位索引i在indexes中的位置
        shiftUp(reverse[i]);
        shiftDown(reverse[i]);
    }


    // 交换堆中索引为i和j的两个索引
    private void swap(int i, int j) {
        int t = indexes[i];
        indexes[i] = indexes[j];
        indexes[j] = t;
    }

    //********************
    //* 最大堆核心辅助函数
    //********************
    private void shiftUp(int k) {

        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swap(k, k / 2);
            reverse[indexes[k]] = k;
            reverse[indexes[k / 2]] = k / 2;
            k /= 2;
        }
    }

    private void shiftDown(int k) {

        while (leftChild(k) <= count) {
            int j = leftChild(k); // 在此轮循环中,data[k]和data[j]交换位置
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0)
                j++;
            // data[j] 是 data[2*k]和data[2*k+1]中的最大值

            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0)
                break;

            swap(k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }
}