package imageProcessing.filters;

import imageProcessing.imageTransformations.convolvedTransformations.Median;
import imageProcessing.imageTransformations.simpleTransformations.Binarization;
import imageProcessing.imageTransformations.simpleTransformations.FlipHorizontal;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

// The class BinarizationFilter transforms the image in UI
// with accordance to its filtering strategy
public class BinarizationFilter implements  Filter{
    @Override
    public void filter(PixelImage theImage) {
        // creating the binarization transform and putting theImage to transform
        Binarization binarization = new Binarization(theImage);

        // transforming the image by applying binarization
        Pixel[][] transformedImage = binarization.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);
    }
}
