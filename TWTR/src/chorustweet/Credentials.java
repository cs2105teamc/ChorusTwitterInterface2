package chorustweet;

import java.util.Hashtable;

public class Credentials {

	private Hashtable<String, String> credentials_hash = new Hashtable<String, String>();
	
	public void setCredHash (String key, String value) { credentials_hash.put(key,value);}
	public String getCredHash (String key) { return credentials_hash.get(key);}

}
