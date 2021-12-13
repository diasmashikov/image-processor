package imageProcessing.filters;

import imageProcessing.imageTransformations.convolvedTransformations.UnsharpMasking;
import imageProcessing.imageTransformations.kernels.ConvolutionalKernel;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;
import imageProcessing.utils.Constants;

// The class UnsharpFilter transforms the image shown in UI
// by reducing sharpness of the image
public class UnsharpFilter implements Filter {
    @Override
    public void filter(PixelImage theImage) {
        // deciding the diameter of our weights convolution kernel
        int kernelDiameter = Constants.KERNEL_SIZE;


        // creating convolutional kernel weights based on the filter
        // and the size of our kernel diameter
        ConvolutionalKernel convolutionalKernel =  new ConvolutionalKernel(new UnsharpMasking(), kernelDiameter, theImage);

        // transformation of the image by applying
        // filter through convolutional kernel with weights
        Pixel[][] transformedImage  = convolutionalKernel.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);
    }
}
