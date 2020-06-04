import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	public static String ownerName;
	public static int number;
	public static int balance;
	public static Scanner in = new Scanner(System.in);
	public static Role roleObject = new Role();
	public static PlayGroundOwner owner = new PlayGroundOwner();
	public static PlayGround playground = new PlayGround();
	public static Player player = new Player();
	public static Adminstrator admin = new Adminstrator();
	public static ewallet wallet = new ewallet();
	
	/** this array store all playgrounds until admin approve them **/
	public static ArrayList<PlayGround>playgroundList = new ArrayList<PlayGround>();
	/** this array store playground after approving **/
	public static ArrayList<PlayGround>approvedPlaygroundList = new ArrayList<PlayGround>();
	
	/** to display main menu to user and let him to log out from his account **/
	public static void logOut()
	{
		int choice = 0;
		do 
		{
			System.out.println("1-Log in \n2-Sign up");
			choice = in.nextInt();
			
			if(choice == 1)
				login();
			else if(choice == 2)
				signUp();
			else
				System.out.println("Wrong choice");
		}
		while(choice < 1 || choice > 2);
	}
	
	/** display playground owner menu and let him to enter any function **/
	public static void owner(String email)
	{
		while(true)
		{
			System.out.println("1-Add new playground \n 2-Set hours \n 3-Show Booking \n 4-Exit");
		
			int choice = in.nextInt();
			if(choice == 1)
			{
				playgroundList.add(owner.getPlaygroundInfo());
			}
			else if(choice == 2)
			{
				System.out.println("Enter avilable hours:");
				number = in.nextInt();
				owner.setHours(approvedPlaygroundList, email, number);
			}
			else if(choice == 3)
			{
				System.out.println("Enter your name:");
				ownerName = in.next();
				owner.viewBooking(approvedPlaygroundList, ownerName);
			}
			else if(choice == 4)
				logOut();
			else
				System.out.println("Wrong choice");
		}
	}
	
	/** display admin menu and let him to approve or delete or suspend or activate ant playground **/
	public static void admin()
	{
		boolean check = false;
		while(true)
		{
			System.out.println(" 1-Approve playground \n 2-Delete playground\n 3-Suspend playground \n 4-Activate playground \n 5-Exit");
		
			int choice = in.nextInt();
			if(choice == 1)
			{
				for(int i = 0 ; i < playgroundList.size(); i++)
				{
					check = admin.approvePlayGround(playgroundList.get(i));
					if(check)
					{
						approvedPlaygroundList.add(playgroundList.get(i));
					}
					else
						playgroundList.remove(i);
				}
				
			}
			else if(choice == 2)
				admin.deletePlayGround(approvedPlaygroundList);
			else if(choice == 3)
			{
				admin.suspendPlayGround(approvedPlaygroundList);
			}
			else if(choice == 4)
				admin.activatePlayground(approvedPlaygroundList);
			else if(choice == 5)
				logOut();
			else
				System.out.println("Wrong choice");
		}
	}
	
	/** display player menu and let him choose anything **/
	public static void player(String email)
	{
		while(true)
		{
			System.out.println("1-Show playground \n 2-Create team \n 3-Book \n 4-Cancel booking \n 5-Add balance \n 6-Exit");
		
			int choice = in.nextInt();
			if(choice == 1)
				playground.displayPlayGrounds(approvedPlaygroundList);
			else if(choice == 2)
				player.createTeam();
			else if(choice == 3)
			{
				playground.displayPlayGrounds(approvedPlaygroundList);
				
				System.out.println("Enter your chocie:");
				int playGround = in.nextInt();
				
				System.out.println("How many hours will you book it?");
				int bookedHours = in.nextInt();
				
				player.bookPlayground(approvedPlaygroundList, playGround - 1, email, bookedHours);
				
				for(int i = 0; i < player.player.size(); i++)
				{
					if(player.player.get(i).getEmail().equals(email))
						wallet.pay(player.player.get(i).getName(), approvedPlaygroundList.get(i).getPricePerHour(),
								approvedPlaygroundList.get(i).getOwnerName());
					break;
				}
				
			}
			else if(choice == 4)
			{
				playground.displayPlayGrounds(approvedPlaygroundList);
				System.out.println("Enter your Chocie");
				int ans = in.nextInt();
				player.cancelBookPlayground(approvedPlaygroundList, ans, email);
			}
			else if(choice == 5)
				player.addBalance();
			else if(choice == 6)
				logOut();
			else
				System.out.println("Wrong choice");
		}
	}
	
	/** check the email and password was signed up before or not **/
	public static boolean determinOwnerOrPlayer(String email, String password)
	{
		boolean check = false; // to prevent unnesseray loops to start  
		for(User roles : roleObject.owner)
		{
			if(roles.getEmail().equals(email))
			{
				owner(email);
				check = true;
			}
			break;
		}
		if(!check)
		{
			for(User roles : roleObject.player)
			{
				if(roles.getEmail().equals(email))
				{
					player(email);
					check = true;
				}
				break;
			}
		}
		
		if(!check)
		{
			for(User roles : roleObject.admin)
			{
				if(roles.getEmail().equals(email))
					admin();
				break;
			}
		}
		
		return check;
	}
	
	public static void login()
	{	
		boolean check = false;
		do
		{
			String email = "", password = "";
			
			System.out.println("Enter your email:");
			email = in.next();
			
			System.out.println("Enter your paswword:");
			password = in.next();
			
			check = determinOwnerOrPlayer(email, password);
		}
		while(!check);
	}
	
	public static void signUp()
	{
		String name = "", password = "", repassword = "", address = "", email = "";
		int role, phone; 
		boolean falseEmail = true, falsePassword = true;
		
		System.out.println("Enter your name:");
		name = in.next();
		while(true)
		{
			do
			{
				System.out.println("Enter your email:");
				email = in.next();
				for(int i = 0; i < email.length(); i++)
				{
					if(email.contains("@") && email.contains(".com") && !email.contains(" "))
						falseEmail = false;
					else
						System.out.println("Your email is wrong. Must contain @ and .com");
				}
				
				
			}while(falseEmail);
			
			do
			{
				System.out.println("Enter your password:");
				password = in.next();
				
				System.out.println("Re-Enter your password:");
				repassword = in.next();
				
				if(password.equals(repassword))
					falsePassword = false;
				else
					System.out.println("your password is wrong re-enter it again.");
			}while(falsePassword);
			if(!determinOwnerOrPlayer(email, password))
			{
				System.out.println("This email is already signed up");
				logOut();
			}
			else
				break;
		}
		System.out.println("Enter your address:");
		address = in.next();
		
		System.out.println("Enter your phone number:");
		phone = in.nextInt();
		
		System.out.println("Enter your balance:");
		balance = in.nextInt();
		do
		{
			System.out.println("Choose your role:" + "\n" + "1-Playground Owner" + "\n" + "2-Player" + "\n" + "3-Admin");
			role = in.nextInt();
		
			if(role > 3 || role < 1)
				System.out.println("Wrong choice");
		
		}while(role > 3 || role < 1);
		
		User user = new User(name, password, repassword, address, email, phone, balance, role);
		
		if(role == 1)
		{
			roleObject.ownerList(user);
			owner(email);
		}
		else if(role == 2)
		{
			roleObject.playerList(user);
			player(email);
		}
		else if(role == 3)
		{
			roleObject.adminList(user);
			admin();
		}
	}
	
	public static void main(String[] args) 
	{
		logOut();	
	}

}
