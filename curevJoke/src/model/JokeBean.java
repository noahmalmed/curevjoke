package model;

import java.net.URL;

/**
 * Data class for passing a joke from the model to the view
 * @author noahmalmed
 *
 */
public class JokeBean {
	private String joke;
	private URL articleURL;
	
	public JokeBean(String joke, URL url){
		this.joke = joke;
		articleURL = url;
	}

	public String getJoke() {
		return joke;
	}

	public URL getArticleURL() {
		return articleURL;
	}
	

}
