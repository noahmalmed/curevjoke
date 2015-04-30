package view;

import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import model.JokeBean;
import model.MainModel;
import net.miginfocom.swing.MigLayout;
import controller.OpenLinkInBrowserAction;

/**
 * View for the main page of the application
 * @author noahmalmed
 *
 */
public class MainView extends JFrame{

	private static final long serialVersionUID = 1L;
	private JLabel jokeField;
	private JButton linkButton;
	private JButton generateButton;
	private MainModel model;
	
	private OpenLinkInBrowserAction linkListener;
	
	public MainView(MainModel model){
		linkListener = new OpenLinkInBrowserAction();
		this.model = model;
		setLayout(new MigLayout("","[grow][center][grow]","[grow][grow][grow][grow]"));
		setTitle("CurEvJoke");
		
		JLabel titleField = new JLabel("Generate a Joke!");		
		titleField.setFont(StaticFonts.TITLE_FONT);
		add(titleField, "cell 1 0");
		
		jokeField = new JLabel("Hello alsdjfklskdjflskdjf");
		jokeField.setFont(StaticFonts.BODY_FONT);
		jokeField.setVisible(false);
		add(jokeField, "cell 1 1");
		
		linkButton = new JButton("Open Source Article");
		linkButton.setFont(StaticFonts.BODY_FONT);
		linkButton.setVisible(false);
		linkButton.addActionListener(linkListener);
		add(linkButton, "cell 0 2 2 1");
		
		generateButton = new JButton("Generate New Joke");
		generateButton.setFont(StaticFonts.BODY_FONT);
		add(generateButton, "cell 1 3");
		
		
		pack();		
	}
	
	/**
	 * Add the controller to the pressible buttons
	 * @param controller
	 */
	public void addController(ActionListener controller){
		generateButton.addActionListener(controller);
	}
	
	/**
	 * Update the page to display a new generated joke
	 */
	public void update(){
		try {
			
			JokeBean joke = model.getJoke();
			jokeField.setText(joke.getJoke());
			jokeField.setVisible(true);
			
			linkButton.setVisible(true);
			linkListener.changeURL(joke.getArticleURL());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
