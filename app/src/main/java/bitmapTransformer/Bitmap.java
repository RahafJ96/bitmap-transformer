package bitmapTransformer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Bitmap {

    private static Path imageOutputPath;
    private static BufferedImage imageData;
    private static BufferedImage newImage;

    /**
     * Bitmap constructor
     *
     * @param inputPath  give it the path for the file
     * @param outputPath give it the path for the newly created file
     * @throws IOException error for the ImageIO.read method
     */
    public Bitmap(String inputPath, String outputPath) throws IOException {

        imageOutputPath = Paths.get(outputPath);
        Path bitMapInPath = Paths.get(inputPath);
        imageData = ImageIO.read(bitMapInPath.toFile());

    }

    /**
     * convert all black colors to green and all white colors to black
     */
    public static void reverseBlackAndGreen() {
        int height = imageData.getHeight();
        int width = imageData.getWidth();


        Color black = new Color(0, 0, 0);
        Color white = new Color(255, 255, 255);
        Color green = new Color(46, 255, 0);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = imageData.getRGB(x, y);

                if (color == black.getRGB()) {
                    imageData.setRGB(x, y, green.getRGB());
                } else if (color == white.getRGB()) {
                    imageData.setRGB(x, y, black.getRGB());
                }
            }
        }
    }

    /**
     * stretch the image Vertically (double the height)
     */
    public static void stretchVertically() {
        int height = imageData.getHeight();
        int heightM = (height * 2);
        int width = imageData.getWidth();
        newImage = new BufferedImage(width, heightM, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < heightM; y++) {
                int color = imageData.getRGB(x, y / 2);

                newImage.setRGB(x, y, color);
                y++;
                if (y != heightM) {
                    newImage.setRGB(x, y, color);
                }
            }
        }
    }

    /**
     * stretch the image Horizontally (double the width)
     */
    public static void stretchHorizontally() {
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int widthM = (width * 2);
        newImage = new BufferedImage(widthM, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < widthM; x++) {
                int color = imageData.getRGB(x / 2, y);

                newImage.setRGB(x, y, color);
                x++;
                if (x != widthM) {
                    newImage.setRGB(x, y, color);
                }
            }
        }
    }

    /**
     * change every color randomly by dividing the current color by two
     */
    public static void random() {
        int height = imageData.getHeight();
        int width = imageData.getWidth();
        int rgb;

        for (int y = 1; y < height; y++) {
            for (int x = 1; x < width; x++) {
                rgb = imageData.getRGB(x, y) / 2;
                imageData.setRGB(x, y, rgb);
            }
        }
    }

    /**
     * create a dummy image for testing
     * @return Bitmap
     */
    public static BufferedImage dummyBitMap() {
        BufferedImage dummyImage = new BufferedImage(4, 4, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < 4; y++) {
            for (int x = 0; x < 4; x++) {
                if (y < 2) {
                    dummyImage.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    dummyImage.setRGB(x, y, Color.WHITE.getRGB());
                }

            }
        }
        return dummyImage;
    }

    /**
     * constructor for testing
     * @param image the dummy image
     * @param outputPath the resources test folder
     */
    public static void setImageData(BufferedImage image, String outputPath) {
        imageData = image;
        imageOutputPath = Paths.get(outputPath);
    }


    /**
     * save the changed images or the newly created ones
     *
     * @throws IOException error for ImageIO.write
     */
    public static void save() throws IOException {

        ImageIO.write(imageData, "bmp", imageOutputPath.toFile());
        if (newImage != null) {
            ImageIO.write(newImage, "bmp", imageOutputPath.toFile());
        }

        System.out.println("Saved file to: " + imageOutputPath);
    }
}