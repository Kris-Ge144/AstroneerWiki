package AstroneerWiki.View;

import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class ToolEquipmentView extends JPanel{

	public ToolEquipmentView(StartMenuView mainView, MenuController controller) {
		add(new JLabel("Tools & Equipment View"));
	}

}
