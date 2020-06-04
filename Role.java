import java.util.ArrayList;

public class Role {
	ArrayList<User> owner = new ArrayList<User>();
	ArrayList<User> player = new ArrayList<User>();
	ArrayList<User> admin = new ArrayList<User>();	
	
	public boolean check = false;
	
	/** add account to owner array **/
	public void ownerList(User account)
	{
		owner.add(account);
	}
	/** add account to player array **/
	public void playerList(User account)
	{
		player.add(account);
	}
	/** add account to admin array **/
	public void adminList(User account)
	{
		admin.add(account);
	}
}
