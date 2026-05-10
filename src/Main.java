public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();
        for (int i = 1; i <= 10; i++) {
            graph.addVertex(new Vertex(i));

        }

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(4, 7);
        graph.addEdge(5, 8);
        graph.addEdge(6, 9);
        graph.addEdge(7, 10);

        System.out.println("GRAPH STRUCTURE");

        graph.printGraph();

        System.out.println("\nBFS Traversal:");

        graph.bfs(1);

        System.out.println("\nDFS Traversal:");

        graph.dfs(1);

        Experiment experiment = new Experiment();

        experiment.runMultipleTests();

        experiment.printResults();
    }
}