package pak01;

import pak02.Monster_Goblin;
import pak02.Monster_Orc;
import pak02.SuperMonster;
import pak02.Weapon_Knife;
import pak02.Weapon_LongSword;

public class Story {

	Game game;
	UI ui;
	VisibilityManager vm;
	Player player = new Player();
	SuperMonster monster;
	
	int silverRing;
	
	public Story(Game g, UI userInterface, VisibilityManager vManager) {
		
		game = g;
		ui = userInterface;
		vm = vManager;
		
	}
	
	public void defaultSetup() {
		
		player.hp = 15;
		ui.hpLabelNumber.setText("" + player.hp);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponLabelName.setText(player.currentWeapon.name);
		
		silverRing = 0;
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
		case "fight": fight(); break;
		case "playerAttack": playerAttack(); break;
		case "monsterAttack": monsterAttack(); break;
		case "win": win(); break;
		case "lose": lose(); break;
		case "ending": ending(); break;
		case "toTitle": toTitle(); break;
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
		
		if(silverRing == 0) {
			
		ui.mainTextArea.setText("Gaurd: Hello Stranger. I have never seen your face before. \nI'm sorry, but we cannot let a stranger enter our town.");
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		} else if(silverRing == 1) {
			ending();
		}
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
		
		int i = new java.util.Random().nextInt(101);
		
		if(i < 75) {
			
			monster = new Monster_Goblin();
			
		}
		else {
			monster = new Monster_Orc();
		}
			
		ui.mainTextArea.setText("You encountered a " + monster.name + "!");
		ui.choice1.setText("Fight!");
		ui.choice2.setText("Run!");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "fight";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
		
	}
	
	public void fight() {
		
		ui.mainTextArea.setText(monster.name + ": " + monster.hp + "\n\nWhat do you do?");
		ui.choice1.setText("Attack!");
		ui.choice2.setText("Run!");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "playerAttack";
		game.nextPosition2 = "crossRoad";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void playerAttack() {
		
		int playerDamage = new java.util.Random().nextInt(player.currentWeapon.damage);
		
		ui.mainTextArea.setText("You attacked the " + monster.name + " and gave " + playerDamage + " damage!");
		
		monster.hp = monster.hp - playerDamage;
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(monster.hp > 0) {
			
			game.nextPosition1 = "monsterAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
		} else if (monster.hp < 1) {
			
			game.nextPosition1 = "win";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
		}
		
	}
	
	public void monsterAttack() {
		
		int monsterDamage = new java.util.Random().nextInt(monster.attack);
		
		ui.mainTextArea.setText(monster.attackMessage + "\nYou received " + monsterDamage + " damage!");
		
		player.hp = player.hp - monsterDamage;
		ui.hpLabelNumber.setText("" + player.hp);
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		if(player.hp > 0) {
			
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		} 
		
		else if (player.hp < 0) {
			
			game.nextPosition1 = "lose";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
			
		}
		
	}
	
	public void win() {
		
		ui.mainTextArea.setText("You've defeated the " + monster.name + "\n\nThe monster dropped a ring!\n\n(You've obtained a silver ring.)");
		
		silverRing = 1;
		
		ui.choice1.setText("Go east.");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "crossRoad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void lose() {
		
		ui.mainTextArea.setText("You are DEAD!\n\n GAME OVER!");
		
		ui.choice1.setText("To the title screen!");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		game.nextPosition1 = "toTitle";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
		
	}
	
	public void ending( ) {
		
		ui.mainTextArea.setText("Gaurd: Oh! you've killed the goblin!?\nThank you! You are a true hero.\n\n<THE END>");
		
		ui.choice1.setVisible(false);
		ui.choice2.setVisible(false);
		ui.choice3.setVisible(false);
		ui.choice4.setVisible(false);
		
	}
	
	public void toTitle() {
		
		defaultSetup();
		vm.showTitleScreen();
		
	}
	
}
