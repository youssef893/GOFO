public class User {
	private String name, password, repassword, address, email;
	private int  phone, choice, role; 
	private float balance ;
	
	 public User(String name, String password, String repassword, String address, String email, int phone, float balance, int role) 
	{
		this.name = name;
		this.password = password;
		this.repassword = repassword;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.balance = balance;
		this.role = role;
	}

	public User() {}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}
}
