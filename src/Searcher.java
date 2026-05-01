public class Searcher {
    public static boolean linearSearch(int[] arr, int x){
        for(int i = 0; i< arr.length; i++){
            if (arr[i] == x){
                return true;
            }
        }
        return false;
    }
    public static boolean binarySearch(int[] arr, int x, int start, int end){
        // requires sorted array
        if(start > end){return false;}

        int mid = (start + end) / 2;

        if(arr[mid] == x){return true;}
        else if(arr[mid] > x){
            return binarySearch(arr, x, mid+1, end);
        } else{
            return binarySearch(arr, x, start, mid-1);
        }
    }
}
