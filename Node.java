
/**
 * Nodes for Binary Tree
 *
 * @author Abhi
 * @version 1 26 24
 */
public class Node<T> {
    private Node leftChild;
    private T info;
    private Node rightChild;

    public Node(T ch) {
        info = ch;
    }

    public Node getLeft() {
        return leftChild;
    }

    public Node getRight() {
        return rightChild;
    }

    public T getInfo() {
        return info;
    }
    
    public void setInfo(T info) {
        this.info = info;
    }
    
    public Node setLeft(Node l) {
        leftChild = l;
        return l;
    }

    public Node setRight(Node r) {
        rightChild = r;
        return r;
    }
}
