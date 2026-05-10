public class Experiment {
    public void runTraversals(Graph g) {
        System.out.println("\nBFS Traversal:");
        g.bfs(1);
        System.out.println("\nDFS Traversal:");
        g.dfs(1);
    }

    public void runMultipleTests() {
        int[] sizes = {10, 30, 100};
        for (int size : sizes) {
            Graph graph = new Graph();
            for (int i = 1; i <= size; i++) {
                graph.addVertex(new Vertex(i));
            }

            for (int i = 1; i < size; i++) {
                graph.addEdge(i, i + 1);
            }

            System.out.println("\n==============================");
            System.out.println("Graph Size: " + size);

            long startBFS = System.nanoTime();

            graph.bfs(1);

            long endBFS = System.nanoTime();

            long bfsTime = endBFS - startBFS;


            long startDFS = System.nanoTime();

            graph.dfs(1);

            long endDFS = System.nanoTime();

            long dfsTime = endDFS - startDFS;

            System.out.println("\nPerformance Results:");

            System.out.println("BFS Execution Time: " + bfsTime + " ns");

            System.out.println("DFS Execution Time: " + dfsTime + " ns");
        }
    }

    public void printResults() {

        System.out.println("\nAll experiments completed successfully.");

    }
}