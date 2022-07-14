package graphs.questions;

import graphs.DFSTraversal;

import java.util.ArrayList;
import java.util.Arrays;

/*
Check if a graph is bipartite using DFS
 */
public class que4 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<9;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(2);
        adj.get(2).add(1);

        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(3).add(4);
        adj.get(4).add(3);

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(5).add(6);
        adj.get(6).add(5);

        adj.get(6).add(7);
        adj.get(7).add(6);

        adj.get(7).add(2);
        adj.get(2).add(7);

        adj.get(5).add(8);
        adj.get(8).add(5);


        System.out.println("Is the graph bipartite : "+ checkbipartite(9,adj));
    }

    public static boolean checkbipartite(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
            if(color[i] == -1)
            {
                if(!dfscheck(i,adj,color))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfscheck(int node, ArrayList<ArrayList<Integer>> adj, int[] color) {
      if(color[node]==-1)
          color[node]=1;

        for(Integer it : adj.get(node))
        {
            if(color[it]==-1)
            {
                color[it] = 1-color[node];
                if(!dfscheck(it,adj,color))
                {
                    return false;
                }
                else if(color[it]==color[node])
                    return false;
            }
        }
        return true;
    }
}
