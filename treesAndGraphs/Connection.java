package testquestions;

/*
 * Connection contains the name and destination of a connection. The destination can be an IP address
 * or a network's name. The name is a unique name given to the source connection. 
 */
public class Connection{
    private String name;
    private String dest;
    
    public Connection(){
    	dest=null;
    }
    public Connection(String name, String dest){
    	this.name=name;
    	this.dest=dest;
    }
    public void setName(String name){
        try{
            if(name==null){
                throw new NullStringException("Name of connection cannot be null");
            }
        }
        catch(NullStringException e){
            return;
        }
        this.name=name;
        return;                       
    }
    
    public void setDest(String dest){
        this.dest=dest;                                                       
    }
    
    public String getName(){
        return name;
    }
    
    public String getDest(){
        return dest;
    }
}                                        
