package AstroneerWiki.Util;


public class ButtonFactory {
	
	public static ButtonLoader standartStartButton() {
		return new ButtonLoader("Start", "/img/backgroundButton/StartButtonBg.jpg");
	}
	
	public static ButtonLoader standartPlanetButton() {
		return new ButtonLoader("Planets", "/img/backgroundButton/PlanetButtonBg.png");
	}
	
	public static ButtonLoader standartResourceButton() {
		return new ButtonLoader("Resources", "/img/backgroundButton/ResourceButtonBg.png");
	}
	
	public static ButtonLoader standartVehicleButton() {
		return new ButtonLoader("Vehicles", "/img/backgroundButton/VehicleButtonBg.png");
	}
	
	public static ButtonLoader standartBaseBuildingButton() {
		return new ButtonLoader("Bases & Buildings","/img/backgroundButton/BaseBuildingButtonBg.jpg");
	}
	
	public static ButtonLoader standartToolEquipmentButton() {
		return new ButtonLoader("Tools & Equipment", "/img/backgroundButton/ToolEquipmentButtonBg.png");
	}
	
	public static ButtonLoader standartResearchButton() {
		return new ButtonLoader("Research & Bytes", "/img/backgroundButton/ResearchButtonBg.jpg");
	}
	
	public static ButtonLoader standartHazardFaunaButton() {
		return new ButtonLoader("Hazards & Fauna", "/img/backgroundButton/HazardFaunaButtonBg.jpg");
	}
	
	public static ButtonLoader standartCosmeticButton() {
		return new ButtonLoader("Cosmetics", "/img/backgroundButton/CosmeticButtonBg.jpg");
	}
	
	public static ButtonLoader standartExitButton() {
		return new ButtonLoader("Exit", "/img/backgroundButton/ExitButtonBg.jpg");
	}
	
}
