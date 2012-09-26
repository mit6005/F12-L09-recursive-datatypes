package beforeclass;

import static org.junit.Assert.*;

import org.junit.Test;

import static beforeclass.Im.*;

public class ImTest {

	@Test
	public void test() {
		// nil := empty()
		ImList<Integer> nil = new Empty<Integer>();
		
		// cons(0, nil)
		nil.cons(0);
		
		// cons(0, cons(1, nil))
		nil.cons(1).cons(0);
		
		// x := cons(0, cons(1, nil))
		ImList<Integer> x = nil.cons(1).cons(0);
		
		// first(x)
		x.first();
		
		// rest(x)
		x.rest();
		
		// y := cons(4, rest(x))
		ImList<Integer> y = x.rest().cons(4);
		
		assertEquals((int)x.first(), 0);
		assertEquals((int)x.rest().first(), 1);
		assertEquals((int)y.first(), 4);
		assertEquals((int)y.rest().first(), 1);
	}

}
