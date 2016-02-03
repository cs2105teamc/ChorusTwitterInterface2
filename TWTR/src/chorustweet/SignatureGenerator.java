package chorustweet;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
public class SignatureGenerator {


//private Hashtable<String, String> messageParameters = new Hashtable<String, String>();
private HashMap<String, String> messageParameters = new HashMap<String, String>();
private Set<String> keys = messageParameters.keySet();
private String method = "POST";
private String URI = "https://api.twitter.com/1.1/statuses/update.json";
public String sigKey = OAuth.percentEncode("uoTrWUWCqHEul2zgXS6bVZtrJS7U1CpFB6WxMkW6vgVI7OfeW9")+"&"+OAuth.percentEncode("3hFyaG5AWiGF6AMW0ZNMpAMNlpBzePjYFUAd9CxdkJzcQ");
public String[] sortArray = keys.toArray(new String[keys.size()]);

public void setParam (String key, String value) { messageParameters.put(key,value);}
public String getParam (String key) { return messageParameters.get(key);}	
public String getParamPair (String key) { return key+messageParameters.get(key);}
public String getEncPair (String key) { return OAuth.percentEncode(key)+"="+"\""+OAuth.percentEncode(messageParameters.get(key))+"\""+", ";}

public String sortArray() {
	Set<String> keys = messageParameters.keySet();
	String[] sortArray = keys.toArray(new String[keys.size()]);
	String result = "";
	Arrays.sort(sortArray);
	for ( int i = 0; i < keys.size(); i++ ) { 
		result = result+OAuth.percentEncode(sortArray[i])+"="+OAuth.percentEncode(getParam(sortArray[i]))+"&";
		}
	result = result.substring(0, (result.length() - 1 ));
	return result;
	
}

public String sigBase (String param) {
	String result = "";
	result = method+"&"+OAuth.percentEncode(URI)+"&"+OAuth.percentEncode(param);
	return result;
	
}
}


