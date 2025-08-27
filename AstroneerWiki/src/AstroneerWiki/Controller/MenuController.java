package AstroneerWiki.Controller;

import java.util.Map;

import AstroneerWiki.Model.HighlightButtonModel;
import AstroneerWiki.Util.ButtonLoader;
import AstroneerWiki.View.StartMenuView;

public class MenuController {
	
	private StartMenuView mainView;
	private HighlightButtonModel buttonHighlighter;
	private Map<String, ButtonLoader> viewButtonMap;

	public MenuController(StartMenuView mainView,
						  HighlightButtonModel buttonHighlighter,
						  Map<String, ButtonLoader>viewButtonMap) {
		this.mainView = mainView;
		this.buttonHighlighter = buttonHighlighter;
		this.viewButtonMap = viewButtonMap;			
	}
	
	public void showView(String viewName) {
		mainView.showCard(viewName);
		
	ButtonLoader btn = viewButtonMap.get(viewName);
	if (btn != null) {
		buttonHighlighter.highlight(btn);
	}
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
