package AstroneerWiki.View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

import AstroneerWiki.Controller.MenuController;
import AstroneerWiki.Model.HighlightButtonModel;
import AstroneerWiki.Util.ButtonFactory;
import AstroneerWiki.Util.ButtonLoader;
import AstroneerWiki.Util.FontLoader;

public class PlanetView extends JPanel {

    private MenuController controller;
    private StartMenuView mainView;
    private Image planetBackgroundImage;
    private HighlightButtonModel buttonHighlighter;
    private Map<String, ButtonLoader> viewButtonMap;

    // Buttons
    private ButtonLoader startMenuBtn;
    private ButtonLoader planetMenuBtn;
    private ButtonLoader resourceMenuBtn;
    private ButtonLoader vehicleMenuBtn;
    private ButtonLoader baseBuildingMenuBtn;
    private ButtonLoader toolEquipmentMenuBtn;
    private ButtonLoader researchMenuBtn;
    private ButtonLoader hazardFaunaMenuBtn;
    private ButtonLoader cosmeticMenuBtn;
    private ButtonLoader exitAppBtn;

    public PlanetView(StartMenuView mainView, MenuController controller) {
        this.mainView = mainView;
        this.controller = controller;

        setLayout(new BorderLayout());

        // Buttons erstellen
        createButtons();

        // Highlight-Modell
        buttonHighlighter = new HighlightButtonModel(
                startMenuBtn, planetMenuBtn, resourceMenuBtn, vehicleMenuBtn,
                baseBuildingMenuBtn, toolEquipmentMenuBtn, researchMenuBtn,
                hazardFaunaMenuBtn, cosmeticMenuBtn, exitAppBtn
        );

        // Map erstellen
        viewButtonMap = new HashMap<>();
        viewButtonMap.put("PlanetView", planetMenuBtn);
        viewButtonMap.put("ResourceView", resourceMenuBtn);
        viewButtonMap.put("VehicleView", vehicleMenuBtn);
        viewButtonMap.put("BaseBuildingView", baseBuildingMenuBtn);
        viewButtonMap.put("ToolEquipmentView", toolEquipmentMenuBtn);
        viewButtonMap.put("ResearchView", researchMenuBtn);
        viewButtonMap.put("HazardFaunaView", hazardFaunaMenuBtn);
        viewButtonMap.put("CosmeticView", cosmeticMenuBtn);

        // Menüleiste
        JPanel menuBar = createPlanetMenuPanel();
        menuBar.setOpaque(false);
        add(menuBar, BorderLayout.SOUTH);

        // Content-Bereich
        JLabel content = new JLabel("Planet View", JLabel.CENTER);
        content.setOpaque(false);
        add(content, BorderLayout.CENTER);

        // Fonts
        UIManager.put("Button.font", FontLoader.getCustomFont(20f));
        UIManager.put("Label.font", FontLoader.getCustomFont(16f));

        // Hintergrundbild laden
        java.net.URL url = getClass().getResource("/img/background/PlanetsBackground.jpg");
        System.out.println("URL = " + url); // Debug
        if (url != null) {
            planetBackgroundImage = new ImageIcon(url).getImage();
        } else {
            System.err.println("❌ Hintergrundbild konnte nicht geladen werden!");
        }
    }

    // Buttons erzeugen
    private void createButtons() {
        startMenuBtn = ButtonFactory.standartStartButton();
        planetMenuBtn = ButtonFactory.standartPlanetButton();
        resourceMenuBtn = ButtonFactory.standartResourceButton();
        vehicleMenuBtn = ButtonFactory.standartVehicleButton();
        baseBuildingMenuBtn = ButtonFactory.standartBaseBuildingButton();
        toolEquipmentMenuBtn = ButtonFactory.standartToolEquipmentButton();
        researchMenuBtn = ButtonFactory.standartResearchButton();
        hazardFaunaMenuBtn = ButtonFactory.standartHazardFaunaButton();
        cosmeticMenuBtn = ButtonFactory.standartCosmeticButton();
        exitAppBtn = ButtonFactory.standartExitButton();
    }

    // Hintergrund zeichnen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (planetBackgroundImage != null) {
            g.drawImage(planetBackgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // Menüleiste
    private JPanel createPlanetMenuPanel() {
        JPanel buttonPnl = new JPanel();
        buttonPnl.setOpaque(false);
        buttonPnl.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

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

        // Größe der Buttons
        Dimension btnSize = new Dimension(170, 95);
        startMenuBtn.setPreferredSize(btnSize);
        planetMenuBtn.setPreferredSize(btnSize);
        resourceMenuBtn.setPreferredSize(btnSize);
        vehicleMenuBtn.setPreferredSize(btnSize);
        baseBuildingMenuBtn.setPreferredSize(btnSize);
        toolEquipmentMenuBtn.setPreferredSize(btnSize);
        researchMenuBtn.setPreferredSize(btnSize);
        hazardFaunaMenuBtn.setPreferredSize(btnSize);
        cosmeticMenuBtn.setPreferredSize(btnSize);
        exitAppBtn.setPreferredSize(btnSize);

        // Aktionen
        startMenuBtn.addActionListener(e -> controller.showView("StartView"));
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
