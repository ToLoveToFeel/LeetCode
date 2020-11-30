package _0000_study._datastructure.heap.maxheap;

/**
 * Date: 2020/11/30 16:17
 * Content:
 */
public class Main {

    // 测试 MaxHeap
    public static void main(String[] args) {

        int N = 10; // 堆中元素个数
        int M = 1000; // 堆中元素取值范围[0, M)
        MaxHeap<Integer> maxHeap = new MaxHeap<>(N);
        for (int i = 0; i < N; i++)
            maxHeap.insert((int) (Math.random() * M));

        Integer[] arr = new Integer[N];
        // 将maxheap中的数据逐渐使用extractMax取出来
        // 取出来的顺序应该是按照从大到小的顺序取出来的
        for (int i = 0; i < N; i++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        // 确保arr数组是从大到小排列的
        for (int i = 1; i < N; i++)
            assert arr[i - 1] >= arr[i];
    }
}
