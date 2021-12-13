package imageProcessing.imageTransformations.kernels;


// ConvolutionalKernelPositionNavigator is used to
// traverse the coordinates the convolutional kernel is applied to
// If convolutional kernel applied to the coordinates
// (0,0), (0,1), (0,2)
// (1, 0), (1, 1), (1, 2)
// (2, 0), (2, 1), (2, 2)
// PositionNavigator navigates ConvolutionalKernel application to apply kernel
// to every coordinate(pixel)
public class ConvolutionalKernelPositionNavigator {
    private int row;
    private int column;
    private int weightsRow;
    private int weightsColumn;
    private double[][] weightsKernel;

    public ConvolutionalKernelPositionNavigator(int row, int column, int weightsRow, int weightsColumn, double[][] weightsKernel) {
        this.row = row;
        this.column = column;
        this.weightsRow = weightsRow;
        this.weightsColumn = weightsColumn;
        this.weightsKernel = weightsKernel;
    }

    public int calculateCorrespondingRow() {
        return row + weightsRow - (weightsKernel.length / 2);
    }

    public int calculateCorrespondingColumn() {
        return column + weightsColumn - (weightsKernel.length / 2);
    }
}
