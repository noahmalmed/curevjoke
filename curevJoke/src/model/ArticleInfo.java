package model;

/**
 * This is a data class used to pass information from the parsing and query sections
 * to the data processing sections
 * @author noahmalmed
 *
 */
public class ArticleInfo {
	protected String url;
	protected String title;
	protected String summary;
	protected String[] organizations;
	protected String[] persons;
	protected String[] locations;
	
	/**
	 * Param constructor, basically just takes values for stored value
	 * @param url
	 * @param title
	 * @param summary
	 * @param orgs
	 * @param persons
	 * @param locations
	 */
	public ArticleInfo(String url, String title, String summary, String[] orgs, String[] persons, String[] locations){
		this.url = url;
		this.title = title;
		this.summary = summary;
		this.organizations = orgs;
		this.persons = persons;
		this.locations = locations;
	}
	
	public String getURL(){
		return url;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getSummary(){
		return summary;
	}
	
	public String[] getOrganizations(){
		return organizations;
	}
	
	public String[] getPersons(){
		return persons;
	}
	
	public String[] getLocations(){
		return locations;
	}

}
