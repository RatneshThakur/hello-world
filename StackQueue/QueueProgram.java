package crackTheCodingInterviewStacksAndQueues;

class Queue{
	Node head;
	Node tail;
	
	void enqueue(int val)
	{
		if(tail == null)
		{
			head = new Node();
			head.val = val;
			tail = head;
			tail.next = null;
		}
		else
		{
			Node newNode = new Node();
			newNode.val = val;
			tail.next = newNode;
			tail = tail.next;
			tail.next = null;
		}
	}
	int dequeue()
	{
		if(head == null)
		{
			System.out.println("Queue is empty");
			return -1;
		}
		
		int val = head.val;
		head = head.next;
		return val;
	}
	
	boolean isEmpty()
	{
		if(head == null)
			return true;
		return false;
	}
}

public class QueueProgram {
	public static void main(String[] args)
	{
		Queue q = new Queue();
		q.enqueue(5);
		q.enqueue(6);
		q.enqueue(7);
		q.enqueue(8);
		
		while(q.isEmpty() == false)
		{
			int val = q.dequeue();
			System.out.println("Value in Queue right now "+ val);
		}
	}
}
