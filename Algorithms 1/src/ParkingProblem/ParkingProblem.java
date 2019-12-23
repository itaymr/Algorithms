package ParkingProblem;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;
/**
 * This is an algorithm to solve the parking problem, whereas you need to count the number of cars in a circular parking lot.
 * You can only move forwards and backwards, and each car could be marked.
 * The solution is iterating through the circular list;
 * first - mark your own car with a specific letter, go one steps forward
 * if the next car is not marked, continue another step(n steps total)
 * if after n steps a car is marked with a letter, change it to another
 * go n steps backwards, this will be your starting position.
 * if the letter has changed, this means you completed one full circle, return n 
 * if not, reset n, continue again
 * @author itaymeiri
 *
 */
public class ParkingProblem {

	
	public static int CyclicLinkedListSize()
	{
		CyclicLinkedList cll = new CyclicLinkedList();



		int size = ThreadLocalRandom.current().nextInt(10, 100 + 1); // generate a random size
		System.out.println("Expected size:" + size);

		for(int i = 0; i < size; i++)
		{
			//add size amount of random nodes, containing random characters
			cll.addNode(new Node((char) ThreadLocalRandom.current().nextInt(10, 100 + 1))); // generates a node with random data
		}
		
		
		boolean foundStart = false;
		
		int counter = 0;
		
		
		cll.get(0).setData('V'); // set the starting position to 0
		while(!foundStart)
		{
			
			cll.goNext(); // iterates
			counter++;
			Node curr = cll.getCurrent();
			if(curr.getData() == 'V')
			{	
				curr.setData('W');
				int temp = counter;
				while(counter > 0)
				{
					cll.goPrev();
					counter--;
				}
				if(cll.getCurrent().getData() == 'W')
				{
					foundStart = true;
					counter = temp;
				}
				else
				{
					counter = 0;
				}
				
			}
		}
		return counter;
		
	}
	

	
	public static void main(String args[])
	{
		
		for(int i = 0; i < 100; i++)
		{		
			System.out.println("actual size: " + CyclicLinkedListSize());
			System.out.println("");
		}
		
	}
}
