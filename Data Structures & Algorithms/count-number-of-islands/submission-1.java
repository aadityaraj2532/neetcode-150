class Solution {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == '1'){
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int i, int j){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = 0;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int x = curr[0];// for curr row
            int y = curr[1];// for curr col
            if(x+1 < grid.length && grid[x+1][y] == '1'){
                q.add(new int[]{x+1, y});
                grid[x+1][y]=0;
            }
            if(x-1 >= 0 && grid[x-1][y] == '1'){
                q.add(new int[]{x-1, y});
                grid[x-1][y] = 0;
            }
            if(y+1 < grid[0].length && grid[x][y+1]=='1'){
                q.add(new int[]{x, y+1});
                grid[x][y+1]=0;
            }
            if(y-1 >= 0 && grid[x][y-1]=='1'){
                q.add(new int[]{x, y-1});
                grid[x][y-1]=0;
            }
        }
    }
}
