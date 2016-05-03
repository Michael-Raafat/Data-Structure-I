package eg.edu.alexu.csd.datastructure.queue.cs59;
/**
 *
 * @author Michael.
 *
 */
public class Node {
	/**
	 * value of node.
	 */
	private Object vali;
	/**
	 * nodes.
	 */
	private Node next, prev;
	/**
	 * starting a node.
	 */
	public Node() {
		this.vali = null;
		this.next = null;
		this.prev = null;
	}
	/**
	 * setting a node with value and pointer to.
	 * to next node and the previous node.
	 * @param val of node.
	 * @param to node.
	 * @param from node.
	 */
	public Node(final Object val, final Node to, final Node from) {
		this.vali = val;
		this.next = to;
		this.prev = from;
	}
	/**
	 * set value to node.
	 * @param val
	 * the value of node
	 */
	public final void setElement(final Object val) {
		this.vali = val;
	}
	/**
	 * set previous node.
	 * @param from
	 * new value
	 */
	public final void setPrev(final Node from) {
		this.prev = from;
	}
	/**
	 * set next node.
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
		return this.vali;
	}
	/**
	 * get next node.
	 * @return next node.
	 */
	public final Node getNext() {
		return this.next;
	}
	/**
	 * get previous node.
	 * @return prev node.
	 */
	public final Node getPrev() {
		return this.prev;
	}

}
