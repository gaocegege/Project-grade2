package Service.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import net.sf.json.JSONArray;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;



import Domain.Arg;
import Domain.Content;
import Domain.Token;
import Service.SearchFormat;



public class DifferentNews {
	public static void main(String[] args) throws IOException {
		SearchFormat sf = new SearchFormat();
		String ans = sf.getSearchSent("ÖÐ¼ÍÎ¯£º×ÔÓÉÖ÷Òå×Ì³¤ÒÑ³ÉÎªµ³µÄÒ»´óÓÇ»¼");
		System.out.println(ans);
        return;
    }
	
}
