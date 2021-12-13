package imageProcessing.imageTransformations.convolvedTransformations;

import imageProcessing.imageTransformations.ImageTransform;
import imageProcessing.utils.Constants;

public class GaussianBlur extends ImageTransform {

    protected double sigma = Constants.SIGMA;

    @Override
    protected double calculateWeight(int row, int column) {
        row -= kernelRadius;
        column -= kernelRadius;
        final double leftMultiplicative = (1 / (2 * Math.PI * Math.pow(sigma, 2)));
        final double exponentPower = ((-(Math.pow(row, 2) + Math.pow(column, 2))) / (2 * Math.pow(sigma, 2)));
        return leftMultiplicative * Math.exp(exponentPower);
    }

    @Override
    public void setKernelDiameter(int kernelDiameter) {
        super.setKernelDiameter(kernelDiameter);
    }
}

//package imageProcessing.imageTransformations;
//
//public class GaussianBlur extends ImageTransform {
//
//    private double summation = 0;
//    private int kernelDiameter;
//    private double kernelRadius;
//    private double sigma;
//    private double[][] weightsKernel;
//
//    public GaussianBlur(double sigma) {
//        this.sigma = sigma;
//    }
//
//    // We create the kernel of weights based around the central pixel
//    @Override
//    public double[][] createConvolutionalKernel() {
//
//        weightsKernel = new double[kernelDiameter][kernelDiameter];
//
//        // Here we fill empty weightKernel with calculated weights
//        fillWeightsKernel();
//
//        // We normalize the kernel's values such that they're all equal to 1
//        normalizeWeightsKernel();
//
//        return weightsKernel;
//    }
//
//
//    private void fillWeightsKernel() {
//        for (int row = 0; row < weightsKernel.length; row++) {
//            for (int column = 0; column < weightsKernel[row].length; column++) {
//                // calculating the weight fo each coordinate
//                weightsKernel[row][column] = calculateWeight(row - kernelRadius, column - kernelRadius, sigma);
//                summation += weightsKernel[row][column];
//            }
//        }
//    }
//
//    // The gaussian function here calculates the weight of a coordinate
//    private double calculateWeight(double x, double y, double sigma) {
//        final double leftMultiplicative = (1 / (2 * Math.PI * Math.pow(sigma, 2)));
//        final double exponentPower = (-(Math.pow(x, 2) + Math.pow(y, 2))) / (2 * Math.pow(sigma, 2));
//        return leftMultiplicative * Math.exp(exponentPower);
//    }
//
//    private void normalizeWeightsKernel() {
//        for (int x = 0; x < weightsKernel.length; x++) {
//            for (int y = 0; y < weightsKernel[x].length; y++) {
//                weightsKernel[x][y] /= summation;
//            }
//        }
//    }
//
//    @Override
//    public void setKernelDiameter(int kernelDiameter) {
//        this.kernelDiameter = kernelDiameter;
//        this.kernelRadius = this.kernelDiameter / 2;
//    }
//}



