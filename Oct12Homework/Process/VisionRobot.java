package Process;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;
import java.util.*;
import java.util.Scanner;

class VisionRobot{


    /**GHETTO VISION FOR ROBOTS
==================================================================================================

Step 1 -------------------------------------------------------------------------------------------
==================================================================================================
Write a program that takes an image and creates a new image where each pixel
not within the specified range of RGB values is filtered out.
	- You may specify the input image and range of RGB values through arguments or standard input.
	- The input images are PNG files.
	- Your program must create a new PNG file called "output.png".
		- Pixels within the specified range of RGB values stay the same.
		- Pixels not within the specified range of RGB values are turned black.
	- The range of RGB values is specified using 6 values:
		- low_red, low_blue, low_green, high_red, high_blue, high_green.
		- You can probably guess what these mean. If not, google what RGB values are. Play around with a colour map online.
	- The stuff that comes packaged with Java should be enough to do this.
		- See here to get started with reading images: https://stackoverflow.com/questions/6444869/how-do-i-read-pixels-from-a-png-file

Step 2 -------------------------------------------------------------------------------------------
==================================================================================================
Modify your program from Step 1 to calculate the mean position of the pixels that were within the specified range of RGB values.
The output image should contain something marking where this mean position is.  i.e: a crosshair or dot, etc
You may create a new program for this, or you may add an option to your program from Step 1.

Step 3 -------------------------------------------------------------------------------------------
==================================================================================================
Take a picture of an object in your household and use your program on the object.
When I was in high school and did something similar to what this HW is based on, I used a bright orange gluestick.

Step 4 -------------------------------------------------------------------------------------------
==================================================================================================
Modifey your program from after Steps 2 and 3 to also take in as input into your program the FOV dimensions of the camera used to take a pictur.
Use this information to calculate the angle at which the "mean position" from Step 2 is away from the camera.

Step 5 -------------------------------------------------------------------------------------------
==================================================================================================
How could the information your program provides after Step 4 be used by an FRC robot?
Instead of filtering pixels by RGB values, are there better ways to track objects?

**/
public static void main(String[] args) {
	Scanner userCameraSpecInput = new Scanner(System.in);

	Color exceptionColorMin = new Color(210, 210, 210,255);
	Color exceptionColorMax = new Color(225,225,225,255);
	
    calculateMeanPixels(paintImage(175, 10, 20, 255, 130,200, exceptionColorMin, exceptionColorMax));
}

public static BufferedImage paintImage(int lowRed, int lowGreen, int lowBlue, int highRed, int highGreen, int highBlue, Color exceptionColorMin, Color exceptionColorMax){
	// Target color : 234,104,74
	BufferedImage img = null;
	BufferedImage newImage = null;
	


	try {
		Color targetColor = new Color(234,104,74,255);
		img = ImageIO.read(new File("Thumb.jpg"));
		newImage = new BufferedImage(640, 640, BufferedImage.TYPE_INT_RGB);
		int width = img.getWidth();
		int height = img.getHeight();
		for(int x = 0; x < width; x += 1){
			for(int y = 0; y < height; y += 1){
				Color currentColor = new Color(img.getRGB(x,y));
				Color minRange = new Color(lowRed, lowGreen, lowBlue);
				Color maxRange = new Color(highRed, highGreen, highBlue);
        		
				Color black = Color.black;
				
				//  if(currentColor.getRGB() < exceptionColorMin.getRGB() || currentColor.getRGB() > exceptionColorMax.getRGB()){
				//     	img.setRGB(x,y,black.getRGB());
				//     }
				if(currentColor.getRed() < lowRed || currentColor.getRed() > highRed || currentColor.getGreen() < lowGreen || currentColor.getGreen() > highGreen || currentColor.getBlue() < lowBlue || currentColor.getBlue() > highBlue){
					img.setRGB(x, y, black.getRGB());
				}
				  
			}
		}
		ImageIO.write(img, "jpg", new File("newImage.jpg"));
		System.out.println(newImage);
	} catch(IOException e ){

	}
	return newImage;

}

public static BufferedImage calculateMeanPixels(BufferedImage newImage){
	
	double targetAngle = 0;
	
	//System.out.println(imgWidth);
	
	double meanAngleX = 0;
	double meanAngleY = 0;
	
	BufferedImage meanPositionImage = null;
	try {
		
	newImage = ImageIO.read(new File("newImage.jpg"));
	
	int meanX = 0;
	int xCounter = 0;
	int meanY = 0;
	int yCounter = 0;
	int meanXPixelLocation = 0;
	int meanYPixelLocation = 0;
	double beforeverticalFOV = 0;
	double beforehorionztalFOV = 0;
	double verticalFOV = 0;
	double horizontalFOV = 0;
	double dist = 17;
	double diagonalDist = 0;
	double diagonalDistY = 0;

	meanPositionImage = new BufferedImage(newImage.getWidth(), newImage.getHeight(), BufferedImage.TYPE_INT_RGB);
	for(int w = 0; w < newImage.getWidth(); w += 1){
		for(int h = 0; h < newImage.getHeight(); h += 1){
			// Color currentColor = new Color(newImage.getRGB(w, h));
			if(newImage.getRGB(w, h) != Color.black.getRGB()){
				meanX += w;
				xCounter += 1;
				meanY += h;
				yCounter += 1;
				newImage.setRGB(w, h, newImage.getRGB(w,h));
			} else {
				newImage.setRGB(w, h, newImage.getRGB(w,h));
			}
		}
	}
	meanXPixelLocation = meanX / xCounter;
	System.out.println(meanXPixelLocation);
	meanYPixelLocation = meanY / yCounter;

	
	for(int w = 0; w < newImage.getWidth(); w += 1){
		for(int h = 0; h < newImage.getHeight(); h += 1){
			for(int i = 0; i < 1; i += 1){
			newImage.setRGB(meanXPixelLocation, meanYPixelLocation, Color.BLUE.getRGB());
			
		
			} 
			for(int j = 0; j < 80; j += 1){
			
			newImage.setRGB(meanXPixelLocation - j, meanYPixelLocation, Color.BLUE.getRGB());
			newImage.setRGB(meanXPixelLocation + j, meanYPixelLocation, Color.BLUE.getRGB());
			newImage.setRGB(meanXPixelLocation, meanYPixelLocation - j, Color.BLUE.getRGB());
			newImage.setRGB(meanXPixelLocation, meanYPixelLocation + j, Color.BLUE.getRGB());
			}
		}
	}
	
	

		ImageIO.write(newImage, "jpg", new File("meanPositionDetected.jpg"));

	double imageWidth = newImage.getWidth();
	System.out.println(imageWidth);
	double imageHeight = newImage.getHeight();
	System.out.println(imageHeight);
	double imageHeightToInch = imageHeight  / 326;
	System.out.println("There are this many pixels per inch vertically" + imageHeightToInch);
	double imageWidthToInch = imageWidth / 326;
	System.out.println("There are this many pixels per inch horizontally" + imageWidthToInch);
	

	double verticalConversionFOV = imageHeightToInch / 2;
	double horizontalConversionFOV = imageWidthToInch / 2;

	double verticalDivisionFOV = verticalConversionFOV / dist;
	System.out.println(verticalConversionFOV);
	double horizontalDivisionFOV = horizontalConversionFOV / dist;
	


	verticalFOV = 2* Math.toDegrees(Math.atan(verticalDivisionFOV));
	horizontalFOV = 2* Math.toDegrees(Math.atan(horizontalDivisionFOV));



	// double conversionRateX = horionztalFOV / imageWidth;
	// double conversionRateY = verticalFOV / imageHeight;

	int distanceFromOriginX = 2016 - meanXPixelLocation;
	int distanceFromOriginY = 1512 - meanYPixelLocation;

	double horizontalPixelsPerDeg = imageWidth / horizontalFOV;
	double verticalPixelsPerDeg = imageHeight / verticalFOV;

	meanAngleX = distanceFromOriginX / horizontalPixelsPerDeg;
	meanAngleY = distanceFromOriginY / horizontalPixelsPerDeg;
	
	// meanAngleX = lockedMeanPixelX * conversionRateX;
	// meanAngleY = lockedMeanPixelY * conversionRateY;


	
	System.out.println("The angle in the x-direction for the mean pixel point is " + meanAngleX);
	System.out.println("The angle in the y-direction for the mean pixel point is " + meanAngleY);
	System.out.println("The FOV for x is " + horizontalFOV);
	System.out.println("The FOV for y is " + verticalFOV);
	
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return meanPositionImage;
	
}

// public static void findAngleAway(int fov, BufferedImage meanPositionImage){
// 	BufferedImage gridMadeImage = null;
// 	ArrayList<Integer> SectorXValues = new ArrayList<Integer>();
// 	int xDistAway = 0;
	
// 	double targetAngle = 0;
	
// 	try {
// 	meanPositionImage = ImageIO.read(new File("meanPositionDetected.jpg"));
// 	gridMadeImage = new BufferedImage(meanPositionImage.getWidth(), meanPositionImage.getHeight(), BufferedImage.TYPE_INT_RGB);
// 	int ImageCentreXLine = meanPositionImage.getWidth() / 2;
	
// 	for(int w = 0; w < meanPositionImage.getWidth(); w += 1){
// 		for(int h = 0; h < meanPositionImage.getHeight(); h += 1){
// 			meanPositionImage.setRGB(w, h, meanPositionImage.getRGB(w,h));
// 		}
// 	}


// 	meanPositionImage.setRGB(230,100, Color.RED.getRGB());
// 	double testAngleX = 230 * absoluteAngleConversion;
// 	double testAngleY = 100 * absoluteAngleConversion;
	
// 	for(int w = 0; w < meanPositionImage.getWidth(); w += 1){
// 		for(int h = 0; h < meanPositionImage.getHeight(); h += 1){
// 			Color currentColor = new Color(meanPositionImage.getRGB(w,h));
// 			// if(currentColor.getRed() == lowRed || currentColor.getRed() == highRed || currentColor.getGreen() == lowGreen || currentColor.getGreen() == highGreen || currentColor.getBlue() == lowBlue || currentColor.getBlue() ==highBlue){
// 			// 	xDistAway = w;
// 			// 	break;
// 			// }
			
				
// 		}
// 	}
// 	double totalDistConversion = 28.3 / meanPositionImage.getWidth();
// 	double returnedDist = 320 * totalDistConversion;

// 	System.out.println("The x Angle of the red line (hopefully correctly found) is : " + testAngleX);
// 	System.out.println("The x Angle of the red line (hopefully correctly found) is : " + testAngleY);
// 	System.out.println("The expect distance from the border to the image (estimate) is around 3.17cm but the real result is " + returnedDist);

// 	ImageIO.write(meanPositionImage, "jpg", new File("middleGridImage.jpg"));


// 	} catch (Exception e) {
// 		// TODO: handle exception
// 	}
// }

}