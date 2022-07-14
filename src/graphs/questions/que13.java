package graphs.questions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Find the Minimum spanning tree using the Prim's Algorithm
 */
class Node2 {
    private int u;
    private int v;
    int weight;

    Node2(int _u, int _v, int _weight)
    {
        u = _u;
        v = _v;
        weight = _weight;
    }
    Node2() {}

    int getU() { return u; }
    int getV()
    {
        return v;
    }
    int getWeight()
    {
        return weight;
    }
}

class SortComprator implements Comparator<Node2> {

    @Override
    public int compare(Node2 o1, Node2 o2) {
        if(o1.getWeight() < o2.getWeight())
            return -1;
        if (o1.getWeight() > o2.getWeight())
            return 1;
        return 0;
    }
}

public class que13 {

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node2> adj = new ArrayList<>();

        adj.add(new Node2(0,1,2));
        adj.add(new Node2(0,3,6));
        adj.add(new Node2(1,3,8));
        adj.add(new Node2(1,2,3));
        adj.add(new Node2(1,4,5));
        adj.add(new Node2(2,4,7));

        krushkalsAlgo(adj,n);
    }

    private static int findPar(int node, int parent[]) {
        if(node == parent[node])
            return node;

        return parent[node] = findPar(parent[node], parent); // This is to compress the path
    }

    private static void union (int u, int v, int parent[], int rank[]) {
        u = findPar(u, parent);
        v = findPar(v, parent);

        if(rank[u] < rank[v])
            parent[u] = v;
        else if (rank[v] < rank[u])
            parent[v] = u;
        else { //if rank is equal we need to increase the rank of parent.
            parent[v] = u;
            rank[u]++;
        }
    }

    public static void krushkalsAlgo (ArrayList<Node2> adj, int n) {
        Collections.sort(adj, new SortComprator()); //sorting the edges based on the weight.

        //Setting the rank and parent
        int parent[] = new int[n];
        int rank[] = new int[n];

        for (int i=0;i<n;i++) {
            parent[i] = i;
            rank[i] = 0;
        }

        int costMST = 0; //To store the total weight of MST
        ArrayList<Node2> mst = new ArrayList<>(); //array list to add the edges to create MST

        for(Node2 it : adj) {
            if(findPar(it.getU(), parent) != findPar(it.getV(),parent)) {
                costMST += it.getWeight(); //if parents of it are not equal that means they are from diff components
                mst.add(it);
                union(it.getU(),it.getV(), parent, rank); // we need to do union of nodes so that we can know after
                //connecting them they are from same component
            }
        }

        System.out.println("Total cost of MST : " +costMST);
        for (Node2 it: mst) {
            System.out.println(it.getU() + "-" + it.getV());
        }
    }

}
