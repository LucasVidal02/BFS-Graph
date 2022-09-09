import java.util.*;

public class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        V = v;
        adj = new LinkedList[v];
        for(int i = 0; i < v; i++){
            adj[i] = new LinkedList();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void BFS(int s){
        
        boolean visitado[] = new boolean[V];

        LinkedList<Integer> fila = new LinkedList();

        visitado[s] = true;
        fila.add(s);

        while (fila.size() != 0){
            s = fila.poll();
            System.out.println(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if(!visitado[n]){
                    visitado[n] = true;
                    fila.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.BFS(2);
    }
}