package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.Access;
import dao.Database;
import dto.History;
import dto.Person;

public class AccessManager
{
	public ArrayList<Person> getPersons() throws Exception
	{
		ArrayList<Person> PersonList = new ArrayList<Person>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		PersonList = access.getPersons(con);
		return PersonList;
	}
	
	public ArrayList<Person> getPersonsById(String id) throws Exception
	{
		ArrayList<Person> PersonList = new ArrayList<Person>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		PersonList = access.getPersonsById(con,id);
		return PersonList;
	}
	
	public ArrayList<History> getPersonsHistoryById(String id) throws Exception
	{
		ArrayList<History> HistoryList = new ArrayList<History>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		HistoryList = access.getPersonsHistoryById(con, id);
		return HistoryList;
	}
	
	public ArrayList<History> getPersonsCurrentActionById(String id) throws Exception
	{
		ArrayList<History> HistoryList = new ArrayList<History>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		HistoryList = access.getPersonsCurrentActionById(con, id);
		return HistoryList;
	}
	
	public ArrayList<History> getAllHistories() throws Exception
	{
		ArrayList<History> HistoryList = new ArrayList<History>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		HistoryList = access.getAllHistories(con);
		return HistoryList;
	}	
	
	public Connection getConnectionForSaveHistory() throws Exception
	{
		Database db = new Database();
		Connection con = db.getConnection();
		return con;
	}	
	
	
	public ArrayList<History> getLoggedInCurrentPersons(String id) throws Exception
	{
		ArrayList<History> HistoryList = new ArrayList<History>();
		Database db = new Database();
		Connection con = db.getConnection();
		Access access = new Access();
		HistoryList = access.getLoggedInCurrentPersons(con, id);
		return HistoryList;
	}	
}
