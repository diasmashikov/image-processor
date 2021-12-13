package imageProcessing.imageTransformations.simpleTransformations;

import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

public class FlipVertical{
    PixelImage image;
    Pixel[][] pixelsKernel;
    int totalNumberOfRows;
    int totalNumberOfColumns;


    public FlipVertical(PixelImage image) {
        this.image = image;
        this.pixelsKernel = image.getData();
        this.totalNumberOfRows = image.getHeight();
        this.totalNumberOfColumns = image.getWidth();
    }

    public Pixel[][] transformImage() {
        for (int row = 0; row < totalNumberOfRows / 2; row++)
        {
            for (int col = 0; col < totalNumberOfColumns; col++)
            {
                Pixel temp = pixelsKernel[row][col];
                pixelsKernel[row][col] = pixelsKernel[totalNumberOfRows - row - 1][col];
                pixelsKernel[totalNumberOfRows - row - 1][col] = temp;
            }
        }

        return pixelsKernel;
    }
}
