package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Find the shortest distance of each node from the source node using BFS Algorithm
 */
public class que9 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<9;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(3);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(1).add(3);
        adj.get(2).add(1);
        adj.get(2).add(6);
        adj.get(3).add(0);
        adj.get(3).add(4);
        adj.get(4).add(3);
        adj.get(4).add(5);
        adj.get(5).add(4);
        adj.get(5).add(6);
        adj.get(6).add(2);
        adj.get(6).add(5);
        adj.get(6).add(7);
        adj.get(6).add(8);
        adj.get(7).add(6);
        adj.get(7).add(8);
        adj.get(8).add(6);
        adj.get(8).add(7);

        System.out.println("The shortest path from source of each node : "+Arrays.toString(shortestPath(adj,9,0)));
    }

    public static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int N, int src) {
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();

        distance[src] = 0;
        q.add(src);

        while (!q.isEmpty())
        {
            int node =q.poll();
            for (Integer it : adj.get(node))
            {
                if (distance[node] +1 < distance[it])
                {
                    //If the value at distance node +1 is smaller than the value which is currently in distance[it] update the value.
                    distance[it] = distance[node]+1;
                    q.add(it);
                }
            }
        }
        return distance;
    }
}
