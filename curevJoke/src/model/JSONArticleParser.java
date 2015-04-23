package model;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.stream.JsonParsingException;

/**
 * This class is in charge of parsing the information received from sites
 * @author noahmalmed
 *
 */
public class JSONArticleParser {
	
	/**
	 * This method parses the json response from the New york times
	 * @param nytResponse - Input Stream returned from the NYT API
	 * @return
	 */
	public List<ParsedArticle> getAllNYTArticleInfo(InputStream nytResponse){
		List<ParsedArticle> allArticles = new ArrayList<ParsedArticle>();
		JsonObject jsonObj;
		try{
			jsonObj = Json.createReader(nytResponse).readObject();
		} catch (JsonParsingException e){
			return allArticles;
		}
		
		JsonArray resultArray = jsonObj.getJsonArray("results");
		
		for(int articleIndex = 0; resultArray != null && articleIndex < resultArray.size(); articleIndex++){
			JsonObject articleObject = resultArray.getJsonObject(articleIndex);
			
			// Extract the article information
			String headline = articleObject.getString("title");
			String memo = articleObject.getString("abstract");
			String url = articleObject.getString("url");
			
			// Extract the facets
			String[] locations = getFacetArray(articleObject,"geo_facet");			
			String[] organizations = getFacetArray(articleObject, "org_facet");
			String[] people = getFacetArray(articleObject, "per_facet");
			normalizePeopleFacet(people);
			
			allArticles.add(new ParsedArticle(url, headline, memo, organizations, people, locations));
		}
		
		return allArticles;
	}
	
	/**
	 * Function to normalize a list of name that are of the form "malmed, noah" to "Noah Malmed
	 * @param people
	 */
	private void normalizePeopleFacet(String[] people){
		for(int i = 0; i < people.length; i++){
			String[] splitNames = people[i].split(",");
			
			String temp = splitNames[splitNames.length - 1];
			splitNames[splitNames.length - 1] = splitNames[0];
			splitNames[0] = temp;
			
			people[i] = "";
			for(String word: splitNames){
				people[i] += " " + word;
			}
		}
	}

	/**
	 * Note: If the facets are not populated return a 0 size array
	 * @param articleObject
	 * @param facet
	 * @return
	 */
	private String[] getFacetArray(JsonObject articleObject, String facet) {	
		try{
			JsonArray articleArray = articleObject.getJsonArray(facet);
			String[] facets = new String[articleArray.size()];
			//Parse the locations
			for(int locationIndex = 0; locationIndex < articleArray.size(); locationIndex++){
				facets[locationIndex] = articleArray.getString(locationIndex);
			}
			
			return facets;
		}
		catch(ClassCastException e){
			return new String[0];
		}
	}

}
