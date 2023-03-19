import java.util.Stack;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Palindrome {
    // Methods for stack
    public static void input_to_stack(String input, Stack<Character> input_stack, Stack<Character> input_stack2) {
        for (int i = 0; i < input.length(); i++){
            input_stack.push(input.toCharArray()[i]);
            input_stack2.push(input.toCharArray()[i]);
        }
    }
    public static void input_reversal(Stack<Character> input_stack, Stack<Character> input_reverse){
        char tmp;
        int size = input_stack.size();
        for (int i = 0; i < size; i++) {
            tmp = input_stack.pop();
            input_reverse.push(tmp);
        }
    }

    // Methods for queue
    public static void input_to_queue(String input, Queue<Character> q, Queue<Character> q_reverse) {
        for (int i = 0; i < input.length(); i++) {
            q.add(input.toCharArray()[i]);
            q_reverse.add(input.toCharArray()[i]);
        }
    }

    public static void q_reversal(Queue<Character> q_reverse){
        int size = q_reverse.size();
        if (size == 0) {
            return;
        }
        char tmp;
        tmp = q_reverse.remove();
        q_reversal(q_reverse);
        q_reverse.add(tmp);
    }

    public static void main(String[] args) {
        System.out.println("Enter any string: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();

        // Using stack
        System.out.println("Using stack:");
        Stack<Character> input_stack = new Stack<>();
        Stack<Character> input_stack2= new Stack<>();
        Stack<Character> input_reverse = new Stack<>();
        input_to_stack(input, input_stack, input_stack2);
        input_reversal(input_stack, input_reverse);
        if (input_stack2.toString().equals(input_reverse.toString())) {
            System.out.println("\nThe input is a palindrome.");
        }
        else {
            System.out.println("\nThe input isn't a palindrome.");
        }

        // Using queue
        System.out.println("\nUsing queue");
        Queue<Character> q = new LinkedList<>();
        Queue<Character> q_reverse = new LinkedList<>();
        input_to_queue(input, q, q_reverse);
        q_reversal(q_reverse);
        if (q.toString().equals(q_reverse.toString())) {
            System.out.println("\nThe input is a palindrome.");
        }
        else {
            System.out.println("\nThe input isn't a palindrome");
        }
    }
}
