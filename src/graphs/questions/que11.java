package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
Find the shortest path suing Dijkstra's Algorithm
 */
public class que11 {
    static class Pair  implements Comparator<Pair> {
        int node;
        int weight;

        public Pair(int _node, int _weight)
        {
            node = _node;
            weight=_weight;
        }

        Pair()
        {
        }
        int getNode()
        {
            return node;
        }

        int getWeight()
        {
            return weight;
        }

        //To make the priority queue min priority queue we have written a compare function
        public int compare(Pair pair1, Pair pair2)
        {
        if(pair1.weight < pair2.weight)
            return -1;

        if(pair1.weight > pair2.weight)
            return 1;

        return 0;
        }

    }

    public static void main(String[] args) {

        int n=5;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Pair(1,2));
        adj.get(1).add(new Pair(0,2));

        adj.get(1).add(new Pair(2,4));
        adj.get(2).add(new Pair(1,4));

        adj.get(0).add(new Pair(3,1));
        adj.get(3).add(new Pair(0,1));

        adj.get(3).add(new Pair(2,3));
        adj.get(2).add(new Pair(3,3));

        adj.get(1).add(new Pair(4,5));
        adj.get(4).add(new Pair(1,5));

        adj.get(2).add(new Pair(4,1));
        adj.get(4).add(new Pair(2,1));

        System.out.println("Shortest path using Dijkstra's Algorithm : "+Arrays.toString(shortestPath(adj,n,0)));
    }

    public static int[] shortestPath(ArrayList<ArrayList<Pair>> adj, int N, int src) {
        int[] distance = new int[N];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src]=0;


        PriorityQueue<Pair> pq = new PriorityQueue<>(N, new Pair());
        pq.add(new Pair(src,0));


        while (pq.size() > 0)
        {
            Pair node = pq.poll();

            for(Pair it : adj.get(node.getNode()))
            {
             if(distance[node.getNode()] + it.getWeight() < distance[it.getNode()])
             {
                 distance[it.getNode()] = distance[node.getNode()] + it.getWeight();
                 pq.add(new Pair(it.getNode(), distance[it.getNode()]));
             }
            }
        }
        return distance;
    }

}
