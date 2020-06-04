import java.util.ArrayList;
import java.util.Scanner;

public class PlayGroundOwner extends Role 
{
	public  Scanner in = new Scanner(System.in);
	
	PlayGround play = new PlayGround();
	
	/** take all playgrounds informations from owner **/
	public PlayGround getPlaygroundInfo()
	{
		String name, location, size, ownerName;
		int avilableHours, cancellationHours;
		float pricePerHour;
		
		System.out.println("Enter playground name:");
		name = in.next();
		
		System.out.println("Enter playground location:");
		location = in.next();
		
		System.out.println("Enter playground size:");
		size = in.next();
		
		System.out.println("Enter playground owner name:");
		ownerName = in.next();
		
		System.out.println("Enter playground avilable hours:");
		avilableHours = in.nextInt();
		
		System.out.println("Enter playground cancellation hours:");
		cancellationHours = in.nextInt();
		
		System.out.println("Enter playground price per hour:");
		pricePerHour = in.nextFloat();
		
		PlayGround playground = new PlayGround(name, location, size, ownerName,"", avilableHours, cancellationHours, pricePerHour, 0, false);
		return playground;
	}

	/** let owner to see which playground is booked  **/
	public void viewBooking(ArrayList<PlayGround> approvedPlaygroundList, String name) 
	{
		for(PlayGround ground : approvedPlaygroundList) // easy way to loop on array of objects
			if(ground.getOwnerName().equals(name) && ground.isBook())
				System.out.println(ground.toString());
	}
	
	/** let owner to set avilable hours to his playgrounds **/
	public void setHours(ArrayList<PlayGround> approvedPlaygroundList, String name, int number)
	{
		String playgroundName;
		System.out.println("Enter playground name:");
		playgroundName = in.nextLine();
		
		for(PlayGround ground : approvedPlaygroundList)
			if(ground.getOwnerName().equals(name) && ground.getName().equals(playgroundName))
			{
				System.out.println("Enter The new avilableHours:");
				int avilableHours = in.nextInt();
				ground.setAvilableHours(avilableHours);
			}
	}
}
