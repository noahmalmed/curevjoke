package controller;

import view.MainView;
import view.SetupView;

/**
 * Main method
 * @author noahmalmed
 *
 */
public class RunGUI {
	public static void main(String[] args){
		SetupView setup = new SetupView();
		MainController cont = new MainController(setup);		
		setup.addController(cont);	
	}
}
