package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Check if a graph is Bipartite or not using BFS.
 */
public class que3 {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<7;i++)
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

        adj.get(4).add(5);
        adj.get(5).add(4);

        adj.get(1).add(6);
        adj.get(6).add(1);

        System.out.println("Is the graph bipartite : "+checkBipartite(7,adj));
    }

    public static boolean checkBipartite(int n, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!bfsCheck(adj,i,color));
                {
                    return false;
                }
            }
        }
     return true;
    }

    public static boolean bfsCheck(ArrayList<ArrayList<Integer>> adj,int node,int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        color[node]=1;

        while(!q.isEmpty())
        {
            Integer nde = q.poll();
            for(Integer it : adj.get(nde))
            {
                if(color[it]==-1)
                {
                    color[it]=1-color[nde];
                    q.add(it);
                }
                else if(color[it] == color[nde])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
