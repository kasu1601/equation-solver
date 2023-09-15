class DSACircularQueue extends DSAQueue {

	/*DEFAULT CONSTRUCTOR
	IMPORT: none // Default constructors don't import
	EXPORT: none // Constructors never export
	ASSERTION: Creates an object with the default values*/
	
	public DSACircularQueue()
	{
		super();
	}
	
	/*CONSTRUCTOR with PARAMETERS
	IMPORT: (integer) maxCapacity
	EXPORT: NONE //Construstors never export
	ASSERTION: Creates DSAStack object with imported values*/
	
	public DSACircularQueue(int maxCapacity)
	{
	 	super(maxCapacity); 
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
	
	@Override
	public void enqueue(Object value) throws QueueIsFullException
	{		
		if(isFull()==true)
		{
			throw new QueueIsFullException("Looks like the queue is full!");
		}else{
			if(isEmpty()==true){
		
				this.front = 0;
        			this.rear = 0;
        		
        		}else if(this.rear == queue.length-1 && this.front !=0){
        	
        			this.rear = 0;
        			    
        		}else{
        			this.rear++;
        		}
        		
        	queue[this.rear] = value;
        	count++;
        	
        	}
	}
	
	@Override
	public void dequeue() throws QueueIsEmptyException
	{
		Object valueRemoved = 0;
		
		if(isEmpty()==true)
		{
			throw new QueueIsEmptyException("Looks like the queue is empty!");
		}else{
		
			valueRemoved = queue[this.front];
		
			if(this.front == this.rear){   //only one element in the circular queue
	
				this.front = -1;
				this.rear = -1;
			
			}else if(this.front == queue.length-1) {
			
				this.front = 0;
			}else{
				this.front++;
			}
			
		System.out.println(valueRemoved);
		count = count-1;
		
		}
	}
	
	@Override
	public void display() throws QueueIsEmptyException
	{
		if (isEmpty()==true) {
        	
          		throw new QueueIsEmptyException("Looks like the queue is empty!");
        	}else{
        		
        		if(rear >= front)
  			{
        			for(int i=front; i <= rear; i++)
       			{
            				System.out.print(queue[i]);
           				System.out.print(" ");
       			}
        				System.out.println();
   			}else{
       			 for(int i=front; i < queue.length; i++)
        			{
           				System.out.print(queue[i]);
            				System.out.print(" ");
       			}
 
        			for(int i=0; i <= rear; i++)
        			{
          				System.out.print(queue[i]);
            				System.out.print(" ");
       			}
        				System.out.println();
    			}
        		
    		}
	}
}	
	
	
