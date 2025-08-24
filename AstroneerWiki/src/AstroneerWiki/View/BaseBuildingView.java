package AstroneerWiki.View;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class BaseBuildingView extends JPanel{
	
	private MenuController controller;
	private StartMenuView mainView;
	
	// Konstruktor
	public BaseBuildingView(StartMenuView mainView, MenuController controller) {
		this.mainView = mainView;
		this.controller = controller;
		
		setLayout(new BorderLayout());
		
		// Menüleiste
		JPanel menuBar = createBaseBuildingMenuPanel();
		add(menuBar, BorderLayout.NORTH);
		
		// Content-Bereich
		JLabel content = new JLabel("Bases & Buildings View", JLabel.CENTER);
		add(content, BorderLayout.CENTER);
		
	}
	
	// Button-Leiste
	private JPanel createBaseBuildingMenuPanel() {
		JPanel buttonPnl = new JPanel();
			
		JButton planetMenuBtn = new JButton("Planets");
		JButton resourceMenuBtn = new JButton("Resources");
		JButton vehicleMenuBtn = new JButton("Vehicles");
		JButton startMenuBtn = new JButton("Start");
		JButton toolEquipmentMenuBtn = new JButton("Tools & Equipment");
		JButton researchMenuBtn = new JButton("Research & Bytes");
		JButton hazardFaunaMenuBtn = new JButton("Hazards & Fauna");
		JButton cosmeticMenuBtn = new JButton("Cosmetics");
		JButton exitAppBtn = new JButton("Exit");
		JButton baseBuildingMenuBtn = new JButton("Bases & Buildings");
	
		// Buttons hinzufügen
		buttonPnl.add(startMenuBtn);
		buttonPnl.add(planetMenuBtn);
		buttonPnl.add(resourceMenuBtn);
		buttonPnl.add(vehicleMenuBtn);
		buttonPnl.add(baseBuildingMenuBtn);
		buttonPnl.add(toolEquipmentMenuBtn);
		buttonPnl.add(researchMenuBtn);
		buttonPnl.add(hazardFaunaMenuBtn);
		buttonPnl.add(cosmeticMenuBtn);
		buttonPnl.add(exitAppBtn);
			
		// Aktionen der Buttons über den Controller steuern
		startMenuBtn.addActionListener(e -> controller.showView("StartMenu"));
        planetMenuBtn.addActionListener(e -> controller.showView("PlanetView"));
        resourceMenuBtn.addActionListener(e -> controller.showView("ResourceView"));
        vehicleMenuBtn.addActionListener(e -> controller.showView("VehicleView"));
        baseBuildingMenuBtn.addActionListener(e -> controller.showView("BaseBuildingView"));
        toolEquipmentMenuBtn.addActionListener(e -> controller.showView("ToolEquipmentView"));
        researchMenuBtn.addActionListener(e -> controller.showView("ResearchView"));
        hazardFaunaMenuBtn.addActionListener(e -> controller.showView("HazardFaunaView"));
        cosmeticMenuBtn.addActionListener(e -> controller.showView("CosmeticView"));
        exitAppBtn.addActionListener(e -> System.exit(0));

        return buttonPnl;
    }

}
