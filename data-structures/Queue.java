import java.util.*;

public class Queue<T> {

	private static Node head;
	private static Node tail;
	
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int userChoice = -1;
		head = tail = null;
		while(true){
		
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue ");
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
						enqueue(in.nextInt());
						break;
				case 2 :
						System.out.println("Dequeued "+dequeue());
						System.out.println("");
						break;
				case 3 :
						view();
						break;
				case 4 :
						System.out.println("Size of the queue is " + size());
						System.out.println("");
						break;
				case 5 :
						System.out.println("Queue is"+(isEmpty()?" ":" not ")+"empty");
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
		if(head != null){
			Node root = head;
			do{
				size++;
				root = root.next;
			} while(root!=null);
		}
		return size;
	}
	
	private static boolean isEmpty(){
		return head == null;
	}
	
	private static void enqueue(int data){
		Node node = new Node(data);
		if(tail == null){
			head = tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
		view();
	}
	
	private static int dequeue(){
		if(head == null){
			System.out.println("Underflow!!!");
			System.out.println("");
			System.exit(0);
		}
		int data = (Integer)head.data;
		head = head.next;
		if(head == null){
			tail = null;
		}
		view();
		return data;
	}
	
	private static void view(){
		if(head == null){
			System.out.println("Queue is empty!");
		} else {
			Node root = head;
			do{
				System.out.print(" --> " + root.data);
				root = root.next;
			} while(root!=null);
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