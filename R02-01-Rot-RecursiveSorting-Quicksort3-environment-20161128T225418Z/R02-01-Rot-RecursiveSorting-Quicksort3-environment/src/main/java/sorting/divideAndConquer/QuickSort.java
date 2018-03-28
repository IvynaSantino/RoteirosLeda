package sorting.divideAndConquer;

import sorting.AbstractSorting;
import util.Util;

/**
 * Quicksort is based on the divide-and-conquer paradigm. The algorithm chooses
 * a pivot element and rearranges the elements of the interval in such a way
 * that all elements lesser than the pivot go to the left part of the array and
 * all elements greater than the pivot, go to the right part of the array. Then
 * it recursively sorts the left and the right parts. Notice that if the list
 * has length == 1, it is already sorted.
 */
public class QuickSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (verifica(array, leftIndex, rightIndex)) {
			if (leftIndex < rightIndex) {
				int pivot = particion(array, leftIndex, rightIndex);
				
				sort(array, leftIndex, pivot - 1);
				sort(array, pivot + 1, rightIndex);
			}
		}
		
	}
	
	private int particion(T[] array, int leftIndex, int rightIndex) {
		
		T pivot = array[leftIndex];
		int inicial = leftIndex;
		  
		for (int j = leftIndex + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) < 0) {
				inicial++;
				Util.swap(array, inicial, j);
				}
			}
		  
		Util.swap(array, leftIndex, inicial);
		  
		return inicial;
		
	}
	
	private boolean verifica(T[] array, int leftIndex, int rightIndex) {
		boolean result = true;
		
		if (array == null || array.length <= 0) {
			result = false;
		} else if (leftIndex >= rightIndex || leftIndex < 0) {
			result = false;
		} else if (rightIndex > array.length || leftIndex >= array.length
				|| rightIndex <= 0) {
			result = false;
		}
		
		return result;
	}
}
