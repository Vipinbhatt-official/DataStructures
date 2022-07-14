package graphs.questions;

import java.util.ArrayList;

/*
Detect a cycle in undirected graph using DFS
 */
public class que2 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(1);
        adj.get(1).add(4);

        System.out.println("Cycle Detected:"+isCycle(5,adj));
    }
    public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(checkForCycle(i,-1,vis,adj))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkForCycle(int node, int prev, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node]=true;

        for(Integer it : adj.get(node))
        {
            if(!vis[it])
            {
                if(checkForCycle(it,node,vis,adj))
                {
                    return true;
                }
            }
            else if(it != prev)
            {
                return true;
            }
        }
        return false;
    }
}
