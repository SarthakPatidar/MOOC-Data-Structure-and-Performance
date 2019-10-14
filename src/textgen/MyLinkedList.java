package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = null;
		this.tail = null;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element) 
	{
		if(element == null)
			throw new NullPointerException();
		
		LLNode<E> newNode = new LLNode<E>(element);
		
		if(size == 0) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.prev = tail;
			newNode.next = null;
			tail.next = newNode;
			tail = newNode;
		}
		
		size += 1;
		
		return false;
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		LLNode<E> temp = head;
		// TODO: Implement this method.
		if(!((index >= 0 && (index < size)) || (index == 0 && size == 0))){
			throw new IndexOutOfBoundsException();
		}
		
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		
		return temp.data;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element == null)
			throw new NullPointerException();
		
		if(!((index >= 0 && (index < size)) || (index == 0 && size == 0))) {
			throw new IndexOutOfBoundsException();
		}		
		
		LLNode<E> newNode = new LLNode<E>(element);
		LLNode<E> temp = head;
		size += 1;
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		if(index == 0) {
			head.prev = newNode;
			newNode.next = head;
			newNode.prev = null;
			head = newNode;
			return;
		}
		
		for(int i=0;i<index-1;i++) {
			temp = temp.next;
		}
		newNode.prev = temp;
		newNode.next = temp.next;
		temp.next = newNode;
		newNode.next.prev = newNode;
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return this.size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{	
		// TODO: Implement this method
		if(!((index >= 0 && (index < size)) || (index == 0 && size == 0))) {
			throw new IndexOutOfBoundsException();
		}
		
		LLNode<E> tempNode = head;
		E removedData;
		
		if(index == 0) {
			removedData = head.data;
			head = head.next;
			size -= 1;
			return removedData;
		}
		
		if(index == size-1) {
			removedData = tail.data;
			tail = tail.prev;
			tail.next = null;
			size -= 1;
			return removedData;
		}
		
		for(int i=0;i<index;i++) {
			tempNode = tempNode.next;
		}
		removedData = tempNode.data;
		
		if(tempNode.next != null) {
			tempNode.next.prev = tempNode.prev;
		}
		
		if(tempNode.prev != null) {
			tempNode.prev.next = tempNode.next;
		}
		
		size -= 1;
		return removedData;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(element == null)
			throw new NullPointerException();
		
		if(!((index >= 0 && (index < size)) || (index == 0 && size == 0))) {
			throw new IndexOutOfBoundsException();
		}

		LLNode<E> temp = head;
		
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		
		E prev = temp.data;
		temp.data = element;
		
		return prev;
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
