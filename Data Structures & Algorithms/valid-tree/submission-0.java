class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n-1) return false;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edges){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(0, graph, visited);
        for(boolean v : visited){
            if(v != true){
                return false;
            }
        }
        return true;
    }
    private void dfs(int node, List<List<Integer>>graph, boolean[] visited){
        visited[node] = true;
        for(int neighbour : graph.get(node)){
            if(!visited[neighbour]){
                dfs(neighbour, graph, visited);
            }
        }
    }
}
