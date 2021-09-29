# bitmap-transformer

**BMP** is a data directory which contains examples of BMP files. The BMP file is a bitmap image format developed by Microsoft and commonly used in the Windows operating system for storing icons.

## What this project do:
In this project we read from bitmap file and modify them in 4 ways:
1. `reverseBlackAndGreen:` this method is looking for the black and white colors and change the black to green and the white to black
2. `random:` this method is to change any color to a random color by dividing the rgb value by 2
3. `stretchVertically:` this method stretch the width twice by duplicating each pixel twice
4. `stretchHorizontally:` this method stretch the height twice by duplicating each pixel twice

## Tests
1. In this [folder](app/src/test) I have a test for every method and it is done by creating a dummy bitImage of 4px width and height half white and half black
2. the tests are [here](app/src/test/java/bitmapTransformer/AppTest.java)
3. the test results are [here](app/src/test/resources)

## How it works:

1. From the terminal enter this command `./gradlew` run `--args`
2. After that enter a space then 'inputFile outputFile transform':
    - inputFile: the name of the required image, and it must be in the [resources](app/src/main/resources) folder
    - outputFile: the name of the edited image (enter any name), and it must be in the [resources](app/src/main/resources) folder
    - transform: what do you want to do with that image you can choose only from:
        - blackgreen
        - random
        - stretchvertically
        - stretchvorizontally

## Contributors

1. Rahaf Al-Jazzazi
2. Doa'a Daban


