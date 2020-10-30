/*										Dated: 2020-09-27
			Välkommen till kursen Grundläggande programmering Java
				Assignment 1b - Queue to checkout
This program is to write a console application where we can add and remove the people in a queue.
        				Programmer: ARSALAN HABIB						*/
 

import java.util.*;
class PQueue {
	public static void main(String[] args)  {

		//  The Scanner class is used to get user input and it is found in the java.util package.
		Scanner input = new Scanner(System.in);		 
	
				
		//  Declare all the variables, integer type and string type.
		int k, i, j;
		int size = 1, count = 0, counter = 0;
		String str, str1, str2;
		String str3 = "quit";

		//  Initialize arraylist string type named as a Queue
		ArrayList<String> Queue = new ArrayList<String>();
  	
		//  Queue Initially add "CHECKUP<-"
		Queue.add("CHECKUP<-");		

		//  This loop count 8 times and add "-" 
		for(i=0 ; i <8; i++)		
			Queue.add("-");

		//  Replace all "," "]" with "|" and replace "[" with ""
		str2 = Queue.toString().replaceAll("," , "|").replace("[","").replace("]","|");	 

		//  CHECKUP<-|-|-|-|-|-|-|-|-|
		System.out.println(str2);    
		System.out.println("----------------------------------");	

		System.out.println("Enter a command: ");
		System.out.print("> ");
		do 
		{
			str = input.nextLine(); 	// Enter user input.


			//  Splits the string based on whitespace	
			String[] Split = str.split("\\s");

			//  This statement can passes through the switch command
			str = Split[0];
		
			//  This loop is to check the Capital Alphabets in a command.
			for (i = 0 ; i < str.length(); i++)   
			{
				char ch = str.charAt(i);
		 		if (ch >= 'A' && ch <= 'Z') 
				count++; 
			}

			//  Using Switch conditional statement
			switch(str)	  
			{
				//  First case executed if the user input command is matches the string "put".
				case "put":      
				{ 	 
			
					//  Using loop to insert the person name in string array
					for (j = 1 ; j < Split.length; j++) 	
					{ 	
						str1 = Split[j];
						 
						//  You can only allow to add 8 person in a queue.
						if(j < 10 )

							//  This loop is to check the Capital Alphabets in the person name.
							for (i = 0 ; i < str1.length(); i++)     
							{
								char ch = str1.charAt(i);
		 						if (ch >= 'A' && ch <= 'Z') 
								counter++; 
							}

							//  This statement matches both the condition "the length of the string is lessthan 11 and all the letter must be small".   
							if (counter == 0 && str1.length() <= 10)	
							{
								//  If the size of the queue less than 9, it add the person in the queue.
								if(size < 9) 	
								{
									str2 = Queue.set(size, str1);		
									size++;
								}

								//  You cannot add more then 8 person in the queue, the queue is full.
								else  	
									System.out.println("QUEUEING FULL: " + str1 + " could not add to the queue.");

								//  This loop to check the names in the queue.
								for (i = 0 ; i < size; i++)
								{
									for(k = i+1; k < size; k++)
									{ 
										//  If the person name is already exist, it print the error message.	
										if(Queue.get(i).equals(Queue.get(k)))     
										{
											str2 = Queue.set(size-1,"-");
											str2 = Queue.toString().replaceAll("," , "|").replace("[","").replace("]","|");
											size--;
											System.out.println("DUPLICATE NAME INVALID: " + str1 + " already exist in the queue.");
										}
									}
								}
							} 
		
							//  Print the error messages.
							else
							{
								//  This condition check if the length of the person name is greater than 11, it print the error message.
								if(str1.length() > 10)     
								{
									System.out.println("NAME LENGTH INVALID: Skipping this person name: "+str1);
									counter = 0;
								}

								//  If the person name is in Capital letters print the error message.
								else		
								{
									System.out.println("CAPITAL LETTER INVALID : " + str1 + " is in Capital, skipping this person.");
									counter = 0;
								}
							}	

					}
						str2 = Queue.toString().replaceAll("," , "|").replace("[","").replace("]","|");
						System.out.println(str2);
						System.out.println("----------------------------------");
		
						System.out.println("Enter a command: ");
						System.out.print("> ");
				} 
				break;

				//  Second case executed if the user input command is matches the string "process".
				case "process":       
				{
					//  This condition is not allow any arguments.
					if(Split.length < 2)
					{ 
	
						//  Queue is already empty. Print the output CHECKUP<-|-|-|-|-|-|-|-|-|
						if(size == 1)		
						{
							System.out.println(str2);
							System.out.println("----------------------------------");	

							System.out.println("Queue is Already Empty!!");
							System.out.println("Enter a command: ");
							System.out.print("> ");
						}
	
						//  We help a person to treat (process) the person.
						else		
						{
							str2 = Queue.remove(1);
							Queue.add("-"); 
							size--;
							str2 = Queue.toString().replaceAll("," , "|").replace("[","").replace("]","|");	

							//  Now queue is empty, it process all the person and print the output CHECKUP<-|-|-|-|-|-|-|-|-|
							if (size == 1) 		
							{ 
								System.out.println(str2);
								System.out.println("----------------------------------");	
	
        	    						System.out.println("Queue is Empty!!");
								System.out.println("Enter a command: ");
								System.out.print("> ");
							} 

							//  Process the person in the queue.
        						else	
  							{
								System.out.println(str2);
								System.out.println("----------------------------------");	

								System.out.println("Enter a command: ");
								System.out.print("> ");
							}
						}
					}

					//  If user input a command with arguments occur error message.	
					else  
					{
						System.out.println("INVALID COMMAND: You cannot pass through any arguments in the (process) command.");
		
						System.out.println("Re-Enter a command: ");
						System.out.print("> ");
					}
				}
				break;

				//  Next case executed if the user input command is matches the string "reset".
				case "reset":     
				{
					//  This condition is not allow any arguments.
					if(Split.length < 2)
					{ 

						//  Queue is already empty. Print the output CHECKUP<-|-|-|-|-|-|-|-|-|
						if(size == 1)  	
						{
							System.out.println(str2);
							System.out.println("----------------------------------");	

							System.out.println("Queue is Already Empty!!");
							System.out.println("Enter a command: ");
							System.out.print("> ");
						}
	
						//  Clear the queue (reset) and print the output CHECKUP<-|-|-|-|-|-|-|-|-|
						else	
						{
							Queue.clear();
							Queue.add("CHECKUP<-");
							for(i=0 ; i <8; i++)
							Queue.add("-");
						
							str2 = Queue.toString().replaceAll("," , "|").replace("[","").replace("]","|");
							size = 1;
							System.out.println(str2);
							System.out.println("----------------------------------");	

							System.out.println("Enter a command: ");
							System.out.print("> ");
						}	
					}

					//  If user input a command with arguments occur error message.	
					else  
					{	
						System.out.println("INVALID COMMAND: You cannot pass through any arguments in the (reset) command.");
								
						System.out.println("Re-Enter a command: ");
						System.out.print("> ");
					}
				}
				break;
	
				//  Last case executed if the user input command is matches the string "quit".
				case "quit":
				{
					//  This condition is not allow any arguments.
					if(Split.length < 2)    	
						System.out.println("Exiting... ");
	
					//  If user input a command with arguments occur error message.	
					else  
					{
						System.out.println("INVALID COMMAND: You cannot pass through any arguments in the (quit) command.");
			
						System.out.println("Re-Enter a command: ");
						System.out.print("> ");
						str = Split[1];
					}
				}
				break;
		
				//  Default label executed if the user entered invaild command.	
				default:

					//  If you enter the command is in Capital letters, it print error.	
					if(count > 0)	
					{	
						System.out.println("Command in Capital is Invalid !!! ");
						count = 0;	
						System.out.println("Re-Enter a command: ");
						System.out.print("> ");
					}

					//  If you do not use the valid command, it print error message.
					else	
					{
						System.out.println("UNKNOWN COMMAND!!");	
						System.out.println("Re-Enter a Command:");  
						System.out.print("> ");
					}
		
	
			}

		//  This condition is terminate only if you enter the input "quit".
		}  while(str.equals(str3) != true); 	
	}

}

					//  Program Ends.
