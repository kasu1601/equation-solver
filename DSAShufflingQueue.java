public class DSAShufflingQueue extends DSAQueue {
 
	/*DEFAULT CONSTRUCTOR
	IMPORT: none // Default constructors don't import
	EXPORT: none // Constructors never export
	ASSERTION: Creates an object with the default values*/
	
	public DSAShufflingQueue()
	{
		super();
	}
	
	/*CONSTRUCTOR with PARAMETERS
	IMPORT: (integer) maxCapacity
	EXPORT: NONE //Construstors never export
	ASSERTION: Creates DSAStack object with imported values*/
	
	public DSAShufflingQueue(int maxCapacity)
	{
	 	super(maxCapacity) ; 
	}
	 
	public int getCount()
	{
		return count;
	}

	public boolean isEmpty() 
	{
		boolean empty = super.isEmpty();
		return empty;
	}
	
	public boolean isFull()
	{
		boolean full = super.isFull();
		return full;
	}	
	
	public void enqueue(Object value) throws QueueIsFullException
	{
		super.enqueue(value);
	}
	
	public Object dequeue() throws QueueIsEmptyException
	{
		Object value = super.dequeue();
		return value;
	}
	
	public Object peek() throws QueueIsEmptyException
	{
		Object frontVal = super.peek();
		return frontVal;
	}
}
