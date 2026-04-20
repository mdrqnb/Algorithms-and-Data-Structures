public class Main {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        Searcher searcher = new Searcher();
        Experiment experiment = new Experiment(sorter, searcher);
        experiment.runAllExperiments();
    }
}