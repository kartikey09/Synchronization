package mergeSortMultiThreaded;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> listToSort;
    private ExecutorService executorService;

    MergeSorter(List<Integer> listToSort, ExecutorService executorService){
        this.listToSort = listToSort;
        this.executorService = executorService;
    }
    @Override
    public List<Integer> call() throws Exception {
        int n = listToSort.size();

        if(n <=1)
            return listToSort;

        List<Integer> leftHalf = new ArrayList<>();
        List<Integer> rightHalf = new ArrayList<>();

        for(int i = 0; i < n/2; i++)
            leftHalf.add(listToSort.get(i));

        for(int i = n/2; i < n; i++)
            rightHalf.add(listToSort.get(i));


        MergeSorter leftMergeSorter = new MergeSorter(leftHalf, executorService);
        MergeSorter rightMergeSorter = new MergeSorter(rightHalf, executorService);

//        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> leftSortedListFuture = executorService.submit(leftMergeSorter);   //non blocking call
        Future<List<Integer>> rightSortedListFuture = executorService.submit(rightMergeSorter); //non blocking call

        List<Integer> leftSortedList = leftSortedListFuture.get();
        List<Integer> rightSortedList = rightSortedListFuture.get();

        int i = 0;
        int j = 0;

        List<Integer> ansList = new ArrayList<>();
        while(i < leftSortedList.size() && j < rightSortedList.size()){
            if(leftSortedList.get(i) < rightSortedList.get(j)){
                ansList.add(leftSortedList.get(i++));
            } else {
                ansList.add(rightSortedList.get(j++));
            }
        }

        while(i < leftSortedList.size())
            ansList.add(leftSortedList.get(i++));
        while(j < rightSortedList.size())
            ansList.add(rightSortedList.get(j++));

        return ansList;
    }
}
