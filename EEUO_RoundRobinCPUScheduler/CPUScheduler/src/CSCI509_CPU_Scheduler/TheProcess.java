/**
 * Description: This class was created to read processes and all other information that come
 * from the “CSVTest.csv” file. The three variables that are in this specific class that are 
 * related from the csv table are called “PID”, “ArrivalTime”, and “BurstTime”.
 * 
 * @author eomed
 *
 */

package CSCI509_CPU_Scheduler;




public class TheProcess
{
    public int PID, ArrivalTime, ServiceTime, BurstTime, CompletionTime;

    /**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            TheProcess(int PID, int ArrivalTime, int BurstTime)
	 * @param PID
	 *            Parameter
	 * @param ArrivalTime
	 *            Parameter      
	 * @param BurstTime
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Reads the information that come from the “CSVTest.csv” file
	 * @param visiblity
	 *            public
	 */
    public TheProcess(int PID, int ArrivalTime, int BurstTime)
    {
        this.PID = PID; // Unique
        this.ArrivalTime = ArrivalTime;
        this.BurstTime = BurstTime;
        this. ServiceTime = 0;
    }
}
