package imageProcessing.imageTransformations.kernels;

// ConvolutionalKernelOffsetDetector is used when
// we want to apply convolutional kernel to the main image
// 3x3 kernel applied on (0, 0) coordinates of the image
// gets beyond the scope, which creates unwished errors
// in order to counteract it detector detects offsets and
// applies necessary measures to continue the work
public class ConvolutionalKernelOffsetDetector {

    private int totalNumberOfRows;
    private int totalNumberOfColumns;
    private int correspondingRow;
    private int correspondingCol;

    public ConvolutionalKernelOffsetDetector(int totalNumberOfRows, int totalNumberOfColumns, int correspondingRow, int correspondingCol) {
        this.totalNumberOfRows = totalNumberOfRows;
        this.totalNumberOfColumns = totalNumberOfColumns;
        this.correspondingRow = correspondingRow;
        this.correspondingCol = correspondingCol;
    }

    public boolean offsetDetected() {
        if(rowOutOfBoundsPositive()) {
            return true;
        }

        if(columnOutOfBoundsPositive()) {
            return true;
        }

        if(rowOufOfBoundsNegative()) {
            return true;
        }

        if(columnOutOfBoundsNegative()) {
            return true;
        }

        return false;
    }

    public int recalculateRowOffset() {
        if(rowOutOfBoundsPositive()) {
            int error_offset = correspondingRow - (totalNumberOfRows - 1);
            correspondingRow = (totalNumberOfRows- 1) - error_offset;
        }

        if(rowOufOfBoundsNegative()) {
            correspondingRow = Math.abs(correspondingRow);
        }

        return correspondingRow;
    }

    public int recalculateColumnOffset() {
        if(columnOutOfBoundsPositive()) {
            int error_offset = correspondingCol - (totalNumberOfColumns - 1);
            return correspondingCol = (totalNumberOfColumns - 1) - error_offset;
        }

        if(columnOutOfBoundsNegative()) {
            return correspondingCol = Math.abs(correspondingCol);
        }

        return correspondingCol;
    }

    private boolean rowOutOfBoundsPositive() {
        return correspondingRow > totalNumberOfRows - 1;
    }

    private boolean columnOutOfBoundsPositive() {
        return correspondingCol > totalNumberOfColumns - 1;
    }

    private boolean rowOufOfBoundsNegative() {
        return correspondingRow < 0;
    }

    private boolean columnOutOfBoundsNegative() {
       return correspondingCol < 0;
    }
}
