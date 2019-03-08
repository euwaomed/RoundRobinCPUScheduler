# RoundRobinCPUScheduler
CSCI 509 - Operating Systems CPU Scheduler Round Robin



Efosa Eric Uwa-Omede ID #: 0842049
CPU Scheduling Project CSCI-509-M01
Uwa-Omede || 1
CPU Scheduler and Round Robin CPU Scheduling Project Report
Instructions:
1. Using the Java IDE of your choice, copy and open the three Java classes, under the path “CSCI509\CPUScheduler\src\CSCI509_CPU_Scheduler”, and the TESTCSV.csv.
2. Run “TheRunnable.java”
3. The user will be requested to enter the filename of the CSV (which is “TESTCSV.csv”) and then the desired Time Quantum (the program will fail if the number is too high).
4. After the user inputs the requested information, the program will run, finish, and display the “CPU Utilization”, “Throughput”, “Average Waiting Time”, and “Average Turnaround Time”.
Project and Program Explained:
According to “What is CPU Scheduling?”, CPU scheduling is a process which allows one process to use the CPU while the execution of another process is on hold (in waiting state) due to unavailability of any resource like I/O etc, thereby making full use of CPU (What is CPU Scheduling?). The aim of CPU scheduling is to make the system efficient, fast and fair (What is CPU Scheduling?).
According to “Program for Round Robin scheduling”, Round Robin is a CPU scheduling algorithm where each process is assigned a fixed time slot in a cyclic way. It is simple, easy to implement, and starvation-free as all processes get a fair share of CPU (Program for Round Robin scheduling).
According to “Program for Round Robin scheduling”, One of the most commonly used technique in CPU scheduling as a core (Program for Round Robin scheduling). It is preemptive as processes are assigned CPU only for a fixed slice of time at most (Program for Round Robin scheduling). The disadvantage of it is more overhead of context switching (Program for Round Robin scheduling).
Efosa Eric Uwa-Omede ID #: 0842049
CPU Scheduling Project CSCI-509-M01
Uwa-Omede || 2
For this project, there are three classes that are called “TheRunnable”, “TheProcess”, and “TheRRScheduler”. The objective of this project was to create a program that simulates Round Robin CPU scheduling. The program created generates a schedule of processes. The processes are stored in the CSV file. The program accepts two parameters. The first parameter is the name of processes CSV file. The second parameter is the desired time quantum of the user.
The “TheProcess” class was created to read processes and all other information that comes from the “CSVTest.csv” file. The three variables that are in this specific class that is related to the CSV table are called “PID”, “ArrivalTime”, and “BurstTime”.
The “TheRRScheduler” class is where the simulation of Round Robin CPU Scheduling takes place. Below are some important features that will help one to understand both the program and the importance of Round Robin to the CPU Scheduler.
In this class, there is a “ProcessesList”, “ReadyQueue”, “Timer” (serves as the purpose of a clock for the running program), “TimeQuantum” (requires user input), CPU (only holds one process at a time), “ContextSwitch” (tracks the switches of each process), and a “Counter”.
Inside the RoundRobin() method, a while loop exists to check if our “ReadyQueue”, “ProcessesList”, or the “CPU” is not empty. Unless we are finished with the processes list, the loop will continue running. Under the conditionals of the while loop, there is a for loop that goes through the “ProcessesList” and verifies which processes’ “ArrivalTime” is equal to the “Timer” (clock). Once a process successfully accomplishes verification through the “if” statement, it will be loaded onto the “ReadyQueue”.
The “CPU” undergoes verification on whether it is empty or not. If it is empty, then the “ReadyQueue” loads process onto the “CPU”. Next, the “Counter” records the current process of the “CPU” and that process’ “ServiceTime”. Afterward, we have an “if” statement that confirms whether or not current process’ “BurstTime” and “ServiceTime” are equal. If they are confirmed to be equal, then the process is done and can be removed from the “CPU”.
Efosa Eric Uwa-Omede ID #: 0842049
CPU Scheduling Project CSCI-509-M01
Uwa-Omede || 3
The program records the processes’ completion time before it is removed from the “CPU”. Then, that process will be added to the “EndProcesses” list. This enables the program to track the processes that have been completed. Then, the “CPU” becomes equals null which would enable it to accept the subsequent waiting process. The “ContextSwitch” is corrected to match the info within the program. In addition, the “Counter” becomes 0 which then triggers a reset.
In the method, the “else if” statement determines whether the process is greater than the value of the “TimeQuantum”. If this happens to be true, the process returns to the “ReadyQueue” to be loaded again, the “CPU” would be updated to null again, the “ContextSwitch” would also be corrected too. In the end, the “Counter” rests to 0.
This process is the way the "CPU" is effectively occupied, and the Round Robin ensures this to be the case. Afterward, the program successfully completes by computing and then printing the pieces of information known as “CPU Utilization”, “Throughput”, “Average Waiting Time”, and “Average Turnaround Time”. The program keeps track of the calculations with the following equations:
CPU Utilization = (Burst Time - (ContextTime * 0.01)) / Processes
Throughput = Processes / Timer
Avg. Waiting Time = The total of all Waiting Times / Processes
Avg. Turnaround Time = The total of all Turnaround Times / Processes
the CPU Scheduling after it prints the “CPU Utilization”, “Throughput”, “Average Waiting Time”, and “Average Turnaround Time”.
In short, the “TheRunnable” class requests the user to input the filename and desired Time Quantum. Afterward, the list of processes that comes from the CSV file is inputted into the ArrayList. Then, the Round Robin method within the “TheRRScheduler” class is utilized. Finally, the calculations are finished and printed to the console for the user to read after all the processes have been completed. References: Program for Round Robin scheduling | Set 1. (2018, September 06). Retrieved from https://www.geeksforgeeks.org/program-round-robin-scheduling-set-1/ What is CPU Scheduling? (n.d.). Retrieved from https://www.studytonight.com/operating-system/cpu-scheduling
