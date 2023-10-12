package comp301.inclass;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Alphabetizer implements Iterator<String> {
    private String[] strings;
    private String last;
    private String next;

    public Alphabetizer(String[] strings) {
        this.strings = strings;
        last = null;
        next = null;
    }


    @Override
    public boolean hasNext() {
        if (next != null) {
            return true;
        }
        for (int i=0; i<strings.length; i++) {
            String candidate = strings[i];
            if ((last == null) || (last.compareTo(candidate) < 0)) {
                // Candidate is possibly next
                if ((next == null) || (next.compareTo(candidate) > 0)) {
                    next = candidate;
                }
            }
        }

        return (next != null);
    }

    @Override
    public String next() {
        if (hasNext()) {
            last = next;
            next = null;
            return last;
        } else {
            throw new NoSuchElementException();
        }
    }
}
