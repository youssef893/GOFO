import java.util.ArrayList;
import java.util.Scanner;

public class Player extends Role {
	User user = new User();
	PlayGround playground = new PlayGround();
	
	public Player() {}
	
	/** to increase his balance **/
	public void addBalance()
	{
		System.out.println("Enter your new balance");
		Scanner in = new Scanner(System.in);
		float balance = in.nextFloat();
		user.setBalance(balance);
	}
	
	/** book his playground by his email and hours he will play **/
	public void bookPlayground(ArrayList<PlayGround> approvedPlaygroundList, int number, String email, float bookedHours)
	{
		if(!approvedPlaygroundList.get(number).isBook())
		{
			approvedPlaygroundList.get(number).setBook(true);
			approvedPlaygroundList.get(number).setBookerName(email);
			approvedPlaygroundList.get(number).setBookedHours(bookedHours);
			System.out.println("you booked " + approvedPlaygroundList.get(number).getName());	
		}
		else
			System.out.println("This playground is booked before.");
	}
	
	/** to cancel his book only by his email **/
	public void cancelBookPlayground(ArrayList<PlayGround> approvedPlaygroundList,int number, String email)
	{
		if(approvedPlaygroundList.get(number).isBook() && approvedPlaygroundList.get(number).getBookerName().equals(email))
		{
			approvedPlaygroundList.get(number).setBook(false);
			System.out.println("your book is cancelled.");
		}
		else
			System.out.println("You didn't book this playground");
			
	}
	
	/** create his favourite team **/
	public void createTeam()
	{
		Player player = new Player();
		Teams teams = new Teams();
		ArrayList<String> team = new ArrayList<String>();
		String member;
		
		for(int i = 0; i < player.player.size(); i++)
			{
				int number = i + 1;
				System.out.println(number + "-" + player.player.get(i).getName());
			}
		
		System.out.println("How many players do you want?");
		Scanner in = new Scanner(System.in);
		int choice = in.nextInt();
		System.out.println("Choose your team's members");
		for(int i = 0; i < choice; i++)
		{
			member = in.next();
			team.add(member);
		}
		teams.saveTeams(team);
	}	
}
