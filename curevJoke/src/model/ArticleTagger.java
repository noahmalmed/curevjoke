package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

/**
 * This singleton class is the programs interface with the MaxentTagger.
 * Because the tagger requires to be trained when starting up (which takes about 3-4 seconds),
 * it is advantegous to just have one tagger that only gets trained once
 * 
 * @author noahmalmed
 *
 */
public enum ArticleTagger {
	INSTANCE;
	
	private final String TRAINING_FILE = "taggers/left3words-wsj-0-18.tagger";
	
	private MaxentTagger tagger;
	
	/**
	 * This is the one time instantiation of the tagger where we train it.
	 * Note: This is the function that takes ~4 seconds to run.
	 */
	private ArticleTagger(){
		try {
			tagger = new MaxentTagger(TRAINING_FILE);
		} catch (IOException | ClassNotFoundException e) {
			// This exception should never be thrown
			e.printStackTrace();
		}
	}
	
	/**
	 * This function produces a list of tagged words given a sentence
	 * @param sentence to parse
	 * @return
	 */
	public List<TaggedWord> tagSentence(String sentence){
		List<Word> wordL = new ArrayList<Word>();
		
		// Remove all of the punctuation to better tag the sentece 
		String [] sampleList = sentence.replaceAll("[^a-zA-Z ]", "").split(" ");
		for(String sam: sampleList){
			wordL.add(new Word(sam));
		}
		
		return tagger.tagSentence(wordL);
	}

}
