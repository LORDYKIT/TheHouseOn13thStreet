package com.example.gameproj;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.Objects;

public class ImageViewBuilder {
    private String imagePath;
    private double fitWidth;
    private double fitHeight;

    public ImageViewBuilder(String imagePath, double fitWidth, double fitHeight) {
        this.imagePath = imagePath;
        this.fitWidth = fitWidth;
        this.fitHeight = fitHeight;
    }

    public ImageView build() {
        Image image = new Image(Objects.requireNonNull(getClass().getResource(imagePath)).toExternalForm());
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(fitWidth);
        imageView.setFitHeight(fitHeight);
        return imageView;
    }
}
