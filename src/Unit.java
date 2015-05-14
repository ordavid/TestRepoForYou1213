
public class Unit {
int type;
int health;
int damage;
int price;
int priceGold;
int priceWood;
int priceStone;
int priceIron;
int speed;
int range;
int player;

public int getPlayer() {
	return player;
}
public void setPlayer(int player) {
	this.player = player;
}
public Unit() {
}
public int getSpeed() {
	return speed;
}

public void setSpeed(int speed) {
	this.speed = speed;
}

public int getRange() {
	return range;
}

public void setRange(int range) {
	this.range = range;
}

public int getPriceGold() {
	return priceGold;
}

public void setPriceGold(int priceGold) {
	this.priceGold = priceGold;
}

public int getPriceWood() {
	return priceWood;
}

public void setPriceWood(int priceWood) {
	this.priceWood = priceWood;
}

public int getPriceStone() {
	return priceStone;
}

public void setPriceStone(int priceStone) {
	this.priceStone = priceStone;
}

public int getPriceIron() {
	return priceIron;
}

public void setPriceIron(int priceIron) {
	this.priceIron = priceIron;
}
boolean isAlive=true;
	


public int getType() {
	return type;
}

public void setType(int type) {
	this.type = type;
}

public int getHealth() {
	return health;
}

public void setHealth(int health) {
	this.health = health;
}

public int getDamage() {
	return damage;
}

public void setDamage(int damage) {
	this.damage = damage;
}

public int getPrice() {
	return price;
}

public void setPrice(int price) {
	this.price = price;
}

public boolean isAlive() {
	return isAlive;
}

public void setAlive(boolean isAlive) {
	this.isAlive = isAlive;
}

public void fight(Unit joanna){
	while(true){
		joanna.setHealth(joanna.getHealth()-damage);
		health=health-joanna.getDamage();
		if(joanna.getHealth()<=0){
			joanna.setAlive(false);
		}
		if(health<=0){
			isAlive=false;
		}
		return;
	}
}
public void raid(Building b){
	if(type==2){
	b.destroyed();
	}
}


}
