package imageProcessing.filters;

import imageProcessing.imageTransformations.kernels.ConvolutionalKernel;
import imageProcessing.imageTransformations.convolvedTransformations.Laplacian;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;
import imageProcessing.utils.Constants;

// The class LaplacianFilter transforms the image shown in UI
// by detecting the edges of objects on the image
public class LaplacianFilter implements Filter {
    @Override
    public void filter(PixelImage theImage) {
        // deciding the diameter of our weights convolution kernel
        int kernelDiameter = Constants.KERNEL_SIZE;


        // creating convolutional kernel weights based on the filter
        // and the size of our kernel diameter
        ConvolutionalKernel convolutionalKernel =  new ConvolutionalKernel(new Laplacian(), kernelDiameter, theImage);

        // transformation of the image by applying
        // filter through convolutional kernel with weights
        Pixel[][] transformedImage  = convolutionalKernel.transformImage();

        // setting the transformed pixel kernel to our image
        theImage.setData(transformedImage);
    }
}
