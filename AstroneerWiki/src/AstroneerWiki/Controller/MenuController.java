package AstroneerWiki.Controller;

import AstroneerWiki.View.StartMenuView;

public class MenuController {
	
	private StartMenuView mainView;

	public MenuController(StartMenuView mainView) {
		this.mainView = mainView;
	}
	
	// Methode zum switchen zwischen Views
	public void showView(String viewName) {
		mainView.showCard(viewName);
	}
	
	// Back to MainMenu Methode
	public void showStartMenu() {
		mainView.showCard("StartMenu");
	}
	
	// Programm beenden Methode
	public void exitApplication() {
		System.exit(0);
	}

}
