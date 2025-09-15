package mergeSortMultiThreaded;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String arge[]) throws ExecutionException, InterruptedException {
        List<Integer> listToBeSorted = List.of(3,6,8,4,2,4,6,34,546,43,3,46,10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(listToBeSorted, executorService);

        Future<List<Integer>> sortedListFuture = executorService.submit(mergeSorter);
        List<Integer> sortedList = sortedListFuture.get();
        System.out.println(sortedList);
        executorService.shutdown();
    }
}
