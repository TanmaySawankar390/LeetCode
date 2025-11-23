class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i =0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0; i< prerequisites.length; i++){
            int ai = prerequisites[i][0];
            int bi = prerequisites[i][1];
            graph.get(bi).add(ai);
            indegree[ai]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i< numCourses;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int[] topo = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()){
            int u = q.remove();
            topo[index++] = u;
            for(int v: graph.get(u)){
                indegree[v]--;
                if(indegree[v] == 0){
                    q.add(v);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }

        return topo; 
    }
}