public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public boolean contains(E item) {
        return findNode(item, root) != null;
    }

    private Node<E> findNode(E item, Node<E> n) {
        if (item == null || n == null) return null;
        int result = item.compareTo(n.data);
        if (result == 0) {
            return n;
        }
        else if (result < 0) {
            return findNode(item, n.left);
        } else {
            return findNode(item, n.right);
        }
    }

    public E min() {
        Node<E> n = minNode(root);
        return (n != null) ? n.data : null;
    }

    private Node<E> minNode(Node<E> n) {
        if (n.left == null) return n;
        else return minNode(n.left);
    }

    public E max() {
        Node<E> n = maxNode(root);
        return (n != null) ? n.data : null;
    }

    private Node<E> maxNode(Node<E> n) {
        if (n.right == null) return n;
        else return maxNode(n.right);
    }

    public E pred(E item) {
        Node<E> n = findNode(item, root);
        if (n == null) return null;
        Node<E> pred = predNode(n);
        return (pred != null) ? pred.data : null;
    }

    private Node<E> predNode(Node<E> n) {
        if (n.left != null) return maxNode(n.left);
        Node<E> p = n.parent;
        while (p != null && p.right != n) {
            n = p;
            p = n.parent;
        }
        return p;
    }

    public E succ(E item) {
        Node<E> n = findNode(item, root);
        if (n == null) return null;
        Node<E> succ = succNode(n);
        return (succ != null) ? succ.data : null;
    }

    private Node<E> succNode(Node<E> n) {
        if (n.right != null) return minNode(n.right);
        Node<E> s = n.parent;
        while (s != null && s.left != n) {
            n = s;
            s = n.parent;
        }
        return s;
    }

    public void add(E item) {
        if (item == null) return;
        if (root == null) root = new Node<E>(item, null);
        else addNode(item, root);
    }

    private void addNode(E item, Node<E> n) {
        assert item != null && n != null;
        int result = item.compareTo(n.data);
        if (result < 0) {
            if (n.left == null) {
                n.left = new Node<E>(item, n);
                return;
            } else 
                addNode(item, n.left);
        } else {
            if (n.right == null) {
                n.right = new Node<E>(item, n);
                return;
            } else 
                addNode(item, n.right);
        }
    }

    public boolean remove(E item) {
        Node<E> n = findNode(item, root);
        if (n == null) return false;
        else {
            removeNode(n);
            return true;
        }
    }

    private void removeNode(Node<E> n) {
        if (n.left == null) replaceNode(n, n.right);
        else if (n.right == null) replaceNode(n, n.left);
        else {
            Node<E> p = predNode(n);
            n.data = p.data;
            removeNode(p);
        }
    }

    private void replaceNode(Node<E> src, Node<E> rep) {
        if (src.parent == null) {
            root = rep;
        }
        else if (src.parent.left == src) src.parent.left = rep;
        else src.parent.right = rep;
    }

    public static void main(String [] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Integer[] contents = {9, 10, 33, 43, 73, 47, 27, 67, 36, 49, 59, 89};
        for (Integer cont : contents) {
            bst.add(cont);
        }
        System.out.println(bst.toString());
        System.out.println(bst.max());
        System.out.println(bst.min());
        System.out.println(bst.succ(67));
        System.out.println(bst.pred(33));
        bst.remove(59);
        System.out.println(bst.toString());
    }
}