package testquestions;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DBInfo{
    HashMap<String,Connection> connInfo;
    
    public DBInfo(){
        connInfo=new HashMap<String,Connection>();
    }
    public void addConnection(String name, String dest){
        
    	Connection connectionObj1;
    	connectionObj1=new Connection(name, dest);
    	connInfo.put(name, connectionObj1);

    }
    
    public void printNameDest(){
    	
    	System.out.println("Total number of connections: "+connInfo.size());
    	char firstChar;
    	List<String> listConnection=new LinkedList<String>();
    	for(Map.Entry<String, Connection> entry: connInfo.entrySet()){
    		firstChar=entry.getKey().charAt(0);
    		if((firstChar>=65 && firstChar<=76)||(firstChar>=97 && firstChar<=108)){	
    			listConnection.add(entry.getKey());
    		}
    	}
    	Collections.sort(listConnection);
    	for(String name:listConnection){
    		System.out.println("Name: "+name+"  Destination: "+connInfo.get(name).getDest());
    	}
    	
    	System.out.println("Number of connections which match filter: "+listConnection.size());
    }
    
    public String searchConnection(String name) throws NoNameException{

    	if(connInfo.containsKey(name)){

    		return connInfo.get(name).getDest();
    	}
    	else{
    		throw new NoNameException("The given name was not found in the database");
    	}

    	//in order to make sure that the program is not aborted after an exception is thrown, we need to enclose it with a try..catch block. 
    	//the catch block can be used to complete the rest of the method

    }
    
    public static void main(String [] args){
        DBInfo dbInfo_obj1=new DBInfo();
        dbInfo_obj1.addConnection("Retriever", "192.168.0.209");
        dbInfo_obj1.addConnection("Boxer", "192.168.0.1");
        dbInfo_obj1.addConnection("Corgi", "192.168.0.100");
        try{
        	dbInfo_obj1.searchConnection("rashmi");
        }
        catch(Exception e){
        	e.printStackTrace();
        }
        dbInfo_obj1.printNameDest();
    }   
}

