import java.io.*;
import java.util.*;


public class LowerCase {
	
	public static void main(String[] agrs)
	{
		readWrite("goodwordsSorted.txt", "lower.txt");
		
	}
	
	public static void readWrite(String s, String s2)
	{
		String temp;
		File inputFile = new File(s);
		File outputFile = new File(s2);
		try
		{
			Scanner sc = new Scanner (inputFile);
			while(sc.hasNextLine())
			{
				temp=sc.nextLine();
				temp = temp.toLowerCase();
				
				FileWriter fw = new FileWriter(outputFile, true);
				
					fw.write(temp + "\n");
				
				fw.close();			
				
				
			}
			
			sc.close();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
			System.exit(1);			
		}
		
	}
	
	
}