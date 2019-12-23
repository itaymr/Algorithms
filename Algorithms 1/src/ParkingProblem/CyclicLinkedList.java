package ParkingProblem;
import java.util.Iterator;
import java.util.LinkedList;

public class CyclicLinkedList {

	
	LinkedList<Node> _nodes;
	private int size;
	private int index;
	private boolean nextCalled;
	public CyclicLinkedList()
	{
		_nodes = new LinkedList();
		size = 0;
	}
	
	public void addNode(Node n)
	{
		if(_nodes.isEmpty())
		{
			_nodes.add(n);
			n.setNext(n);
			size++;
			return;
		}
		
		_nodes.getLast().setNext(n);
		_nodes.add(n);
		_nodes.getLast().setNext(_nodes.getFirst());
		size++;
	}
	
	
	public Iterator<Node> iteretor()
	{
		return _nodes.iterator();
	}
	
	public LinkedList<Node> myList()
	{
		return _nodes;
	}
	
	int positiveRemainder(int n, int divisor)
	{
	  if (n >= 0)
	    return n % divisor;
	  else
	  {
	    int val = divisor + (n % divisor);
	    if (val == divisor)
	      return 0;
	    else
	      return val;
	  }
	}
	
	public Node get(int index)
	{
		return _nodes.get(positiveRemainder(index, size));
	}
	
	public Node getCurrent()
	{
		return this.get(index);
	}
	//
	public void goNext()
	{
		index++;
	}
	
	public void goPrev() {
		
		index--;
	}
	
}
