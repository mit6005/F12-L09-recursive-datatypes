package beforeclass;

// Version of Im that gets Java to enforce proper access patterns & invariants
public class Im2<E> {
	
	// This part copied exactly from Im.java, with some "public" changed to "private".
	
    private static interface ImList<E> {
        public ImList<E> cons(E e);
        public E first();
        public ImList<E> rest();
    }

    private static class Empty<E> implements ImList<E> {
        public Empty() { }
        public ImList<E> cons(E e) { return new Cons<E>(e, this); }
        public E first() { throw new UnsupportedOperationException(); }
        public ImList<E> rest() { throw new UnsupportedOperationException(); }
    }

    private static class Cons<E> implements ImList<E> {
        private final E e;
        private final ImList<E> rest;

        public Cons(E e, ImList<E> rest) { this.e = e; this.rest = rest; }
        public ImList<E> cons(E e) { return new Cons<E> (e, this); }
        public E first() { return e; }
        public ImList<E> rest() { return rest; }
    }   
	
    // Now the new part!
    
	private final ImList<E> list;
	// Rep invariant: list references either an Empty or a Cons
	
	private Im2(ImList<E> list) {
		this.list = list;
	}
	
	public static <E> Im2<E> empty() {
		return new Im2<E>(new Empty<E>());
	}
	
	public static <E> Im2<E> add(E e, Im2<E> l) {
		return new Im2<E>(l.list.cons(e));
	}
	
	public static <E> E first(Im2<E> l) {
		return l.list.first();
	}
	
	public static <E> Im2<E> rest(Im2<E> l) {
		return new Im2<E>(l.list.rest());
	}
    
}
