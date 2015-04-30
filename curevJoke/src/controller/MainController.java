package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MainModel;
import view.MainView;
import view.SetupView;

/**
 * Main controller for the GUI
 * @author noahmalmed
 *
 */
public class MainController implements ActionListener {

	private SetupView setupView;
	private MainView  mainView;
	private MainModel model;
	
	public MainController(SetupView sView){
		setupView = sView;
		setupView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
		
			case "Quit": 
				//TODO: make one line function
				System.exit(0);
				break;
			case "Continue":
				handleContinuePress();
				break;
			case "Generate New Joke":
				handleGenerateJoke();
				break;		
		}
		
	}
	
	/**
	 * Method to handle moving from the setup view to the main view of the Application
	 */
	private void handleContinuePress(){
		// Obtain checkbox information
		boolean nytPressed = setupView.nytPressed();
		boolean worldNewsPressed = setupView.worldNewsPressed();
		boolean nationalNewsPressed = setupView.nationalNewsPressed();
		boolean frontPagePressed = setupView.frontPageNewsPressed();
		
		//check if we can move on
		if(nytPressed && (worldNewsPressed || nationalNewsPressed || frontPagePressed)){
			// Create the generator
			model = new MainModel(nytPressed, worldNewsPressed, nationalNewsPressed, frontPagePressed);			
			setupView.setVisible(false);
			
			mainView = new MainView(model);
			mainView.setVisible(true);
			mainView.addController(this);			
			mainView.setSize(setupView.getSize());
		} else {
			setupView.displayInvalidButtonsPressed();
		}
		
	}
	
	/**
	 * Method to handle the generate joke button being pressed
	 */
	private void handleGenerateJoke(){
		mainView.update();
	}
	
}
