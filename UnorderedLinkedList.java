public abstract class UnorderedLinkedList<T> extends LinkedListClass<T> {
//Default constructor

	public UnorderedLinkedList() {
		super();
	}

	public boolean linearSearch(T key) {
	    LinkedListNode current = first;
	    while (current != null) {
	      if (current.info == key) {
	        return true;
	      } else {
	        current = current.link;
	      }
	    }
	    return false;
	  }

	public void bubbleSort() {
	    LinkedListNode<T> current = first;
	    while (current.link != null) {
	      Comparable<T> tmp = (Comparable<T>) current.info;
	      if (tmp.compareTo(current.link.info) > 0) {
	        T temp = current.info;
	        current.info = current.link.info;
	        current.link.info = temp;
	        temp = current.info;
	        current = first;
	      }
	      else {
	        current = current.link;
	      }
	    }
	  }

	public boolean binarySearch(T key) {
	    int middle = super.length() / 2;
	    int newMiddle = 0;
	    boolean found = false;
	    while (found == false) {
	      LinkedListNode<T> current = first;
	      Comparable<T> temp = (Comparable<T>) current.info;
	      int count = 0;
	      while (count != middle && current != null) {
	        current = current.link;
	        count++;
	      }
	      if (key == current.info) {
	        found = true;
	        return true;
	      }
	      else if (temp.compareTo(key) > 0) {
	        newMiddle = super.length() / middle;
	        middle = newMiddle;
	        found = false;
	      }
	      else if (temp.compareTo(key) < 0) {
	        newMiddle = (middle / 2) + 1;
	        middle = newMiddle;
	        found = false;
	      }
	    }
	    return false;
	  }
}