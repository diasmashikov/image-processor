package imageProcessing.imageTransformations.simpleTransformations;

import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

public class GrayScale {

    PixelImage image;
    Pixel[][] pixelsKernel;
    int totalNumberOfRows;
    int totalNumberOfColumns;
    Pixel[][] transformedKernel;


    public GrayScale(PixelImage image) {
        this.image = image;
        this.pixelsKernel = image.getData();
        this.totalNumberOfRows = image.getHeight();
        this.totalNumberOfColumns = image.getWidth();
        this.transformedKernel = new Pixel[pixelsKernel.length][pixelsKernel[0].length];
    }


    public Pixel[][] transformImage() {


        for (int row = 0; row < totalNumberOfRows; row++)
        {
            for (int col = 0; col < totalNumberOfColumns; col++)
            {
                grayScalePixel(pixelsKernel[row][col], row, col);
            }
        }

        return transformedKernel;
    }

    private void grayScalePixel(Pixel pixel, int row, int column) {

        int red = (int) (pixel.red * 0.299);
        int green = (int) (pixel.green * 0.587);
        int blue = (int) (pixel.blue * 0.114);

        int colorsCombined = red + green + blue;

        transformedKernel[row][column] = new Pixel(colorsCombined,
                colorsCombined,
                colorsCombined
        );

    }
}
