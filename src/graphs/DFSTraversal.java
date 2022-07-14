package graphs;

import java.util.ArrayList;

public class DFSTraversal {



    public static  ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> storeDfs = new ArrayList<>();
        boolean[] vis = new boolean[V+1];

        for(int i=1;i<=V;i++)
        {
            if(!vis[i])
            {
                dfs(i,vis,adj,storeDfs);
            }
        }
        return storeDfs;
    }

    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> storeDfs) {
        storeDfs.add(node);
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, vis, adj, storeDfs);

            }
        }
    }
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<8;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(4);
        adj.get(2).add(7);
        adj.get(4).add(2);
        adj.get(4).add(6);
        adj.get(6).add(4);
        adj.get(6).add(7);
        adj.get(7).add(6);
        adj.get(7).add(2);
        adj.get(3).add(5);
        adj.get(5).add(3);

        ArrayList<Integer> ans = dfsOfGraph(7,adj);
        System.out.println(ans);
    }
}
