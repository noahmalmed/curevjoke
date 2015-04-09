package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is in charge of parsing and storing the information received from news sites
 * @author noahmalmed
 *
 */
public class ArticleParser {
	private List<ArticleInfo> articles;
	
	/**
	 * Default constructor: 
	 */
	public ArticleParser(){
		articles = new ArrayList<ArticleInfo>();
	}
	
	/**
	 * Add a single ArticleInfo object
	 * @param headline
	 */
	public void addArticles(ArticleInfo headline){
		articles.add(headline);
	}
	
	/**
	 * Add a list of articles
	 * @param articles
	 */
	public void addArticles(List<ArticleInfo> articles){
		this.articles.addAll(articles);
	}
	
	/**
	 * receive a list of articles
	 * @return
	 */
	public List<ArticleInfo> getHeadlines(){
		return articles;
	}
}
