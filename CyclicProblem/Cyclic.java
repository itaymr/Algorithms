package CyclicProblem;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

import ParkingProblem.CyclicLinkedList;
import ParkingProblem.Node;

/**
 * This is an implementation of Floyd's Tortoise and Hare algorithm, used to determine whether 
 * a list is cyclic. 
 * @author itaymeiri
 *
 */
public class Cyclic {



	public static boolean isCyclic()
	{
				
		int size = ThreadLocalRandom.current().nextInt(10, 100 + 1); // generate a random size

		CyclicLinkedList cll = new CyclicLinkedList();
			//Initialziing random letters
			for(int i = 0; i < size; i++)
			{
				//add size amount of random nodes, containing random characters
				cll.addNode(new Node((char) ThreadLocalRandom.current().nextInt(1, 70 + 1))); // generates a node with random data, doesn't create 'H' or 'T'
			}

		
		boolean ans = false;


		boolean flag = false;
		int hare = 0;
		int tortoise = 0;
		while (!flag)
		{
			hare+= 2;
			tortoise+=1;
			try {
				if(cll.get(hare).equals(cll.get(tortoise))) // check if they're the exact same object using Objects .equal
				{
					flag = true;
					// cycle detected
					ans = true;
				}
			}
			catch(NullPointerException e)
			{
				
				//We found a null pointer, meaning the list has a cut off point and isn't cyclic
				ans = false;
				flag = true;
			}
		}


		return ans;	


	}
	public static void main(String[] args)
	{

		System.out.println("IsCyclic?:" + isCyclic());

	}
}
