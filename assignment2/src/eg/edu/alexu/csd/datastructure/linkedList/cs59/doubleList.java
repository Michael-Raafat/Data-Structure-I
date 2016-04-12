package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class doubleList implements ILinkedList {

	private node head;
	private int size;

	public doubleList() {
		head = new node();
		size = 0;
	}

	@Override
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		if (element.equals(null))
			throw new RuntimeException();
		if (index == 0 && size == 0) {
			node U = new node(null, null, element);
			head = U;
			size++;
		} else if (index < 0 || index > size) {
			throw new RuntimeException();
		} else if (index == 0) {
			node F = head;
			node U = new node(F, null, element);
			head = U;
			size++;
		} else if (index < size) {
			node s = head;
			node m = new node(element);
			for (int i = 1; i < index; i++) {
				s = s.getnext();
			}
			node x = s.getnext();
			m.setnext(x);
			m.setprev(s);
			x.setprev(m);
			s.setnext(m);
			size++;
		} else {
			node s = head;
			node m = new node(element);
			for (int i = 1; i < index; i++) {
				s = s.getnext();
			}
			s.setnext(m);
			m.setprev(s);
			size++;
		}
	}

	@Override
	public void add(Object element) {
		// TODO Auto-generated method stub
		if (element.equals(null))
			throw new RuntimeException();
		if (size == 0) {
			head.setelement(element);
		} else {
			node s = head;
			node m = new node(element);
			while (s.getnext() != null) {
				s = s.getnext();
			}
			s.setnext(m);
			m.setprev(s);
		}
		size++;

	}

	@Override
	public Object get(int index) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		node m = head;
		for (int i = 1; i <= index; i++) {
			m = m.getnext();
		}
		return m.getele();
	}

	@Override
	public void set(int index, Object element) {
		// TODO Auto-generated method stub
		if (index < 0 || index >= size) {
			throw new RuntimeException();
		}
		node m = head;
		for (int i = 1; i <= index; i++) {
			m = m.getnext();
		}
		m.setelement(element);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		head = new node(null, null, null);
		size = 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0)
			return true;
		return false;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		/*
		 * if(size<1 || index <0 || index >=size) { throw new
		 * RuntimeException(); } node m =head; if(size==1) { this.clear(); }
		 * else if(index==0) { node n = head.getnext(); head=n;
		 * head.setprev(null); size--; } else if(index==size-1) { for(int
		 * i=1;i<index-1;i++) { m = m.getnext(); } if(m.getnext()!=null) {
		 * m=m.getnext(); m.setnext(null); size--; } else { return; } } else {
		 * for(int i=1;i<=index;i++) { m = m.getnext(); } if(m.getprev()==null)
		 * { node n = m.getnext(); m.setnext(null); m.setprev(null);
		 * n.setprev(null); } else if(m.getnext()==null) { node p = m.getprev();
		 * m.setnext(null); m.setprev(null); p.setnext(null); } else { node p =
		 * m.getprev(); node n = m.getnext(); m.setnext(null); m.setprev(null);
		 * p.setnext(n); n.setprev(p); } size--; }
		 */
		if (index >= size || index < 0)
			throw new RuntimeException();
		node temp;
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
			node p;
			node f;
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
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex || size == 0) {
			throw new RuntimeException();
		}
		node m = head;
		for (int i = 1; i <= fromIndex; i++) {
			m = m.getnext();
		}
		doubleList dd = new doubleList();
		dd.add(m.getele());
		for (int i = fromIndex; i < toIndex; i++) {
			m = m.getnext();
			dd.add(m.getele());
		}
		return dd;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		boolean found = false;
		if (size == 0 || o.equals(null))
			return found;
		node z = head;
		if (z.getele().equals(o))
			found = true;
		while (z.getnext() != null && !found) {
			z = z.getnext();
			if (z.getele().equals(o))
				found = true;
		}
		return found;
	}

}