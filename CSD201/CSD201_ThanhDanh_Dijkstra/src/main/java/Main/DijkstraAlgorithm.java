/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package Main;
import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        int to, weight;
        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int vertex, dist;
        public Node(int vertex, int dist) {
            this.vertex = vertex;
            this.dist = dist;
        }
        public int compareTo(Node other) {
            return Integer.compare(this.dist, other.dist);
        }
    }

    static void dijkstra(List<List<Edge>> graph, int start) {
        int n = graph.size();
        int[] dist = new int[n];
        int[] prev = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;
            if (current.dist > dist[u]) continue;

            for (Edge edge : graph.get(u)) {
                int v = edge.to;
                int weight = edge.weight;
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    prev[v] = u;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Output
        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("No path to vertex " + i);
            } else {
                System.out.print("Path to " + i + " (Cost: " + dist[i] + "): ");
                printPath(prev, i);
                System.out.println();
            }
        }
    }

    static void printPath(int[] prev, int v) {
        if (prev[v] != -1) {
            printPath(prev, prev[v]);
        }
        System.out.print(v + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = scanner.nextInt();

        System.out.print("Enter number of edges: ");
        int E = scanner.nextInt();

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        System.out.println("Enter edges in format: from to weight");
        for (int i = 0; i < E; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();
            int weight = scanner.nextInt();
                if (from < 0 || from >= V || to < 0 || to >= V) {
                    System.out.println("Invalid edge: " + from + " -> " + to + ". Skipping.");
                    continue;
}

            graph.get(from).add(new Edge(to, weight));
            // Nếu là đồ thị vô hướng thì thêm dòng sau:
            // graph.get(to).add(new Edge(from, weight));
        }

        System.out.print("Enter the starting vertex: ");
        int start = scanner.nextInt();

        System.out.println("Dijkstra Shortest Paths from vertex " + start + ":");
        dijkstra(graph, start);
    }
}
