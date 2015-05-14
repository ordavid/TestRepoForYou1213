import javax.swing.JOptionPane;

import processing.core.PApplet;


public class game extends PApplet {
	Player p1 = new Player(3,200,500,300,1,80,120,70);
	Player p2 = new Player(3,200,500,300,1,80,120,70);
	boolean isGameOver=false;
	int screen = 0;
	final int BUILDSCREEN=1;
	final int TRAINSCREEN=2;
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
	
	boolean turn=true;
	public void setup(){
		
		size(600,600);
	}
	public void draw(){
		
		
		background(0,0,0);
		textSize(12);
		fill(255,255,255);
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
		
		if(screen == 0){
			rect(90,500,100,70);
			rect(200,500,100,70);
			rect(310,500,100,70);
			}
		if(screen == BUILDSCREEN){
			ellipse(110,500,80,80);
			ellipse(220,500,80,80);
			ellipse(330,500,80,80);
			ellipse(440,500,80,80);
		}
		if(screen == TRAINSCREEN){
			ellipse(110,500,80,80);
			ellipse(220,500,80,80);
			ellipse(330,500,80,80);
		}
		if(screen == ATTACKSCREEN){
			if((p1.getTroops().size()>0||p2.getTroops().size()>0)){
			BattleInstance joanna = new BattleInstance(p1.getTroops(),p2.getTroops());
			for(int r=10; r<590; r+=580/(joanna.getGrid().length)){
				for(int c = 10; c<590; c+=580/(joanna.getGrid()[0].length)){
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
			}
			else{
				screen=ENDSCREEN;
			}
		}
	}
	
	
	public void mouseClicked(){
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
			Swordsman gm=new Swordsman();
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addTroop(gm);
				System.out.println("You just trained a swordsman");
				
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==TRAINARCHER){
			Archer gm=new Archer();
			if(current.buy(gm.getPriceGold(), gm.getPriceWood(), gm.getPriceStone(), gm.getPriceIron())){
				current.addTroop(gm);
				System.out.println("You just trained an archer");
				
			}
			else{
				System.out.println("You cannot afford");
			}
		}
		if(a==TRAINHORSE){
			Horseman gm=new Horseman();
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
		}
		else{
			current=p1;
		}
		return;
	}
	
}
