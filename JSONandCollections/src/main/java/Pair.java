public class Pair <T, U>{

    private T thing1;
    private U thing2;

    public Pair(T thing1, U thing2) {
        this.thing1 = thing1;
        this.thing2 = thing2;
    }
    public T getThing1() {
        return thing1;
    }
    public U getThing2() {
        return thing2;
    }

}
