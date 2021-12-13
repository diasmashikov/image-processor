package imageProcessing.filters;

import imageProcessing.filters.Filter;
import imageProcessing.imageTransformations.simpleTransformations.FlipHorizontal;
import imageProcessing.imageTransformations.simpleTransformations.GrayScale;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

// The class GrayScale transforms the image shown in UI
// by reducing making the image gray overall containing white and black colors
public class GrayScaleFilter implements Filter
{
    public void filter(PixelImage theImage)
    {
        // creating the grayScale transform and putting theImage to transform
        GrayScale grayScale = new GrayScale(theImage);

        // transforming the image by applying flipVertical
        Pixel[][] transformedImage = grayScale.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);

    }
}
