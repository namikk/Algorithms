package homework;
/**
 * This class implements the Heap-sort algorithm for sorting and array
 * 
 * @author Namik Karovic
 * @author Amar Bajramovic
 */
public class HeapSort {

	// initial max-heap builder method
	public static void buildMaxHeap(int[] array) {
		for (int i = array.length / 2; i >= 0; i--) {
			maxHeapify(array, i, array.length);
		}
	}

	// maxHeapify : creates a max-heap in a given array for a given heapSize
	// starts from the currentNode index
	// ends when the array is a max-heap
	public static void maxHeapify(int[] array, int currentNode, int heapSize) {
		int left = 2 * currentNode;// left child index
		int right = 2 * currentNode + 1;// right child index
		int largest = currentNode;// largest index

		// check if left child is larger than parent
		if (left < heapSize && array[left] > array[currentNode]) {
			largest = left;
		} else
			largest = currentNode;

		// check if right child is larger than previous largest
		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		// iterative control construct for arranging the rest of the heap
		while (largest != currentNode) {
			// first exchange current node with largest
			exchange(array, currentNode, largest);

			// then continue with arranging the rest of the heap
			currentNode = largest;

			left = 2 * currentNode;
			right = 2 * currentNode + 1;

			if (left < heapSize && array[left] > array[currentNode]) {
				largest = left;
			} else
				largest = currentNode;

			if (right < heapSize && array[right] > array[largest]) {
				largest = right;
			}

		}

	}// end maxHeapify

	// exchanges i and j elements of a given array
	public static void exchange(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	// heapsort method
	// calling this method will sort the given array using heapsort
	public static void heapSort(int[] array) {
		int n = array.length;
		buildMaxHeap(array);
		for (int i = array.length - 1; i > 0; i--) {
			exchange(array, i, 0);
			maxHeapify(array, 0, --n);
		}
	}

}
