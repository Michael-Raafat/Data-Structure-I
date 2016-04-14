package eg.edu.alexu.csd.datastructure.linkedList.cs59;
/**
 *
 * @author Michael
 *
 */
public class Node {
	/**
	 * value stored.
	 */
	private Object element;
	/**
	 * pointers to before and after.
	 */
	private Node next, prev;
	/**
	 * constructor with no data.
	 */
	public Node() {
		this.element = null;
		this.next = null;
		this.prev = null;
	}
	/**
	 * contructor with element.
	 * @param here
	 * element value
	 */
	public Node(final Object here) {
		this.element = here;
		this.next = null;
		this.prev = null;
	}
	/**
	 * constructor for single List.
	 * @param there
	 * next node.
	 * @param here
	 * element.
	 */
	public Node(final Node there, final Object here) {
		this.element = here;
		this.next = there;
		this.prev = null;
	}
	/**
	 * constructor for doubleList.
	 * @param there
	 * next node
	 * @param thiss
	 * previous node
	 * @param here
	 * element value
	 */
	public Node(final Node there, final Node thiss, final Object here) {
		this.element = here;
		this.next = there;
		this.prev = thiss;
	}
	/**
	 * set this node value to a certain value.
	 * @param here
	 * new value
	 */
	public final void setelement(final Object here) {
		this.element = here;
	}
	/**
	 * set this node next to a new value.
	 * @param there
	 * new value
	 */
	public final void setnext(final Node there) {
		this.next = there;
	}
	/**
	 * sets the previous node to a new value.
	 * @param there
	 * new value
	 */
	public final void setprev(final Node there) {
		this.prev = there;
	}
	/**
	 *
	 * @return
	 * returns element saved in the node.
	 */
	public final Object getele() {
		return this.element;
	}
	/**
	 *
	 * @return
	 * returns the next node saved in this node.
	 */
	public final Node getnext() {
		return this.next;
	}
	/**
	 *
	 * @return
	 * returns the previous node saved in this node.
	 */
	public final Node getprev() {
		return this.prev;
	}
}
