package array_duplicates;

public class Array_Duplicates {

	public static void main(String[] args) {
		int arr[] = {5,8,9,6,5,6,6,9};

		for(int i=0; i<arr.length;i++) {
			int j;
			for(j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					break;
				}
			}
			if (i == j) {
				System.out.print(arr[i] + " ");
			}
		}
	}

}


