package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JokeFormer {
	
	/**
	 * Function that actually creates a joke given an article
	 * 
	 * @param article
	 * @return
	 */
	public String makeJoke(ParsedArticle article){
		List<String> jokes = new ArrayList<String>();
		int numPN = article.getOrganizations().length + article.getPersons().length;
		
		
		// This part checks to see if there are enough parsed words to make a certain joke
		// TODO: organize if blocks to conserve the number of boolean expressions
		// TODO: ORganize jokes into class
		if(numPN >= 2){
			String[] properNouns = article.getProperNouns(2);
			
			if(article.getPresentVerbs().size() > 0){				
				jokes.add(formLastOnEarth(properNouns[0], properNouns[1], article.getRandomPresentVerb()));
			} 
			
			if(article.getPastVerbs().size() > 0){
				jokes.add(formBreakup(properNouns[0], properNouns[1], article.getRandomPastVerb()));
			}
			
			if(article.getNouns().size() > 0){
				jokes.add(formPassion(properNouns[0], properNouns[1], article.getRandomNoun()));
			}		
			
			jokes.add(formReincarted(properNouns[0], properNouns[1]));
			jokes.add(formAffair(properNouns[0], properNouns[1]));
			
		} if(numPN >= 1){
			String properNoun = article.getProperNouns(1)[0];
			
			if(article.getNouns().size() > 0 && article.getPastVerbs().size() > 0){
				jokes.add(formDump(properNoun, article.getRandomPastVerb(), article.getRandomNoun()));
			}
			
			if(article.getNouns().size() > 0 && article.getAdjectives().size() > 0){
				jokes.add(formSaturdayNight(article.getRandomAdjective(), article.getRandomNoun(), properNoun));
			}
			
			if(article.getPastVerbs().size() > 0){
				jokes.add(formBlackOut(properNoun, article.getRandomPastVerb()));
			}
			
			if(article.getPresentVerbs().size() > 0 && article.getNouns().size() > 0){
				jokes.add(formLoves(properNoun, article.getRandomPresentVerb(), article.getRandomNoun()));
			}
			
			if(article.getNouns().size() > 0){
				jokes.add(formShortLoves(properNoun, article.getRandomNoun()));
			}
		}
		
		if(jokes.isEmpty()){
			return "";
		} else {
			Random gen = new Random();
			return jokes.get(gen.nextInt(jokes.size()));
		}
		
	}
	
	
	// All joke formats are below: -----------------------------------------------------------------------------------------------
	
	private String formLastOnEarth(String pn1, String pn2, String verb){
		return String.format("If %s and %s were the last people on earth. I'm sure they would %s each other.", pn1, pn2, verb);
	}
	
	private String formDump(String pn, String verb, String noun){
		return String.format("After taking a dump, %s likes to %s %s", pn, verb, noun);
	}
	
	private String formBreakup(String pn1, String pn2, String pastV){
		return String.format("What did %s do to %s after they broke up? %s them", pn1, pn2, pastV);
	}
	
	private String formReincarted(String pn1, String pn2){
		return String.format("%s wish they could be reincarnated as %s", pn1, pn2);
	}
	
	private String formAffair(String pn1, String pn2){
		return String.format("I hear %s and %s are having an affair", pn1, pn2);
	}
	
	// you don't have to put an adjective in
	private String formSaturdayNight(String adjective, String noun, String pn1){
		return String.format("\"Nothing is better than a %s %s on a Saturday night\"\n-%s", adjective, noun, pn1);
	}
	
	private String formPassion(String pn1, String pn2, String noun){
		return String.format("%s really pissed off %s when they mentioned that they have a %s after a night of passion.", pn1, pn2, noun);
	}
	
	// Can be present or past?
	private String formBlackOut(String pn1, String verb){
		return String.format("%s blacked out from too much %s last night.", pn1, verb);
	}
	
	private String formLoves(String pn1, String verb, String noun){
		return String.format("%s really loves to %s %s", pn1, verb, noun);
	}
	
	private String formShortLoves(String pn1, String noun){
		return String.format("%s really loves %s", pn1, noun);
	}

}
