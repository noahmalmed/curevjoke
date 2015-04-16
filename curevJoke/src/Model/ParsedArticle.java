package Model;

import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.TaggedWord;

/**
 * This class extends the ArticleInfo and actually parses the info into lists of words
 * @author noahmalmed
 *
 */
public class ParsedArticle extends ArticleInfo{
	private List<String> nouns;
	private List<String> adjectives;
	private List<String> pastVerbs;
	private List<String> presentVerbs;
	private List<String> adverbs;	
	private List<String> other; //<--- Contains all other words here
	
	/**
	 * Parameterized constructor: 
	 * Calls the super constructor on the given values and then parses those values
	 * @param url
	 * @param title
	 * @param summary
	 * @param orgs
	 * @param persons
	 * @param locations
	 */
	public ParsedArticle(String url, String title, String summary, String[] orgs, String[] persons, String[] locations){
		super(url, title, summary, orgs, persons, locations);
	
		nouns = new ArrayList<String>();
		adjectives = new ArrayList<String>();
		pastVerbs = new ArrayList<String>();
		presentVerbs = new ArrayList<String>();
		adverbs = new ArrayList<String>();
		other = new ArrayList<String>();
	
		parseArticleInfo();
	}
	
	/**
	 * Function that parses all of the words in the Title and Summary
	 */
	private void parseArticleInfo(){
		
		List<TaggedWord> taggedTitle = ArticleTagger.INSTANCE.tagSentence(title);
		List<TaggedWord> taggedSummary = ArticleTagger.INSTANCE.tagSentence(summary);
		
		// Match the tag with the word type
		sortWordsByTags(taggedTitle);
		sortWordsByTags(taggedSummary);		
	}

	/*
	 * Sortings based off of information found at the following site:
	 * http://www.comp.leeds.ac.uk/amalgam/tagsets/upenn.html
	 */
	/**
	 * Function that sorts words based on their tags
	 * Note:
	 *  Sorting based off of information found at the following site:
	 *  http://www.comp.leeds.ac.uk/amalgam/tagsets/upenn.html
	 *  
	 * @param taggedList of words
	 */
	private void sortWordsByTags(List<TaggedWord> taggedList) {
		for(TaggedWord wordWithTag: taggedList){
			String word = wordWithTag.word();
			String tag = wordWithTag.tag();
			if(tag.matches("JJ|JJR|JJS")){
				if(adjectives.indexOf(word) == -1){
					adjectives.add(word);
				}
			} else if (tag.matches("NN|NNS")){
				if(nouns.indexOf(word) == -1){
					nouns.add(word);
				}
			} else if (tag.matches("RB|RBR|RBS")){
				if(adverbs.indexOf(word) == -1){
					adverbs.add(word);
				}
			} else if (tag.matches("VB|VBG|VBZ")){
				if(presentVerbs.indexOf(word) == -1){
					presentVerbs.add(word);
				}
			} else if(tag.matches("VBD|VBN")){
				if(pastVerbs.indexOf(word) == -1){
					pastVerbs.add(word);
				}
			} else {
				if(other.indexOf(word) == -1){
					other.add(word);
				}
			}
		}
	}

	public List<String> getNouns() {
		return nouns;
	}

	public List<String> getAdjectives() {
		return adjectives;
	}

	public List<String> getPastVerbs() {
		return pastVerbs;
	}

	public List<String> getPresentVerbs() {
		return presentVerbs;
	}

	public List<String> getAdverbs() {
		return adverbs;
	}

	public List<String> getOther() {
		return other;
	}

}
