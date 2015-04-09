package Model;

/**
 * This is a data class used to pass information from the parsing and query sections
 * to the data processing sections
 * @author noahmalmed
 *
 */
public class ArticleInfo {
	private String title;
	private String summary;
	
	public ArticleInfo(String title, String summary){
		this.title = title;
		this.summary = summary;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getSummary(){
		return summary;
	}

}
