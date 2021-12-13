package imageProcessing.filters;

import imageProcessing.models.PixelImage;

/**
 * Defines a filter method to modify images
 * This simple interface is COMPLETE. Don't change it.
 */

public interface Filter
{
  /**
   * Modify the image according to your algorithm
   * @param  theImage The image to modify
 * @throws Exception 
   */
  void filter(PixelImage theImage)  ;
}
