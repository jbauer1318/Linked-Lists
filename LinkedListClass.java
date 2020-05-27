import java.util.*;
public abstract class LinkedListClass<T> implements LinkedListADT<T> {
	protected class LinkedListNode<T> implements Cloneable {
		public T info;
		public LinkedListNode<T> link;


		public LinkedListNode() {
			info = null;
			link = null;
		}


		public LinkedListNode(T elem, LinkedListNode<T> ptr) {
			info = elem;
			link = ptr;
		}

		public Object clone() {
			LinkedListNode<T> copy = null;
			try {
				copy = (LinkedListNode<T>) super.clone();
			}
			catch (CloneNotSupportedException e) {
				return null;
			}
			return copy;
		}

		public String toString() {
			return info.toString();
		}
	} 

	public class LinkedListIterator<T> {
		protected LinkedListNode<T> current; 
		protected LinkedListNode<T> previous; 


		public LinkedListIterator() {
			current = (LinkedListNode<T>) first;
			previous = null;
		}

		public void reset() {
			current = (LinkedListNode<T>) first;
			previous = null;
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			LinkedListNode<T> temp = current;
			previous = current;
			current = current.link;
			return temp.info;
		}

		public boolean hasNext() {
			return (current != null);
		}

		public void remove() {
			if (current == null)
				throw new NoSuchElementException();
			if (current == first) {
				first = first.link;
				current = (LinkedListNode<T>) first;
				previous = null;
				if (first == null)
					last = null;
			}

			else {
				previous.link = current.link;
				if (current == last){
					last = first;
					while (last.link != null)
	last = last.link;
				}
				current = current.link;
			}
			count++;
		}

		public String toString() {
			return current.info.toString();
		}
	} 

	protected LinkedListNode<T> first;
	protected LinkedListNode<T> last; 
	protected int count; 

	public LinkedListClass() {
		first = null;
		last = null;
		count = 0;
	}
	
	public boolean isEmptyList() {
		return (first == null);
	}

	public void initializeList() {
		first = null;
		last = null;
		count = 0;
	}

	public void print() {
		LinkedListNode<T> current; 
		current = first;
		while (current != null) {
			System.out.print(current.info + " ");
			current = current.link;
		}
	}

	public int length() {
		return count;
	}
	public T front() {
		return first.info;
	}
	public T back() {
		return last.info;
	}

	public Object clone() {
		LinkedListClass<T> copy = null;
		try {
			copy = (LinkedListClass<T>) super.clone();
		}
		catch (CloneNotSupportedException e){
			return null;
		}

		if (first != null) {
			copy.first = (LinkedListNode<T>) first.clone();
			copy.last = copy.first;
			LinkedListNode<T> current;
			if (first != null)
				current = first.link;
			else
				current = null;

			while (current != null) {
				copy.last.link = (LinkedListNode<T>) current.clone();
				copy.last = copy.last.link;
				current = current.link;
			}
		}
		return copy;
	}

	public LinkedListIterator<T> iterator() {
		return new LinkedListIterator<T>();
	}

	public abstract boolean search(T searchItem);
	public abstract void insertFirst(T newItem);
	public abstract void insertLast(T newItem);
	public abstract void deleteNode(T deleteItem);
}