package bitmapTransformer;

import java.io.File;

public class App {

    public static void main(String[] args) {
        Bitmap bitmap = new Bitmap();
        bitmap.mirrorImage(new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_normal.jpg")
                , new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_Mirror.jpg"));
        bitmap.rotate90(new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_normal.jpg")
                , new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_Rotate.jpg"),
                1);
        bitmap.darken(new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_normal.jpg"),
                new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_Dark.jpg"));

        bitmap.lighten(new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_normal.jpg"),
                new File("C:\\Users\\AB\\401course\\bitmap-transformer\\app\\src\\main\\resources\\Car_Light.jpg"));
    }
}