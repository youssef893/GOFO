import java.util.ArrayList;

public class Teams {
	ArrayList <ArrayList<String>> teams = new ArrayList();
	
	/** add account to teams array **/
	public void saveTeams(ArrayList<String> team)
	{
		teams.add(team);
	}
}
