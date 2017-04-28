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
	 * @param val of node
	 * @param to node
	 */
	public Node(final Object val, final Node to) {
		this.value = val;
		this.next = to;
	}
	/**
	 * set value to node.
	 * @param val
	 * the value of node
	 */
	public final void setElement(final Object val) {
		this.value = val;
	}
	/**
	 * set next noode.
	 * @param to
	 * new value
	 */
	public final void setNext(final Node to) {
		this.next = to;
	}
	/**
	 * get value of node.
	 * @return value
	 */
	public final Object getElement() {
		return this.value;
	}
	/**
	 * get next node.
	 * @return next node.
	 */
	public final Node getNext() {
		return this.next;
	}

}
