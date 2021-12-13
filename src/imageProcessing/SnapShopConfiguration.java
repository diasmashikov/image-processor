package imageProcessing;

// 1. Additional filters that were added are: Binarization, GrayScale, and Median.
// The new filters were used for calculating the crops area
// 2. All the filters work correctly. However, the laplacian filter is not as good for detecting all the edges of crops area fields
// 3. The biggest problem I encountered is the object-oriented design of the application.
// My program separates filters into convolved transformations using convolutional kernels and
// simple transformations that do not require additional kernels
// I tried to do it by dividing them into different transformation interfaces(Convolved and Simple). However, the configuration file accepts
// Filter type interfaces which means I need to rewrite the .addFilter which is not acceptable. Eventually, with sacrifice of writing the code
// a bit more scalable and cleaner I just wrote the classes separately they way they are.

import imageProcessing.filters.*;

/**
 * A class to configure the imageProcessing.SnapShop application
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SnapShopConfiguration
{
  /**
   * Method to configure the imageProcessing.SnapShop.  Call methods like addFilter
   * and setDefaultFilename here.
   * @param theShop A pointer to the application
   */
  public static void configure(SnapShop theShop)
  {

    theShop.setDefaultFilename("/Users/diasmashikov/Desktop/ImageProcessing/images/billg.jpg");
    theShop.addFilter(new FlipHorizontalFilter(), "Flip Horizontal");
    theShop.addFilter(new FlipVerticalFilter(), "Flip Vertical");
    theShop.addFilter(new NegativeFilter(), "Negative");
    theShop.addFilter(new GrayScaleFilter(), "GrayScale");
    theShop.addFilter(new MedianFilter(), "MedianFilter");
    theShop.addFilter(new BinarizationFilter(), "BinarizationFilter");
    theShop.addFilter(new GaussianBlurFilter(), "Gaussian Blur");
    theShop.addFilter(new LaplacianFilter(), "Laplacian");
    theShop.addFilter(new UnsharpFilter(), "Unsharp");
    theShop.addFilter(new EdgyFilter(), "Edgy");


    // add your other filters below
  }
}
