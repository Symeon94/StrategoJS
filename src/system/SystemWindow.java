package system;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class SystemWindow 
{
	private static int texture;
	private static Controller c;
	
	public static void main(String[] args) throws LWJGLException
	{
		Display.setDisplayMode(new DisplayMode(1280,720));
		Display.setFullscreen(false);
		Display.setVSyncEnabled(true);
		Display.create();
		
		c = new Controller();
		init();
		
		while(!Display.isCloseRequested())
		{
			update();
			render();
			Display.update();
		}
		destroy();
		Display.destroy();
	}
	
	public static void init() {
		glEnable(GL_TEXTURE_2D);
		glEnable(GL_CULL_FACE);
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		GLU.gluOrtho2D(0, 1280, 0, 720);
		
		texture = TexturesLoader.loadTexture("data/test.png");
	}
	
	public static void update() {
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(0, 0, 0, 1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	public static void render() {
		glTranslatef(10f,0.2f,0);
		glScalef(0.5f,0.5f,1);
		glRotatef(45,0,0,1);
		glBindTexture(GL_TEXTURE_2D, texture);
		glBegin(GL_TRIANGLES);
			glColor3f(1,1,1);
			glTexCoord2f(0,0); glVertex3f(00,0,0);
			glTexCoord2f(1,0); glVertex3f(400,0,0);
			glTexCoord2f(0,1); glVertex3f(0,300,0);
		glEnd();
		

		glBegin(GL_TRIANGLES);
			glColor3f(1,1,1);
			glTexCoord2f(1,1); glVertex3f(400,300,0);
			glTexCoord2f(0,1); glVertex3f(0,300,0);
			glTexCoord2f(1,0); glVertex3f(400,0,0);
		glEnd();

		glBindTexture(GL_TEXTURE_2D, 0);
	}
	
	public static void destroy() {
		glDeleteTextures(texture);
	}
	
}
