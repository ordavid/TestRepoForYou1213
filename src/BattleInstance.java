import java.util.ArrayList;


public class BattleInstance {
	
	Unit [][] grid;
	public BattleInstance(ArrayList<Unit> troops1, ArrayList<Unit> troops2){
		if(troops1.size()>=troops2.size()){ 
			grid = new Unit[troops1.size()][10];
		}
		else{
			grid = new Unit[troops2.size()][10];
		}
		for(int c = 0; c<grid.length; c++){
			if(c<troops1.size()){
			grid[c][0]=troops1.get(c);
			}
		}
		for(int c = 0; c<grid.length; c++){
			if(c<troops2.size()){
			grid[c][9]=troops2.get(c);
			}
		}
	
	}
	public Unit[][] getGrid() {
		return grid;
	}
	public void setGrid(Unit[][] grid) {
		this.grid = grid;
	}
			
}
