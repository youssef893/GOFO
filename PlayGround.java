import java.util.ArrayList;

public class PlayGround {
	private String name, loction, size, ownerName, bookerName;
	private int avilableHours;
	private float pricePerHour, cancellationPeriod, bookedHours;
	private boolean book = false;
		
	public PlayGround() {}
	
	

	public PlayGround(String name, String loction, String size, String ownerName, String bookerName, int avilableHours,
			float pricePerHour, float cancellationPeriod, float bookedHours, boolean book) {
		super();
		this.name = name;
		this.loction = loction;
		this.size = size;
		this.ownerName = ownerName;
		this.bookerName = bookerName;
		this.avilableHours = avilableHours;
		this.pricePerHour = pricePerHour;
		this.cancellationPeriod = cancellationPeriod;
		this.bookedHours = bookedHours;
		this.book = book;
	}

	/** to can change these values **/
	public String getBookerName() {
		return bookerName;
	}

	public float getBookedHours() {
		return bookedHours;
	}

	public void setBookedHours(float bookedHours) {
		this.bookedHours = bookedHours;
	}

	public void setBookerName(String bookerName) {
		this.bookerName = bookerName;
	}

	public float getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(float pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public boolean isBook() {
		return book;
	}

	public void setAvilableHours(int avilableHours) {
		this.avilableHours = avilableHours;
	}

	public String getName() {
		return name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setBook(boolean book) {
		this.book = book;
	}	
	
	@Override
	public String toString() {
		return "PlayGround: \n [name = " + name + "\n loction = " + loction + "\n size = " + size + "\n ownerName = " + ownerName
				+ "\n avilableHours = " + avilableHours + "\n cancellationPeriod = " + cancellationPeriod + "\n pricePerHour = "
				+ pricePerHour + "\n book = " + book + "]";
	}

	/** print all playgrounds **/
	public void displayPlayGrounds(ArrayList<PlayGround> approvedPlaygroundList)
	{
		System.out.println(approvedPlaygroundList.size());
		for(PlayGround ground : approvedPlaygroundList)
		{
			System.out.println(ground.toString());
		}
	}
	
	
}
