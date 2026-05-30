package six;
public class Stack<T> {
    private final T[] data;
    private int size;

    @SuppressWarnings("unchecked")
    public Stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new RuntimeException("Stack Overflow: stack is full.");
        }
        data[size] = element;
        size++;
    }

    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty: there is nothing to pop.");
        }
        size--;
        T element = data[size];
        data[size] = null;
        return element;
    }

    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Stack is empty: stack is empty.");
        }
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        Stack<String> stringStack = new Stack<>(3);
        System.out.println("Is the stack empty? " + stringStack.isEmpty());
        stringStack.push("First");
        stringStack.push("Second");
        stringStack.push("Third");
        System.out.println("highest element: " + stringStack.peek());
        System.out.println("pop: " + stringStack.pop());
        System.out.println("pop: " + stringStack.pop());
        System.out.println("New highest element: " + stringStack.peek());
    }
}
