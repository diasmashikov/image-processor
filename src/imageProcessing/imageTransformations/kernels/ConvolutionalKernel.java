package imageProcessing.imageTransformations.kernels;

import imageProcessing.imageTransformations.ImageTransform;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

// ConvolutionalKernel creates the convolutional kernel
// based on its size and image transform(filtering) user wants to apply
// Convolutional kernels can be created of any size 3x3, 5x5, 7x7 and etc.
public class ConvolutionalKernel {
    private ImageTransform imageTransformation;
    private double[][] kernel;
    private int kernelDiameter;

    private int totalNumberOfRows;
    private int totalNumberOfColumns;

    private PixelImage image;
    private Pixel[][] pixelsKernel;
    private double[][] pixelsKernelRedColors;
    private double[][] pixelsKernelGreenColors;
    private double[][] pixelsKernelBlueColors;

    public ConvolutionalKernel(ImageTransform imageTransformation, int kernelDiameter, PixelImage image) {

        this.imageTransformation = imageTransformation;
        this.kernelDiameter = kernelDiameter;
        this.imageTransformation.setKernelDiameter(kernelDiameter);

        kernel = this.imageTransformation.createConvolutionalKernel();


        this.image = image;
        this.pixelsKernel = image.getData();

        this.totalNumberOfRows = this.image.getHeight();
        this.totalNumberOfColumns = this.image.getWidth();

        pixelsKernelRedColors = new double[kernelDiameter][kernelDiameter];
        pixelsKernelGreenColors = new double[kernelDiameter][kernelDiameter];
        pixelsKernelBlueColors = new double[kernelDiameter][kernelDiameter];
    }

    public Pixel[][] transformImage() {

        Pixel[][] transformedKernel = new Pixel[pixelsKernel.length][pixelsKernel[0].length];

        // start traversing each pixel one by one
        for (int row = 0; row < totalNumberOfRows; row++) {
            for (int col = 0; col < totalNumberOfColumns; col++) {



                //we compute a weight of every pixel that corresponds to the position of a particular weight in our convolutional kernel



                // traverse until the convolutional kernel domains
                for(int weightsRow = 0; weightsRow < kernel.length; weightsRow++) {

                    for(int weightsCol = 0; weightsCol < kernel[weightsRow].length; weightsCol++) {
                        ConvolutionalKernelPositionNavigator positionNavigator = new ConvolutionalKernelPositionNavigator(row, col, weightsRow, weightsCol, kernel);

                        // getting position of the main matrix corresponding to convolutional kernel
                        int correspondingRow = positionNavigator.calculateCorrespondingRow();
                        int correspondingCol = positionNavigator.calculateCorrespondingColumn();

                        // these 4 if statements are four counteracting if convolutional kernel gets out of bounds
                        ConvolutionalKernelOffsetDetector offsetDetector = new ConvolutionalKernelOffsetDetector(totalNumberOfRows, totalNumberOfColumns, correspondingRow, correspondingCol);

                        if(offsetDetector.offsetDetected()) {
                            correspondingRow = offsetDetector.recalculateRowOffset();
                            correspondingCol = offsetDetector.recalculateColumnOffset();
                        }

                        // getting the current weight
                        double currentWeight = kernel[weightsRow][weightsCol];

                        applyWeightsToPixelsColors(correspondingRow, correspondingCol, weightsRow, weightsCol, currentWeight);

                    }
                }

                // getting actual pixel we want to blur

                // we take the sum of our weight * pixel(each color) divided by sum of weights(because of normalization sum of weights is always 1) which is our blur pixel
                // set the blur pixel to the initial pixel
               // temp.red = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelRedColors)));
                //temp.green = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelGreenColors)));
                //temp.blue = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelBlueColors)));

                int red = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelRedColors)));
                int green = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelGreenColors)));
                int blue = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelBlueColors)));


                transformedKernel[row][col] = new Pixel(red,
                        green,
                        blue
                        );
            }

        }
        return transformedKernel;


    }

    private int getWeightedColorValue(double[][] weightedColor) {
        double summation = 0;

        for (int row = 0; row < weightedColor.length; row++) {
            for (int col = 0; col < weightedColor[row].length; col++) {
                summation += weightedColor[row][col];
            }
        }


        return (int) summation;
    }

    private void applyWeightsToPixelsColors(int correspondingRow, int correspondingColumn, int weightsRow, int weightsColumn, double currentWeight) {
        // getting the pixel of the main matrix relative to convolutional kernel position
        Pixel correspondingPixel = pixelsKernel[correspondingRow][correspondingColumn];

        // apply the weight to our pixel(to its RGB colors)
        pixelsKernelRedColors[weightsRow][weightsColumn] = currentWeight * correspondingPixel.red;
        pixelsKernelGreenColors[weightsRow][weightsColumn] = currentWeight * correspondingPixel.green;
        pixelsKernelBlueColors[weightsRow][weightsColumn] = currentWeight * correspondingPixel.blue;
    }

}
