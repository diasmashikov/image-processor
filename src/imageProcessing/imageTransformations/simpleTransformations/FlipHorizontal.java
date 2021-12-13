package imageProcessing.imageTransformations.simpleTransformations;

import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

public class FlipHorizontal {
    PixelImage image;
    Pixel[][] pixelsKernel;
    int totalNumberOfRows;
    int totalNumberOfColumns;


    public FlipHorizontal(PixelImage image) {
        this.image = image;
        this.pixelsKernel = image.getData();
        this.totalNumberOfRows = image.getHeight();
        this.totalNumberOfColumns = image.getWidth();
    }

    public Pixel[][] transformImage() {
        for (int row = 0; row < totalNumberOfRows; row++) {
            for (int col = 0; col < totalNumberOfColumns / 2; col++)
            {
                Pixel temp = pixelsKernel[row][col];
                pixelsKernel[row][col] = pixelsKernel[row][totalNumberOfColumns - col - 1];
                pixelsKernel[row][totalNumberOfColumns - col - 1] = temp;
            }
        }

        return pixelsKernel;
    }
}
