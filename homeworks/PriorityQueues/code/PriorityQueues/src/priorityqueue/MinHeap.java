package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	private ArrayList<T> heap;
	
	public MinHeap() {
		//TODO: WRITE THIS METHOD
	}
	
	public MinHeap(ArrayList<T> data) {
		//TODO: WRITE THIS METHOD
	}
	
	private void heapify() {
		//TODO: WRITE THIS METHOD
	}
	
	private void percolateUp(int index) {
		//TODO: WRITE THIS METHOD
	}
	
	private void percolateDown(int index) {
		//TODO: WRITE THIS METHOD
	}
	
	@Override
	public void push(T data) {
		//TODO: WRITE THIS METHOD
	}

	@Override
	public T poll() {
		//TODO: WRITE THIS METHOD
		return null;
	}

	@Override
	public T peek() {
		//TODO: WRITE THIS METHOD
		return null;
	}
	
	@Override
	public int size() {
		//TODO: WRITE THIS METHOD
		return 0;
	}
}
