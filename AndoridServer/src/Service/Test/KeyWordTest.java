package Service.Test;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Service.KeyWordServiceOld;

public class KeyWordTest {
	public static void main(String args[]) throws IOException
	{
		Document doc = Jsoup.connect("http://hn.qq.com/a/20140715/010000.htm").get();
		KeyWordServiceOld keyWordService = new KeyWordServiceOld();
		String buf = doc.text();
		keyWordService.getImportant(buf);
	}

}
