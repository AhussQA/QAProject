package Database;

import java.util.UUID;

public class DatabaseFunctions {

	

    public static String enquote(String s){
        return "'"+s+"'";
    }

  public static String createUserAccount(int id, String userName,String password,String firstName,String lastName,int doornumber,String postcode){

        return "INSERT INTO person VALUES ("+id+","+enquote(userName)+","+enquote(password)+","
        +enquote(firstName)+","+enquote(lastName)+","+doornumber+","+enquote(postcode)+")";
    }
  public static String createPostCode(String postcode,String city,String county, String country){

      return "INSERT INTO postcode VALUES ("+enquote(postcode)+","+enquote(city)+","+enquote(county)+","+enquote(country)+")";
  }
  
  public static String listPostcode(String postcode){
      return "SELECT * FROM postcode WHERE postcode ='"+postcode+"'";
  }
  
  public static String createBasket(int id,String itemName){

      
      return "INSERT INTO basket VALUES ("+id+","+enquote(itemName)+")";
  }

    public static String listItems(){
        return "SELECT * FROM item";
    }

    public static String listItems(String name){
        return "SELECT * FROM item WHERE name ='"+name+"'";
    }

    public static String listUserByID(int ID){
        return "SELECT * FROM person WHERE personID ="+ID;
    }

    public static String listUsersByName(String name){
        return "SELECT * FROM person WHERE name ='"+name+"'";
    }
    
    public static String getMaxPersonID() {
    	return "Select Count(personID) as max from person";
    }

    





}
