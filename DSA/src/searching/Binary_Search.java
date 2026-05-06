package searching;

public class Binary_Search {

	public static int binarySearchRecursive(int array[], int left, int right, int target){
		
		if (right >= left){

			// calculation of new mid
			int mid = left + (right - left)/2;

			// returns position where found
			if (array[mid] == target)      
				return mid;                     // use mid+1 when the problem asks 1-based indexing 

			// goes to recursive calls in left half
			if (array[mid] > target)
				return binarySearchRecursive(array, left, mid-1, target);

			// goes to recursive calls in right half
			else
				return binarySearchRecursive(array, mid+1, right, target);
		}
		// if element is not found we return -1
		else
			return -1;
	}
	
	// Iterative method 
	public static int binarySearchIterative(int array[], int left, int right, int target) {
		while (left <= right) {
			int mid = left + (right - left) / 2;

			// if item is at mid
			if (array[mid] == target)
				return mid;             

			// If item greater, ignore left half, consider only right half
			if (array[mid] < target)
				left = mid + 1;

			// If item is smaller, ignore right half, consider only left half
			else
				right = mid - 1;
		}

		// if we are able to reach here
		// means item wasn't present
		return -1;
	}
	public static void main(String args[]){

		int[ ] array = {10, 20, 30, 40, 50, 60, 70, 80};
		int target = 70;

		int RecursiveResult = binarySearchRecursive(array, 0, array.length-1, target);
		int IterativeResult = binarySearchIterative(array, 0, array.length-1, target);
		

		if( RecursiveResult == -1)
			System.out.println("Recursive: Element not found");
		else
			System.out.println("Recursive: The value " + target + " found at position: " + RecursiveResult);
		
		if( IterativeResult == -1)
			System.out.println("Iterative: Element not found");
		else
			System.out.println("Iterative: The value " + target + " found at position: " + IterativeResult);

	}
}
