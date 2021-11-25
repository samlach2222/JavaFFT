import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class TraitementImage {
    private BufferedImage image;
    private int width;
    private int height;

    public void ImageToGray(){
        try {
            File input = new File("D:\\WINDOWS\\Documents\\GitHub\\FFT-Java\\FFT_Java\\out\\production\\FFT_Java\\image.jpg");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();
            for(int i=0; i<height; i++) {
                for(int j=0; j<width; j++) {
                    Color c = new Color(image.getRGB(j, i));
                    int red = (int)(c.getRed() * 0.299);
                    int green = (int)(c.getGreen() * 0.587);
                    int blue = (int)(c.getBlue() *0.114);
                    Color newColor = new Color(red+green+blue,
                            red+green+blue,red+green+blue);
                    image.setRGB(j,i,newColor.getRGB());
                }
            }
//            File ouptut = new File("D:\\WINDOWS\\Documents\\GitHub\\FFT-Java\\FFT_Java\\out\\production\\FFT_Java\\imageGray.jpg");
//            System.out.println("Done");
//            ImageIO.write(image, "jpgc  ", ouptut);
        } catch (Exception e) {
            System.out.println("test");
        }
    }

    public ArrayList<ArrayList<Complexe>> GetArrayListFromImage(){
        ArrayList<ArrayList<Complexe>> result = new ArrayList<ArrayList<Complexe>>();
        for(int i=0; i<height; i++) {
            for(int j=0; j<width; j++) {
                Color c = new Color(image.getRGB(j, i));
                int red = (c.getRed());
                int green = (c.getGreen());
                int blue = (c.getBlue());
                double moyenne = (double) (red + green + blue) /3;
                result.get(i).add(new Complexe(moyenne, 0));
            }
        }
        return result;
    }

    public TraitementImage() throws Exception{

    }
}
