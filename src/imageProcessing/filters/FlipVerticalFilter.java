package imageProcessing.filters;

import imageProcessing.filters.Filter;
import imageProcessing.imageTransformations.simpleTransformations.FlipHorizontal;
import imageProcessing.imageTransformations.simpleTransformations.FlipVertical;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

// The class FlipVerticalFilter transforms the image shown in UI
// by flipping the image vertically
public class FlipVerticalFilter implements Filter {
    @Override
    public void filter(PixelImage theImage) {

        // creating the flipVertical transform and putting theImage to transform
        FlipVertical flipVertical = new FlipVertical(theImage);

        // transforming the image by applying flipVertical filter
        Pixel[][] transformedImage = flipVertical.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);

    }
}
