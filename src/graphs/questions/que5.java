package graphs.questions;

import java.util.ArrayList;
/*
Detect a cycle in a directed graph using DFS
 */
public class que5 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //vertex 0
        ArrayList<Integer> neighbors = new ArrayList<>();
        neighbors.add(1);
        graph.add(neighbors);

        //vertex 1
        neighbors = new ArrayList<>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //vertex 2
        neighbors = new ArrayList<>();
        neighbors.add(3);
        graph.add(neighbors);

        //vertex 3
        neighbors = new ArrayList<>();
        neighbors.add(4);
        graph.add(neighbors);

        //vertex 4
        neighbors = new ArrayList<>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //vertex 5
        neighbors = new ArrayList<>();
        graph.add(neighbors);

        System.out.println("Cycle Detected in Directed graph using DFS:"+isCycle(graph,6));
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] vis = new int[V];
        int[] dfsVis = new int[V];

        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            {
                if(checkCycle(i,adj,vis,dfsVis))
                {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkCycle(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[]dfs) {
        vis[node]=1;
        dfs[node]=1;

        for(Integer neighbor : adj.get(node))
        {
            if(vis[neighbor]==0)
            {
                if(checkCycle(neighbor,adj,vis,dfs))
                {
                    return true;
                }
            } else if(dfs[neighbor]==1) //If vis[neighbor] is already 1 then we just need to check is dfs[neig..] is also one or not
                return true;
        }

        dfs[node]=0;
        return false;
    }
}
