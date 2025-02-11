package arraysdemo;

import java.util.Arrays;

public class ArraysDemo {

    public static void testIntArray() {

        int[] numbers = new int[10];
        System.out.println(numbers[10]);
        int[] withInitializerList = {1, 2, 3};
        System.out.println(withInitializerList[2]);

    }

    public static void deepCopy(Widget[] array1, Widget[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if(array1[i] != null) {
                array2[i] = new Widget(array1[i]);
            }
        }
    }

    public static void testWidgetArray() {
        Widget[] widgets = new Widget[10];
        widgets[0] = new Widget(1, "cat");
        widgets[1] = new Widget(2, "dog");
        widgets[2] = new Widget(3, "bird");
        Arrays.stream(widgets).forEach(widget -> System.out.println(widget));
        Widget[] copy = new Widget[10];
        deepCopy(widgets, copy);
        widgets[0].setWord("***NEW WORD***");
        Arrays.stream(copy).forEach(widget -> System.out.println(widget));

//
//                Arrays.copyOf(widgets, widgets.length);
//
//

    }

    public static void main(String[] args) {
//        testIntArray();
        testWidgetArray();
    }

}
