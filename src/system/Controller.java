package system;

import model.Plateau;

public class Controller 
{
	public static int STATE_BEGIN = 0;
	public static int PLAYER_A = 1;
	public static int PLAYER_B = 2;
	public static int STATE_PIECES_A = 1;
	public static int STATE_PIECES_B = 2;
	public static int STATE_PLAYER_A = 3;
	public static int STATE_PLAYER_B = 4;
	
	private Plateau p;
	private int state;
	private int player;
	
	public Controller() {
		p = new Plateau();
		state = STATE_BEGIN;
		player = PLAYER_A;
	}
	
	public void click(int x, int y) {
		int caseClickX = x/80;
		int caseClickY = y/80;
		if(state == STATE_BEGIN || (state != player && state < STATE_PLAYER_A))
			putPiece(caseClickX, caseClickY);
	}
	
	private void putPiece(int caseX, int caseY) {
	}
	
	public void render() {
		p.render();
	}
}
