package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class WikipediaArticle {
	public static int getTopicCount(String topic) {
		String response;
		int count = 0;
		try {
			URL obj = new URL(
					"https://en.wikipedia.org/w/api.php?action=parse&section=0&prop=text&format=json&page=" + topic);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			response = in.readLine();
			JsonObject convertedObject = new Gson().fromJson(response, JsonObject.class);
			String data = convertedObject.toString();
			Pattern p = Pattern.compile(topic);
			Matcher m = p.matcher(data);
			while (m.find())
				count++;
			in.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return count;
	}
}
