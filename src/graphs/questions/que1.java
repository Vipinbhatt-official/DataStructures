package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Detect a cycle in undirected graph using BFS
 */
class Node {
    int first;
    int second;

    public Node(int first,int second) {
        this.first=first;
        this.second=second;
    }
}
public class que1 {
    public static boolean iscycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] vis = new boolean[V+1];
        Arrays.fill(vis,false);

        for(int i=0;i<V;i++)
        {
            if(!vis[i])
            {
                if(checkForCycle(adj,i,vis))
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean checkForCycle(ArrayList<ArrayList<Integer>> adj, int s, boolean[] vis) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,-1));
        vis[s]=true;

        while(!q.isEmpty())
        {
            //saving the current node and the previous node
            int node = q.peek().first;
            int prev = q.peek().second;
            q.remove();

            for (Integer it : adj.get(node))
            {
                if(!vis[it])
                {
                    q.add(new Node(it,node));
                    vis[it]=true;
                }
                else if(prev != it)
                    return true;
            }
        }
         return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(2).add(3);
        adj.get(1).add(3);
        adj.get(2).add(4);

        System.out.println("Cycle Detected : "+iscycle(5,adj));
    }
}
