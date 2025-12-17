public class DoublyLinkedList<T> {

    public static class Node<T> {
        T data;
        Node<T> prev;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    // Insertar al final
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Eliminar un elemento
    public void delete(T data) {
        if (head == null) return;

        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {

                // único elemento
                if (current == head && current == tail) {
                    head = null;
                    tail = null;
                }
                // borrar head
                else if (current == head) {
                    head = head.next;
                    head.prev = null;
                }
                // borrar tail
                else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                }
                // borrar nodo intermedio
                else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public int search(T data) {
        int index = 0;
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    // Invertir la lista
    public void reverse() {
        Node<T> current = head;
        Node<T> temp = null;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }

        Node<T> oldHead = head;
        head = tail;
        tail = oldHead;
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }
}
