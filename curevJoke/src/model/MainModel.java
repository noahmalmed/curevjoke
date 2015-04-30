package model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

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
	
	/**
	 * Method that returns a joke to the view
	 * @return
	 * @throws MalformedURLException
	 */
	public JokeBean getJoke() throws MalformedURLException{
		if(articles.isEmpty()){
			return new JokeBean("No Articles Retrieved" , new URL("http://www.sadmuffin.net/cherrybam/graphics/comments-sorry/sorry004.gif"));
		} else {
			JokeFormer jf = new JokeFormer();			
			Random gen = new Random();
			
			String joke = "";
			ParsedArticle article;
			// Make sure that we get a joke from the generator
			do{
				article = articles.get(gen.nextInt(articles.size()));			
				joke = jf.makeJoke(article);
			}while (joke.equals(""));
			
			return new JokeBean(joke, new URL(article.url));
		}
	}

}
