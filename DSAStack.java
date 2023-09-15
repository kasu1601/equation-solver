/*AUTHOR: Harshi Kasundi Bandaranayake
 *CURTIN ID: 20583387 
 *SLIIT ID: IT21151606
 *PURPOSE: creating a DSAStack class */

import java.util.*;

public class DSAStack
{	
	//declaring class fields
	private static final int DEFAULT_CAPACITY = 100;
	private int count = 0;
	Object[] stack; 
	
	/*DEFAULT CONSTRUCTOR
	IMPORT: none // Default constructors don't import
	EXPORT: none // Constructors never export
	ASSERTION: Creates an object with the default values*/
	
	public DSAStack()
	{
		stack = new Object[DEFAULT_CAPACITY]; 
	}
	
	/*CONSTRUCTOR with PARAMETERS
	IMPORT: (integer) maxCapacity
	EXPORT: NONE //Construstors never export
	ASSERTION: Creates DSAStack object with imported values*/
	
	 public DSAStack(int maxCapacity) throws ArrayIndexOutOfBoundsException
	 {
	 	if(maxCapacity>0){
	 	
	 		stack = new Object[maxCapacity]; 	
	 	}else{
	 		throw new ArrayIndexOutOfBoundsException("Size of the queue must be greater than zero");
	 	}
	 }
	 
	//SETTING UP GETTERS
	 
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
		
		if(count<=0)
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
		
		if(count==stack.length)
		{
			full = true;
		}
		
		return full;
	}
	
	/*ACCESSOR: top
	IMPORT: none
	EXPORT: topVal(Object)*/
	
	public Object top() throws StackIsEmptyException
	{
		Object topVal=0;
		
		if(isEmpty()==true)
		{
			throw new StackIsEmptyException("Looks like the stack is empty!");
		}else{
			topVal = stack[count-1];
			//return topVal;
		}
		
		return topVal; //remove this later
	}
	
	
	//SETTING UP SETTERS
	
	/*MUTATOR: push
	IMPORT: value(Object)
	EXPORT: none*/
		
	public void push(Object value) throws StackIsFullException
	{
		if(isFull()==true)
		{
			throw new StackIsFullException("Looks like the stack is full!");
		}else{
		
			stack[count] = value;
			count++;
		}
	}
	
	/*MUTATOR: pop
	IMPORT: none
	EXPORT: topVal(Object)*/
	
	public Object pop() throws StackIsEmptyException
	{
		Object topVal=0;
		if(isEmpty()== true)
		{
			throw new StackIsEmptyException("Looks like the stack is empty!");
		}else{
		
			topVal = top();
			count = count-1;
		}	
		return topVal;
		
	}
	
	public void display() throws StackIsEmptyException
	{
		if (isEmpty()==true) {
        	
          		throw new StackIsEmptyException("Looks like the stack is empty!"); 
        	}else{
        		for (int i = 0; i < count; i++){
        		
             			System.out.print("[");
            			System.out.print(stack[i]);
            			System.out.print("] ");
        		}
        			System.out.println();
    		}	
	}
}

	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
