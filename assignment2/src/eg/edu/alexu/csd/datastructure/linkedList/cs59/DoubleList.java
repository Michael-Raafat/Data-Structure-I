package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 *
 * @author Michael
 *
 */
public class DoubleList implements ILinkedList {
	/**
	 * List head.
	 */
	private Node head;
	/**
	 * List size.
	 */
	private int size;
	/**
	 * List constructor.
	 */
	public DoubleList() {
		head = new Node();
		size = 0;
	}

	@Override
	public final void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (element.equals(null)) {
			throw new RuntimeException();
		}
		if (index == 0 && size == 0) {
			Node u = new Node(null, null, element);
			head = u;
			size++;
		} else if (index < 0 || index > size) {
			throw new RuntimeException();
		} else if (index == 0) {
			Node f = head;
			Node u = new Node(f, null, element);
			head = u;
			size++;
		} else if (index < size) {
			Node s = head;
			Node m = new Node(element);
			for (int i = 1; i < index; i++) {
				s = s.getnext();
			}
			Node x = s.getnext();
			m.setnext(x);
			m.setprev(s);
			x.setprev(m);
			s.setnext(m);
			size++;
		} else {
			Node s = head;
			Node m = new Node(element);
			for (int i = 1; i < index; i++) {
				s = s.getnext();
			}
			s.setnext(m);
			m.setprev(s);
			size++;
		}
	}

	@Override
	public final void add(final Object element) {
		// TODO Auto-generated method stub
		if (element.equals(null)) {
			throw new RuntimeException();
		}
		if (size == 0) {
			head.setelement(element);
		} else {
			Node s = head;
			Node m = new Node(element);
			while (s.getnext() != null) {
				s = s.getnext();
			}
			s.setnext(m);
			m.setprev(s);
		}
		size++;

	}

	@Override
	public final Object get(final int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		Node m = head;
		for (int i = 1; i <= index; i++) {
			m = m.getnext();
		}
		return m.getele();
	}

	@Override
	public final void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		Node m = head;
		for (int i = 1; i <= index; i++) {
			m = m.getnext();
		}
		m.setelement(element);
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		head = new Node(null, null, null);
		size = 0;
	}

	@Override
	public final boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public final void remove(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		}
		Node temp;
		if (size == 1) {
			this.clear();
		} else if (index == 0) {
			temp = head;
			head = head.getnext();
			head.setprev(null);
			size--;
		} else if (index == size - 1) {
			int i = 0;
			temp = head;
			while (i < index - 1) {
				temp = temp.getnext();
				i++;
			}
			temp.setnext(null);
			size--;
		} else {
			int i = 0;
			temp = head;
			while (i < index - 1) {
				temp = temp.getnext();
				i++;
			}
			Node p;
			Node f;
			p = temp;
			temp = temp.getnext();
			f = temp.getnext();
			p.setnext(f);
			temp.setnext(null);
			temp.setprev(null);
			f.setprev(p);
			size--;
		}
	}

	@Override
	public final int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public final ILinkedList sublist(
			final int fromIndex, final int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 0 || toIndex >= size
				|| fromIndex > toIndex || size == 0) {
			throw new RuntimeException();
		}
		Node m = head;
		for (int i = 1; i <= fromIndex; i++) {
			m = m.getnext();
		}
		DoubleList dd = new DoubleList();
		dd.add(m.getele());
		for (int i = fromIndex; i < toIndex; i++) {
			m = m.getnext();
			dd.add(m.getele());
		}
		return dd;
	}

	@Override
	public final boolean contains(final Object o) {
		// TODO Auto-generated method stub
		boolean found = false;
		if (size == 0 || o.equals(null)) {
			return found;
		}
		Node z = head;
		if (z.getele().equals(o)) {
			found = true;
		}
		while (z.getnext() != null && !found) {
			z = z.getnext();
			if (z.getele().equals(o)) {
				found = true;
			}
		}
		return found;
	}

}

