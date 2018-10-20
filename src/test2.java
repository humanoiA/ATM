public class test2 {
 
    public static void main(String[] args) {
        int[][] mx = {
        		{0,0,0,0,0}, 
        		{0,1,1,1,0}, 
        		{0,1,0,1,0}, 
        		{0,1,1,1,0}, 
        		{0,0,0,0,0}, 
        		{1,0,0,0,0} 
        };
 
        int total = 0;
		for(int i=0; i<mx.length; i++){
            for(int j=0; j<mx[i].length; j++){
                if(mx[i][j] == 1){
                    total ++;
                    findIslands(mx,i,j);
                }
 
            }
        }
        System.out.print("Total number of islands is " + total);
    }
 
    static void findIslands(int[][] mx, int x, int y) {
        try {
            if (mx[x][y] == 1) {
                mx[x][y] = 0;
                findIslands(mx, x + 1, y);
                findIslands(mx, x, y + 1);
                findIslands(mx, x - 1, y);
                findIslands(mx, x, y - 1);
                findIslands(mx, x + 1, y + 1);
                findIslands(mx, x - 1, y - 1);
                findIslands(mx, x + 1, y - 1);
                findIslands(mx, x - 1, y + 1);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }
}