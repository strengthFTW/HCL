public class Spiral_matrix{
    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int[][] matrix = {
         {1,2,3},
         {4,5,6},
         {7,8,9}   
        };

        Spiral_display(matrix,row,col);
    }
    public static void Spiral_display(int[][] matrix, int row,int col) {
        int top = 0;
        int bottom = row-1;
        int left = 0;
        int right = col-1;

        while(left <= right && top <= bottom) {
            for(int i=left; i<=right; i++) {
                System.out.print(matrix[top][i] + " ");
            }
            top++;
            
            for(int i=top; i<= bottom; i++) {
                System.out.print(matrix[i][right]+ " ");
            }
            right--;

            if(top <=bottom) {
                for(int i=right; i>=left; i--) {
                    System.out.print(matrix[bottom][i]+ " ");
                }
                bottom--;
            }
            if(left<=right) {
                for(int i=bottom; i>= top; i--) {
                    System.out.print(matrix[i][left] + " ");
                }
                left++;
            }

        }
    }
}