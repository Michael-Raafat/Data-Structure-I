package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 *
 * @author Michael
 *
 */
public class SingleList implements ILinkedList {
	/**
	 * list size.
	 */
	private int size = 0;
	/**
	 * list head.
	 */
	private Node head = new Node();

	@Override
	public final void add(final int index, final Object element) {

		// TODO Auto-generated method stub
		if (element.equals(null)) {
			throw new RuntimeException("ERROR");
		}
		if (index > size || index < 0) {
			throw new RuntimeException("ERROR");
		}
		if (index == 0) {
			if (size == 0) {
				head = new Node(null, element);
				size++;
			} else {
				Node temp;
				temp = head;
				head = new Node(temp, element);
				size++;
			}
		} else if (index == size) {
			Node temp = new Node(null, element);
			Node p = head;
			for (int i = 0; i < size - 1; i++) {
				p = p.getnext();
			}

			p.setnext(temp);
			size++;
		} else if (index > 0) {
			Node temp = new Node(element);
			Node p = head;
			for (int i = 0; i < index - 1; i++) {
				p = p.getnext();
			}
			temp.setnext(p.getnext());
			p.setnext(temp);
			size++;
		}
	}

	@Override
	public final void add(final Object element) {
		// TODO Auto-generated method stub
		if (element.equals(null)) {
			throw new RuntimeException("ERROR");
		}
		if (size == 0) {
			Node p = new Node(null, element);
			head = p;
		} else {
			Node temp = head;
			while (temp.getnext() != null) {
				temp = temp.getnext();
			}
			Node q = new Node(null, element);
			temp.setnext(q);
		}
		size++;
	}

	@Override
	public final Object get(final int index) {
		// TODO Auto-generated method stub
		if (index >= size || index < 0) {
			throw new RuntimeException();
		}
		Node temp = head;
		int i = 0;
		while (i < index) {
			temp = temp.getnext();
			i++;
		}
		return temp.getele();
	}

	@Override
	public final void set(final int index, final Object element) {
		// TODO Auto-generated method stub
		if ((index >= size && size != 0) || index < 0) {
			throw new RuntimeException();
		}
		if (index == 0) {
			head.setelement(element);
		} else if (index == size) {
			Node temp = new Node(element);
			Node p = head;
			for (int i = 0; i < size - 1; i++) {
				p = p.getnext();
			}
			temp.setnext(null);
			p.setnext(temp);

		} else {
			Node p = head;
			for (int i = 0; i < index; i++) {
				p = p.getnext();
			}
			p.setelement(element);
		}
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		head = new Node(null, null);
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
			p = temp;
			temp = temp.getnext();
			p.setnext(temp.getnext());
			temp.setnext(null);
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
			throw new RuntimeException("SUBBLIST");
		}
		Node m = head;
		for (int i = 1; i <= fromIndex; i++) {
			m = m.getnext();
		}
		SingleList dd = new SingleList();
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
		Node p = head;
		boolean flag = true;
		if (p.getele().equals(o)) {
			flag = false;
		}
		while (flag && p.getnext() != null) {
			p = p.getnext();
			if (p.getele().equals(o)) {
				flag = false;
			}

		}
		return !flag;
	}

}
