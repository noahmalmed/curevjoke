package tests;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import Model.ArticleInfo;
import Model.ParsedArticle;

public class TestParsedArticle {
	
	@Test
	public void testArticleParse(){
		String[] tArray = new String[0];
		ParsedArticle testParse = new ParsedArticle("", "Noah killed alot of tests", "The awesome turtle. They sucked", tArray, tArray, tArray);
		

		assertTrue(testParse.getNouns().get(0).equals("alot"));
		assertTrue(testParse.getNouns().get(1).equals("tests"));
		assertTrue(testParse.getAdjectives().get(0).equals("awesome"));
		assertTrue(testParse.getOther().get(0).equals("Noah"));
	}
	
	@Test
	public void testArticleParseDuplicate(){
		String[] tArray = new String[0];
		ParsedArticle testParse = new ParsedArticle("", "Noah killed alot of tests", "The awesome tests. They sucked", tArray, tArray, tArray);
		
		assertTrue(testParse.getNouns().size() == 2);
	}
}
