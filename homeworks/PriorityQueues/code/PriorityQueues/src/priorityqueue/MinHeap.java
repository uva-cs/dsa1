package priorityqueue;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> implements PriorityQueue<T> {

	/* The actual heap of data */
	private ArrayList<T> heap;
	
	public MinHeap() {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	public MinHeap(ArrayList<T> data) {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	private void heapify() {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	private void percolateUp(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	private void percolateDown(int index) {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	@Override
	public void push(T data) {
		/* TODO: IMPLEMENT THIS METHOD */
	}

	@Override
	public T poll() {
		/* TODO: IMPLEMENT THIS METHOD */
	}

	@Override
	public T peek() {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	@Override
	public int size() {
		/* TODO: IMPLEMENT THIS METHOD */
	}
	
	
}
