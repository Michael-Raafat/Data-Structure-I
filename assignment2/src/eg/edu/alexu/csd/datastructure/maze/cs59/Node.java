package eg.edu.alexu.csd.datastructure.maze.cs59;
/**
 *
 * @author Michael.
 *
 */
public class Node {
	/**
	 * mark as unvisited.
	 */
	private boolean visited;
	/**
	 * co-ordinates of node.
	 */
	private Object x, y, value;
	/**
	 * parent and child.
	 */
	private Node child, parent;
	/**
	 * nodes.
	 */
	private Node next, prev;
	/**
	 * initialize a node.
	 */
	public Node() {
		this.value = null;
		this.x = null;
		this.y = null;
		this.parent = null;
		this.child = null;
		this.visited = false;
		this.next = null;
		this.prev = null;
	}
	/**
	 * set value of node.
	 * @param val
	 * new value
	 */
	public final void setVal(final Object val) {
		this.value = val;
	}
	/**
	 * value.
	 * @return value.
	 */
	public final Object getVal() {
		return this.value;
	}
	/**
	 * set coordinates to node.
	 * @param xx x-axis
	 * @param yy y-axis
	 */
	public final void setCoordinates(final Object xx, final Object yy) {
		this.x = xx;
		this.y = yy;
	}
	/**
	 * set visited node.
	 * @param v
	 * new state
	 */
	public final void setVisited(final boolean v) {
		this.visited = v;
	}
	/**
	 * 
	 * @return
	 */
	public final boolean getVisited() {
		return this.visited;
	}
	/**
	 * set parent node.
	 * @param to
	 * new value
	 */
	public final void setParent(final Node to) {
		this.parent = to;
	}
	/**
	 * get x of node.
	 * @return x
	 */
	public final Object getx() {
		return this.x;
	}
	/**
	 * get y of node.
	 * @return y
	 */
	public final Object gety() {
		return this.y;
	}
	/**
	 * get parent node.
	 * @return parent node.
	 */
	public final Node getParent() {
		return this.parent;
	}

}

