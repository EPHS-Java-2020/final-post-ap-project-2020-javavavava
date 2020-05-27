package tileWorkGame;

public class TileGameWork {

	private int[][] original = { {1, 2, 3}, 
							   {4, 5, 6},
							   {7, 8, 9}
			
							 };
	private int[][] changed = new int[3][3];
	private int[][] output = new int [3][3];
	
	public TileGameWork() {
		boardPrint(original);
		 
	}
	public  void boardPrint(int[][] board) {
		for(int i = 0; i < 3; i++) {
				System.out.print(board[0][i] + " ");
			
		}
		System.out.println();
		for(int j = 0; j < 3; j++) {
			System.out.print(board[1][j] + " ");
		
	}
		System.out.println();
		for(int k = 0; k < 3; k++) {
			System.out.print(board[2][k] + " ");
		
	}
		System.out.println();

	}
	
	public void randomizer(int[][] sourceGrid) {
		System.arraycopy(sourceGrid, 0, changed, 0, 3);
		for(int i = 0; i< changed.length; i++) {
			for (int j = 0; j < changed[i].length; j++) {
				int i1 = (int) (Math.random() * changed.length);
				int j1 = (int) (Math.random() * changed[i].length);
				int temp = changed[i][j];
				changed[i][j] = changed[i1][j1];
				changed[i1][j1] = temp;	
			}
		}
	}
	
	public int[][] getOriginal() {
		return original;
	}
	public void setOriginal(int[][] original) {
		this.original = original;
	}
	public int[][] getChanged() {
		return changed;
	}
	public void setChanged(int[][] changed) {
		this.changed = changed;
	}
	public int[][] getOutput() {
		return output;
	}
	public void setOutput(int[][] output) {
		this.output = output;
	}
	public void switcher(int first, int second) {
		int temp = 0;
	
		for(int i = 0; i < changed.length; i++) {
			for(int j =0; j < changed[i].length; j++) {
				//find the first matching number
				
				if (changed[i][j] == first) {
					//look down
//					System.out.println(i + " --> " + j);
					if (i < changed.length - 1 && changed[i + 1][j] == second){
						 temp = changed[i][j];
						 output[i][j] = changed[i+1][j];
						 output[i+1][j] = temp;
					
					}else if ( i> 0 && changed[i-1][j]== second) {
						//look up
						 temp = changed[i][j];
						output[i][j] = changed[i-1][j];
						output[i-1][j] = temp;
					
					}else if(j < changed[i].length && changed[i][j+1] == second) {
						//look right
						 temp = changed[i][j];
						output[i][j] = changed[i][j+1];
						output[i][j+1] = temp;
					}else if (j > 0 && changed[i][j-1] == second) {
						//look left
						 temp = changed[i][j];
						output[i][j] = changed[i][j-1];
						output[i][j-1] = temp;
					}
				}
				if(output[i][j] == 0) {
					output[i][j] = changed[i][j];
				}
			}
		}
		boardPrint(output);
	}
	public boolean checker() {
		for(int i = 0; i < original.length; i++) {
			for(int j = 0; j < original[i].length; j++) {
				if(original[i][j] == output[i][j]) {
					return true;
				}
				
			}
		}
		return false;
	}
}
