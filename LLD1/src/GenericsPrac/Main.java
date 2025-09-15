package GenericsPrac;

public class Main {
    public static void main(String args[]){
        GenericCont<Integer> gc1 = new GenericCont<>();
        GenericCont<String> gc2 = new GenericCont<>();
        gc1.add(22);
        System.out.println(gc1.get());
        gc2.add("Hello");
        System.out.println(gc2.get());
    }
}
