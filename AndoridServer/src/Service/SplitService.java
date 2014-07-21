package Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;

import Domain.Token;

//split a sentence
public class SplitService {
	private List<Token> tokens;

	public List<Token> split(String sentence) throws IOException {
		// get the fenci from ltp
		String api_key = "c1H8M0n9CrIK1q4yOaPzuK0d8Y7EgRzrYdhkhBzH";
		String pattern = "srl";
		String format = "json";
		String text = URLEncoder.encode(sentence, "utf-8");
		
		String params = "api_key="
			+ api_key + "&" + "text=" + text + "&" + "format=" + format
			+ "&" + "pattern=" + pattern;
		URL url = new URL("http://api.ltp-cloud.com/analysis/");
		URLConnection conn = url.openConnection();
		 // 设置doOutput属性为true表示将使用此urlConnection写入数据  
		conn.setDoOutput(true);  
        // 定义待写入数据的内容类型，我们设置为application/x-www-form-urlencoded类型  
		conn.setRequestProperty("content-type", "application/x-www-form-urlencoded");  
        // 得到请求的输出流对象  
        OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream()); 
        out.write(params);
        out.flush();
        out.close();
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
}
