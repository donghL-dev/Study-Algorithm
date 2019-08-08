package summercamp;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<String> implements List<String> {

    private int size;

    private String[] array;

    public MyArrayList() {
        this.size = 0;
        this.array = (String[]) new Object[5];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public boolean add(String element) {
        if(size >= array.length) {
            String[] bigger = (String[]) new Object[array.length*2];
            System.arraycopy(array, 0 , bigger, 0, array.length);
            array = bigger;
        }
        array[size] = element;
        size++;
        return true;
    }

    @Override
    public void add(int index, String element) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        add(element);

        for(int i=size-1; i>index; i--) {
            array[i] = array[i-1];
        }

        array[index] = element;
    }

    @Override
    public boolean addAll(Collection<? extends String> collection) {
        boolean flag = true;
        for(String element : collection) {
            flag &= add(element);
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> collection) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        boolean flag = true;

        for(String element : collection) {
            flag &= add(element);
        }

        for(int i=size-1; i>index; i--) {
            if(i-collection.size() > 0)
                array[i] = array[i-collection.size()];
        }

        for(String element : collection) {
            array[index++] = element;
        }

        return flag;
    }

    @Override
    public int indexOf(Object object) {
        for(int i=0; i<size; i++) {
            if(equals(object, array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public boolean contains(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object element : collection) {
            if(!(contains(element)))
                return false;
        }
        return true;
    }

    @Override
    public String get(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String set(int index, String element) {
        String old = get(index);
        array[index] = element;
        return old;
    }

    private boolean equals(Object target, Object element) {
        if(target == null)
            return element == null;
        else
            return target.equals(element);
    }

    @Override
    public int lastIndexOf(Object object) {
        for(int i=size-1; i>=0; i--) {
            if(equals(object, array[i]))
                return i;
        }
        return -1;
    }

    @Override
    public ListIterator<String> listIterator() {
        return null;
    }

    @Override
    public ListIterator<String> listIterator(int index) {
        return null;
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for(Object element : collection) {
            flag &= remove(element);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public Iterator<String> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean remove(Object object) {
        if(!contains(object))
            return false;
        remove(indexOf(object));
        return true;
    }

    @Override
    public String remove(int index) {

        String old = get(index);

        for(int i=size-1; i>index; i--) {
            array[i-1] = array[i];
        }

        size--;
        array[size] = null;

        return old;
    }
}
