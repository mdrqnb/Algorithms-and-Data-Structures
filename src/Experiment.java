public class Experiment {
    private Sorter sorter;
    private Searcher searcher;

    public Experiment(Sorter sorter, Searcher searcher) {
        this.sorter = sorter;
        this.searcher = searcher;
    }

    public long measureSortTime(int[] arr, String type) {
        long start = System.nanoTime();
        if (type.equalsIgnoreCase("basic")) {
            sorter.basicSort(arr);
        } else if (type.equalsIgnoreCase("advanced")) {
            sorter.advancedSort(arr);
        }
        long end = System.nanoTime();
        return end - start;
    }

    public long measureSearchTime(int[] arr, int target) {
        long start = System.nanoTime();
        searcher.search(arr, target);
        long end = System.nanoTime();
        return end - start;
    }

    public void runAllExperiments() {
        int[] sizes = {10, 100, 1000};

        for (int size : sizes) {
            System.out.println("ARRAY SIZE: " + size);

            int[] randomArray = sorter.generateRandomArray(size);

            int[] sortedArray = sorter.generateSortedArray(size);

            int[] randomForBasic = sorter.copyArray(randomArray);
            int[] randomForAdvanced = sorter.copyArray(randomArray);

            int[] sortedForBasic = sorter.copyArray(sortedArray);
            int[] sortedForAdvanced = sorter.copyArray(sortedArray);

            long basicRandomTime = measureSortTime(randomForBasic, "basic");
            long advancedRandomTime = measureSortTime(randomForAdvanced, "advanced");

            long basicSortedTime = measureSortTime(sortedForBasic, "basic");
            long advancedSortedTime = measureSortTime(sortedForAdvanced, "advanced");

            int target = sortedArray[size / 2];
            long searchTime = measureSearchTime(sortedArray, target);

            System.out.println("Random Array:");
            System.out.println("Bubble Sort Time: " + basicRandomTime + " ns");
            System.out.println("Quick Sort Time: " + advancedRandomTime + " ns");

            System.out.println("\nSorted Array:");
            System.out.println("Bubble Sort Time: " + basicSortedTime + " ns");
            System.out.println("Quick Sort Time: " + advancedSortedTime + " ns");

            System.out.println("\nSearching:");
            System.out.println("Binary Search Target: " + target);
            System.out.println("Binary Search Time: " + searchTime + " ns");

            if (size == 10) {
                System.out.println("\nExample Sorted Result (Quick Sort on Random Small Array):");
                sorter.printArray(randomForAdvanced);
            }
        }
    }
}