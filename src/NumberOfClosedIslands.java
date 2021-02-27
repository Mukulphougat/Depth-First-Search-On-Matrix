public class NumberOfClosedIslands {
    public static int closedIslands(int[][] grid){
        if ( grid == null || grid.length == 0 ) return 0;
        int closedIsland = 0, row = grid.length , col = grid[0].length;
        for ( int i = 1 ; i < row - 1 ; i++ ){
            for ( int j = 1 ; j < col - 1 ; j++ ){
                if ( grid[i][j] == 0 ){
                    if ( isClosedIsland(grid,i,j,row,col) ){
                        closedIsland++;
                    }
                }
            }
        }

        return closedIsland;
    }

    public static boolean isClosedIsland(int[][] grid, int i, int j, int row, int col ){
        // -1 = visited, 1 = water , 0 = land
        if ( grid[i][j] == -1 || grid[i][j] == 1 ) return true;
        if ( isOnPerimeter(i,j,row,col)) return false;
        grid[i][j] = -1;
        boolean left = isClosedIsland(grid,i,j-1,row,col);
        boolean right = isClosedIsland(grid,i,j+1,row,col);
        boolean up = isClosedIsland(grid,i - 1,j,row,col);
        boolean down = isClosedIsland(grid,i+1,j,row,col);

        return left && right && up && down;
    }

    public static boolean isOnPerimeter( int i, int j, int row, int col ){
        return i == 0 || j == 0 || i == row - 1 || j == col - 1;
    }

    public static void main(String[] args){
        int[][] grid = {
                {1,1,1,1,1,1,1,0},
                {1,0,0,0,0,1,1,0},
                {1,0,1,0,1,1,1,0},
                {1,0,0,0,0,1,0,1},
                {1,1,1,1,1,1,1,0}
        };

        System.out.println(closedIslands(grid));
    }
}
