package pak01;

import pak02.Weapon_Knife;
import pak02.Weapon_LongSword;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.hp = 10;
		ui.hpLabelNumber.setText("" + player.hp);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
	}
	
	public void selectPosition(String nextPosition) {
		
		switch(nextPosition) {
		case "townGate": townGate(); break;
		case "talkGaurd": talkGaurd(); break;
		case "attackGaurd": attackGaurd(); break;
		case "crossRoad": crossRoad(); break;
		case "north": north(); break;
		case "east": east(); break;
		case "west": west(); break;
		}
		
	}
	
	public void townGate() {
		
		ui.mainTextArea.setText("You are at the gate of the town. \nA gaurd is standing in front of you. \n\nWhat do you do?");
		ui.choice1.setText("Talk to the gaurd.");
		ui.choice2.setText("Attack the gaurd.");
		ui.choice3.setText("Leave.");
		ui.choice4.setText("");
		
		game.nextPosition1 = "talkGaurd";
		game.nextPosition2 = "attackGaurd";
		game.nextPosition3 = "crossRoad";
		game.nextPosition4 = "";
		
	}
	
	public void talkGaurd() {
		
		ui.mainTextArea.setText("Gaurd: Hello Stranger. I have never seen your face before. \nI'm sorry, but we cannot let a stranger enter our town.");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void attackGaurd() {
		
		ui.mainTextArea.setText("Gaurd: Hey! Don't be stupid. \n\nThe gaurd attacked you so hard and you gave up. \n(You recieved 3 damage)");
		player.hp -= 3;
		ui.hpLabelNumber.setText("" + player.hp);
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void crossRoad() {
		
		ui.mainTextArea.setText("You are at a crossroad. \nIf you go south, you will go back to the town.");
		ui.choice1.setText("Go north.");
		ui.choice2.setText("Go east.");
		ui.choice3.setText("Go south.");
		ui.choice4.setText("Go west.");
		
		game.nextPosition1 = "north";
		game.nextPosition2 = "east";
		game.nextPosition3 = "townGate";
		game.nextPosition4 = "west";
		
		
	}
	
	public void north() {
		
		ui.mainTextArea.setText("There is a river .\nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 2.)");
		player.hp += 3;
		ui.hpLabelNumber.setText("" + player.hp);
		ui.choice1.setText("Go south.");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void east() {
		
		ui.mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword.)");
		player.currentWeapon = new Weapon_LongSword();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		ui.choice1.setText("Go west.");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void west() {
		
		ui.mainTextArea.setText("");
		ui.choice1.setText("");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		
	}
	
}
