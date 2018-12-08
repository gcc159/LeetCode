package Design.Peeking_Iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
    private List<Integer> contents;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        contents=new LinkedList<>();
        while(iterator.hasNext()){
            contents.add(iterator.next());

        }

    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return contents.get(0);
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {

        Integer res=null;
        if(!contents.isEmpty()) {
            res=contents.get(0);
            contents.remove(0);
        }
        return res;

    }

    @Override
    public boolean hasNext() {
        return !contents.isEmpty();
    }

}
