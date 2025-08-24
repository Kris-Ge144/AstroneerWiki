package AstroneerWiki.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class ResearchView extends JPanel{

	public ResearchView(StartMenuView mainView, MenuController controller) {
		add(new JLabel("Research & Bytes"));
	}

}
