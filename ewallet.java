import java.util.Scanner;

public class ewallet
{
	Role role =  new Role();
	
	/** take money from player and give it for owner balance **/
	public void pay(String player, float price, String onwername)
	{
		System.out.println("How many hours?");
		
		Scanner in = new Scanner(System.in);
		float hours = in.nextFloat();
		
		for (int i = 0; i < role.player.size(); i++) // to take money from player
			if(role.player.get(i).getName().equals(player))
				role.player.get(i).setBalance(role.player.get(i).getBalance() - (price * hours));
		
		for(int i = 0; i < role.owner.size(); i++) // to add money to owner
			if(role.owner.get(i).getName().equals(onwername))
				role.owner.get(i).setBalance(role.owner.get(i).getBalance() + (price * hours));

	}
}
