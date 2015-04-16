import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;


public class Taggerz {
	public static void main(String [] args) throws ClassNotFoundException, IOException{
		String path = "taggers/bidirectional-distsim-wsj-0-18.tagger";
		
		MaxentTagger tagger = new MaxentTagger(path);
		
		List<Word> wordL = new ArrayList<Word>();
		String sample = "Noah killed alot of tests";
		String [] sampleList = sample.replaceAll("[^a-zA-Z ]", "").split(" ");
		for(String sam: sampleList){
			wordL.add(new Word(sam));
		}
		
		List<TaggedWord> tagged = tagger.tagSentence(wordL);
		System.out.println(tagged);

	}
	
	/*
	 * Here's an idea. We look at all of the facets to find the proper nouns in the article. Then we parse the title and the abstract for verbs and adjectives.
	 */
}
