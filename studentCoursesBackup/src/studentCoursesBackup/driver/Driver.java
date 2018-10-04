package studentCoursesBackup.driver;

import java.io.File;

import studentCoursesBackup.myTree.BST;
import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.util.Results;
import studentCoursesBackup.util.TreeBuilder;

/**
 * @author Aaditya Sakharam Patil
 *
 */
public class Driver {
	/**
	 * Main method
	 * @param Commandline args
	 * @return none
	 */
	public static void main(String[] args) {
		try {
			
			/**
			 * As the build.xml specifies the arguments as argX, in case the
			 * argument value is not given java takes the default value specified in
			 * build.xml. To avoid that, below condition is used
			 */
			if (args.length != 5 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}") || args[4].equals("${arg4}" )) 
			{
				System.out.println(args.length);
				System.err.println("Error: Incorrect number of arguments. Program accepts 5 argumnets.");
				System.exit(0);
			}
			
			/**
			 *argument validation
			 */
			File file1 = new File(args[0]);
			if (!file1.exists()) 
			{
				System.out.println("Input file does not exist.");
				System.exit(1);
			}
			File file2 = new File(args[1]);
			if (!file2.exists()) 
			{
				System.out.println("delete file does not exist.");
				System.exit(1);
			}
			
			String inputFile=args[0];
			String deleteFile = args[1];
			String output1 = args[2];
			String output2 = args[3];
			String output3 = args[4];
			
			//tree input
			TreeBuilder t1= new TreeBuilder(inputFile,deleteFile);
			BST tree1 = t1.tree("orig");
			BST bTree1 =t1.tree("backup1");
			BST bTree2 =t1.tree("backup2");
			Results o1= new Results(output1);
			Results o2= new Results(output2);
			Results o3= new Results(output3);
			tree1.printNodes();
			o1.displayStdOut("Original Tree: \n");
			o1.writeToFile();
			o1.clearResult();
			bTree1.printNodes();
			o2.displayStdOut("\nBackup Tree1: \n");
			o2.writeToFile();
			o2.clearResult();
			bTree2.printNodes();
			o3.displayStdOut("\nBackup Tree2: \n");
			o3.writeToFile();
			o3.clearResult();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
		finally {
			
		}
	
	}

	@Override
	public String toString() {
		return "Driver [toString()=" + super.toString() + "]";
	}
}
