package _0000_study._datastructure.queue.arrayqueue;

/**
 * Date: 2020/9/7 17:44
 * Content:
 */
public class Main {
    public static void main(String[] args) {

        ArrayQueue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
