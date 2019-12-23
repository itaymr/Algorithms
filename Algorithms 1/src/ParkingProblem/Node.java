package ParkingProblem;

public class Node {

	
	Node next;
	char data;
	
	public Node(char data)
	{
		next = null;
		this.data=data;
	}
	
	
	public void setData(char data)
	{
		this.data = data;
	}
	
	public Node getNext()
	{
		return next;
	}
	
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	public char getData()
	{
		return data;
	}
}

