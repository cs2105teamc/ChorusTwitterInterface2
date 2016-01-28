package chorustweet;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
public class SignatureGenerator {
	
	// POST&https%3A%2F%2Fapi.twitter.com%2F1.1%2Fstatuses%2Fupdate.json&oauth_consumer_key%3D95p1GHyf0qHplNMcJCjlDpArY%26oauth_nonce%3D94f35ae0dc1d8b0228c4e1979e9907c6%26oauth_signature_method%3DHMAC-SHA1%26oauth_timestamp%3D1453976467%26oauth_token%3D4830664103-4GWULAlsO57vCAbZYtOB1rSYxD0hEwW91Rcazim%26oauth_version%3D1.0%26status%3DAlessandro%2525should%2525shave.
	// Authorization: OAuth oauth_consumer_key="95p1GHyf0qHplNMcJCjlDpArY", oauth_nonce="94f35ae0dc1d8b0228c4e1979e9907c6", oauth_signature="UilTLodwuONAREES4TIi78rymxE%3D", oauth_signature_method="HMAC-SHA1", oauth_timestamp="1453976467", oauth_token="4830664103-4GWULAlsO57vCAbZYtOB1rSYxD0hEwW91Rcazim", oauth_version="1.0"
	// curl --request 'POST' 'https://api.twitter.com/1.1/statuses/update.json' --data 'status=Alessandro%25should%25shave.' --header 'Authorization: OAuth oauth_consumer_key="95p1GHyf0qHplNMcJCjlDpArY", oauth_nonce="94f35ae0dc1d8b0228c4e1979e9907c6", oauth_signature="UilTLodwuONAREES4TIi78rymxE%3D", oauth_signature_method="HMAC-SHA1", oauth_timestamp="1453976467", oauth_token="4830664103-4GWULAlsO57vCAbZYtOB1rSYxD0hEwW91Rcazim", oauth_version="1.0"' --verbose

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
//		System.out.println(sortArray[i]);
//		System.out.print(OAuth.percentEncode(sortArray[i])+"="+OAuth.percentEncode(getParam(sortArray[i])));
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

//
//public void printHash() {
//String[] sigArray = new String[messageParameters.size()];
//messageParameters.forEach((k,v) -> {
//	int element = 0;
//	String s = (OAuth.percentEncode(k)+"="+OAuth.percentEncode(v));
//	sigArray[element] = s;
//	sortArray[element] = s;
//	System.out.println(sigArray[element]);
//	element = element +1;
//
//}
//
//		);
//}
}

