package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Find the topological sort using the DFS Algorithm
 */
public class que6 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n=6;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);

        System.out.println("Topological sort :"+ Arrays.toString(topSort(adj,n)));
    }

    public static int[] topSort(ArrayList<ArrayList<Integer>> adj, int N){
        Stack<Integer> stack = new Stack<>();
        int[] vis = new int[N];

        for (int i=0;i<N;i++)
        {
            if(vis[i]==0)
            {
               findTopSort(i,vis,adj,stack);
            }
        }

        int[] topo = new int[N];
        int ind =0;
        while (!stack.isEmpty())
        {
            topo[ind++]=stack.pop();
        }

      return topo;
    }

    static void findTopSort(int node, int[] vis,ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        vis[node]=1;
        for (Integer it : adj.get(node))
        {
            if (vis[it]==0)
            {
                findTopSort(it,vis,adj,stack);
            }
        }
        stack.push(node);
    }
}
