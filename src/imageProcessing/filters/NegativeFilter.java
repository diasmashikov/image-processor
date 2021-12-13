package imageProcessing.filters;

import imageProcessing.filters.Filter;
import imageProcessing.imageTransformations.simpleTransformations.FlipHorizontal;
import imageProcessing.imageTransformations.simpleTransformations.Negative;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

// The class UnsharpFilter transforms the image shown in UI
// by getting the opposite color-side of the image
public class NegativeFilter implements Filter {
    @Override
    public void filter(PixelImage theImage) {

        // creating the negative transform and putting theImage to transform
        Negative negative = new Negative(theImage);

        // transforming the image by applying negative filter
        Pixel[][] transformedImage = negative.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);
    }


}
