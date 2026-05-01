public class Experiment {
    private Sorter sorter;
    private Searcher searcher;

    public Experiment() {
        this.sorter = new Sorter();
        this.searcher = new Searcher();
    }

    public long measureSortTime(int[] arr, String type){
        int[] copy = arr.clone();

        long start = System.nanoTime();

        if (type.equals("basic")) {
            sorter.BubbleSort(copy);
        } else if (type.equals("advanced")) {
            sorter.QuickSort(copy);
        }

        long end = System.nanoTime();
        return end - start; // nanoseconds
    }

    public long measureSearchTime(int[] arr, int target, String type){
        long start = System.nanoTime();
        if(type.equals("linear")) {
            searcher.linearSearch(arr, target);
        } else{
            searcher.binarySearch(arr, target, 0, arr.length-1);
        }
        long end = System.nanoTime();
        return end - start;
    }
    public void runAllExperiments(){
        int[] sizes = {10,100,1000};
        String[] labels = {"Small (10)", "Medium (100)", "Large (1000)"};

        for(int i = 0; i<sizes.length; i++){
            int size = sizes[i];
            System.out.println(labels[i]);

            int[] randomArr = sorter.generateRandomArray(size);
            int[] sorterArr = randomArr.clone();
            sorter.QuickSort(randomArr);

            int target = randomArr[size-1]; // worst case for linear search

            // sorting random arrays
            long basicBubbleSort_random = measureSortTime(randomArr, "basic");
            long advancedQuickSort_random = measureSortTime(randomArr, "advanced");

            // sorting sorted arrays
            long basicBubbleSort_sorted = measureSortTime(sorterArr, "basic");
            long advancedQuickSort_sorted = measureSortTime(sorterArr, "advanced");

            // linear searching
            long linearSearch_random = measureSearchTime(randomArr, target, "linear");
            long linearSearch_sorted = measureSearchTime(sorterArr, target, "linear");

            // binary search
            long binarySearch_sorted = measureSearchTime(sorterArr, target, "binary");

            System.out.println("Sorting random arrays: basic - " + basicBubbleSort_random + " advanced - " + advancedQuickSort_random);
            System.out.println("Sorting sorted arrays: basic - " + basicBubbleSort_sorted + " advanced - " + advancedQuickSort_sorted);

            System.out.println("Linear search: random - " + linearSearch_random + " sorted - " + linearSearch_sorted);
            System.out.println("Binary search: sorted - " + binarySearch_sorted);


        }
    }
}
