package webService;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.AccessManager;
import dao.Access;
import dao.Database;
import dto.History;
import dto.Person;

@Path("/users")
public class PersonService
{
	@GET
	@Path("/getAllPersons")
	@Produces("application/json")
	public String getAllPersons()
	{
		String Persons = null;
		ArrayList<Person> PersonList = new ArrayList<Person>();
		JsonArray personArray;
		try
		{
			PersonList = new AccessManager().getPersons();
			System.out.println(PersonList.toString());
			Gson gson = new Gson();
			JsonElement tree = gson.toJsonTree(PersonList);
			personArray = tree.getAsJsonArray();
			String History = null;
			ArrayList<History> HistoryList = new ArrayList<History>();
			for(JsonElement element : personArray)
			{
				HistoryList = new AccessManager().getPersonsCurrentActionById(element.getAsJsonObject().get("id").getAsString());
				History = gson.toJson(HistoryList);
				System.out.println(History);
				element.getAsJsonObject().addProperty("status", HistoryList.get(0).getAction());
			}
			return personArray.toString();
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return "{Error}";
	}
	
	
	@GET
	@Path("/getLoggedInCurrentPersonsJSON")
	@Produces("application/json")
	public String getLoggedInCurrentPersonsJSON()
	{
		String Persons = null;
		ArrayList<Person> PersonList = new ArrayList<Person>();
		JsonArray personArray;
		JsonArray activePersonList = new JsonArray();
		
		try
		{
			PersonList = new AccessManager().getPersons();
			System.out.println(PersonList.toString());
			Gson gson = new Gson();
			JsonElement tree = gson.toJsonTree(PersonList);
			personArray = tree.getAsJsonArray();
			String History = null;
			String status = "";
			ArrayList<History> HistoryList = new ArrayList<History>();
			for(JsonElement element : personArray)
			{
				HistoryList = new AccessManager().getLoggedInCurrentPersons(element.getAsJsonObject().get("id").getAsString());
				History = gson.toJson(HistoryList);
				System.out.println(History);
				element.getAsJsonObject().addProperty("time", HistoryList.get(0).getTime());
				element.getAsJsonObject().addProperty("status", HistoryList.get(0).getAction());
				
				status = element.getAsJsonObject().get("status").toString();
				
				if(status.equals("\"login\""))
					activePersonList.add(element);
				else
					System.out.println("{Error1}");
			}
			
			return activePersonList.toString();
			
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return "{Error}";
	}
	
	
	@GET
	@Path("getPersonByIdJSON/{id}")
	@Produces("application/json")
	public String getPersonByIdJSON(@PathParam("id")String id)
	{
		String Persons = null;
		ArrayList<Person> PersonList = new ArrayList<Person>();
		try
		{
			PersonList = new AccessManager().getPersonsById(id);
			Gson gson = new Gson();
			Persons = gson.toJson(PersonList);
			System.out.println(Persons);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return Persons;
	}
	
	@GET
	@Path("getPersonHistoryByIdJSON/{id}")
	@Produces("application/json")
	public String getPersonHistoryByIdJSON(@PathParam("id")String id)
	{
		System.out.println(id+"\n");
		
		String History = null;
		String Person = null;
		String Result = null;
		String Test = null;
		ArrayList<History> HistoryList = new ArrayList<History>();
		ArrayList<Person> PersonList = new ArrayList<Person>();
		//
		ArrayList<Object> mergeResult = new ArrayList<Object>();
		try
		{
			HistoryList = new AccessManager().getPersonsHistoryById(id);
			PersonList = new AccessManager().getPersonsById(id);
			
			
			Gson gson = new Gson();
			
			//
			mergeResult.addAll(PersonList);
			mergeResult.addAll(HistoryList);	
			//
			
			//History = gson.toJson(HistoryList);
			//Person = gson.toJson(PersonList);
			
			Test = gson.toJson(mergeResult);
			
			//Result = History.concat(Person);
			
			System.out.println(Test);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return Test;
	}
	
	@GET
	@Path("getPersonsCurrentActionByIdJSON/{id}")
	@Produces("application/json")
	public String getPersonsCurrentByIdJSON(@PathParam("id")String id)
	{
		System.out.println(id+"\n");
		
		String History = null;
		ArrayList<History> HistoryList = new ArrayList<History>();
		try
		{
			HistoryList = new AccessManager().getPersonsCurrentActionById(id);
			Gson gson = new Gson();
			History = gson.toJson(HistoryList);
			System.out.println(History);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return History;
	}
	
	
	@GET
	@Path("getAllHistories")
	@Produces("application/json")
	public String getAllHistories()
	{		
		String History = null;
		ArrayList<History> HistoryList = new ArrayList<History>();
		try
		{
			HistoryList = new AccessManager().getAllHistories();
			Gson gson = new Gson();
			History = gson.toJson(HistoryList);
			System.out.println(History);
		} catch (Exception e)
		{
				e.printStackTrace();
		}
		return History;
	}
	
	/*@GET
	@Path("saveHistory")
	@Produces("application/json")
	public String saveHistory()
	{
		String Result = null;
		Connection con = null;
		try
		{
			//f�r JSON 
			//FileInputStream input = new FileInputStream("C:/Users/Matthias/workspace/RestWSProject/history.json");
            //BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			//testObject = new AccessManager().getHistoryObject();
			//History = testObject.toString();
			//Gson gson = new Gson();
			//History = gson.fromJson(reader,History.class);
			//History testHistory = gson.fromJson(reader, History.class);
			Gson gson = new Gson();
			String test ="{'time':'2015-05-30 12:14:18.0','userid':'32E2A993','action':'login'}";
			History history = gson.fromJson(test,History.class);
			
			//Test
			//History testObject = new History().getHistoryObject();
			con = new AccessManager().getConnectionForSaveHistory();
			
			Access access = new Access();
			if(access.saveHistory(history, con) == true)
				Result = "OK";
			else Result = "ERROR";

		}
		catch (Exception e)
		{
				e.printStackTrace();
		}
		return Result;
	}*/
	
	
	@POST
	@Path("/saveHistory")
	@Consumes("application/json")
	@Produces("application/json")
	public String saveHistory(InputStream incomingData)
	{
		StringBuilder history = new StringBuilder();
		try
		{
		BufferedReader in = new BufferedReader(new InputStreamReader(incomingData));
		String line = null;
		while((line = in.readLine()) != null)
		{
			history.append(line);
		}
		}
		catch (Exception e)
		{
			System.out.println("Error Parsing: -"+e.getMessage());
		}
		System.out.println("Post received!: "+history.toString());
		
		String Result = null;
		Connection con = null;
		try
		{
			Gson gson = new Gson();
			//String test ="{'time':'2015-05-30 12:14:18.0','userid':'32E2A993','action':'login'}";
			History historyObject = gson.fromJson(history.toString(),History.class);
			Date currentDateTime = new Date();
			System.out.println(currentDateTime.toString());
            SimpleDateFormat expectedFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            historyObject.setTime(expectedFormat.format(currentDateTime));
			con = new AccessManager().getConnectionForSaveHistory();
			Access access = new Access();
			if(access.saveHistory(historyObject, con) == true)
				Result = "{\"result\"=\"OK\"}";
			else Result = "{\"result\"=\"ERROR\"}";
		}
		catch (Exception e)
		{
				e.printStackTrace();
		}
		return Result;	
	}
}
