import java.util.*;

public class Stack<T> {

	private static Node top;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int userChoice = -1;
		top = null;
		while(true){
		
			System.out.println("1. Push ");
			System.out.println("2. Pop ");
			System.out.println("3. View");
			System.out.println("4. Size");
			System.out.println("5. Is empty?");
			System.out.println("6. Exit Program");
			System.out.print("Enter your choice (number) : ");
			userChoice = in.nextInt();
			System.out.println("");
			switch(userChoice){
				case 1 :
						System.out.print("Enter the data : ");
						push(in.nextInt());
						break;
				case 2 :
						System.out.println("Popped "+pop());
						System.out.println("");
						break;
				case 3 :
						view();
						break;
				case 4 :
						System.out.println("Size of the stack is " + size());
						System.out.println("");
						break;
				case 5 :
						System.out.println("Stack is"+(isEmpty()?" ":" not ")+"empty");
						System.out.println("");
						break;
				case 6 :
						System.exit(0);
				default :
						System.out.println("Please enter a valid option!");
			}
		}
	}
	
	private static int size(){
		int size = 0;
		if(top != null){
			Node root = top;
			while(root != null){
				size++;
				root = root.next;			
			}	
		}
		return size;
	}
	
	private static boolean isEmpty(){
		return top == null;
	}
	
	private static void push(int data){
		Node node = new Node(data);
		node.next = top;
		top = node;
		view();
	}
	
	private static int pop(){
		if(top == null){
			System.out.println("Underflow!!!");
			System.out.println("");
			System.exit(0);
		}
		int data = (Integer)top.data;
		top = top.next;
		view();
		return data;
	}
	
	private static void view(){
		if(top == null){
			System.out.println("Stack is empty!");
		} else {
			Node root = top;
			while(root != null){
				System.out.print(" --> " + root.data);
				root = root.next;			
			}
		}
		System.out.println("");
		System.out.println("");
	}
	
	private static class Node<T>{
		
		private T data;
		private Node next;
		
		public Node(T data){
			this.data = data;
		}
		
		public T getData(){
			return data;
		}
		
		public Node getNext(){
			return next;
		}
		
	}

}