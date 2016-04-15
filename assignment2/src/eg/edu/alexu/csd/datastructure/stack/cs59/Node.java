package eg.edu.alexu.csd.datastructure.stack.cs59;

/**
 * 
 * @author Michael.
 *
 */
public class Node {
	/**
	 * value of node.
	 */
	private Object value;
	/**
	 * nodes.
	 */
	private Node next;
	/**
	 * starting a node.
	 */
	public Node() {
		this.value = null;
		this.next = null;
	}
	/**
	 * setting a node with value and pointer to.
	 * to next node
	 */
	public Node(final Object value, final Node next) {
		this.value = value;
		this.next = next;
	}
	/**
	 * set value to node.
	 * @param value
	 * the value of node
	 */
	public final void setElement(final Object value) {
		this.value = value;
	}
	/**
	 * set next noode.
	 * @param there
	 * new value
	 */
	public final void setNext(final Node next) {
		this.next = next;
	}
	/**
	 * get value of node.
	 */
	public final Object getElement() {
		return this.value;
	}
	/**
	 * get next node.
	 */
	public final Node getNext() {
		return this.next;
	}

}
