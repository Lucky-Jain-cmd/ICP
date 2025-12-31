class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
          for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);
        }
        int [] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (state[i] == 0) {
                if (dfs(i, graph, state) == false) {
                    return false; 
                }
            }
        }

        return true;
    }
private boolean dfs(int node,List<List<Integer>> graph,int [] state){
    state [node]=1;
    for(int neighbour : graph.get(node)){
        if(state[neighbour]==1){
            return false;
        }
        if(state[neighbour]==0){
            if(dfs(neighbour,graph,state)==false){
                return false;
            }
        }
    }
    state[node]=2;
    return true;
}}