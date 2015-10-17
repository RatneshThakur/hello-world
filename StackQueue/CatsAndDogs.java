package crackTheCodingInterviewStacksAndQueues;
import java.util.*;

class Animal
{
	String type;
	int order;
	
	public void printType()
	{
		System.out.println("type :" + type);
	}
	public void setOrder(int ord)
	{
		order = ord;
	}
	public int getOrder()
	{
		return order;
	}
	public boolean isOlder(Animal a)
	{
		if(order > a.order)
			return true;
		return false;
	}
}

class Dogs extends Animal
{
	
}
class Cats extends Animal
{
	
}

class AnimalQueue{
	LinkedList<Dogs> dogList = new LinkedList<Dogs>();
	LinkedList<Cats> catList = new LinkedList<Cats>();
	private int order = 0;
	
	public void enqueue(Animal a)
	{
		order++;
		a.setOrder(order);
		
		if(a instanceof Dogs)
			dogList.addLast((Dogs)a);
		else if(a instanceof Cats)
			catList.addLast((Cats)a);
		
	}
	
	public Animal dequeue()
	{
		if(dogList.isEmpty() && catList.isEmpty())
			return null;
		if(dogList.isEmpty())
			return catList.poll();
		else if(catList.isEmpty())
			return dogList.poll();
		
		Animal dog = dogList.peek();
		Animal cat = catList.peek();
		if(dog.isOlder(cat))
			return dogList.poll();
		
		return catList.poll();
	}
	
	public boolean isEmpty()
	{
		if(dogList == null && catList == null)
			return true;
		else
			return false;
	}
	
}

public class CatsAndDogs {
	public static void main(String[] args)
	{
		Cats c = new Cats();
		c.type ="cat";
		AnimalQueue q = new AnimalQueue();
		q.enqueue(c);
		Dogs d = new Dogs();
		d.type = "dog";
		q.enqueue(d);
		Dogs d1 = new Dogs();
		d1.type = "dog";
		q.enqueue(d1);
		while(q.isEmpty() == false)
		{
			Animal a = q.dequeue();
			System.out.println("Animal is : "+ a.type);
		}
	}
}
