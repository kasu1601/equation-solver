/*AUTHOR: Harshi Kasundi Bandaranayake
 *CURTIN ID: 20583387 
 *SLIIT ID: IT21151606
 *PURPOSE: creating a DSAQueue class */

import java.util.*;

class DSAQueue
{	
	//declaring class fields
	protected static final int DEFAULT_CAPACITY = 100;
	protected int front,rear,count = 0;
	Object[] queue; 
	
	/*DEFAULT CONSTRUCTOR
	IMPORT: none // Default constructors don't import
	EXPORT: none // Constructors never export
	ASSERTION: Creates an object with the default values*/
	
	public DSAQueue()
	{
		queue = new Object[DEFAULT_CAPACITY];
	}
	
	/*CONSTRUCTOR with PARAMETERS
	IMPORT: (integer) maxCapacity
	EXPORT: NONE //Construstors never export
	ASSERTION: Creates DSAStack object with imported values*/
	
	public DSAQueue(int maxCapacity) throws ArrayIndexOutOfBoundsException
	{
		if(maxCapacity>0){
		
	 		queue = new Object[maxCapacity]; 
	 	}else{
	 		throw new ArrayIndexOutOfBoundsException("Size of the queue must be greater than zero");
	 	}
	}
	 
	//initialising getters
	 
        /*ACCESSOR: getCount
	IMPORT: none
	EXPORT: count(integer)*/
	
	public int getCount()
        {
        	return count;
        }

        /*ACCESSOR: isEmpty
	IMPORT: none
	EXPORT: empty(boolean)*/
	
	public boolean isEmpty()
	{
		boolean empty = false;
		
		if(count==0)
		{
			empty = true;
		}
		
		return empty;
	}
	
	/*ACCESSOR: isFull
	IMPORT: none
	EXPORT: full(boolean)*/
	
	public boolean isFull()
	{
		boolean full = false;
		
		if(count==queue.length)
		{
			full = true;
		}
		
		return full;
	}
	
	/*MUTATOR: enqueue
	IMPORT: value(Object)
	EXPORT: none*/
		
	public void enqueue(Object value) throws QueueIsFullException
	{
		if(isFull()==true){
		
			throw new QueueIsFullException("Looks like the queue is full!");
		}else{
			queue[rear] = value;
			rear++;
			count++;
		}
	}
	
	/*MUTATOR: dequeue
	IMPORT: NONE
	EXPORT: frontVal*/
		
	public Object dequeue() throws QueueIsEmptyException
	{
		Object value = 0;
		if(isEmpty()==true){
			throw new QueueIsEmptyException("Looks like the queue is empty!");
		}else{	
			
			value = peek();
			
			for(int i=0; i<rear-1; i++) //shuffling all elements up by one
			{
				queue[i] = queue[i+1];
			}
			
			rear = rear-1;
			count = count-1;
		}
		
		return value;
	}
	
	public Object peek() throws QueueIsEmptyException
	{
		Object frontVal = 0;
	
		if(isEmpty()==true){
		
			throw new QueueIsEmptyException("Looks like the queue is empty!");
		}else{
			frontVal = queue[front];
		}
		
		return frontVal;
	}
	
	public void display() throws QueueIsEmptyException
   	{
        	if (isEmpty()==true) {
        	
          		throw new QueueIsEmptyException("Looks like the queue is empty!"); 
        	}else{
        		for (int i = front; i < rear; i++){
        		
            			System.out.print("[");
            			System.out.print(queue[i]);
            			System.out.print("] ");
        		}
        			System.out.println();
    		}
    	}	
	
	
}
