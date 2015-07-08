package dto;

public class History 
{
	private String time;
	private String userid;
	private String action;
	
	public History()
	{
		
	}
	
	public History(String time, String userid, String action)
	{
		super();
		this.time = time;
		this.userid = userid;	
		this.action = action;
	}

	public String getTime()
	{
		return time;
	}

	public void setTime(String time)
	{
		this.time = time;
	}

	public String getUserID()
	{
		return userid;
	}

	public void setUserID(String userid)
	{
		this.userid = userid;
	}

	public String getAction()
	{
		return action;
	}

	public void setAction(String action)
	{
		this.action = action;
	}

	public History getHistoryObject() throws Exception
	{
		History history = new History();
		history.setUserID("32E2A993");
		history.setAction("login");
		history.setTime("2015-05-31 12:14:18");
		
		return history;
	}
	
	@Override
	public String toString()
	{
		return "History time=" + time + ", userid=" + userid + ", action=" + action + "";			
	}
}
