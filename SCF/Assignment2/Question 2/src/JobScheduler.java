import java.util.*;

// This is a main Class for First Come First Serve Job Scheduler Algo
public class JobScheduler
{
	// Method used to sort the Process with help of Arrival Time
	 public void sortbyArrivalTime(int process[][], int col, int size) 
	 { 
		 for(int i = 0; i < size; i++)
		 {
			 for(int j = 1; j < size ; j++)
			 if(process[j][0] <  process[j-1][0])
			 {
				 // for arrival Time
				 int temp;
				 temp = process[j][0];
				 process[j][0] = process[j-1][0];
				 process[j-1][0] = temp;
				 
				 //for Burst Time
				 temp = process[j][1];
				 process[j][1] = process[j-1][1];
				 process[j-1][1] = temp;
			 }
		 }      
	 } 
	
	//Method used to find completion time of Process
	public void CompletionTime(int process[][], int size, int turnAroundTime[], int completeTime[])
	{
		for(int i = 0; i < size; i++)
			completeTime[i] = process[i][0] + turnAroundTime[i];
	}
	
	// Method used to find Waiting Time of process
	public void WaitingTime(int process[][], int size, int waitingTime[])
	{
		int service_time[] = new int[size];
		service_time[0] = 0;
		waitingTime[0] = 0;
		
		for(int i = 1; i < size; i++)
		{
			 service_time[i] = service_time[i-1] + process[i-1][1]; 
			 waitingTime[i] = service_time[i] - process[i][0];
			 
			 if(waitingTime[i] < 0)
				 waitingTime[i] = 0;
		}
	}
	
	//method used to find Turn Around Time Of Process
	public void TurnAroundTime(int process[][], int size, int waitingTime[], int turnAroundTime[])
	{
		 for (int i = 0; i < size ; i++)  
			 turnAroundTime[i] = process[i][1] + waitingTime[i]; 
	}
	
	//method used for find Total Waiting Time
	public void TotalWaitingTime(int waitingTime[], int size)
	{
	    int total_waitingTime = 0; 
	    for (int i = 0 ; i < size ; i++) 
	    {
	    	total_waitingTime +=  waitingTime[i]; 
	    }
	    System.out.println("Average waiting time = " + (float)total_waitingTime / (float)size);  
	}
	
	//method used for find Maximum Waiting Time for a process in queue
	public void maxWaitingTime(int waitingTime[], int size)
	{
	   int max_waitingTime = 0; 
	   for (int i = 1 ; i < size ; i++) 
	   {
		   if(max_waitingTime < waitingTime[i])
		       max_waitingTime = waitingTime[i];
	   }
	  System.out.println("Maximum Waiting Time period for a process in queue = "+ max_waitingTime);  
	}
	
	//method used to display completion time , waiting time and TurnAround Time of all Process
	void display(int process[][], int size)
	{
		int waitingTime[] = new int[size], turnAroundTime[] = new int[size], completeTime[] = new int[size];  
		  
	    // Function to find waiting time of all processes  
	    WaitingTime(process, size, waitingTime);  
	  
	    // Function to find turn around time for all processes  
	    TurnAroundTime(process, size, waitingTime, turnAroundTime);
	    
	    // Function to find Completion time
	    CompletionTime(process, size, turnAroundTime, completeTime);
	  
	    // Display processes along with all details  
	    System.out.print("Processes " + " Arrival Time " + " Burst Time "  + " Waiting Time " + " Turn-Around Time "  + " Completion Time \n");  
	    for (int i = 0 ; i < size ; i++)  
	    {  
	        System.out.println(i+1 + "\t\t" + process[i][0] + "\t\t" + process[i][1] + "\t\t" + waitingTime[i] + "\t\t " + turnAroundTime[i] + "\t\t " + completeTime[i]);  
	    }  
	    
	    TotalWaitingTime(waitingTime, size);
	    maxWaitingTime(waitingTime, size);
	}
	
	public static void main(String arg[])
	{
		Scanner sc = new Scanner(System.in);
		JobScheduler obj = new JobScheduler();
		System.out.println("enter the no of Job");
		try
		{
		   int noOfJob = sc.nextInt();
		   int process[][] = new int[noOfJob][2];
		   //String processName[] = new String[noOfJob];
	       System.out.println("Enter the Arrival Time and Burst Time For each Process");
		   for(int i = 0; i < noOfJob; i++ )
	       {
			   System.out.println("For process "+ i);
			   //processName[i] = sc.next();
			   for(int j = 0; j < 2; j++)
			   {
				  try
				  {
				     process[i][j] = sc.nextInt(); 
				  }
				  catch(Exception e)
				{
					System.out.println(e);
				}
			  }
		   }
		   obj.sortbyArrivalTime(process, 0, noOfJob); 
		   obj.display(process, noOfJob);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
