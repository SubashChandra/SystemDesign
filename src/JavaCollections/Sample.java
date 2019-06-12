package JavaCollections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Sample {
    public static void main(String[] args) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(a > b)
                    return -1;
                else if(a < b)
                    return +1;
                return 0;
            }
        };

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(comparator);
        priorityQueue.add(5);
        priorityQueue.add(12);
        priorityQueue.add(3);
        while(!priorityQueue.isEmpty()){
            System.out.println(priorityQueue.poll());
        }
    }

}
