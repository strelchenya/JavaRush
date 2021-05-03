package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {

    public static ImageReader getImageReader(ImageTypes imageTypes) {

        ImageReader imageReader;

        if (imageTypes == ImageTypes.BMP) {
            imageReader = new BmpReader();
        } else if (imageTypes == ImageTypes.JPG) {
            imageReader = new JpgReader();
        } else if (imageTypes == ImageTypes.PNG) {
            imageReader = new PngReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }

        return imageReader;
    }
}



        /*if (imageTypes != null) {
            switch (imageTypes) {
                case JPG:
                    return new JpgReader();
                case BMP:
                    return new BmpReader();
                case PNG:
                    return new PngReader();
//            default:

            }
        }
//        System.out.println("defolt");
        throw new IllegalArgumentException("Неизвестный тип картинки");
    }
}
*/