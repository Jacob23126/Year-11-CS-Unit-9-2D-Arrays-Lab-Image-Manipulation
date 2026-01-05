package code;

import image.APImage;
import image.Pixel;


public class ImageManipulation {


    /** CHALLENGE 0: Display Image
     */
    public static void main(String[] args) {
// Run all challenges in sequence
        System.out.println("=== Starting all challenges ===");

        // Challenge 0 (loads and shows original)
        System.out.println("Challenge 0: Loading original image...");
        APImage original = new APImage("cyberpunk2077.jpg");
        original.draw(); // Shows window 1


        System.out.println("Challenge 1: Converting to grayscale...");
        grayScale("cyberpunk2077.jpg"); // Shows window 2


        System.out.println("Challenge 2: Converting to black and white...");
        blackAndWhite("cyberpunk2077.jpg"); // Shows window 3


        System.out.println("Challenge 3: Edge detection (threshold 20)...");
        edgeDetection("cyberpunk2077.jpg", 20); // Shows window 4


        System.out.println("Challenge 4: Reflecting image...");
        reflectImage("cyberpunk2077.jpg"); // Shows window 5


        System.out.println("Challenge 5: Rotating image...");
        rotateImage("cyberpunk2077.jpg"); // Shows window 6

        System.out.println("=== All challenges completed! ===");
    }



    /** CHALLENGE ONE: Grayscale
  */
    public static void grayScale(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        APImage hi = image.clone();

        for (int y = 0; y < hi.getHeight(); y++) {
            for (int x = 0; x < hi.getWidth(); x++) {
                Pixel p = hi.getPixel(x, y);
                int red = p.getRed();
                int green = p.getGreen();
                int blue = p.getBlue();
                int average = (red + green + blue) / 3;

                p.setRed(average);
                p.setGreen(average);
                p.setBlue(average);
            }
        }

        hi.draw();
    }






    /** CHALLENGE TWO: Black and White
      */
    public static void blackAndWhite(String pathOfFile) {
        APImage image = new APImage(pathOfFile);
        APImage hi = image.clone();

        for (int y = 0; y < hi.getHeight(); y++) {
            for (int x = 0; x < hi.getWidth(); x++) {
                Pixel p = hi.getPixel(x, y);
                int red = p.getRed();
                int green = p.getGreen();
                int blue = p.getBlue();
                int average = (red + green + blue) / 3;

                if (average < 128) {
                    p.setRed(0);
                    p.setGreen(0);
                    p.setBlue(0);
                } else {
                    p.setRed(255);
                    p.setGreen(255);
                    p.setBlue(255);
                }
            }
        }

        hi.draw();
    }


    /** CHALLENGE Three: Edge Detection
       */
    public static void edgeDetection(String pathToFile, int threshold) {
        APImage image = new APImage(pathToFile);
        APImage hi = image.clone();

        for (int y = 0; y < hi.getHeight() - 1; y++) {
            for (int x = 0; x < hi.getWidth() - 1; x++) {
                Pixel current = hi.getPixel(x, y);
                int red = current.getRed();
                int green = current.getGreen();
                int blue = current.getBlue();
                int currentAvg = (red + green + blue) / 3;

                Pixel leftPixel = hi.getPixel(x + 1, y);
                int leftRed = leftPixel.getRed();
                int leftGreen = leftPixel.getGreen();
                int leftBlue = leftPixel.getBlue();
                int leftAvg = (leftRed + leftGreen + leftBlue) / 3;

                Pixel belowPixel = hi.getPixel(x, y + 1);
                int belowRed = belowPixel.getRed();
                int belowGreen = belowPixel.getGreen();
                int belowBlue = belowPixel.getBlue();
                int belowAvg = (belowRed + belowGreen + belowBlue) / 3;

                int diffLeft = Math.abs(currentAvg - leftAvg);
                int diffBelow = Math.abs(currentAvg - belowAvg);

                if (diffLeft > threshold || diffBelow > threshold) {
                    current.setRed(0);
                    current.setGreen(0);
                    current.setBlue(0);
                } else {
                    current.setRed(255);
                    current.setGreen(255);
                    current.setBlue(255);
                }
            }
        }

        for (int x = 0; x < hi.getWidth(); x++) {
            Pixel p = hi.getPixel(x, hi.getHeight() - 1);
            p.setRed(255);
            p.setGreen(255);
            p.setBlue(255);
        }
        for (int y = 0; y < hi.getHeight(); y++) {
            Pixel p = hi.getPixel(hi.getWidth() - 1, y);
            p.setRed(255);
            p.setGreen(255);
            p.setBlue(255);
        }

        hi.draw();
    }


    /** CHALLENGE Four: Reflect Image
     *
     * INPUT: the complete path file name of the image
     * OUTPUT: the image reflected about the y-axis
     *
     */
    public static void reflectImage(String pathToFile) {
        APImage image = new APImage(pathToFile);
        APImage reflection = new APImage(image.getWidth(), image.getHeight());

        for (int y = 0; y < image.getHeight(); y++) {
            for (int x = 0; x < image.getWidth(); x++) {
                Pixel original = image.getPixel(x, y);
                Pixel copy = original.clone();

                int reflectedX = image.getWidth() - 1 - x;
                reflection.setPixel(reflectedX, y, copy);
            }
        }

        reflection.draw();
    }



    /** CHALLENGE Five: Rotate Image
      */
    public static void rotateImage(String pathToFile) {
        APImage image = new APImage(pathToFile);
        int width = image.getWidth();
        int height = image.getHeight();

        // For 90° clockwise rotation: new width = old height, new height = old width
        APImage rotate = new APImage(height, width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Pixel original = image.getPixel(x, y);
                Pixel copy = original.clone();

                // Correct rotation formula for 90° clockwise:
                // Original (x, y) → Rotated (height-1-y, x)
                int newX = height - 1 - y;
                int newY = x;

                rotate.setPixel(newX, newY, copy);
            }
        }

        rotate.draw();
    }

    //crit B
    public static void myImageManipulation(String fileName) {

    }
}





