package eg.edu.alexu.csd.datastructure.linkedList.cs59;
/**
 * @author Michael.
 *
 */
public class node {
    /**
     * object element.
     */
    private Object element;
    /**
     *nodes next and previous. 
     */
	private node next, prev;
    /**
     * Any node.
     */
	public node() {	
		this.element = null;
        this.next = null;
		this.prev = null;
	}
    /**
     * @param here
     * value of node.
     */
	public node(final Object here) {
		this.element = here;
		this.next = null;
		this.prev = null;
	}
	/**
	 * @param there
	 * to set next node.
	 * @param here
	 * to set the value.
	 */
	public node(final node there, final Object here) {
		this.element = here;
		this.next = there;
		this.prev = null;
    }
    /**
     * @param there
     * to set next node.
     * @param thiss
     * to set previous node.
     * @param here
     * to set value of node.
     */
	public node(final node there, final node thiss, final Object here) {
		this.element = here;
		this.next = there;
		this.prev = thiss;
        }
	/**
	 * @param here
	 * to set element.
	 */

	public final void setelement(final Object here) {
		this.element = here;
    }
    /**
     * @param there
     * set next node.
     */
	public final void setnext(final node there) {
		this.next = there;
	}
    /**
     * @param there.
     * set previous node.
     */
	public final void setprev(final node there) {
		this.prev = there;
	}
    /**
     * @return value of node.
     */
	public final Object getele() {
		return this.element;
	}
	/**
     * @return node of next.
     */
	public final node getnext() {
	    return this.next;
	    }
	/**
     * @return node of previous.
     */
	public final node getprev() {
		return this.prev;
        }
}
