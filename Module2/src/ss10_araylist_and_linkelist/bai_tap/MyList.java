package ss10_araylist_and_linkelist.bai_tap;

import java.util.Arrays;

public class MyList<E> {
    int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int CAPACITY) {
        elements = new Object[CAPACITY];
    }

    public boolean add(E element) {
        if (size == elements.length) {
            this.ensureCapacity(5);
        }
        elements[size++] = element;

        return true;
    }

    public void add(E element, int index) {
        if (index > elements.length) {
            throw new IllegalArgumentException("index: " + index);
        } else if (index == elements.length) {
            this.ensureCapacity(5);
        }

        if (elements[index] == null) {
            elements[index] = element;
            size++;
        } else {
            for (int i = size + 1; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        }
    }


    public void ensureCapacity(int minCapcity) {
        if (minCapcity >= 0) {
            int newSize = elements.length + minCapcity;
            elements = Arrays.copyOf(elements, newSize);
        }
    }


}
