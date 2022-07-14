package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
Find the shortest path of each node from source node using DFS and Topo sort
 */
public class que10 {

    static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight)
        {
            this.node = node;
            this.weight= weight;
        }

        int getNode()
        {
            return node;
        }

        int getWeight()
        {
            return weight;
        }
    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0;i<6;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1,2));
        adj.get(0).add(new Pair(4,1));
        adj.get(1).add(new Pair(2,3));
        adj.get(2).add(new Pair(3,6));
        adj.get(4).add(new Pair(2,2));
        adj.get(4).add(new Pair(5,4));
        adj.get(5).add(new Pair(3,1));

        System.out.println("Shortest path using DFS and Topo sort " + Arrays.toString(shortestPath(adj,6,0)));
    }

    public static int[] shortestPath(ArrayList<ArrayList<Pair>> adj, int N,int src) {
        int[] distance = new int[N];
        Stack stack = new Stack();
        boolean[] vis = new boolean[N];

        for(int i=0;i<N;i++)
        {
            vis[i]=false;
        }

        //Step 1: getting the complete graph topologically sorted in a stack
        for (int i=0;i<N;i++)
        {
            if (!vis[i])
            {
                topologicalSort(adj,i,vis,stack);
            }
        }

        //Step 2:working with weights and distance now

        for(int i=0;i<N;i++)
        {
            distance[i]=Integer.MAX_VALUE;
        }
        distance[src]=0;

        while (!stack.isEmpty())
        {
            int node = (int) stack.pop();

            //checking if the node have infinite value or not
            if(distance[node] != Integer.MAX_VALUE)
            {
                for (Pair it : adj.get(node))
                {
                    if (distance[node] + it.getWeight() < distance[it.getWeight()])
                    {
                        distance[it.getNode()] = distance[node] + it.getWeight();
                    }
                }
            }
        }

        return distance;
    }

    public static void topologicalSort(ArrayList<ArrayList<Pair>> adj, int node,boolean[] vis,Stack stack) {
        vis[node]=true;
        for (Pair it : adj.get(node))
        {
            if(!vis[it.getNode()])
            {
                topologicalSort(adj, it.getNode(), vis,stack);
            }
        }

        stack.add(node);
    }

}
