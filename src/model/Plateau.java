package model;

public class Plateau {
	private static int EMPTY = -1;
	
	private int [][] plateau;
	
	public Plateau() {
		plateau = new int[10][10]; 
		for(int i = 0 ; i < plateau.length ; i++)
			for(int j = 0 ; j < plateau[0].length ; j++)
				plateau[i][j] = EMPTY;
	}
	
	/**
	 * We cannot put a piece if x,y is outside the game OR x,y is
	 * in the water OR if another is already there
	 * @return true if we can put a piece where specified
	 */
	public boolean setPiece(int type, int x, int y) {
		if(x < 0 || y < 0 || x >= plateau.length || y >= plateau[0].length)
			return false;
		if(plateau[x][y] != EMPTY)
			return false;
		plateau[x][y] = type;
		return true;
	}
}
