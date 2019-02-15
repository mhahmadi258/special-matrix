package ir.ac.kntu;

public class Matrix {
    private int width;
    private int height;
    int[][] array;

    public Matrix(int width, int height, int[][] array) {
        this.width = width;
        this.height = height;
        this.array = array;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
