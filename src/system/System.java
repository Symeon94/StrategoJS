package system;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class System 
{
	public static void main(String[] args) throws LWJGLException
	{
		Display.setDisplayMode(new DisplayMode(1280,720));
		Display.setFullscreen(false);
		Display.setVSyncEnabled(true);
		Display.create();
		
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
		GLU.gluOrtho2D(0, 800, 0, 600);
	}
	
	public static void update() {
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(0, 0, 0, 1);
		glMatrixMode(GL_MODELVIEW);
	}
	
	public static void render() {
		//glTranslatef(0.1f,0,0);
		glBegin(GL_TRIANGLES);
		glColor3f(1,1,1);
		glVertex3f(0,0,0);
		glVertex3f(400,0,0);
		glVertex3f(0,300,0);
		glEnd();
	}
	
	public static void destroy() {
		
	}
	
}
