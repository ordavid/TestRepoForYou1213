import java.util.ArrayList;


public class Player {
int gold;
int wood;
int stone;
int iron;
int goldIncome;
int woodIncome;
int stoneIncome;
int ironIncome;
ArrayList<Unit> troops = new ArrayList<Unit>();
ArrayList<Building> buildings = new ArrayList<Building>();
int health;

public Player(int g,int w,int s,int i,int gi,int wi,int si,int ii){
	gold=g;
	wood=w;
	stone=s;
	iron=i;
	goldIncome=gi;
	woodIncome=wi;
	stoneIncome=si;
	ironIncome=ii;
	health=1000;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public void incrementGold(){
	gold+=goldIncome;
}
public void incrementWood(){
	wood+=woodIncome;
}
public void incrementStone(){
	stone+=stoneIncome;
}
public void incrementIron(){
	iron+=ironIncome;
}
public int getGold() {
	return gold;
}
public void setGold(int gold) {
	this.gold = gold;
}
public int getWood() {
	return wood;
}
public void setWood(int wood) {
	this.wood = wood;
}
public int getStone() {
	return stone;
}
public void setStone(int stone) {
	this.stone = stone;
}
public int getIron() {
	return iron;
}
public void setIron(int iron) {
	this.iron = iron;
}
public int getGoldIncome() {
	return goldIncome;
}
public void setGoldIncome(int goldIncome) {
	this.goldIncome = goldIncome;
}
public int getWoodIncome() {
	return woodIncome;
}
public void setWoodIncome(int woodIncome) {
	this.woodIncome = woodIncome;
}
public int getStoneIncome() {
	return stoneIncome;
}
public void setStoneIncome(int stoneIncome) {
	this.stoneIncome = stoneIncome;
}
public int getIronIncome() {
	return ironIncome;
}
public void setIronIncome(int ironIncome) {
	this.ironIncome = ironIncome;
}
public ArrayList<Unit> getTroops(){
	return troops;
}
public void addTroop(Unit a){
	troops.add(a);
}

public ArrayList<Building> getBuildings(){
	return buildings;
}
public void addBuilding(Building a){
	buildings.add(a);
	if(a.getType()==1){
		goldIncome+=a.getValue();
	}
	if(a.getType()==2){
		woodIncome+=a.getValue();
	}
	if(a.getType()==3){
		stoneIncome+=a.getValue();
	}
	if(a.getType()==4){
		ironIncome+=a.getValue();
	}
}

public void removeBuilding(Building a){
	buildings.add(a);
	if(a.getType()==1){
		goldIncome+=a.getValue();
	}
	if(a.getType()==2){
		woodIncome+=a.getValue();
	}
	if(a.getType()==3){
		stoneIncome+=a.getValue();
	}
	if(a.getType()==4){
		ironIncome+=a.getValue();
	}
}

public int getNumSwordsman(){
	int count=0;
	for(int i = 0; i<troops.size(); i++){
		if(troops.get(i) instanceof Swordsman){
			count++;
		}
	}
	return count;
}

public int getNumHorseman(){
	int count=0;
	for(int i = 0; i<troops.size(); i++){
		if(troops.get(i) instanceof Horseman){
			count++;
		}
	}
	return count;
}

public int getNumArcher(){
	int count=0;
	for(int i = 0; i<troops.size(); i++){
		if(troops.get(i) instanceof Archer){
			count++;
		}
	}
	return count;	
}

public void update(){
	gold+=goldIncome;
	stone+=stoneIncome;
	wood+=woodIncome;
	iron+=ironIncome;
}

public boolean buy(int a, int b, int c, int d){
	if(gold-a<0 ||wood-b<0 ||stone-c<0||iron-d<0){
	return false;
	}
	gold-=a;
	wood-=b;
	stone-=c;
	iron-=d;
	return true;
}

public void removeTroop(Unit a){
	for(int i = 0; i<troops.size(); i++){
		if(troops.get(i).getType()==a.getType()){
			troops.remove(i);
			return;
		}
	}
	}

}
