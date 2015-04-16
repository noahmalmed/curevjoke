package Model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * This class connects to news sites and retrieves information from them
 * @author noahmalmed
 *
 */
public class ArticleRetriever {
	
	private JSONArticleParser parser;
	
	/**
	 * Default constructor just instantiates the json parser
	 */
	public ArticleRetriever(){
		parser = new JSONArticleParser();
	}

	/**
	 * This function retrieves all recent articles from the NewYork Times AP
	 * @return a list of the meta information from the articles
	 */
	public List<ParsedArticle> retrieveNYTHeadlines(){
		String url = "http://api.nytimes.com/svc/news/v3/content";
		String source = "all";
		String section = "world;nytfrontpage";
		String devKey = "b59b3bfb57fc16741c8a89d92ad00ca6:18:67750048";
		
		String httpRequest = String.format("%s/%s/%s?api-key=%s", url, source, section, devKey);
		
		//TODO: For unit tests mock urlconnection(Powermock, Mockito)
		try {
			URLConnection connection = new URL(httpRequest).openConnection();
			connection.setRequestProperty("Accept-Charset", "UTF-8");
			InputStream response = connection.getInputStream();
			
			return parser.getAllNYTArticleInfo(response);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
			
	}

}
