package imageProcessing.imageTransformations.convolvedTransformations;

import imageProcessing.imageTransformations.ImageTransform;
import imageProcessing.imageTransformations.kernels.ConvolutionalKernelOffsetDetector;
import imageProcessing.imageTransformations.kernels.ConvolutionalKernelPositionNavigator;
import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;
import imageProcessing.utils.MatrixPrinter;

import java.util.Arrays;

public class Median {
    PixelImage image;
    Pixel[][] pixelsKernel;
    double[][] kernel;
    int totalNumberOfRows;
    int totalNumberOfColumns;
    Pixel[][] transformedKernel;
    int kernelDiameter = 5;


    public Median(PixelImage image) {
        this.image = image;
        this.pixelsKernel = image.getData();
        this.totalNumberOfRows = image.getHeight();
        this.totalNumberOfColumns = image.getWidth();
        this.transformedKernel = new Pixel[pixelsKernel.length][pixelsKernel[0].length];
        this.kernel = new double[kernelDiameter][kernelDiameter];

    }

    public Pixel[][] transformImage() {

        Pixel[][] transformedKernel = new Pixel[pixelsKernel.length][pixelsKernel[0].length];

        // start traversing each pixel one by one
        for (int row = 0; row < totalNumberOfRows; row++) {
            for (int col = 0; col < totalNumberOfColumns; col++) {



                //we compute a weight of every pixel that corresponds to the position of a particular weight in our convolutional kernel


                double[] medianArrayR = new double[kernelDiameter * kernelDiameter];
                double[] medianArrayG = new double[kernelDiameter * kernelDiameter];
                double[] medianArrayB = new double[kernelDiameter * kernelDiameter];
                // traverse until the convolutional kernel domains
                int i = 0;
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
                        medianArrayR[i] = pixelsKernel[correspondingRow][correspondingCol].red;
                        medianArrayG[i] = pixelsKernel[correspondingRow][correspondingCol].green;
                        medianArrayB[i] = pixelsKernel[correspondingRow][correspondingCol].blue;
                        i++;
                    }
                }

                Arrays.sort(medianArrayR);
                Arrays.sort(medianArrayG);
                Arrays.sort(medianArrayB);

                // getting actual pixel we want to blur

                // we take the sum of our weight * pixel(each color) divided by sum of weights(because of normalization sum of weights is always 1) which is our blur pixel
                // set the blur pixel to the initial pixel
                // temp.red = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelRedColors)));
                //temp.green = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelGreenColors)));
                //temp.blue = Math.min(255, Math.max(0, getWeightedColorValue(pixelsKernelBlueColors)));

                int red = (int) medianArrayR[(kernelDiameter * kernelDiameter) / 2];
                int green = (int) medianArrayG[(kernelDiameter * kernelDiameter) / 2];
                int blue = (int) medianArrayB[(kernelDiameter * kernelDiameter) / 2];


                transformedKernel[row][col] = new Pixel(red,
                        green,
                        blue
                );
            }

        }
        return transformedKernel;


    }
}
