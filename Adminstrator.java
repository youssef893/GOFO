import java.util.ArrayList;
import java.util.Scanner;

public class Adminstrator extends Role{
	PlayGround playground ;
	Scanner in = new Scanner(System.in);
	/** store the suspended playgrounds until admin activate it **/
	ArrayList <PlayGround> suspendedPlayground = new ArrayList();
	
	/** let admin to review and accept or ignore the playground **/
	public boolean approvePlayGround(PlayGround playgrounds)
	{
		boolean check = false;
		System.out.println(playgrounds.toString());
		System.out.println("Enter your choice:" + "\n" + "1-Approve" + "\n" + "2-Decline");
			
		int choice = in.nextInt();
			
		if(choice == 1)
		{
			check = true;
			System.out.println("added");
		}
		else if(choice == 2)
			System.out.println("Deleted");
		return check;
	}
	
	/** let admin to delete playground **/
	public void deletePlayGround(ArrayList<PlayGround> approvedPlaygroundList)
	{
		playground.displayPlayGrounds(approvedPlaygroundList);
		System.out.println("\nEnter number of playground to delete:");
		int choice = in.nextInt();
		approvedPlaygroundList.remove(choice - 1);
		
	}
	
	/** to suspend playground **/
	public void suspendPlayGround(ArrayList<PlayGround> approvedPlaygroundList)
	{
		playground.displayPlayGrounds(approvedPlaygroundList);
		
		System.out.println("\nEnter number of playground to suspend:");
		int choice = in.nextInt();
		
		suspendedPlayground.add(approvedPlaygroundList.get(choice - 1));
		approvedPlaygroundList.remove(choice - 1);
		
	}
	
	/** to remove playground from suspended array and activate it **/
	public void activatePlayground(ArrayList<PlayGround> approvedPlaygroundList)
	{
		for(int i = 0; i < suspendedPlayground.size(); i++)
		{
			int number = i + 1;
			System.out.println(number + "-" + suspendedPlayground.get(i).toString());
		}
		
		System.out.println("Enter number of playground to activate:");
		int choice = in.nextInt();
		approvedPlaygroundList.add(suspendedPlayground.get(choice - 1));
	}

}
