package soliddemo;

public class PositiveAdder extends Adder {

    public PositiveAdder() {

    }

    @Override
    public int add(int a, int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException();
        }
        return super.add(a, b);
    }
}
