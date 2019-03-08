/**
 * Description: The “TheRunnable” class is started to prompt the user for the 
 * filename and desired Time Quantum. From there, the csv table transfers the
 * list of processes to the ArrayList.)
 * 
 * @author eomed
 *
 */

package CSCI509_CPU_Scheduler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TheRunnable {

	/**
	 * Parameterized constructor
	 * 
	 * @param name
	 *            main(String[] arg) throws IOException
	 * @param arg
	 *            Parameter
	 * @param override
	 *            None
	 * @param comment
	 *            Prompts the user for the filename of CSVFile 
	 *            and desired Time Quantum
	 * @param visiblity
	 *            public
	 */

	public static void main(String[] arg) throws IOException {
		Scanner kb = new Scanner(System.in);
		System.out.print("Please Enter Filename: ");
		String FileName = kb.nextLine();
		System.out.print("Please Enter Time Quantum: ");
		int tq = kb.nextInt();
		Scanner inputStream = new Scanner(new File(FileName));
		inputStream.useDelimiter("(,|\\v+)");
		inputStream.nextLine();
		ArrayList<CSCI509_CPU_Scheduler.TheProcess> CSVFile = new ArrayList<>();
		while (inputStream.hasNext()) {
			CSCI509_CPU_Scheduler.TheProcess Process = new CSCI509_CPU_Scheduler.TheProcess(inputStream.nextInt(),
					inputStream.nextInt(), inputStream.nextInt());
			CSVFile.add(Process);
		}

		CSCI509_CPU_Scheduler.TheRRScheduler MyScheduler = new CSCI509_CPU_Scheduler.TheRRScheduler(CSVFile, tq);
		MyScheduler.RoundRobin();
		kb.close();
		inputStream.close();
	}

}
