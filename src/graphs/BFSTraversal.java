package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
This program shows us how can we Implement BFS Traversal on an undirected graph.
 */
public class BFSTraversal {

    private static ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> bfs = new ArrayList<>(); //List to save the final output
        boolean[] vis = new boolean[V]; //Boolean array to check if a node is visited
        Queue<Integer> q = new LinkedList<>(); //Queue to compute the adjacent nodes of a node one by one

        q.add(0);
        vis[0]=true;

        while(!q.isEmpty()) {
            Integer node = q.poll();
            bfs.add(node);

            //Now visit all the adjacent vertices and if a adjacent has not been visited mark it visited and enque it.
            for(Integer it : adj.get(node))
            {
                if(!vis[it])
                {
                    vis[it] = true;
                    q.add(it);
                }
            }
        }
        return bfs;
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<5;i++)
        {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(2).add(4);
        adj.get(4).add(2);

        ArrayList<Integer> ans = bfs(5,adj);
        System.out.println(ans);
    }
}
