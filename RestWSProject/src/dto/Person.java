package dto;

public class Person
{
	/*private int id;
	private String name;
	private String duration;
	private double fee;

	public Person()
	{
		
	}
	
	public Person(int id, String name, String duration, double fee)
	{
		super();
		this.id = id;
		this.name = name;
		this.duration = duration;
		this.fee = fee;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDuration()
	{
		return duration;
	}

	public void setDuration(String duration)
	{
		this.duration = duration;
	}

	public double getFee()
	{
		return fee;
	}

	public void setFee(double fee)
	{
		this.fee = fee;
	}

	@Override
	public String toString()
	{
		return "Person [id=" + id + ", name=" + name + ", duration=" + duration
				+ ", fee=" + fee + "]";
	}*/

	private String firstName;
	private String lastName;
	private String    id;
	//private String loggedIn;
	//private String loggedOut;
	private String role;

	public Person()
	{
		
	}
	
	public Person(String firstName, String lastName, String id, String loggedIn, String loggedOut, String role)
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.loggedIn = loggedIn;
		//this.loggedOut = loggedOut;
		this.role = role;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getfirstName()
	{
		return firstName;
	}

	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getlastName()
	{
		return firstName;
	}

	public void setlastName(String lastName)
	{
		this.lastName = lastName;
	}

	/*public String getloggedIn()
	{
		return loggedIn;
	}
	
	public void setloggedIn(String loggedIn)
	{
		this.loggedIn = loggedIn;
	}

	public String getloggedOut()
	{
		return loggedIn;
	}
	
	public void setloggedOut(String loggedOut)
	{
		this.loggedOut = loggedOut;
	}*/
	
	public void setRole(String role)
	{
		this.role = role;
	}
	
	public String getRole()
	{
		return role;
	}

	@Override
	public String toString()
	{
		return "Person id=" + id + ", firstName=" + firstName + ", lastName=" + lastName	+ ", role=" + /*loggedIn + ", loggedOut=" + loggedOut +",  role=" +*/ role + "";
	}
}
