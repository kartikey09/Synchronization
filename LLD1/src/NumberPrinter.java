public class NumberPrinter implements Runnable{
    private int number;

    public NumberPrinter(int number){
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("The number is : " + this.number + " and the thread is " + Thread.currentThread().getName());
    }
}