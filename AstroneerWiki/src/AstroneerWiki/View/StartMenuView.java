package AstroneerWiki.View;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartMenuView extends JFrame{
	private JLabel appTitleLbl;
	private JPanel buttonPnl, appTitlePnl;
	private JButton planetMenuBtn, resourceMenuBtn, vehicleMenuBtn, baseBuildingMenuBtn,
					toolsEquipmentMenuBtn, researchMenuBtn, hazardsFaunaMenuBtn, cosmeticsMenuBtn, exitAppBtn;
	private static StartMenuView instance;
	
	// Konstruktor
	private StartMenuView() {
		setTitle("Astroneer Wiki");
		setSize(1920, 1080);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	// Panels
		buttonPnl = new JPanel();
		appTitlePnl = new JPanel();
		
	// Label
		appTitleLbl = new JLabel("Astroneer Wiki");
		appTitleLbl.setFont(new Font("Arial", Font.BOLD, 32));
		appTitlePnl.add(appTitleLbl);
		
	// Buttons
		planetMenuBtn = new JButton("Planets");
		resourceMenuBtn = new JButton("Resources");
		vehicleMenuBtn = new JButton("Vehicles");
		baseBuildingMenuBtn = new JButton("Bases & Buildings");
		toolsEquipmentMenuBtn = new JButton("Tools & Equipment");
		researchMenuBtn = new JButton("Research & Bytes");
		hazardsFaunaMenuBtn = new JButton("Hazards & Fauna");
		cosmeticsMenuBtn = new JButton("Cosmetics");
		exitAppBtn = new JButton("Exit");
		
	// Buttons zum Panel hinzufügen
		buttonPnl.add(planetMenuBtn);
		buttonPnl.add(resourceMenuBtn);
		buttonPnl.add(vehicleMenuBtn);
		buttonPnl.add(baseBuildingMenuBtn);
		buttonPnl.add(toolsEquipmentMenuBtn);
		buttonPnl.add(researchMenuBtn);
		buttonPnl.add(hazardsFaunaMenuBtn);
		buttonPnl.add(cosmeticsMenuBtn);
		buttonPnl.add(exitAppBtn);
		
	// Panels zum Frame hinzufügen
		add(appTitlePnl, BorderLayout.NORTH);
		add(buttonPnl, BorderLayout.CENTER);
	
	}
	
	// Getter
	
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
}
