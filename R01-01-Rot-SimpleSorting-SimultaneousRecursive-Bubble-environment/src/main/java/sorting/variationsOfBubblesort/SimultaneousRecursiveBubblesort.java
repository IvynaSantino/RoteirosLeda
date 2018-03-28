package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * Este algoritmo eh RECURSIVO e aplica o bubblesort na entrada empurrando os 
 * elementos grandes apra o final e trazendo os elementos menores para o início.
 * Dessa forma, ao final da primeira iteração, o menor elemento está na primeira
 * posição e o maioe elemento está na ultima. 
 * Nas proximas iterações as posicoes dos elementos das iterações anteriores
 * são excluidas do espaço de varredura do array.
 */
public class SimultaneousRecursiveBubblesort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (verifica(array, leftIndex, rightIndex)) {
			int inicio = leftIndex;
			int fim = rightIndex;
			
			if (inicio < rightIndex) {
				if (array[inicio].compareTo(array[inicio+1]) > 0) {
					Util.swap(array, inicio, inicio+1);
				}
				
				inicio++;
				sort(array, inicio, rightIndex);
			}
			
			if (fim > leftIndex) {
				if (array[fim].compareTo(array[fim-1]) < 0) {
					Util.swap(array, fim, fim-1);
				}
				
				fim--;
				sort(array, leftIndex, fim);
			}
		}
		
		
		
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
