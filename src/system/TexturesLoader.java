package system;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.EXTTextureFilterAnisotropic;

import static org.lwjgl.opengl.GL14.*;
import static org.lwjgl.opengl.GL12.*;
import static org.lwjgl.opengl.GL11.*;

/**
 * Methode permettant de charge une texture
 * @author Syméon
 */
public class TexturesLoader
{
	/**
	 * Charge une texture
	 * @param pathname le chemin vers la texture a charger
	 * @return l'adresse de la texture dans la memoire gpu
	 */	
	public static int loadTexture(String pathname) 
	{
		BufferedImage img = null;
		int texture = glGenTextures();
		try
		{
			img = ImageIO.read(new File(pathname));
			ByteBuffer buffer = BufferUtils.createByteBuffer(img.getWidth()*img.getHeight()*4);
			for(int y = 0; y < img.getHeight(); y++)
			{
	            for(int x = 0; x < img.getWidth(); x++)
	            {
	                int pixel = img.getRGB(x, y);
	                buffer.put((byte) ((pixel >> 16) & 0xFF));   
	                buffer.put((byte) ((pixel >> 8) & 0xFF));   
	                buffer.put((byte) (pixel & 0xFF));              
	                buffer.put((byte) ((pixel >> 24) & 0xFF));   
	            }
	        }
			buffer.flip();
			glBindTexture(GL_TEXTURE_2D, texture);
			// Wrapping parameter
	        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
	        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
	        // Filter
	        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
	        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
	        // Anisotropic filter
	        glTexParameteri(GL_TEXTURE_2D, EXTTextureFilterAnisotropic.GL_TEXTURE_MAX_ANISOTROPY_EXT, 16);
	        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAX_LEVEL, 16-1); 
	        // Mipmap creation
	        glTexParameteri(GL_TEXTURE_2D, GL_GENERATE_MIPMAP, GL_TRUE);
	        // Create texture
			glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA8, img.getWidth(), img.getHeight(), 0, GL_RGBA, GL_UNSIGNED_BYTE, buffer);
			glBindTexture(GL_TEXTURE_2D, 0);
		}
		catch(IOException ioe)
		{
			ioe.printStackTrace();
		}
		return texture;
	}
}