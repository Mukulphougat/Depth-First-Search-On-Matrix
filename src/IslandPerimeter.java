public class IslandPerimeter {
    /*
    You are given row x col grid representing a map where grid[i][j] = 1 represents land and grid[i][j] = 0 represents water.

    Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

    The island doesn't have "lakes", meaning the water inside isn't connected to the water around the island. One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.



    Example 1:


    Input: grid = [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]
    Output: 16
    Explanation: The perimeter is the 16 yellow stripes in the image above.
     */
    public static int islandPerimeter(int[][] grid) {
        int res = 0;
        int m = grid.length;
        int n = grid[0].length;
        for( int i = 0 ; i < m ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( grid[i][j] == 1 ){
                    grid[i][j] = 4;
                }
            }
        }

        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        for( int i = 0 ; i < m ; i++ ){
            for( int j = 0 ; j < n ; j++ ){
                if( grid[i][j] > 0 ){
                    int k = 0;
                    int ans = 0;
                    while( k < 4 ){
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if( x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0 ){
                            ans++;
                        }
                        k++;
                    }
                    // subtracting the number of edges with which this cells share its boundary
                    res += grid[i][j] - ans;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        int[][] grid = {{0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        int res = islandPerimeter(grid);
        System.out.println(res);


    }
}
