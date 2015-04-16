package tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.Test;

import Model.ArticleInfo;
import Model.JSONArticleParser;
import Model.ParsedArticle;

public class jsonParserTest {
	
	private final String JSON_VALID_TEST_FILE = "src/tests/test_json";
	private final String JSON_EMPTY_TEST_FILE = "src/tests/empty_json";
	private final String JSON_INVALID_TEST_FILE = "src/tests/invalid_json";

	@Test
	public void testBasicParse() throws FileNotFoundException{
		InputStream in = new FileInputStream(new File(JSON_VALID_TEST_FILE));
		
		JSONArticleParser testParser = new JSONArticleParser();
		List<ParsedArticle> foundArticles = testParser.getAllNYTArticleInfo(in);
		assertTrue(foundArticles.size() == 5);
		assertTrue(foundArticles.get(0).getTitle().equals("Local Stop: The Ironbound"));
		assertTrue("  Ali Abdullah Saleh".equals(foundArticles.get(4).getPersons()[0]));

		
		
	}
	
	@Test
	public void testemptyParse() throws FileNotFoundException{
		InputStream in = new FileInputStream(new File(JSON_EMPTY_TEST_FILE));
		
		JSONArticleParser testParser = new JSONArticleParser();
		List<ParsedArticle> foundArticles = testParser.getAllNYTArticleInfo(in);
		assertTrue(foundArticles.size() == 0);
	}
	
	@Test
	public void testInvalidParse() throws FileNotFoundException{
		InputStream in = new FileInputStream(new File(JSON_INVALID_TEST_FILE));
		
		JSONArticleParser testParser = new JSONArticleParser();
		List<ParsedArticle> foundArticles = testParser.getAllNYTArticleInfo(in);
		assertTrue(foundArticles.size() == 0);
	}
}
