package imageProcessing.filters;

import imageProcessing.imageTransformations.convolvedTransformations.Median;
import imageProcessing.imageTransformations.simpleTransformations.FlipHorizontal;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

// The class MedianFilter transforms the image shown in UI
// by reducing the noise and make it lightly blurry
public class MedianFilter implements  Filter{
    @Override
    public void filter(PixelImage theImage) {

        // creating the median transform and putting theImage to transform
        Median median = new Median(theImage);

        // transforming the image by applying median filter
        Pixel[][] transformedImage = median.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);
    }
}
