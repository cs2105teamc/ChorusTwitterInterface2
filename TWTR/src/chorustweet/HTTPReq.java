package chorustweet;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HTTPReq {
	public String PostTWT (String hdr, String query) throws IOException {
//		try {
			URL url = new URL("https://api.twitter.com/1.1/statuses/update.json");
			HttpsURLConnection connect = (HttpsURLConnection)url.openConnection();
			connect.setDoOutput(true);
			connect.setRequestMethod("POST");	
			connect.setRequestProperty("Authorization", hdr);
			connect.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			connect.setRequestProperty("Content-Length", String.valueOf(query.length()));
			
			OutputStream output = connect.getOutputStream();
			output.write(query.getBytes());
			
		      StringBuilder responseSB = new StringBuilder();
		        BufferedReader br = new BufferedReader(new InputStreamReader(connect.getInputStream()));
		          
		        String line;
		        while ( (line = br.readLine()) != null)
		            responseSB.append(line);
		                 
		        // Close streams
		        br.close();
		        output.close();
		         
		        return responseSB.toString();
}
}