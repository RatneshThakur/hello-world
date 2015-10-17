package crackTheCodingInterviewStacksAndQueues;

import javax.swing.plaf.synth.SynthOptionPaneUI;

class Node{
	int val;
	Node next;
}

class Stack{
	Node top;
	
	void push(int val)
	{
		if(top == null)
		{
			top = new Node();
			top.val = val;
			top.next = null;
		}
		else
		{
			Node newNode = new Node();
			newNode.val = val;
			newNode.next = top;
			top = newNode;
		}
	}
	
	int pop()
	{
		if(top == null)
		{
			System.out.println("Stack is empty");
			return -1;
		}
		int val = top.val;
		top = top.next;
		return val;
	}
	
	boolean isEmtpy()
	{
		if(top == null)
			return true;
		return false;
	}
}

public class StackProgram
{
	public static void main(String[] args)
	{
		Stack s = new Stack();
		s.push(1);
		s.push(6);
		s.push(7);
		
		while(s.isEmtpy() == false)
		{
			int val = s.pop();
			System.out.println("Value in stack is :" + val);
		}
		s.pop();
	}
}

