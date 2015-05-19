import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import processing.core.PApplet;
import processing.core.PImage;


public class game extends PApplet {
	Player p1 = new Player(3,200,500,300,1,80,120,70);
	Player p2 = new Player(3,200,500,300,1,80,120,70);
	boolean isGameOver=false;
	int screen = 0;
	PImage botA  = loadImage("C:\\Users\\Tgotesdyner689\\Desktop\\botArcher.jpg");
	PImage topA  = loadImage("C:\\Users\\Tgotesdyner689\\Desktop\\topArcher.jpg");
	PImage botS  = loadImage("C:\\Users\\Tgotesdyner689\\Desktop\\botSwords.png");
	PImage topS  = loadImage("C:\\Users\\Tgotesdyner689\\Desktop\\topSwords.jpg");
	//PImage botH  = loadImage("C:\\Users\\Tgotesdyner689\\Desktop\\botHorse.jpg");
	PImage topH  = loadImage("C:\\Users\\Tgotesdyner689\\Desktop\\topHorse.jpg");
	
	final int BUILDSCREEN=1;
	final int TRAINSCREEN=2;
	final int FIGHTSCREEN=9;
	final int ATTACKSCREEN=3;
	final int ENDSCREEN=0;
	final int BUILDGOLDMINE=1;
	final int BUILDLUMBERMILL=2;
	final int BUILDSTONEQUARRY=3;
	final int BUILDIRONMINE=4;
	final int TRAINSWORDSMAN=5;
	final int TRAINARCHER=6;
	final int TRAINHORSE=7;
	final int ATTACK=8;
	Player current = p1;
	BattleInstance joanna; 
	int turn=1;
	ArrayList<Square> squares;
	int originalR;
	int originalC;
	int finalR;
	int finalC;
	int click=0;
	
	public void setup(){
		size(600,600);
	}
	public void draw(){
		
		if(p1.getHealth()<=0){
			System.out.println("Player 2 wins!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
		if(p2.getHealth()<=0){
			System.out.println("Player 1 wins!!!!!!!!!!!!!!!!!!!!!!!!!!!");
			System.exit(0);
		}
		background(0,0,0);
		textSize(12);
		fill(255,255,255);
		if(screen!=FIGHTSCREEN){
		if(current.equals(p1)){
		text("Turn: player 1", 220, 300); 
		}
		else if(current.equals(p2)){
		text("Turn: player 2", 220, 300); 
		}
		fill(255,255,0);
		text("Gold: " + p1.getGold(), 10, 30); 
		fill(153, 76, 0);
		text("Wood: " + p1.getWood(), 10, 50); 
		fill(224, 224, 224);
		text("Stone: " + p1.getStone(), 10, 70); 
		fill(128,128,128);
		text("Iron: " + p1.getIron(), 10, 90); 
		fill(255,255,0);
		text("Gold: " + p2.getGold(), 400, 30); 
		fill(153, 76, 0);
		text("Wood: " + p2.getWood(), 400, 50); 
		fill(224, 224, 224);
		text("Stone: " + p2.getStone(), 400, 70); 
		fill(128,128,128);
		text("Iron: " + p2.getIron(), 400, 90); 
		fill(255,255,255);
		text("Swordsmen: " + p1.getNumSwordsman(), 10, 110); 
		fill(255,255,255);
		text("Archers: " + p1.getNumArcher(), 10, 130); 
		fill(255,255,255);
		text("Horsemen: " + p1.getNumHorseman(), 10, 150); 
		fill(255,255,255);
		text("Swordsmen: " + p2.getNumSwordsman(), 400, 110); 
		fill(255,255,255);
		text("Archers: " + p2.getNumArcher(), 400, 130); 
		fill(255,255,255);
		text("Horsemen: " + p2.getNumHorseman(), 400, 150); 
		fill(0,255,0);
		text("Health: " + p2.getHealth(), 400, 170); 
		fill(0,255,0);
		text("Health: " + p1.getHealth(), 10, 170);
		fill(255,255,255);
		}
		
		if(screen == 0){
			rect(90,500,100,70);
			text("Build", 100, 590); 
			rect(200,500,100,70);
			text("Train", 210, 590); 
			rect(310,500,100,70);
			text("Fight", 320, 590); 
			}
		if(screen == BUILDSCREEN){
			ellipse(110,500,80,80);
			text("Gold Mine: \n300w,1g,\n500s,200i", 80, 550); 
			ellipse(220,500,80,80);
			text("Lumber Mill: \n100w,3g,\n400s,200i", 190, 550); 
			ellipse(330,500,80,80);
			text("Quarry: \n200w,2g,\n100s,400i", 300, 550); 
			ellipse(440,500,80,80);
			text("Iron Mine: \n300w,3g,\n200s,100i", 410, 550); 
		}
		if(screen == TRAINSCREEN){
			ellipse(110,500,80,80);
			text("Swordsman: \n20w,2g,\n50s,120i", 80, 550); 
			ellipse(220,500,80,80);
			text("Archer: \n100w,4g,\n50s,20i", 190, 550); 
			ellipse(330,500,80,80);
			text("Horseman: \n200w,6g,\n200s,170i", 300, 550); 
		}
		if(screen == ATTACKSCREEN){
			if((p1.getTroops().size()>0||p2.getTroops().size()>0)){
			joanna = new BattleInstance(p1.getTroops(),p2.getTroops());
			squares = new ArrayList<Square>();
			for(int r=10; r<590-580/(joanna.getGrid()[0].length); r+=580/(joanna.getGrid().length)){
				for(int c = 10; c<=590-580/(joanna.getGrid()[0].length); c+=580/(joanna.getGrid()[0].length)){
					if(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))] instanceof Swordsman){
						fill(255,0,0);
					}
					else if(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))] instanceof Archer){
						fill(0,255,0);
					}
					else if(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))] instanceof Horseman){
						fill(0,0,255);
					}
					else{
						fill(255,255,255);
					}
					
					rect(r,c,580/(joanna.getGrid().length),580/(joanna.getGrid()[0].length));
					
				}
			}
			screen=FIGHTSCREEN;
			}
			else{
				screen=ENDSCREEN;
			}
		}
		if(screen==FIGHTSCREEN){
			for(int r=10; r<590-580/(joanna.getGrid()[0].length); r+=580/(joanna.getGrid().length)){
				for(int c = 10; c<=590-580/(joanna.getGrid()[0].length); c+=580/(joanna.getGrid()[0].length)){
					if(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))] instanceof Swordsman){
						if(p1.getTroops().contains(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))])){
							topS.resize((580/(joanna.getGrid().length)), (580/(joanna.getGrid()[0].length)));
							image(topS,r,c);	
						}
						else{
							botS.resize((580/(joanna.getGrid().length)), (580/(joanna.getGrid()[0].length)));
							image(botS,r,c);		
						}
					}
					else if(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))] instanceof Archer){
						if(p1.getTroops().contains(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))])){
							topA.resize((580/(joanna.getGrid().length)), (580/(joanna.getGrid()[0].length)));
							image(topA,r,c);	
						}
						else{
							botA.resize((580/(joanna.getGrid().length)), (580/(joanna.getGrid()[0].length)));
							image(botA,r,c);		
						}
					}
					else if(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))] instanceof Horseman){
						if(p1.getTroops().contains(joanna.getGrid()[(r-10)/(580/(joanna.getGrid().length))][(c-10)/(580/(joanna.getGrid()[0].length))])){
							topH.resize((580/(joanna.getGrid().length)), (580/(joanna.getGrid()[0].length)));
							image(topH,r,c);	
						}
						else{
							topH.resize((580/(joanna.getGrid().length)), (580/(joanna.getGrid()[0].length)));
							image(topH,r,c);		
						}
					}
					else{
						
						rect(r,c,580/(joanna.getGrid().length),580/(joanna.getGrid()[0].length));
						fill(255,255,255);
					}
					
				}
				}
			if(p1.getTroops().size()==0 || p2.getTroops().size()==0){
				int winner = fightOver();
				reduceHealth(winner);
				System.out.println("Player " + winner + " is victorius!!!!");
				screen=ENDSCREEN;
			}
				
			
			
		}
	}
	
	
	private void reduceHealth(int winner) {
		if(winner==1){
			p2.setHealth(p2.getHealth()-p1.getNumSwordsman()*50-p1.getNumArcher()*100-p1.getNumHorseman()*150);
		}
		if(winner==2){
			p1.setHealth(p1.getHealth()-p2.getNumSwordsman()*50-p2.getNumArcher()*100-p2.getNumHorseman()*150);
		}
		
	}
	private int fightOver() {
		if(p1.getTroops().size()==0){
			return 2;
		}
		if(p2.getTroops().size()==0){
			return 1;
		}
		return 0;
	}
	public void mouseClicked(){
		if(screen==FIGHTSCREEN){
			makeMove(mouseX,mouseY);
		}
		if(mouseX>70 && mouseX<150 && mouseY>460 && mouseY<540 && screen==BUILDSCREEN){
			runTurn(BUILDGOLDMINE);
			screen=ENDSCREEN;
			return;
		}
		if(mouseX>180 && mouseX<260 && mouseY>460 && mouseY<540 && screen==BUILDSCREEN){
			runTurn(BUILDLUMBERMILL);
			screen=ENDSCREEN;
			return;
		}
		if(mouseX>290 && mouseX<370 && mouseY>460 && mouseY<540 && screen==BUILDSCREEN){
			runTurn(BUILDSTONEQUARRY);
			screen=ENDSCREEN;
			return;
		}
		if(mouseX>400 && mouseX<480 && mouseY>460 && mouseY<540 && screen==BUILDSCREEN){
			runTurn(BUILDIRONMINE);
			screen=ENDSCREEN;
			return;
		}
		if(mouseX>70 && mouseX<150 && mouseY>460 && mouseY<540 && screen==TRAINSCREEN){
			runTurn(TRAINSWORDSMAN);
			screen=ENDSCREEN;
			return;
		}
		if(mouseX>180 && mouseX<260 && mouseY>460 && mouseY<540 && screen==TRAINSCREEN){
			runTurn(TRAINARCHER);
			screen=ENDSCREEN;
			return;
		}
		if(mouseX>290 && mouseX<370 && mouseY>460 && mouseY<540 && screen==TRAINSCREEN){
			runTurn(TRAINHORSE);
			screen=ENDSCREEN;
			return;
		}
		
		if(mouseX>90 && mouseX<190 && mouseY>500 && mouseY<570 && screen==ENDSCREEN){
			screen=BUILDSCREEN;
		}
		if(mouseX>200 && mouseX<300 && mouseY>500 && mouseY<570 && screen==ENDSCREEN){
			screen=TRAINSCREEN;
		}
		if(mouseX>310 && mouseX<410 && mouseY>500 && mouseY<570 && screen==ENDSCREEN){
			screen=ATTACKSCREEN;
		}
		
	
		
		
	}
	private void makeMove(int mouseX, int mouseY) {
		
		if(click==0){
			originalR=(mouseY-10)/(580/(joanna.getGrid()[0].length));
			originalC=(mouseX-10)/(580/(joanna.getGrid().length));
			click=1;
			return;
		}
		if(click==1){
			finalR=(mouseY-10)/(580/(joanna.getGrid()[0].length));
			finalC=(mouseX-10)/(580/(joanna.getGrid().length));
			Unit temp = joanna.getGrid()[originalC][originalR];
			if(isValidMove(originalR, originalC, finalR, finalC,temp)){
			if(joanna.getGrid()[finalC][finalR]==null){
			joanna.getGrid()[originalC][originalR]=null;
			joanna.getGrid()[finalC][finalR]=temp;
			click=0;
			}
			else{
				joanna.getGrid()[finalC][finalR].setHealth(joanna.getGrid()[finalC][finalR].getHealth()-temp.getDamage());
				System.out.println("Health of unit attacked: " + joanna.getGrid()[finalC][finalR].getHealth());
				if(joanna.getGrid()[finalC][finalR].getHealth()<=0){
					if(joanna.getGrid()[finalC][finalR].getPlayer()==1){
						p1.removeTroop(joanna.getGrid()[finalC][finalR]);
					}
					else if(joanna.getGrid()[finalC][finalR].getPlayer()==2){
						p2.removeTroop(joanna.getGrid()[finalC][finalR]);
					}
					joanna.getGrid()[finalC][finalR]=null;
				}
			}
			
			}
			click=0;
			
		}
		
	}
	private boolean isValidMove(int originalR2, int originalC2, int finalR2,
			int finalC2, Unit a) {
		if(a==null||(finalC2==originalC2&&finalR2==originalR2) ){
			return false;	
		}
		if(joanna.getGrid()[finalC2][finalR2] != null){
			if(Math.abs(finalR2-originalR2)<=a.getRange() && Math.abs(finalC2-originalC2)<=a.getRange()){
				return true;
			}
		}
		if(Math.abs(finalR2-originalR2)<=a.getSpeed() && Math.abs(finalC2-originalC2)<=a.getSpeed()){
		return true;
		}
		return false;
	}
	public void runTurn(int a){
		
		if(a==BUILDGOLDMINE){
			Building gm=new GoldMine();
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addBuilding(gm);
				System.out.println("You just bought an gold mine!" );
				
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==BUILDSTONEQUARRY){
			Building gm=new StoneQuarry();
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addBuilding(gm);
				System.out.println("You just bought a stone quarry!" );
			}
			else{
				System.out.println("You cannot afford");
				
			}
		}
		if(a==BUILDLUMBERMILL){
			Building gm=new LumberMill();
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addBuilding(gm);
				System.out.println("You just bought an lumber mill!" );
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==BUILDIRONMINE){
			Building gm=new IronMine();
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addBuilding(gm);
				System.out.println("You just bought an iron mine!" );
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==TRAINSWORDSMAN){
			Swordsman gm=new Swordsman(turn);
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addTroop(gm);
				System.out.println("You just trained a swordsman");
				
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==TRAINARCHER){
			Archer gm=new Archer(turn);
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addTroop(gm);
				System.out.println("You just trained an archer");
				
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==TRAINHORSE){
			Horseman gm=new Horseman(turn);
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addTroop(gm);
				System.out.println("You just trained a horseman");
				
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		
		System.out.println("Your turn is over");
		current.update();
		
		
		
		
		
		
		
		
		
		if(current.equals(p1)){
			current=p2;
			turn=2;
		}
		else{
			current=p1;
			turn=1;
		}
		return;
	}
	
}
