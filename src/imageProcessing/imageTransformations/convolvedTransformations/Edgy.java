package imageProcessing.imageTransformations.convolvedTransformations;

import imageProcessing.imageTransformations.ImageTransform;

public class Edgy extends ImageTransform {

    @Override
    protected double calculateWeight(int row, int column) {
        if(row == kernelRadius && column == kernelRadius) {
            return Math.pow(kernelDiameter, 2);

        } else {
            return -1;
        }
    }

    @Override
    public void setKernelDiameter(int kernelDiameter) {
        super.setKernelDiameter(kernelDiameter);
    }
}
