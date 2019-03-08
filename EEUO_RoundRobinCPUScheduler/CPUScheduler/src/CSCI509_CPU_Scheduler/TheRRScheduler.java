package CSCI509_CPU_Scheduler;

/**
 * Description: The “TheRRScheduler” class is where the simulation of Round Robin CPU Scheduling
 * takes place. Below are some important features that will help one to understand both the 
 * program and importance of Round Robin to the CPU Scheduler. 
 * 
 * @author eomed
 *
 */


import java.util.ArrayList;


//Source Code
public class TheRRScheduler
{
    int Timer;
    ArrayList<CSCI509_CPU_Scheduler.TheProcess> ProcessesList;
    ArrayList<CSCI509_CPU_Scheduler.TheProcess> ReadyQueue;
    ArrayList<CSCI509_CPU_Scheduler.TheProcess> EndProcesses;

    int TimeQuantum;
    int ContextSwitch; // small number that should be less than half the TimeQuantum

    CSCI509_CPU_Scheduler.TheProcess CPU;
    int Counter;

    /**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            TheRRScheduler(ArrayList<CSCI509_CPU_Scheduler.TheProcess> ProcessesList, 
	 *            int TimeQuantum)
	 * @param ProcessesList
	 *            Parameter
	 * @param TimeQuantum
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Stores the information in the ArrayList for which would be used in the 
	 *            RoundRobin() method
	 * @param visiblity
	 *            public
	 * 
	 */

    public TheRRScheduler(ArrayList<CSCI509_CPU_Scheduler.TheProcess> ProcessesList, int TimeQuantum)
    {
        this.TimeQuantum = TimeQuantum;
        this.ProcessesList = ProcessesList;
    }

    /**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            RoundRobin()
	 * @param override
	 *            None
	 * @param comment
	 *            Inside the RoundRobin() method, a while loop exists to check 
	 *            if our “ReadyQueue”, “ProcessesList”, or the “CPU” is not empty. 
	 * @param visiblity
	 *            public
	 * 
	 */
    public void RoundRobin()
    {
        Timer = 0;
        ContextSwitch = 0;
        CPU = null;
        ReadyQueue = new ArrayList<>();
        EndProcesses = new ArrayList<>();

        while(!ReadyQueue.isEmpty() || !ProcessesList.isEmpty() || CPU != null)
        {
            //add to ReadyQueue
            for(int i = 0; i < ProcessesList.size(); i++)
            {
                if(ProcessesList.get(i).ArrivalTime == Timer)
                {
                    ReadyQueue.add(ProcessesList.remove(i));
                }
            }

            // Add to CPU
            if (CPU == null)
            {
                CPU = ReadyQueue.remove(0);
            }

            Counter++;
            CPU.ServiceTime++;

            if(CPU.BurstTime == CPU.ServiceTime)
            {
                // done
                CPU.CompletionTime = Timer; //Completion Time is set
                EndProcesses.add(CPU);
                CPU = null;
                ContextSwitch++;
                Counter = 0;
            }
            else if(Counter == TimeQuantum)
            {
                //Exceeds TimeQuantum
                ReadyQueue.add(CPU);
                CPU = null;
                ContextSwitch++;
                Counter = 0;
            }
            Timer++; // Real Time

            double SumTurnAroundTime = 0.0;
            double SumWaitingTime = 0.0;
            double SumUtil = 0.0;
            for(int j = 0; j < EndProcesses.size(); j++)
            {
                SumTurnAroundTime += EndProcesses.get(j).CompletionTime - EndProcesses.get(j).ArrivalTime;
                SumWaitingTime += (EndProcesses.get(j).CompletionTime - EndProcesses.get(j).ArrivalTime)
                        - EndProcesses.get(j).BurstTime;
                SumUtil += EndProcesses.get(j).BurstTime;
            }

            double AvgTurnAroundTime = SumTurnAroundTime / EndProcesses.size();
            double AvgWaitingTime = SumWaitingTime / EndProcesses.size();
            double CPUUtilization = (SumUtil - (ContextSwitch * 0.01)) / Timer;
            double Throughput = (double) EndProcesses.size() / Timer;

            System.out.println("");
            System.out.println("CPU Utilization: " + CPUUtilization);
            System.out.println("Throughput: " + Throughput);
            System.out.println("Average Waiting Time: " + AvgWaitingTime);
            System.out.println("Average Turnaround Time: " + AvgTurnAroundTime);

        }


    }

}
