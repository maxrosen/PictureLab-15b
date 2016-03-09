//Stevens & Rosen Lab15b v100

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
      
 ////////////////////////////////////////////////////////////////////////  
   
      // REQUIRED FOR 80-POINTS
      public void grayScale()
      {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
          for (Pixel pixelObj : rowArray)
          {
              int bw = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue())/3;
              pixelObj.setBlue(bw); pixelObj.setGreen(bw); pixelObj.setRed(bw);
          }
        }
      }
  
//////////////////////////////////////////////////////////////////////////  

      // REQUIRED FOR 80-POINTS
      //Mirrors horizontally
      public void mirror()
      {  
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] temp = new Pixel[pixels.length][pixels[0].length];
        for (int r = 0; r < pixels.length; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              temp[r][c] = pixels[r][c];
          }
        }
        Color tempColor = new Color(0,0,0);
        for (int r = 0; r < pixels.length; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              tempColor = temp[r][c].getColor();
              pixels[r][pixels[0].length - c - 1].setColor(tempColor);
          }
        }
      } 
      
////////////////////////////////////////////////////////////////////////////////////////

      // REQUIRED FOR 80-POINTS
      public void upsideDown()
      { 
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] temp = new Pixel[pixels.length][pixels[0].length];
        for (int r = 0; r < pixels.length; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              temp[r][c] = pixels[r][c];
          }
        }
        Color tempColor = new Color(0,0,0);
        for (int r = 0; r < pixels.length; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              tempColor = temp[r][c].getColor();
              pixels[pixels.length - r - 1][c].setColor(tempColor);
          }
        }
      }    
      
//////////////////////////////////////////////////////////////////////////////////////////

   // REQUIRED FOR 90-POINTS
   public void mirrorVertical()
   {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] temp = this.getPixels2D();
        Color tempColor = new Color(0,0,0);
        for (int r = 0; r < pixels.length; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              tempColor = temp[r][c].getColor();
              pixels[r][pixels[0].length - c - 1].setColor(tempColor);
          }
        }
   }
   
//////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 90-POINTS
   public void mirrorHorizontal()
   {
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] temp = this.getPixels2D();
        Color tempColor = new Color(0,0,0);
        for (int r = 0; r < pixels.length; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              tempColor = temp[r][c].getColor();
              pixels[pixels.length - r - 1][c].setColor(tempColor);
          }
        }
   }
      
//////////////////////////////////////////////////////////////////////////////////////////////////      
    
   // REQUIRED FOR 90-POINTS
   public void mirrorDiagonal()
   { 
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] temp = this.getPixels2D();
        Color tempColor = new Color(0,0,0);
        int difference = pixels[0].length - pixels.length;
        for (int c = 0; c < pixels.length; c++)
        {
          for (int r = 0; r < pixels[0].length - difference; r++)
          {
              tempColor = temp[r][c].getColor();
              pixels[c][r].setColor(tempColor);
          }
        }
   }
   
/////////////////////////////////////////////////////////////////////////////////////
   
   // REQUIRED FOR 100-POINTS
   public void mirrorTemple()
   { 
        Pixel[][] pixels = this.getPixels2D();
        Pixel[][] temp = this.getPixels2D();
        Color tempColor = new Color(0,0,0);
        for (int r = 0; r < 100; r++)
        {
          for (int c = 0; c < pixels[0].length; c++)
          {
              tempColor = temp[r][c].getColor();
              pixels[r][pixels[0].length - c - 1].setColor(tempColor);
          }
        }
   }
   
} 
