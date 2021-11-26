import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 * Classe pour transformer des Images en ArrayList et inversement
 * Cette classe permet d'obtenir les images en niveau de gris avec des pixels entre 0 et 1.
 * @author Samuel LACHAUD
 * @version 1.1
 */
public class TraitementImage {
    /**
     * Image stockée dans la classe
     */
    private BufferedImage image;
    /**
     * Largeur de l'image stockée
     */
    private int width;
    /**
     * Longueur de l'image stockée
     */
    private int height;

    /**
     * Méthode permettant de stocker dans l'attribut "image" le jpeg "image.jpg" en niveau de gris
     * @throws IOException si le jpeg "image.jpg" n'existe pas.
     */
    public void ImageToGray() throws IOException{
        try {
            File input = new File("image.jpg");
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

    /**
     * Méthode permettant à partir de l'attribut "image" une fois mise en niveau de gris,
     * de retourner un tableau de tableau de complexe avec comme partie réelle, la couleur des pixels de l'image entre 0 et 1.
     * @return un tableau de tableau de complexe avec la couleur de chaque pixel de l'image en niveau de gris entre 0 et 1.
     */
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

    /**
     * Méthode permettant de créer une image avec un tableau de tableau de complexe et de la stocker sous le nom de "image2.jpg".
     * @param array Tableau de Tableay de complexe avec comme partie réelle les couleurs de chaque pixel de notre future image entre 0 et 1.
     * @throws IOException si le jpeg "image2.jpg" ne peux être créé.
     */
    public void createImageFromArrayList(ArrayList<ArrayList<Complexe>> array) throws IOException {
        BufferedImage returnImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for(int i=0; i<array.size(); i++) {
            for(int j=0; j<array.get(i).size(); j++){
                Complexe value = new Complexe(array.get(i).get(j).getReal(), 0);
                Color c = new Color((int) (value.getReal()*255), (int) (value.getReal()*255), (int) (value.getReal()*255)); // multipplié par 255 pour avoir une valeur entre 0 et 255.
                returnImage.setRGB(j,i,c.getRGB() );
            }
        }
        try {
            File ouptut = new File("image2.jpg");
            ImageIO.write(returnImage, "jpg", ouptut);
            System.out.println("Image stockée sous le nom de 'image2.jpg'");
        }
        catch(Exception e){
        }
    }

    /**
     * Constructeur de la classe TraitementImage.
     */
    public TraitementImage(){

    }
}
