/*
 * Decompiled with CFR 0.146.
 */
package tfu;

import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;
import tfu.Jf518;
import tfu.Jq519;

public class Jg365
extends AbstractCollection
implements Deque {
    int d;
    Object[] g;
    int j;
    int q;

    @Override
    public boolean removeLastOccurrence(Object object) {
        throw new UnsupportedOperationException();
    }

    public void addFirst(Object object) {
        this.d = this.d - 1 & this.g.length - 1;
        this.g[this.d] = object;
        if (this.q == this.d) {
            Jg365.z(this);
        }
        ++this.j;
    }

    public void addLast(Object object) {
        this.g[this.q] = object;
        this.q = this.q + 1 & this.g.length - 1;
        if (this.q == this.d) {
            Jg365.z(this);
        }
        ++this.j;
    }

    public Object removeLast() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        this.q = this.q - 1 & this.g.length - 1;
        Object object = this.g[this.q];
        this.g[this.q] = null;
        ++this.j;
        return object;
    }

    public Object removeFirst() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        Object object = this.g[this.d];
        this.g[this.d] = null;
        this.d = this.d + 1 & this.g.length - 1;
        ++this.j;
        return object;
    }

    public boolean offerLast(Object object) {
        this.addLast(object);
        return true;
    }

    @Override
    public void clear() {
        int n = this.d;
        while (n != this.q) {
            this.g[n] = null;
            n = n + 1 & this.g.length - 1;
        }
        this.q = this.d;
        ++this.j;
    }

    public Object pollLast() {
        if (this.q == this.d) {
            return null;
        }
        this.q = this.q - 1 & this.g.length - 1;
        Object object = this.g[this.q];
        this.g[this.q] = null;
        ++this.j;
        return object;
    }

    public Object getFirst() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        return this.g[this.d];
    }

    public Object getLast() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        return this.g[this.q - 1 & this.g.length - 1];
    }

    public Jg365() {
        this(8);
    }

    public Object peekLast() {
        if (this.q == this.d) {
            return null;
        }
        return this.g[this.q - 1 & this.g.length - 1];
    }

    @Override
    public Iterator iterator() {
        return new Jf518(this);
    }

    @Override
    public boolean add(Object object) {
        this.addLast(object);
        return true;
    }

    @Override
    public boolean offer(Object object) {
        this.addLast(object);
        return true;
    }

    @Override
    public Object remove() {
        return this.removeFirst();
    }

    public Object pop() {
        return this.removeFirst();
    }

    @Override
    public Object element() {
        return this.getFirst();
    }

    @Override
    public Object peek() {
        return this.peekFirst();
    }

    public void push(Object object) {
        this.addFirst(object);
    }

    public Iterator descendingIterator() {
        return new Jq519(this);
    }

    @Override
    public boolean isEmpty() {
        return this.q == this.d;
    }

    private static void z(Jg365 jg365) {
        Object[] arrobject = new Object[jg365.g.length << 1];
        int n = jg365.g.length - jg365.d;
        int n2 = arrobject.length - n;
        System.arraycopy(jg365.g, 0, arrobject, 0, jg365.q);
        System.arraycopy(jg365.g, jg365.d, arrobject, n2, n);
        jg365.g = arrobject;
        jg365.d = n2;
    }

    public boolean offerFirst(Object object) {
        this.addFirst(object);
        return true;
    }

    public Object peekFirst() {
        if (this.q == this.d) {
            return null;
        }
        return this.g[this.d];
    }

    public Jg365(int n) {
        int n2;
        for (n2 = 1; n2 < n; n2 <<= 1) {
        }
        if (n2 <= 0) {
            throw new IllegalArgumentException(n + " is out of range");
        }
        this.g = new Object[n2];
        this.q = 0;
        this.d = 0;
    }

    @Override
    public int size() {
        return this.q - this.d & this.g.length - 1;
    }

    @Override
    public boolean removeFirstOccurrence(Object object) {
        throw new UnsupportedOperationException();
    }

    public Object pollFirst() {
        if (this.q == this.d) {
            return null;
        }
        Object object = this.g[this.d];
        this.g[this.d] = null;
        this.d = this.d + 1 & this.g.length - 1;
        ++this.j;
        return object;
    }

    @Override
    public Object poll() {
        return this.pollFirst();
    }
}

