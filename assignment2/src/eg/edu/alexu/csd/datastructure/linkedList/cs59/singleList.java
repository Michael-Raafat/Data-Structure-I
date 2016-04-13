package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
/**
 * @author Michael.
 *
 */
public class singleList implements ILinkedList {
    /**
     * size of list.
     */
	private int size = 0;
	/**
	 * head node.
	 */
    private node head = new node();

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
				head = new node(null, element);
				size++;
			} else {
				node temp;
				temp = head;
				head = new node(temp, element);
				size++;
			}
		} else if (index == size) {
			node temp = new node(null, element);
			node p = head;
			for (int i = 0; i < size - 1; i++) {
				p = p.getnext();
			}

			p.setnext(temp);
			size++;
		} else if (index > 0) {
			node temp = new node(element);
			node p = head;
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
			node p = new node(null, element);
			head = p;
		} else {
		    node temp = head;
			while (temp.getnext() != null) {
				temp = temp.getnext();
			}
			node q = new node(null, element);
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
		node temp = head;
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
			node temp = new node(element);
			node p = head;
			for (int i = 0; i < size - 1; i++) {
				p = p.getnext();
			}
			temp.setnext(null);
			p.setnext(temp);
		} else {
			node p = head;
			for (int i = 0; i < index; i++) {
				p = p.getnext();
			}
			p.setelement(element);
		}
	}

	@Override
	public final void clear() {
		// TODO Auto-generated method stub
		head = new node(null, null);
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
		node temp;
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
			node p;
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
        if (fromIndex < 0
        		||
        		toIndex >= size
        		||
        		fromIndex > toIndex
        		||
        	    size == 0) {
			throw new RuntimeException("SUBBLIST");
		}
		node m = head;
		for (int i = 1; i <= fromIndex; i++) {
			m = m.getnext();
		}
		singleList dd = new singleList();
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
		node p = head;
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
