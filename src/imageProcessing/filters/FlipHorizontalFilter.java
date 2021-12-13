package imageProcessing.filters;

import imageProcessing.filters.Filter;
import imageProcessing.imageTransformations.simpleTransformations.FlipHorizontal;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

/**
 * imageProcessing.filters.Filter that flips the image horizontally.
 * This class is COMPLETE. Don't change it. But model your other classes (such
 * as imageProcessing.filters.FlipVerticalFilter) after it.
 */
public class FlipHorizontalFilter implements Filter
{
  public void filter(PixelImage theImage)
  {

    // creating the flipHorizontal transform and putting theImage to transform
    FlipHorizontal flipHorizontal = new FlipHorizontal(theImage);

    // transforming the image by applying flipHorizontal filter
    Pixel[][] transformedImage = flipHorizontal.transformImage();

    // setting the transformed pixel kernel to our image
    theImage.setData(transformedImage);

  }
}
