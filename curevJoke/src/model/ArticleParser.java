package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is in charge of parsing and storing the information received from news sites
 * @author noahmalmed
 *
 */
public class ArticleParser {
	private List<ParsedArticle> articles;
	
	/**
	 * Default constructor: 
	 */
	public ArticleParser(){
		articles = new ArrayList<ParsedArticle>();
	}
	
	/**
	 * Add a single ArticleInfo object
	 * @param headline
	 */
	public void addArticles(ParsedArticle headline){
		articles.add(headline);
	}
	
	/**
	 * Add a list of articles
	 * @param articles
	 */
	public void addArticles(List<ParsedArticle> articles){
		this.articles.addAll(articles);
	}
	
	/**
	 * receive a list of articles
	 * @return
	 */
	public List<ParsedArticle> getHeadlines(){
		return articles;
	}
}
