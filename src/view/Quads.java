package view;

import static org.lwjgl.opengl.GL11.*;

public class Quads 
{
	public static void drawQuads() {
		glBegin(GL_TRIANGLES);
			glTexCoord2f(0,0); glVertex3f(0,0,0);
			glTexCoord2f(1,0); glVertex3f(1,0,0);
			glTexCoord2f(0,1); glVertex3f(0,1,0);
		glEnd();
		glBegin(GL_TRIANGLES);
			glTexCoord2f(1,1); glVertex3f(1,1,0);
			glTexCoord2f(0,1); glVertex3f(0,1,0);
			glTexCoord2f(1,0); glVertex3f(1,0,0);
		glEnd();
	}
}
