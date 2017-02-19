package model;

import static org.lwjgl.opengl.GL11.*;

import system.TexturesLoader;
import view.Quads;

public class Plateau {
	private static int EMPTY = -1;
	
	private int [][] plateau;
	private int grassTexture, waterTexture;
	
	public Plateau() {
		grassTexture = TexturesLoader.loadTexture("data/grass.png");
		waterTexture = TexturesLoader.loadTexture("data/water.png");
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
	
	public void render() {
		glColor3f(1,1,1);
		glScalef(80,80,1);
		// Render grass
		glBindTexture(GL_TEXTURE_2D, grassTexture);
		glPushMatrix();
		for(int i = 0 ; i < 10 ; i++)
		{
			glPushMatrix();
			for(int j = 0 ; j < 10 ; j++)
			{
				if(!((j == 4 || j == 5) && (i == 2 || i == 3 || i == 6 || i == 7)))
					Quads.drawQuads();
				glTranslatef(0,1,0);
			}
			glPopMatrix();
			glTranslatef(1,0,0);
		}
		glPopMatrix();
		
		// Render water
		glBindTexture(GL_TEXTURE_2D, waterTexture);
		glPushMatrix();
		glTranslatef(2,4,0);
		for(int i = 2 ; i < 8 ; i++) {	
			glPushMatrix();
			for(int j = 4 ; j < 6 ; j++)
			{
				if((j == 4 || j == 5) && (i == 2 || i == 3 || i == 6 || i == 7))
					Quads.drawQuads();
				glTranslatef(0,1,0);
			}
			glPopMatrix();
			glTranslatef(1,0,0);
		}
		glPopMatrix();
	}
}
