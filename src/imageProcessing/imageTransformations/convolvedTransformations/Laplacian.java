package imageProcessing.imageTransformations.convolvedTransformations;

import imageProcessing.imageTransformations.ImageTransform;
import imageProcessing.utils.Constants;

public class Laplacian extends ImageTransform {
    protected double sigma = Constants.SIGMA;

    @Override
    protected double calculateWeight(int row, int column) {
        if(row == kernelRadius && column == kernelRadius) {
            return Math.pow(kernelDiameter, 2) - 1;

        } else {
            return -1;
        }
    }

    @Override
    public void setKernelDiameter(int kernelDiameter) {
        super.setKernelDiameter(kernelDiameter);
    }
}
