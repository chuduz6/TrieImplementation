import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.StringTokenizer;


// 

public class Main {
	
	public static void main (String[] args) {
		
		Trie badwords = new Trie();		
		badwords.setupTrie(args[0]);
		
		Trie goodwords = new Trie();		
		goodwords.setupTrie(args[1]);
				
		String temp;
		String temp2;
		File inputFile = new File(args[2]);
		File outputFile = new File(args[3]);
		try
		{
			
			Scanner sc = new Scanner (inputFile);
			while(sc.hasNextLine())
			{
				FileWriter fw = new FileWriter(outputFile, true);
				temp2=sc.nextLine();					
				StringTokenizer tokenizer = new StringTokenizer(temp2);
				
				while(tokenizer.hasMoreTokens())
				{
					temp = tokenizer.nextToken();
					temp = temp.toLowerCase();
					
					if(temp.startsWith("obama") || temp.startsWith("romney")  || temp.startsWith("barrack") || temp.startsWith("odumbo") || temp.startsWith("nobama") || temp.startsWith("odummy") || temp.startsWith("bammy") || temp.startsWith("barak") || temp.startsWith("barack") || temp.startsWith("barrak") || temp.startsWith("barock") || temp.startsWith("barrock") || temp.startsWith("barrok") || temp.startsWith("barrok") || temp.startsWith("barok") || temp.startsWith("potus") || temp.startsWith("mitt") || temp.startsWith("robme") || temp.startsWith("romnuts") || temp.startsWith("zomney") || temp.startsWith("romny") || temp.startsWith("romne") || temp.startsWith("romni") || temp.startsWith("romnesia") || temp.startsWith("mittens"))
					{
						fw.write(temp + " ");
					}
					else if (badwords.stringInTrie(temp))
					{
						fw.write(temp + "(bad) ");
					}
					else if (goodwords.stringInTrie(temp))
					{
						fw.write(temp + "(good) ");
					}
					else
					{
						
					}
						
					
				}
							
				fw.write("\n");
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