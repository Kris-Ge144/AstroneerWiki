package AstroneerWiki.View;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import AstroneerWiki.Controller.MenuController;
import AstroneerWiki.Util.FontLoader;

public class CosmeticView extends JPanel{
	
	private MenuController controller;
	private StartMenuView mainView;
	private JPanel contentPanel;
	private Image cosmeticBackgroundImage;
	
	// Konstruktor
	public CosmeticView(StartMenuView mainView, MenuController controller) {
		this.mainView = mainView;
		this.controller = controller;
		
		setLayout(new BorderLayout());
		
		// Menüleiste
		JPanel menuBar = createCosmeticMenuPanel();
		menuBar.setOpaque(false);
		add(menuBar, BorderLayout.NORTH);
		
		// Content-Bereich
		JLabel content = new JLabel("Cosmetic View", JLabel.CENTER);
		content.setOpaque(false);
		add(content, BorderLayout.CENTER);
		
		// Font laden
		UIManager.put("Button.font", FontLoader.getCustomFont(20f));
		UIManager.put("Label.font", FontLoader.getCustomFont(16f));
		
		// Hintergrundbild laden mit Debug
        java.net.URL url = getClass().getResource("/img/background/AstroneerMoon.png");
        System.out.println("URL = " + url); // Debug
        if (url != null) {
            cosmeticBackgroundImage = new ImageIcon(url).getImage();
        } else {
            System.err.println("❌ Hintergrundbild konnte nicht geladen werden!");
        }
           
	}
	
	// Hintergrund zeichnen
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if (cosmeticBackgroundImage != null) {
				g.drawImage(cosmeticBackgroundImage, 0, 0, getWidth(), getHeight(), this);
			}
		}
		
	
	// Button-Leiste
	private JPanel createCosmeticMenuPanel() {
		JPanel buttonPnl = new JPanel();
		buttonPnl.setOpaque(false);
			
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
