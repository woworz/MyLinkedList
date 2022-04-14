package com.my.Fater;

import java.util.Iterator;

public class LinkedListFather {

    public LinkedListFather() {

    }

    /**
     * Returns an iterator over the elements contained in this collection.
     */
    public Iterator iterator() {
        return null;
    }

    /**
     * Returns true if this collection contains the specified element.
     */
    public boolean contains(Object obj) {
        Iterator it = iterator();
        if (obj == null)
        {
            while (it.hasNext())
                if (it.next() == null)
                    return true;
        } else {
            while (it.hasNext())
                if (obj.equals(it.next()))
                    return true;
        }
        return false;
    }

    public int size() {
        return 0;
    }

    /***
     * Retains only the elements in this collection that are contained in the specified collection (optional operation).
     */
    public boolean remove(Object obj) {
        Iterator it = iterator();
        if (obj==null) {
            while (it.hasNext()) {
                if (it.next()==null) {
                    it.remove();
                    return true;
                }
            }
        } else {
            while (it.hasNext()) {
                if (obj.equals(it.next())) {
                    it.remove();
                    return true;
                }
            }
        }
        return false;
    }
}
