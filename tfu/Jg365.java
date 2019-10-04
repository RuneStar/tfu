// 
// Decompiled by Procyon v0.5.36
// 

package tfu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Deque;
import java.util.AbstractCollection;

public class Jg365 extends AbstractCollection implements Deque
{
    int d;
    Object[] g;
    int j;
    int q;
    
    @Override
    public boolean removeLastOccurrence(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public void addFirst(final Object o) {
        this.d = (this.d - 1 & this.g.length - 1);
        this.g[this.d] = o;
        if (this.q == this.d) {
            z(this);
        }
        ++this.j;
    }
    
    @Override
    public void addLast(final Object o) {
        this.g[this.q] = o;
        this.q = (this.q + 1 & this.g.length - 1);
        if (this.q == this.d) {
            z(this);
        }
        ++this.j;
    }
    
    @Override
    public Object removeLast() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        this.q = (this.q - 1 & this.g.length - 1);
        final Object o = this.g[this.q];
        this.g[this.q] = null;
        ++this.j;
        return o;
    }
    
    @Override
    public Object removeFirst() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        final Object o = this.g[this.d];
        this.g[this.d] = null;
        this.d = (this.d + 1 & this.g.length - 1);
        ++this.j;
        return o;
    }
    
    @Override
    public boolean offerLast(final Object o) {
        this.addLast(o);
        return true;
    }
    
    @Override
    public void clear() {
        for (int i = this.d; i != this.q; i = (i + 1 & this.g.length - 1)) {
            this.g[i] = null;
        }
        this.q = this.d;
        ++this.j;
    }
    
    @Override
    public Object pollLast() {
        if (this.q == this.d) {
            return null;
        }
        this.q = (this.q - 1 & this.g.length - 1);
        final Object o = this.g[this.q];
        this.g[this.q] = null;
        ++this.j;
        return o;
    }
    
    @Override
    public Object getFirst() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        return this.g[this.d];
    }
    
    @Override
    public Object getLast() {
        if (this.q == this.d) {
            throw new NoSuchElementException();
        }
        return this.g[this.q - 1 & this.g.length - 1];
    }
    
    public Jg365() {
        this(8);
    }
    
    @Override
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
    public boolean add(final Object o) {
        this.addLast(o);
        return true;
    }
    
    @Override
    public boolean offer(final Object o) {
        this.addLast(o);
        return true;
    }
    
    @Override
    public Object remove() {
        return this.removeFirst();
    }
    
    @Override
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
    
    @Override
    public void push(final Object o) {
        this.addFirst(o);
    }
    
    @Override
    public Iterator descendingIterator() {
        return new Jq519(this);
    }
    
    @Override
    public boolean isEmpty() {
        return this.q == this.d;
    }
    
    private static void z(final Jg365 jg365) {
        final Object[] g = new Object[jg365.g.length << 1];
        final int n = jg365.g.length - jg365.d;
        final int d = g.length - n;
        System.arraycopy(jg365.g, 0, g, 0, jg365.q);
        System.arraycopy(jg365.g, jg365.d, g, d, n);
        jg365.g = g;
        jg365.d = d;
    }
    
    @Override
    public boolean offerFirst(final Object o) {
        this.addFirst(o);
        return true;
    }
    
    @Override
    public Object peekFirst() {
        if (this.q == this.d) {
            return null;
        }
        return this.g[this.d];
    }
    
    public Jg365(final int i) {
        int j;
        for (j = 1; j < i; j <<= 1) {}
        if (j <= 0) {
            throw new IllegalArgumentException(i + " is out of range");
        }
        this.g = new Object[j];
        final int n = 0;
        this.q = n;
        this.d = n;
    }
    
    @Override
    public int size() {
        return this.q - this.d & this.g.length - 1;
    }
    
    @Override
    public boolean removeFirstOccurrence(final Object o) {
        throw new UnsupportedOperationException();
    }
    
    @Override
    public Object pollFirst() {
        if (this.q == this.d) {
            return null;
        }
        final Object o = this.g[this.d];
        this.g[this.d] = null;
        this.d = (this.d + 1 & this.g.length - 1);
        ++this.j;
        return o;
    }
    
    @Override
    public Object poll() {
        return this.pollFirst();
    }
}
