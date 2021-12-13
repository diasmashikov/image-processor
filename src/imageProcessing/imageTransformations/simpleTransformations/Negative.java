package imageProcessing.imageTransformations.simpleTransformations;

import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

public class Negative {

    PixelImage image;
    Pixel[][] pixelsKernel;
    int totalNumberOfRows;
    int totalNumberOfColumns;


    public Negative(PixelImage image) {
        this.image = image;
        this.pixelsKernel = image.getData();
        this.totalNumberOfRows = image.getHeight();
        this.totalNumberOfColumns = image.getWidth();
    }


    public Pixel[][] transformImage() {
        for (int row = 0; row < totalNumberOfRows; row++)
        {
            for (int col = 0; col < totalNumberOfColumns; col++)
            {
                pixelsKernel[row][col] = negatePixel(pixelsKernel[row][col]);
            }
        }

        return pixelsKernel;
    }

    private Pixel negatePixel(Pixel pixel) {

        pixel.red = 255 - pixel.red;
        pixel.green = 255 - pixel.green;
        pixel.blue = 255 - pixel.blue;

        return pixel;
    }
}
