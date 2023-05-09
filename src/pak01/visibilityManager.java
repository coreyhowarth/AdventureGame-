package pak01;

public class visibilityManager {
	
	UI ui;
	
	public visibilityManager(UI userInterface) {
		
		ui = userInterface;
		
	}
	
	public void showTitleScreen() {
		
		//Shows title screen
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		//Hide Game screen
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		ui.playerPanel.setVisible(false);
		
	}
	
	public void titleToTown() {
		
		//Hide title screen
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
				
		//Show Game screen
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		ui.playerPanel.setVisible(true);
				
		
	}
}
