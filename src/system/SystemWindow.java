package system;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.*;
import org.lwjgl.util.glu.GLU;

import static org.lwjgl.opengl.GL11.*;

public class SystemWindow 
{
	//private static int texture;
	private static Controller c;
	
	public static void main(String[] args) throws LWJGLException
	{
		Display.setDisplayMode(new DisplayMode(800,800));
		Display.setFullscreen(false);
		Display.setVSyncEnabled(true);
		Display.create();
		
		c = new Controller();
		init();
		
		while(!Display.isCloseRequested())
		{
			update();
			c.render();
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
		GLU.gluOrtho2D(0, 800, 0, 800);
		
		//texture = TexturesLoader.loadTexture("data/test.png");
	}
	
	public static void update() {
		glClear(GL_COLOR_BUFFER_BIT);
		glClearColor(0, 0, 0, 1);
		glMatrixMode(GL_MODELVIEW);
		glLoadIdentity();
	}
	
	public static void destroy() {
		//glDeleteTextures(texture);
	}
	
}
