package Model;

import java.io.InputStream;
import java.util.ArrayList;
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
	public List<ArticleInfo> getAllNYTArticleInfo(InputStream nytResponse){
		List<ArticleInfo> allArticles = new ArrayList<ArticleInfo>();
		JsonObject jsonObj;
		try{
			jsonObj = Json.createReader(nytResponse).readObject();
		} catch (JsonParsingException e){
			return allArticles;
		}
		
		JsonArray resultArray = jsonObj.getJsonArray("results");
		
		for(int index = 0; resultArray != null && index < resultArray.size(); index++){
			JsonObject articleObject = resultArray.getJsonObject(index);
			String headline = articleObject.getString("title");
			String memo = articleObject.getString("abstract");
			allArticles.add(new ArticleInfo(headline, memo));
		}
		
		return allArticles;
	}

}
