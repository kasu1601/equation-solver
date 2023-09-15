/*AUTHOR: Harshi Kasundi Bandaranayake
 *CURTIN ID: 20583387 
 *SLIIT ID: IT21151606
 *PURPOSE: creating a DSAStack class */

import java.util.*;

public class EquationSolver{

 	public static void main(String[]args){
 	
 		String equation = "";
 		Scanner sc = new Scanner(System.in);
 	
 		System.out.println("Enter your equation: ");
 		equation = sc.nextLine();
 		
 		System.out.println(solve(equation));
 	}
 	
 	public static double solve(String equation)
 	{
 		double finalResult = 0;
 		
 		parseInfixToPostfix(equation);
 		finalResult = evaluatePostfix(parseInfixToPostfix(equation));
 		
 		return finalResult;
 	}
 
 	public static int precedenceOf(String operator)
 	{
 		int order = 0;
 		
 		switch(operator) //using PEMDAS
 		{
 			case "-": case "+":
 				order = 1;
 			break;
 			
 			case "/": case "*":
 				order = 2;
 			break;
 			
 			default:
 				order = 0;
 		}
 		
 		return order;
 	}
 	
 	private static DSAQueue parseInfixToPostfix(String equation) 
 	{	
		String[] token = equation.split(" "); 
		Object value = 0;
		
		DSAStack stack = new DSAStack(token.length);
		DSAShufflingQueue postfixQueue = new DSAShufflingQueue(token.length);
		
		try{
			for(int i=0; i< token.length; i++)  
			{ 
				switch(token[i])
				{
					case("("):
					
						stack.push(token[i]);
					break;
				
					case(")"):
				
						while(!stack.isEmpty() && !(stack.top()).equals("("))
						{
                   					value = stack.pop();
                   					postfixQueue.enqueue(value);
                   				}
                   					stack.pop();
                   			break;
                   		
                   			case("-"): case("+"): case("/"): case("*"):
                   			
                   				while(!stack.isEmpty() && !(stack.top()).equals("(") && (precedenceOf((stack.top()).toString())>=precedenceOf(token[i])))
                   				{
                   					value = stack.pop();
                   					postfixQueue.enqueue(value);
                              		}
                              			stack.push(token[i]);
                             		break;
                              
                              	default:
                              		postfixQueue.enqueue(Double.valueOf(token[i]));	
				}  
			}
		
			while (!stack.isEmpty())
			{
				if((stack.top()).equals("("))
               	 	{
               	 		System.out.println("Invalid Expression");
               	 	}else{
					postfixQueue.enqueue(stack.pop());
			 	}
			}
		
		
		}catch(StackIsFullException e){
			System.out.println(e);
			
		}catch(StackIsEmptyException ex){
           		System.out.println(ex);
           		
        	}catch(QueueIsFullException e){
			System.out.println(e);
		}
				
		return postfixQueue;
	}
	
	private static double executeOperation(Object operator, double operand1, double operand2)
	{
		double result = 0;
		
		switch(operator.toString())
		{
                   case "+":
                    	result = operand2+operand1;
                   break;
                     
                   case "-":
                    	result = operand2-operand1;
                   break;
                     
                   case "/":
                    	result = operand2/operand1;
                   break;
                     
                   case "*":
                   	result = operand2*operand1;
                   break;
              }
              return result;
	}
	
	private static double evaluatePostfix(DSAQueue queue)
	{
		int length = queue.getCount();
		double result = 0;
		Object value = 0;
		DSAStack operandStack = new DSAStack(length);
		
		try
		{
			for(int i = 0; i<length; i++)
			{
				value = queue.dequeue();
				
				if(value instanceof Double)
				{
					operandStack.push(value);
			
				}else{
					double val1 = Double.valueOf(operandStack.pop().toString());
					double val2 = Double.valueOf(operandStack.pop().toString());
					
					result = executeOperation(value,val1,val2);
					operandStack.push(result);
				}		
			}
			
			result = Double.valueOf(operandStack.pop().toString());
			
		}catch(QueueIsEmptyException ex){
           		System.out.println(ex);
           			
		}catch(StackIsFullException e){
			System.out.println(e);
			
		}catch(StackIsEmptyException ex){
           		System.out.println(ex);		
           	}
           	
		return result;
	}
 }
 	
