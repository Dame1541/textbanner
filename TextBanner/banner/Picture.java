package banner;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Klass för att skapa ett Picture-objekt för att kunna få ut färgmedelvärdet i en bild
 * @author filip
 */
public class Picture {
	
	private BufferedImage image;
	
	/**
	 * Skapar ett Picture-objekt från en File av typ jpg, jpeg, png, och tif
	 * @param file Filen som ska tas in
	 * @throws Exception SLänger ett exception om filen inte stöds
	 */
	public Picture(File file) throws Exception {
			if (new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "tif").accept(file))
				image = ImageIO.read(file);
			else
				throw new Exception("File isn't an image.");
	}

	/**
	 * Hämtar medelfärgen från en area i en bild
	 * @param x1 X-startpunkten för arean
	 * @param y1 Y-startpunkten för arean
	 * @param x2 X-slutpunkten för arean
	 * @param y2 Y-slutpunkten för arean
	 * @return Färgen som returneras
	 */
	public int getAverageColor(double x1, double y1, double x2, double y2) {

		int color = 0;
		double xLength = 1, yLength = 1, red = 0, green = 0, blue = 0, area = 0;
		
		for (double x = x1; x < (x2 > image.getWidth() ? image.getWidth() : x2); x++) {
			for (double y = y1; y < (y2 > image.getHeight() ? image.getHeight() : y2); y++) {

				if (Math.ceil(x) != x && Math.ceil(x) <= x2)
					xLength = Math.ceil(x) - x;
				else if (Math.ceil(x) != x || x+1 > x2)
					xLength = x2 - x;

				if (Math.ceil(y) != y && Math.ceil(y) <= y2)
					yLength = Math.ceil(y) - y;
				else if (Math.ceil(y) != y || y+1 > y2)
					yLength = y2 - y;

				area += xLength * yLength;
				color =  image.getRGB((int)x, (int)y); 
				x = Math.floor(x);
				y = Math.floor(y);
				red += ((color & 0x00ff0000) >> 16) * xLength * yLength;
				green += ((color & 0x0000ff00) >> 8) * xLength * yLength;
				blue +=  (color & 0x000000ff) * xLength * yLength;
			}
		}

		if (area != 0) {
			red /= area;
			green /= area;
			blue /= area;
		}

		return Color.rgb((int)Math.round(red), (int)Math.round(green), (int)Math.round(blue));
	}

	/**
	 * Hämtar bredden på bilden
	 * @return
	 */
	public int getWidth() {
		return image.getWidth();
	}

	/**
	 * Hämtar höjden på bilden
	 * @return
	 */
	public int getHeight() {
		return image.getHeight();
	}
}