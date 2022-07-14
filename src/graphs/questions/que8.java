package graphs.questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
Detect a cycle in Directed graph using BFS Algorithm (kahn's Algorithm)
 */
public class que8 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //vertex 0
        ArrayList<Integer> neighbors = new ArrayList<>();
        neighbors.add(1);
        graph.add(neighbors);

        //vertex 1
        neighbors = new ArrayList<>();
        neighbors.add(2);
        neighbors.add(5);
        graph.add(neighbors);

        //vertex 2
        neighbors = new ArrayList<>();
        neighbors.add(3);
        graph.add(neighbors);

        //vertex 3
        neighbors = new ArrayList<>();
        neighbors.add(4);
        graph.add(neighbors);

        //vertex 4
        neighbors = new ArrayList<>();
        neighbors.add(0);
        neighbors.add(1);
        graph.add(neighbors);

        //vertex 5
        neighbors = new ArrayList<>();
        graph.add(neighbors);

        //Negative use case
/*
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<6;i++)
        {
            adj.add(new ArrayList<>());
        }
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(3).add(1);
        adj.get(2).add(3);
*/


        System.out.println("Cycle Detected in Directed graph using BFS : "+detectCycleUsingTopoSort(graph,6));
    }

    public static boolean detectCycleUsingTopoSort(ArrayList<ArrayList<Integer>> adj, int N)
    {
        int[] indegree = new int[N];
        Queue<Integer> q = new LinkedList<>();
        //Finding indegree
        for (int i=0;i<N;i++)
        {
            for (Integer it : adj.get(i))
            {
                indegree[it]++;
            }
        }
        //Adding all nodes having indegree 0 in stack
        for(int i=0;i<N;i++)
        {
            if (indegree[i]==0)
            {
                q.add(i);
            }
        }
        int counter =0;
        while (!q.isEmpty())
        {
            Integer node = q.poll();
            counter++;

            for (Integer it : adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0)
                {
                    q.add(it);
                }
            }
        }
        // If the counter is equal to N that means topological sort was done for each node in graph so there is no cycle
        if (counter == N)
            return false;

      return true;
    }
}
