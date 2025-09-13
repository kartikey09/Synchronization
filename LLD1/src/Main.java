import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 100; i++) {
            if(i == 5 || i == 10 || i == 95)
                    System.out.println("hello");
            NumberPrinter nb = new NumberPrinter(i);
            executorService.submit(nb);
        }
        executorService.shutdown();
    }
}