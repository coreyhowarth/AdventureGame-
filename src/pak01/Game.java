package pak01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {
	
	ChoiceHandler handler = new ChoiceHandler();
	UI ui = new UI();
	visibilityManager vm = new visibilityManager(ui);
	
	public Game() {
		
		ui.createUI(handler);
		vm.showTitleScreen();
		
	}
	
	public class ChoiceHandler implements ActionListener {

		public void actionPerformed(ActionEvent event) {
		
			String yourChoice = event.getActionCommand();
			
			switch(yourChoice) {
			
			case "start": 
				vm.titleToTown();
				break;
				
			case "c1":
				break;
				
			case "c2":
				break;
				
			case "c3":
				break;
				
			case "c4":
				break;
			}
			
		}
	}
	
	public static void main(String[] args) {
		
		new Game();
		
	}
	
}
