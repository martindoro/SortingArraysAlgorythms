package sort_arrays;

public class SortTimer {

	public static int[] unsortedArray = new int[100000];
	public static long startTime;
	public static long endTime;

	public static void main(String[] args) {
		MergeSort obj = new SortTimer().new MergeSort();

		arrayCreation();
		startTime = System.nanoTime();
		obj.sort(unsortedArray.clone(), 0, unsortedArray.length - 1);
		endTime = System.nanoTime();
		System.out.println(
				"Merge sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
		bubbleSort(unsortedArray.clone());
		selectionSort(unsortedArray.clone());
		insertionSort(unsortedArray.clone());
		selectionSort(unsortedArray.clone());
		startTime = System.nanoTime();
		obj.sort(unsortedArray.clone(), 0, unsortedArray.length - 1);
		endTime = System.nanoTime();
		System.out.println(
				"Merge sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
		insertionSort(unsortedArray.clone());
		bubbleSort(unsortedArray.clone());
		insertionSort(unsortedArray.clone());
		selectionSort(unsortedArray.clone());
		startTime = System.nanoTime();
		obj.sort(unsortedArray.clone(), 0, unsortedArray.length - 1);
		endTime = System.nanoTime();
		System.out.println(
				"Merge sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
		bubbleSort(unsortedArray.clone());
		insertionSort(unsortedArray.clone());
		bubbleSort(unsortedArray.clone());
		startTime = System.nanoTime();
		obj.sort(unsortedArray.clone(), 0, unsortedArray.length - 1);
		endTime = System.nanoTime();
		System.out.println(
				"Merge sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
		selectionSort(unsortedArray.clone());

	}

	private class MergeSort {
		void merge(int array[], int l, int m, int r) {
			int n1 = m - l + 1;
			int n2 = r - m;
			int[] L = new int[n1];
			int[] R = new int[n2];

			for (int i = 0; i < n1; i++) {
				L[i] = array[l + i];
			}
			for (int j = 0; j < n2; j++) {
				R[j] = array[m + 1 + j];
			}

			int i = 0;
			int j = 0;
			int k = l;

			while (i < n1 && j < n2) {
				if (L[i] <= R[j]) {
					array[k] = L[i];
					i++;
				} else {
					array[k] = R[j];
					j++;
				}
				k++;
			}

			while (i < n1) {
				array[k] = L[i];
				i++;
				k++;
			}

			while (j < n2) {
				array[k] = R[j];
				j++;
				k++;
			}
		}

		void sort(int[] array, int l, int r) {
			if (l < r) {
				int m = (l + r) / 2;
				sort(array, l, m);
				sort(array, m + 1, r);
				merge(array, l, m, r);
			}
			System.out.println(array[0]);
		}
	}

	public static void arrayCreation() {
		for (int i = 0; i < unsortedArray.length; i++) {
			unsortedArray[i] = (int) (Math.random() * 2147483647);
		}
	}

	public static void bubbleSort(int[] inputArray) {
		int temp;
		long startTime = System.nanoTime();

		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 1; j < inputArray.length - i; j++) {
				if (inputArray[j - 1] > inputArray[j]) {
					temp = inputArray[j - 1];
					inputArray[j - 1] = inputArray[j];
					inputArray[j] = temp;
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.println(
				"Bubble sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
	}

	public static void selectionSort(int[] inputArray) {
		long startTime = System.nanoTime();

		for (int i = 0; i < inputArray.length - 1; i++) {
			int lowestIndex = i;
			for (int j = i + 1; j < inputArray.length; j++) {
				if (inputArray[j] < inputArray[lowestIndex]) {
					lowestIndex = j;
				}
			}
			int smallerNumber = inputArray[lowestIndex];
			inputArray[lowestIndex] = inputArray[i];
			inputArray[i] = smallerNumber;
		}
		long endTime = System.nanoTime();
		System.out.println(
				"Selection sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
	}

	public static void insertionSort(int[] inputArray) {
		int temp;
		long startTime = System.nanoTime();

		for (int i = 1; i < inputArray.length; i++) {
			for (int j = i; j > 0; j--) {
				if (inputArray[j] < inputArray[j - 1]) {
					temp = inputArray[j];
					inputArray[j] = inputArray[j - 1];
					inputArray[j - 1] = temp;
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.println(
				"Insertion sort time: " + (Double.toString((double) (endTime - startTime) / 1000000000)) + " seconds.");
	}
}
