package uk.ac.cam.jlf60.oop.supo.week_1;

public class Matrix {
    
    private float[][] matrix;
    int n;
    
    public Matrix (int n) {
        this.n = n;
        matrix = new float[n][n];
    }
    
    public void printMatrix () {
        for (float[] x : matrix) {
            for (float y : x) {
                System.out.print(y + " ");
            }
        System.out.println();
        }
    System.out.println();
    }
    
    public void setValue (int x, int y, float value) {
        matrix[y][x] = value;
    }
    
    public float getValue (int x, int y) {
        return matrix[y][x];
    }

    public void transpose () {
        for (int x = 0; x < n - 1; x++) {
            for (int y = x + 1; y < n; y++) {
                float temp = getValue(x,y);
                setValue(x,y, getValue(y,x));
                setValue(y,x, temp);
            }
        }
    }
    
    public Matrix add(Matrix toAdd) {
        Matrix addition = new Matrix(this.n);
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                addition.setValue(x, y, getValue(x,y) + toAdd.getValue(x,y));
            }
        }
        return addition;
    }

    
    public static void main(String[] args) {
        Matrix mat = new Matrix(6);
        mat.printMatrix();
        mat.setValue(1,0,1.0f);
        mat.setValue(2,0,1.1f);
        mat.setValue(3,0,1.2f);
        mat.setValue(1,1,1.3f);
        mat.setValue(1,2,1.4f);
        mat.setValue(5,4,2.0f);
        mat.printMatrix();
        mat.transpose();
        mat.printMatrix();
    }
}
