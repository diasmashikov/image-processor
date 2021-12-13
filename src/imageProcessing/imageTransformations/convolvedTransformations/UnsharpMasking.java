package imageProcessing.imageTransformations.convolvedTransformations;

import imageProcessing.imageTransformations.ImageTransform;
import imageProcessing.utils.Constants;

public class UnsharpMasking extends ImageTransform {
    private double sigma = Constants.SIGMA;


    @Override
    public void setKernelDiameter(int kernelDiameter) {
        super.setKernelDiameter(kernelDiameter);
    }

    @Override
    protected double calculateWeight(int row, int column) {
        final double negativeLeftMultiplicative = -(1 / (2 * Math.PI * Math.pow(sigma, 2)));

        final double exponentPower = (-(Math.pow(row - kernelRadius, 2) + Math.pow(column - kernelRadius, 2))) / (2 * Math.pow(sigma, 2));

        double gaussianWeight = negativeLeftMultiplicative * Math.exp(exponentPower);

        if(row == kernelRadius && column == kernelRadius) {
            return -gaussianWeight * 9;

        } else {
            return gaussianWeight;
        }
    }
}
