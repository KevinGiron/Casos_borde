public class DoublyLinkedListTest {

    private static DoublyLinkedList<Integer> list;

    public static void main(String[] args) {
        testEmptyList();
        testInsertOnEmptyList();
        testDeleteSingleElement();
        testDeleteHead();
        testDeleteTail();
        testDeleteMiddle();
        testSearchNotFound();
        testSearchFound();
        testReverseEmpty();
        testReverseSingle();

        System.out.println("Todas las pruebas pasaron correctamente");
    }

    static void setUp() {
        list = new DoublyLinkedList<>();
    }

    static void testEmptyList() {
        setUp();
        assertNull(list.getHead(), "Head debería ser null");
        assertNull(list.getTail(), "Tail debería ser null");
    }

    static void testInsertOnEmptyList() {
        setUp();
        list.insert(10);
        assertEquals(list.getHead(), list.getTail(), "Head y Tail deben ser iguales");
        assertNull(list.getHead().prev, "Prev debería ser null");
        assertNull(list.getHead().next, "Next debería ser null");
    }

    static void testDeleteSingleElement() {
        setUp();
        list.insert(5);
        list.delete(5);
        assertNull(list.getHead(), "Head debería ser null");
        assertNull(list.getTail(), "Tail debería ser null");
    }

    static void testDeleteHead() {
        setUp();
        list.insert(1);
        list.insert(2);
        list.delete(1);
        assertNull(list.getHead().prev, "Prev del head debería ser null");
    }

    static void testDeleteTail() {
        setUp();
        list.insert(1);
        list.insert(2);
        list.delete(2);
        assertNull(list.getTail().next, "Next del tail debería ser null");
    }

    static void testDeleteMiddle() {
        setUp();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.delete(2);
        assertEquals(Integer.valueOf(3), list.getHead().next.data,
        "El siguiente del head debería ser 3");
    }

    static void testSearchNotFound() {
        setUp();
        assertEquals(-1, list.search(99), "Elemento no debería encontrarse");
    }

    static void testSearchFound() {
        setUp();
        list.insert(7);
        assertEquals(0, list.search(7), "Elemento debería encontrarse en índice 0");
    }

    static void testReverseEmpty() {
        setUp();
        list.reverse();
        assertNull(list.getHead(), "Head debería ser null");
        assertNull(list.getTail(), "Tail debería ser null");
    }

    static void testReverseSingle() {
        setUp();
        list.insert(4);
        list.reverse();
        assertEquals(list.getHead(), list.getTail(), "Head y Tail deben ser iguales");
    }


    static void assertNull(Object obj, String msg) {
        if (obj != null) {
            throw new RuntimeException("Fallo: " + msg);
        }
    }

    static void assertEquals(Object expected, Object actual, String msg) {
        if (expected == null && actual == null) return;
        if (expected != null && expected.equals(actual)) return;
        throw new RuntimeException(
            "Fallo: " + msg + " | esperado=" + expected + ", actual=" + actual
        );
    }

    static void assertEquals(int expected, int actual, String msg) {
        if (expected != actual) {
            throw new RuntimeException(
                "Fallo: " + msg + " | esperado=" + expected + ", actual=" + actual
            );
        }
    }
}
