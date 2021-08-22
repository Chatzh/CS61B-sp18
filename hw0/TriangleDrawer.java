public class TriangleDrawer {
    public static void drawTriangle(int n) {
        int i = 0;
        while (i < n) {
            int j = 0;
            while (j <= i) {
                System.out.print("*");
                j++;
            }
            System.out.println("");
            i++;
        }
    }
    
    public static void main(String[] args) {
        drawTriangle(10);
    }
}