package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	protected String[] properNouns;
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
		
		properNouns = new String[organizations.length+persons.length];
		
		//Copy the org and persons array into the proper nouns array
		System.arraycopy(organizations, 0, properNouns, 0, organizations.length);
		System.arraycopy(persons, 0, properNouns, organizations.length, persons.length);
	}
	
	/** 
	 * Get an array of random proper nouns
	 * @param numberOfProperNouns  - number of proper nouns
	 * @return
	 */
	public String[] getProperNouns(int numberOfProperNouns){
		String [] chosenNouns = new String[numberOfProperNouns];
		List<Integer> chosenIndices = new ArrayList<Integer>();
		
		Random gen = new Random();
		for(int i = 0; i < numberOfProperNouns; i++){
			boolean uniqueIndex = false;
			
			// Grab a unique proper noun
			while(!uniqueIndex){
				Integer gennedIndex = gen.nextInt(properNouns.length);
				
				if(!chosenIndices.contains(gennedIndex)){
					chosenIndices.add(gennedIndex);
					chosenNouns[i] = properNouns[gennedIndex];
					uniqueIndex = true;
				}
			}
		}
		
		return properNouns;
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
