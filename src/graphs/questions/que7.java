package graphs.questions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
Find the Topological sort using BFS Algorithm
 */
public class que7 {

    public static void main(String[] args) {

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

        System.out.println("Topological sort using BFS :" + Arrays.toString(topsort(adj,6)));
    }

    public static int[] topsort(ArrayList<ArrayList<Integer>> adj, int N) {
        int[] topo = new int[N];
        int[] degree = new int[N];
        Queue<Integer> q = new LinkedList<>();

        //finding indegree
        for(int i=0;i<N;i++)
        {
            for(Integer it : adj.get(i))
            {
                degree[it]++;
            }
        }

        //Adding all the nodes into queue whose indegree is 0.
        for (int i=0;i<N;i++)
        {
            if (degree[i]==0)
            {
                q.add(i);
            }
        }

        int index=0;
        while(!q.isEmpty())
        {
            Integer node =q.poll();
            topo[index++]=node;

            //Now getting the adjacent nodes of popped node and reducing there indegree by 1.
            for (Integer it : adj.get(node))
            {
                degree[it]--;
                //If the degree of any adjacent node became 0 add that node into queue
                if (degree[it] == 0)
                    q.add(it);
            }
        }
        return topo;
    }
}
