package chorustweet;

import java.util.Hashtable;

public class Credentials {

//	private String account_name;
//	private String[] credentials_array = new String[4];
	private Hashtable<String, String> credentials_hash = new Hashtable<String, String>();
	
//	public String getAccount_name() { return account_name; }
//	public void setAccount_name(String acct) { account_name = acct;}
//	public String[] getCredentials() { return credentials_array;}
//	public String getCredElement(int element) { return credentials_array[element];}
//	public void setCredentials(String elementval, int element) {
//		credentials_array[element] = elementval;
//	}
	public void setCredHash (String key, String value) { credentials_hash.put(key,value);}
	public String getCredHash (String key) { return credentials_hash.get(key);}

}
