package soliddemo;

public class AdderDriver {

    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println(adder.add(1, -2));

        adder = new PositiveAdder();
        System.out.println(adder.add(1, -2));
    }
}
