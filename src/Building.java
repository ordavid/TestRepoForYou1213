
public class Building {
boolean isAlive=true;
int value;
int type;
int priceGold;
int priceWood;
int priceStone;
int priceIron;
	
	public Building(){
		
	}

	public void destroyed(){
		isAlive=false;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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
	

}
