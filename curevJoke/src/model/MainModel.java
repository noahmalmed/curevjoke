package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Class that handles interfacing with the data structure and the interface
 * @author noahmalmed
 *
 */
public class MainModel {
	
	List<ParsedArticle> articles;
	
	/**
	 * Constructor - Pass in a list of configurable options
	 * @param nyt
	 * @param worldNews
	 * @param nationalNews
	 * @param frontPage
	 */
	public MainModel(boolean nyt, boolean worldNews, boolean nationalNews, boolean frontPage){
		ArticleRetriever ret = new ArticleRetriever();
		articles = ret.retrieveNYTHeadlines(worldNews, nationalNews, frontPage);
	}
	
	//TODO: Actually implement this
	public JokeBean getJoke() throws MalformedURLException{
		return new JokeBean("This is a dumb joke", new URL("https://www.facebook.com/"));
	}

}
