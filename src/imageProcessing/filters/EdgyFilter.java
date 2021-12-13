package imageProcessing.filters;

import imageProcessing.imageTransformations.convolvedTransformations.Edgy;
import imageProcessing.imageTransformations.kernels.ConvolutionalKernel;
import imageProcessing.models.PixelImage;
import imageProcessing.utils.Constants;

// The class EdgyFilter transforms the image shown in UI
// by shaprning the edges of the image
public class EdgyFilter implements Filter {

    @Override
    public void filter(PixelImage theImage) {
        // deciding the diameter of our weights convolution kernel
        int kernelDiameter = Constants.KERNEL_SIZE;

        // creating convolutional kernel weights based on the filter
        // and the size of our kernel diameter
        ConvolutionalKernel convolutionalKernel =  new ConvolutionalKernel(new Edgy(), kernelDiameter, theImage);

        // transformation of the image by applying
        // filter through convolutional kernel with weights
        imageProcessing.models.Pixel[][] transformedImage  = convolutionalKernel.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);
    }
}
