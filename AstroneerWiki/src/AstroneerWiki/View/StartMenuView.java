package AstroneerWiki.View;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import AstroneerWiki.Controller.MenuController;

public class StartMenuView extends JFrame {
	
	private static StartMenuView instance;
	private JPanel contentPanel;
	private CardLayout cardLayout;
	private MenuController controller;
	
	// Singleton
	private StartMenuView() {
		setTitle("Astroneer Wiki");
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// CardLayout für alle Views
		cardLayout = new CardLayout();
		contentPanel = new JPanel(cardLayout);
		add(contentPanel, BorderLayout.CENTER);
		
		// Controller initialisieren und ihm dieese View übergeben
		controller = new MenuController(this);
		
		// Startmenü-Panel erstellen
		JPanel startMenuPanel = createStartMenuPanel();
		
		// Panels registrieren
		contentPanel.add(startMenuPanel,"StartMenu");
		
		// weitere Views registrieren
		contentPanel.add(new PlanetView(this, controller),"PlanetView");
		contentPanel.add(new VehicleView(this, controller),"VehicleView");
		contentPanel.add(new ResourceView(this, controller),"ResourceView");
		contentPanel.add(new BaseBuildingView(this, controller),"BaseBuildingView");
		contentPanel.add(new ToolEquipmentView(this, controller),"ToolEquipmentView");
		contentPanel.add(new ResearchView(this, controller),"ResearchView");
		contentPanel.add(new HazardFaunaView(this, controller),"HazardFaunaView");
		contentPanel.add(new CosmeticView(this, controller),"CosmeticView");
		
		// Standartmäßig Startmenü anzeigen
		showCard("StartMenu");
	}
	
	// Erzeugt das Startmenü-Panel mit allen Buttons
	private JPanel createStartMenuPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		
		// Titel
		JLabel appTitleLbl = new JLabel("Astroneer Wiki", JLabel.CENTER);
		appTitleLbl.setFont(new Font("Arial", Font.BOLD, 32));
		panel.add(appTitleLbl, BorderLayout.NORTH);
		
		// Button-Leiste
		JPanel buttonPnl = new JPanel();
		
		JButton planetMenuBtn = new JButton("Planets");
		JButton resourceMenuBtn = new JButton("Resources");
		JButton vehicleMenuBtn = new JButton("Vehicles");
		JButton baseBuildingMenuBtn = new JButton("Bases & Buildings");
		JButton toolEquipmentMenuBtn = new JButton("Tools & Equipment");
		JButton researchMenuBtn = new JButton("Research & Bytes");
		JButton hazardFaunaMenuBtn = new JButton("Hazards & Fauna");
		JButton cosmeticMenuBtn = new JButton("Cosmetics");
		JButton exitAppBtn = new JButton("Exit");
		
		// Buttons hinzufügen
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
		planetMenuBtn.addActionListener(e -> controller.showView("PlanetView"));
		resourceMenuBtn.addActionListener(e -> controller.showView("ResourceView"));
		vehicleMenuBtn.addActionListener(e -> controller.showView("VehicleView"));
		baseBuildingMenuBtn.addActionListener(e -> controller.showView("BaseBuildingView"));
		toolEquipmentMenuBtn.addActionListener(e -> controller.showView("ToolEquipmentView"));
		researchMenuBtn.addActionListener(e -> controller.showView("ResearchView"));
		hazardFaunaMenuBtn.addActionListener(e -> controller.showView("HazardFaunaView"));
		cosmeticMenuBtn.addActionListener(e -> controller.showView("CosmeticView"));
		exitAppBtn.addActionListener(e -> System.exit(0));
		
		panel.add(buttonPnl, BorderLayout.CENTER);
		
		return panel;
	}
	
	// Methode, um Panels zu wechseln
	public void showCard(String name) {
		cardLayout.show(contentPanel, name);
	}
	
	// Singleton Getter
	public static StartMenuView getInstance() {
		if (instance == null) {
			instance = new StartMenuView();
		}
		return instance;
	}
	
	// Main zum Testen
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(() -> {
			StartMenuView.getInstance().setVisible(true);
		});
	}
	// Getter & Setter

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public void setContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
	}

	public CardLayout getCardLayout() {
		return cardLayout;
	}

	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}

	public MenuController getController() {
		return controller;
	}

	public void setController(MenuController controller) {
		this.controller = controller;
	}

	public static void setInstance(StartMenuView instance) {
		StartMenuView.instance = instance;
	}
	
	
}
