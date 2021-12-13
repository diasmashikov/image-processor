package imageProcessing.imageTransformations.simpleTransformations;

import imageProcessing.models.Pixel;
import imageProcessing.models.PixelImage;

public class Binarization {
    PixelImage image;
    Pixel[][] pixelsKernel;
    int totalNumberOfRows;
    int totalNumberOfColumns;


    public Binarization(PixelImage image) {
        this.image = image;
        this.pixelsKernel = image.getData();
        this.totalNumberOfRows = image.getHeight();
        this.totalNumberOfColumns = image.getWidth();
    }

    public Pixel[][] transformImage() {
        int cropCount = 0;
        for (int row = 0; row < totalNumberOfRows; row++) {
            for (int col = 0; col < totalNumberOfColumns; col++)
            {
                Pixel temp = pixelsKernel[row][col];
                if(temp.red < 127) {
                    temp.red = 0;
                } else {
                    temp.red = 255;
                }

                if(temp.green < 127) {
                    temp.green = 0;
                } else {
                    temp.green = 255;
                }

                if(temp.blue < 127) {
                    temp.blue = 0;
                } else {
                    temp.blue = 255;
                }

                if(temp.red == 255 && temp.blue == 255 && temp.green == 255) {
                    cropCount++;
                }
                pixelsKernel[row][col] = temp;
            }
        }

        System.out.println(cropCount/(Math.pow((82/2.5), 2)) + " km^2 of crops");

        return pixelsKernel;
    }
}
