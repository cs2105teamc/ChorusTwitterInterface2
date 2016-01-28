package chorustweet;
import java.io.IOException;
import java.security.SignatureException;
import java.util.Arrays;


 class CredentialsTest {
	 public static void main (String[] args) throws SignatureException {
		 chorustweet.Message testmsg = new chorustweet.Message();
		 chorustweet.Credentials test = new chorustweet.Credentials();
		 chorustweet.SignatureGenerator testSig = new chorustweet.SignatureGenerator();
		 chorustweet.HMACSHA1 testsha1 = new chorustweet.HMACSHA1();
		 chorustweet.Nonce testnonce = new chorustweet.Nonce();
		 chorustweet.HTTPReq testreq = new chorustweet.HTTPReq();
				 
		 String header = "";
		 String postdata = "";
		 long epochl = System.currentTimeMillis();
		 epochl = epochl /1000;
		 String epoch = Long.toString(epochl);
//		 String epochs = epoch;
//		 Test getting and setting account name and credentials
//		 test.setAccount_name("CS2105TeamC");
//		 test.setCredentials("4830664103-4GWULAlsO57vCAbZYtOB1rSYxD0hEwW91Rcazim", 0);
//		 test.setCredentials("3hFyaG5AWiGF6AMW0ZNMpAMNlpBzePjYFUAd9CxdkJzcQ", 1);
//		 test.setCredentials("95p1GHyf0qHplNMcJCjlDpArY", 2);
//		 test.setCredentials("uoTrWUWCqHEul2zgXS6bVZtrJS7U1CpFB6WxMkW6vgVI7OfeW9", 3);
//		 System.out.println("Account name: " + test.getAccount_name());
//		 System.out.println("Credentials : " + Arrays.toString(test.getCredentials()));
//		 Arrays.stream(test.getCredentials()).forEach(System.out::println);
//		 test.setCredHash("oauth_consumer_key", "95p1GHyf0qHplNMcJCjlDpArY");
//		 test.setCredHash("oauth_token", "4830664103-4GWULAlsO57vCAbZYtOB1rSYxD0hEwW91Rcazim");

		 testSig.setParam("status", "Uploading to GitHub");
//		 testSig.setParam("include_entities", "true");
		 testSig.setParam("oauth_consumer_key", "95p1GHyf0qHplNMcJCjlDpArY");
		 testSig.setParam("oauth_nonce", testnonce.nextSessionId());
		 testSig.setParam("oauth_signature_method", "HMAC-SHA1");
		 testSig.setParam("oauth_timestamp", epoch);
		 testSig.setParam("oauth_token", "4830664103-4GWULAlsO57vCAbZYtOB1rSYxD0hEwW91Rcazim");
		 testSig.setParam("oauth_version", "1.0");
		 header = "OAuth ";
		 postdata = "status="+OAuth.percentEncode((testSig.getParam("status")));
		//, testSig.sigKey))+"\""+", "+testSig.getEncPair("signature_method");
		 header = header+testSig.getEncPair("oauth_consumer_key")+testSig.getEncPair("oauth_nonce")+OAuth.percentEncode("oauth_signature")+"="+"\""+OAuth.percentEncode(testsha1.calculateRFC2104HMAC(testSig.sigBase(testSig.sortArray()), testSig.sigKey))+"\""+", "+testSig.getEncPair("oauth_signature_method")+testSig.getEncPair("oauth_timestamp")+testSig.getEncPair("oauth_token")+testSig.getEncPair("oauth_version");
		 header = header.substring(0, (header.length() - 2 ));
//		 testSig.setParam("method", "POST");
//		 testSig.setParam("URI", "https://api.twitter.com/1.1/statuses/update.json");
//		 System.out.println(testSig.getParamPair("oauth_consumer_key"));
//		 System.out.println(testSig.getEncoded(testSig.getParamPair("oauth_consumer_key")));
//		 System.out.println(testSig.getEncoded("Dogs, Cats & Mice"));
//		 System.out.println(OAuth.percentEncode(testSig.getParamPair("oauth_consumer_key")));
//		 testSig.printHash();
//		 System.out.print(testSig.sortArray());
//		 System.out.print(testSig.sigBase(testSig.sortArray()));
//		 System.out.println(testSig.sigKey);
//		 System.out.println(testsha1.calculateRFC2104HMAC(testSig.sigBase(testSig.sortArray()), testSig.sigKey));
		 System.out.println(header);
		 System.out.println(postdata);
		 try {
			testreq.PostTWT(header , postdata);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		 System.out.println(testnonce.nextSessionId());
//		 System.out.println(testmsg.getMessage());
		 
		
		 
	 }

	 
	 
}
