package eg.edu.alexu.csd.datastructure.linkedList;
/**
 *
 * @author Michael
 *
 */
public interface ILinkedList {
	/**
	 * Inserts a specified element at the specified sposition in the list.
	 * @param index of list
	 * @param element of node
	 */
	public void add(int index, Object element);
	/**
	 * Inserts the specified element at the end of the list.
	 * @param element in a list
	 */
	public void add(Object element);
	/**
	 * Returns the element at the specified position in this list.
	 * @param index of element
	 */
	 public Object get(int index);
	/**
	 * Replaces the element at the specified position in this list with
	 * the specified element.
	 * @param index of element
	 * @param element itself
	 */
	 public void set(int index, Object element);
	/**
	 * Removes all of the elements from this list.
	 */
	 public void clear();
	/**
	 * Returns true if this list contains no elements.
	 */
	 public boolean isEmpty();
	/**
	 * Removes the element at the specified position in this list.
	 * @param index to be removed
	 */
	 public void remove(int index);
	/**
	 * Returns the number of elements in this list.
	 * @return size.
	 */
	 public int size();
	/**
	 * Returns a view of the portion of this list between the specified.
	 * @param fromIndex and
	 * @param toIndex end sublist
	 * inclusively.
	 */
	 public ILinkedList sublist(int fromIndex, int toIndex);
	/**
	 * Returns true if this list contains an element with the same value.
	 * as the specified element.
	 * @param o element.
	 * @return true or false
	 */
	 public boolean contains(Object o);



}
