package imageProcessing.imageTransformations;

import imageProcessing.utils.MatrixPrinter;

// ImageTransform class is the super class of all
// derived classes that use convolutional kernels to apply
// filtering. Its responsibility to create convolutional kernels and
// weights that correspond to the filter
// How weights are calculated is what each derived class responsible for
public abstract class ImageTransform {
    protected double summation = 0;
    protected int kernelDiameter;
    protected int kernelRadius;
    //private double sigma;
    protected double[][] weightsKernel;


    public double[][] createConvolutionalKernel() {
        weightsKernel = new double[kernelDiameter][kernelDiameter];

        // Here we fill empty weightKernel with calculated weights
        fillWeightsKernel();

        // We normalize the kernel's values such that they're all equal to 1
        normalizeWeightsKernel();

        return weightsKernel;
    };

    public void setKernelDiameter(int kernelDiameter) {
        this.kernelDiameter = kernelDiameter;
        this.kernelRadius = this.kernelDiameter / 2;
    }

    protected void fillWeightsKernel() {
        for (int row = 0; row < weightsKernel.length; row++) {
            for (int column = 0; column < weightsKernel[row].length; column++) {
                // calculating the weight fo each coordinate
                weightsKernel[row][column] = calculateWeight(row, column);

                summation += weightsKernel[row][column];
            }
        }

        MatrixPrinter.printMatrix(weightsKernel);
    }
    protected abstract double calculateWeight(int row, int column);

    protected void normalizeWeightsKernel() {
        if(summation == 0) {
            summation = 1;
        }
        for (int x = 0; x < weightsKernel.length; x++) {
            for (int y = 0; y < weightsKernel[x].length; y++) {
                weightsKernel[x][y] /= summation;
            }
        }
    }
}
