import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Excursion 
{
	private String mDate;
	private String mStartTime;
	private int mDuration; // In Minutes
	private String mPlace;
	private String mDescription;
	private ArrayList<String> mParticipants;

	private static DateTimeFormatter DateFormatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
	private static DateTimeFormatter TimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	//Standard Constructor
	public Excursion() {
		mDate = LocalDateTime.now().format(DateFormatter);
		mStartTime = LocalDateTime.now().format(TimeFormatter);
		mDuration = 0;
		mPlace = "";
		mDescription = "";
		mParticipants = new ArrayList<String>();
	}

	//Constructor with basic params
	public Excursion(String date, String startTime, int duration, String place) {
		mDate = date;
		mStartTime = startTime;
		mDuration = duration;
		mPlace = place;
		mDescription = "";
		mParticipants = new ArrayList<String>();
	}

	//Constructor with basic params and description
	public Excursion(String date, String startTime, int duration, String place, String description)
	{
		mDate = date;
		mStartTime = startTime;
		mDuration = duration;
		mPlace = place;
		mDescription = description;
		mParticipants = new ArrayList<String>();
	}

	public void print()
	{
		System.out.println("Excursion (" + mDate + " , " + mStartTime + ") " + mDuration + " minutes long " + " at " + mPlace + " ( " + mDescription + " ) ");
		System.out.println("Participants: ");
		for (int i = 0; i < mParticipants.size(); i++)
		{
			System.out.println((i+1) + ") " + mParticipants.get(i));
		}
	}

	public void setDate(String date)
	{
		mDate = date;
	}

	public String getDate()
	{
		return mDate;
	}

	public void setStartTime(String startTime)
	{
		mStartTime = startTime;
	}

	public String getStartTime()
	{
		return mStartTime;
	}

	public void setDuration(int duration)
	{
		mDuration = duration;
	}

	public int getDuration()
	{
		return mDuration;
	}

	public void setPlace(String place)
	{
		mPlace = place;
	}

	public String getPlace()
	{
		return mPlace;
	}

	public void setDescription(String description)
	{
		mDescription = description;
	}

	public String getDescription()
	{
		return mDescription;
	}

	public ArrayList<String> getParticipants()
	{
		return mParticipants;
	}

	public void addParticipant(String name)
	{
		mParticipants.add(name);
	}

	public String getParticipantName(int index)
	{
		return mParticipants.get(index);
	}

	public int getNumberOfParticipants()
	{
		return mParticipants.size();
	}
}