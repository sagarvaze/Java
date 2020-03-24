public abstract class BinaryTree<E> {
    protected Node<E> root;

    protected static class Node<T> {
        protected T data;
        protected Node<T> left, right, parent;

        protected Node(T data, Node<T> parent) {
            this.parent = parent;
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }

    public String preorder() {
        return preorder(root);
    }

    private String preorder(Node<E> n) {
        if (n == null) return "";
        return (n + " " + preorder(n.left) + " " + preorder(n.right)).trim();
    }

    public String postorder() {
        return postorder(root);
    }

    private String postorder(Node<E> n) {
        if (n == null) return "";
        return (postorder(n.left) + " " + postorder(n.right) + " " + n).trim();
    }

    public String inorder() {
        return inorder(root);
    }

    private String inorder(Node<E> n) {
        if (n == null) return "";
        return (inorder(n.left) + " " + n + " " + inorder(n.right)).trim();
    }

    public String toString() {
        return inorder();
    }

    public String breadthFirst() {
        Queue<Node<E>> nodeQueue = new LinkedQueue<Node<E>>();
        StringBuilder breadthTraversal = new StringBuilder();
        nodeQueue.enqueue(root);
        while(!nodeQueue.isEmpty()) {
            Node<E> n = nodeQueue.dequeue();
            if (n != null) {
                nodeQueue.enqueue(n.left);
                nodeQueue.enqueue(n.right);
                if (n.data != null) breadthTraversal.append(n.data);
            }
        }
        return breadthTraversal.toString();
    }
}