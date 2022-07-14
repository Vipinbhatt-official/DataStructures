package graphs.questions;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Find the Minimum spanning tree using the Prim's Algorithm
 */
class Node1 implements Comparator <Node1> {
    int V;
    int weight;

    Node1(int _V, int _weight)
    {
        V = _V;
        weight = _weight;
    }
    Node1() {}
    int getV()
    {
        return V;
    }
    int getWeight()
    {
        return weight;
    }
    //For priority Queue
    @Override
    public int compare(Node1 o1, Node1 o2) {
        if (o1.weight < o2.weight)
            return -1;
        if (o1.weight > o2.weight)
            return 1;
        return 0;
    }
}

public class que12 {

    public static void main(String[] args) {
        int n = 5;
        ArrayList<ArrayList<Node1>> adj = new ArrayList<>();

        for (int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new Node1(1,2));
        adj.get(1).add(new Node1(0,2));

        adj.get(1).add(new Node1(2,3));
        adj.get(2).add(new Node1(1,3));

        adj.get(0).add(new Node1(3,6));
        adj.get(3).add(new Node1(0,6));

        adj.get(1).add(new Node1(3,8));
        adj.get(3).add(new Node1(1,8));

        adj.get(1).add(new Node1(4,5));
        adj.get(4).add(new Node1(1,5));

        adj.get(2).add(new Node1(4,7));
        adj.get(4).add(new Node1(2,7));

       // primsMST(adj,n);
        primsMSTOptimised(adj,n);
    }
    //Brute Forece Approach :- TC - approc O(N^2)
    public static void primsMST(ArrayList<ArrayList<Node1>> adj, int N) {
        int[] key = new int[N];
        boolean[] MST = new boolean[N];
        int[] parent = new int[N];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(MST, false);


        key[0] = 0;
        parent[0]=-1;

        for (int i = 0; i < N-1; i++) //for n-1 edges
        {
            int mini = Integer.MAX_VALUE;
            int u = 0;

            for (int v = 0; v < N; v++) //for n nodes
            {
                if (!MST[v] && key[v] < mini) {
                    mini = key[v];
                    u = v;
                }
            }

                MST[u] = true; //set the node true which you have picked

            //Now go to adjacent nodes
            for (Node1 it : adj.get(u)) {
                if (!MST[it.getV()] && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u; // if the weight of adjacent node is less take the parent of that node
                    key[it.getV()] = it.getWeight(); // Also update the weight in Key array as we need the min weight
                }
            }
        }
        //Printing the parents array as it contains parent of all nodes
        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }

    //Optimised using min Priority Queue. TC :- approx O(nlogn)
    public static void primsMSTOptimised(ArrayList<ArrayList<Node1>> adj, int N) {
        int[] key = new int[N];
        boolean[] MST = new boolean[N];
        int[] parent = new int[N];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(MST, false);


        PriorityQueue<Node1> pq = new PriorityQueue<>(N, new Node1());
        key[0] = 0;
        parent[0]=-1;
        pq.add(new Node1(key[0],0));

        while (!pq.isEmpty())
        {
            int u =pq.poll().getV();
            MST[u] = true; //set the node true which you have picked

            //Now go to adjacent nodes
            for (Node1 it : adj.get(u)) {
                if (!MST[it.getV()] && it.getWeight() < key[it.getV()]) {
                    parent[it.getV()] = u; // if the weight of adjacent node is less take the parent of that node
                    key[it.getV()] = it.getWeight(); // Also update the weight in Key array as we need the min weight
                    pq.add(new Node1(it.getV(), key[it.getV()]));
                }
            }
        }
        //Printing the parents array as it contains parent of all nodes
        for (int i = 1; i < N; i++) {
            System.out.println(parent[i] + " - " + i);
        }
    }
}

