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
        } catch (Exception e) {

        }
    }

    public ArrayList<ArrayList<Complexe>> GetArrayListFromImage(){
        ArrayList<ArrayList<Complexe>> result = new ArrayList<ArrayList<Complexe>>();
        for(int i=0; i<height; i++) {
            result.add(new ArrayList<Complexe>());
            for(int j=0; j<width; j++) {
                Color c = new Color(image.getRGB(j, i));
                int value = (c.getRed()); // R, G et B sont égaux
                result.get(i).add(new Complexe((double) value/255, 0)); // divisé par 255 pour avoir une valeur entre 0 et 1.
            }
        }
        return result;
    }

    public void createImageFromArrayList(ArrayList<ArrayList<Complexe>> array) throws IOException {
        BufferedImage returnImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i=0; i<array.size(); i++) {
            for(int j=0; j<array.get(i).size(); j++){
                Complexe value = new Complexe(array.get(i).get(j).getReal(), 0);
                Color c = new Color((int) (value.getReal()*255), (int) (value.getReal()*255), (int) (value.getReal()*255));
                returnImage.setRGB(j,i,c.getRGB() );
            }
        }
        try {
            File ouptut = new File("D:\\WINDOWS\\Documents\\GitHub\\FFT-Java\\FFT_Java\\out\\production\\FFT_Java\\imageGray.jpg");
            ImageIO.write(returnImage, "jpg", ouptut);
            System.out.println("Done");
        }
        catch(Exception e){
        }
    }

    public TraitementImage() throws Exception{

    }
}
