package arraysdemo;

public class Widget {

    private int number;
    private String word;

    public Widget(int number, String word) {
        this.number = number;
        this.word = word;
    }

    public Widget(Widget other) {
        this.number = other.getNumber();
        this.word = other.getWord();
    }

    public int getNumber() {
        return number;
    }

    public String getWord() {
        return word;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "Widget{" +
                "number=" + number +
                ", word='" + word + '\'' +
                '}';
    }

}
