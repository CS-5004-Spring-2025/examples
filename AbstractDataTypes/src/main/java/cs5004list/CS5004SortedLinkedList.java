package cs5004list;

public class CS5004SortedLinkedList<T extends Comparable<T>> implements CS5004SortedList<T> {

    private Node<T> head;
    private int size;

    public void insert(T element) {
        size++;
        if (head == null) {
            head = new Node<>(element);
            return;
        }
        head = head.insert(element);
    }

    public String toString()  {
        if (head == null) {
            return "";
        }
        return head.toString();
    }

    public int size() {
        if (head == null) {
            return 0;
        }
        return head.size(0);
    }

    class Node<T extends Comparable<T>> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node(T data) {
            this(data, null);
        }

//        public int size() {
//            if (this.next == null) {
//                return 1;
//            }
//            return 1 + this.next.size();
//        }

        public int size(int result) {
            if (this.next == null) {
                return result + 1;
            }
            return this.next.size(result + 1);
        }


        Node<T> insert(T data) {

            // insert at the beginning of the list
            if (data.compareTo(this.data) < 0) {
                Node<T> newNode = new Node<>(data, this);
                return newNode;
            }
            // insert at the end
            if (this.next == null) {
                Node<T> newNode = new Node<>(data);
                this.next = newNode;
                return this;
            }
            this.next = next.insert(data);
            return this;
        }

        public String toString() {
            if (this.next == null) {
                return data.toString();
            }
            return data.toString() + " " + next.toString();
        }

    }

}
