package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import Domain.Token;


public class SplitService {
	private List<Token> tokens;

	public List<Token> split(String sentence) throws IOException {
		String api_key = "c1H8M0n9CrIK1q4yOaPzuK0d8Y7EgRzrYdhkhBzH";
		String pattern = "srl";
		String format = "json";
		String text = URLEncoder.encode(sentence, "utf-8");

		URL url = new URL("http://api.ltp-cloud.com/analysis/?" + "api_key="
				+ api_key + "&" + "text=" + text + "&" + "format=" + format
				+ "&" + "pattern=" + pattern);
		URLConnection conn = url.openConnection();
		conn.connect();

		BufferedReader innet = new BufferedReader(new InputStreamReader(
				conn.getInputStream(), "utf-8"));
		String line = "", cur;
		while ((cur = innet.readLine()) != null) {
			line += cur;
		}
		innet.close();

		line = line.replaceAll("\\s*", "");
		line = line.substring(2, line.length() - 2);
		JsonToTokens jj = new JsonToTokens();
		tokens = jj.transfer(line);
		return tokens;

	}
	public List<String> split2(String sentence) throws IOException{
		List<String> result = new ArrayList<String>();
		List<Token>cur = this.split(sentence);
		for(Token t: cur)
			result.add(t.getCont());
		return result;
	}
}
