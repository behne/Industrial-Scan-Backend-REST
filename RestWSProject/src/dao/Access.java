package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import dto.History;
import dto.Person;

public class Access
{
	public ArrayList<Person> getPersons(Connection con) throws SQLException
	{
		ArrayList<Person> PersonList = new ArrayList<Person>();
		PreparedStatement stmt = con.prepareStatement("SELECT * FROM person");
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				Person PersonObj = new Person();
				PersonObj.setId(rs.getString("id"));
				PersonObj.setfirstName(rs.getString("firstName"));
				PersonObj.setlastName(rs.getString("lastName"));
				//PersonObj.setloggedIn(rs.getString("loggedIn"));
				//PersonObj.setloggedOut(rs.getString("loggedOut"));
				PersonObj.setRole(rs.getString("role"));
				PersonList.add(PersonObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return PersonList;
		
	}
	
	public ArrayList<Person> getPersonsById(Connection con, String id) throws SQLException
	{
		String query = "SELECT * FROM `person` WHERE id = 'ID'";
		query = query.replaceFirst("ID",id);
		System.out.println(query);
		ArrayList<Person> PersonList = new ArrayList<Person>();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try //p.id = :ID").setParameter("ID", id).uniqueResult();
		{
			while(rs.next())
			{
				Person PersonObj = new Person();
				PersonObj.setId(rs.getString("id"));
				PersonObj.setfirstName(rs.getString("firstName"));
				PersonObj.setlastName(rs.getString("lastName"));
				//PersonObj.setloggedIn(rs.getString("loggedIn"));
				//PersonObj.setloggedOut(rs.getString("loggedOut"));
				PersonObj.setRole(rs.getString("role"));
				PersonList.add(PersonObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return PersonList;
		
	}
	
	
	public ArrayList<History> getPersonsHistoryById(Connection con, String id) throws SQLException
	{
		//String query = "SELECT * FROM history where userid = (ID)";
		String query = "SELECT * FROM person INNER JOIN history ON history.userid = person.id WHERE person.id = 'ID'";
		query = query.replaceFirst("ID",id);
		System.out.println(query);
		//ArrayList<Person> PersonList = new ArrayList<Person>();
		
		ArrayList<History> HistoryList = new ArrayList<History>();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				//Person PersonObj = new Person();
				//PersonObj.setfirstName(rs.getString("firstname"));
				//PersonObj.setlastName(rs.getString("lastname"));
				
				History HistoryObj = new History();
				HistoryObj.setTime(rs.getString("time"));
				//HistoryObj.setUserID(rs.getString("userid"));
				HistoryObj.setAction(rs.getString("action"));
				HistoryList.add(HistoryObj);
				//PersonList.add(PersonObj);
				//List<Person> newList = new ArrayList<Person>(PersonList);
				//newList.addAll(HistoryList);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return HistoryList;		
	}		
	
	public ArrayList<History> getPersonsCurrentActionById(Connection con, String id) throws SQLException
	{
		//String query = "SELECT * FROM history where userid = (ID)";
		//String query = "SELECT action FROM history h WHERE userid = 'ID' and time=( SELECT MAX(time) FROM history WHERE h.action = action and h.userid = 'ID')";
		String query = "SELECT action FROM history h WHERE userid = 'ID' ORDER BY h.time DESC";
		query = query.replaceFirst("ID",id);
		System.out.println(query);
		//ArrayList<Person> PersonList = new ArrayList<Person>();
		
		ArrayList<History> HistoryList = new ArrayList<History>();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{

				History HistoryObj = new History();
				HistoryObj.setAction(rs.getString("action"));
				HistoryList.add(HistoryObj);
				break;
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return HistoryList;		
	}		
	
	public ArrayList<History> getLoggedInCurrentPersons(Connection con, String id) throws SQLException
	{
		//String query = "SELECT * FROM history where userid = (ID)";
		//String query = "SELECT action FROM history h WHERE userid = 'ID' and time=( SELECT MAX(time) FROM history WHERE h.action = action and h.userid = 'ID')";
		String query = "SELECT time, action FROM history h WHERE userid = 'ID' ORDER BY h.time DESC";
		query = query.replaceFirst("ID",id);
		System.out.println(query);
		//ArrayList<Person> PersonList = new ArrayList<Person>();
		
		ArrayList<History> HistoryList = new ArrayList<History>();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{

				History HistoryObj = new History();
				HistoryObj.setAction(rs.getString("action"));
				HistoryObj.setTime(rs.getString("time"));
				HistoryList.add(HistoryObj);
				break;
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return HistoryList;		
	}		
	
	public ArrayList<History> getAllHistories(Connection con) throws SQLException
	{
		String query = "SELECT * FROM history ORDER BY time DESC";
		
		ArrayList<History> HistoryList = new ArrayList<History>();
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery();
		try
		{
			while(rs.next())
			{
				History HistoryObj = new History();
				HistoryObj.setTime(rs.getString("time"));
				HistoryObj.setUserID(rs.getString("userid"));
				HistoryObj.setAction(rs.getString("action"));
				HistoryList.add(HistoryObj);
			}
		} catch (SQLException e)
		{		
			e.printStackTrace();
		}
		return HistoryList;		
	}			
	
	
	public boolean saveHistory(History history, Connection con) throws SQLException
	{
		java.sql.Statement statement = null;
 
		String query = "INSERT INTO history(time, userid, action) VALUES ('TIME','ID','ACTION')";
		query = query.replaceFirst("ID",history.getUserID());
		query = query.replaceFirst("ACTION",history.getAction());
		query = query.replaceFirst("TIME",history.getTime());
		
		try {
			statement = con.createStatement();
 			System.out.println(query);
 			statement.executeUpdate(query);
			//System.out.println("Record is inserted into DBUSER table!");
			
			return true;
 
		} catch (SQLException e) {
 
			//System.out.println(e.getMessage());
			
			return false;
		}
	}
}
