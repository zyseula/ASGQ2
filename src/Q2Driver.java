import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 *  Driver class
 *  <p>
 *  The invert indexing is done in the driver class
 *  <p>
 *  Author: Yi Zhang
 */

public class Q2Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File rawFile = new File("ds17s-Asg4-data.txt");
		try {
			Q2AddressBook ab = new Q2AddressBook(rawFile);
			Q2InvertIndexList OrgList = new Q2InvertIndexList();
			for(int i = 0;i<ab.number;i++)
			{
				String temp = ab.getOrgAt(i);
				String[] splited = temp.trim().split("\\s+");
				for(int j = 0;j<splited.length;j++){
					if(OrgList.contain(splited[j]))
						OrgList.add(splited[j], i);
					else
						OrgList.addNew(splited[j], i);
				}
			}
			System.out.println("Please enter the information you want to search:");
			Scanner keyboard=new Scanner(System.in);
			String input=keyboard.nextLine();
			System.out.println("Here is the search result:");
			int [] temp = OrgList.returnList(input);
			if(temp != null){
				for(int i = 0;i<temp.length;i++){
					if(temp[i]!=-1)
						System.out.println(ab.getALLAt(temp[i]).trim());
				}
			}
			else
			{
				System.out.println("O record matched!");
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
