package practice7_2;

import java.util.ArrayDeque;
import java.util.Deque;

public class IntegerStack {

    public static void main ( String[] args ) {
        // Create an instance of IntegerStack
        IntegerStack stack = new IntegerStack();

        // Push integers 0 to 4 onto the stack
        for (int i = 0; i < 5; i++) {
            stack.push(i);
        }

        // Print the stack after pushing elements
        System.out.println("After pushing 5 elements: " + stack);

        // Pop (remove) the top element from the stack
        int element = stack.pop();
        System.out.println("Popped element = " + element);
        System.out.println("After popping 1 element: " + stack);

        // Peek (look at) the top element without removing it
        int top = stack.peek();
        System.out.println("Peeked element = " + top);
        System.out.println("After peeking 1 element: " + stack);
    }

    // Underlying data structure: a Deque used to simulate a stack
    private Deque<Integer> data = new ArrayDeque<>();

    // Pushes an element onto the top of the stack
    public void push ( Integer element ) {
        data.addFirst(element);  // add to the front (top of stack)
    }

    // Pops (removes and returns) the top element of the stack
    public Integer pop () {
        if (data.isEmpty()) {
            System.out.println("Stack is empty");
        }
        return data.removeFirst(); // remove from front (top of stack)
    }

    // Peeks at (returns but does not remove) the top element of the stack
    public Integer peek () {
        return data.peekFirst();  // get the first element without removing it
    }

    // Returns the string representation of the stack
    public String toString () {
        return data.toString();
    }
}

