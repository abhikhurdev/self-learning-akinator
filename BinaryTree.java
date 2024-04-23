import java.util.Stack;
import java.util.*;

/**
 * BinaryTree class
 *
 * @author Abhi K
 * @version 1 26 24
 */
public class BinaryTree<T>
{
    private Node root;

    public BinaryTree() {
        root = null;
    }
    
    public BinaryTree(T info) {
        root = new Node(info);
    }
    
    public Node getRoot(){
        return root;
    }

    public void display() {
        display(root, 0);
        System.out.println();
    }

    public void display(Node subtree, int level) { //recursive
        if(subtree == null) return;

        display(subtree.getRight(), level + 1);

        for(int i = 0; i < level; i++)
            System.out.print("\t");

        System.out.println(subtree.getInfo());

        display(subtree.getLeft(), level + 1);
    }
    
    public void preorderStack() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.empty()) {
            Node currNode = stack.pop();

            if(currNode.getRight() != null)
                stack.push(currNode.getRight());
            if(currNode.getLeft() != null)
                stack.push(currNode.getLeft());

            System.out.print(currNode.getInfo());
        }
        System.out.println();
    }

    public void preorderRecursion() {
        preorderRecursion(root);
        System.out.println();
    }

    public void preorderRecursion(Node n) {
        if(n == null) return;
        System.out.print(n.getInfo());
        preorderRecursion(n.getLeft());
        preorderRecursion(n.getRight());
    }

    public void inorderRecursion() {
        inorderRecursion(root);
        System.out.println();
    }

    public void inorderRecursion(Node n){
        if(n == null) return;
        inorderRecursion(n.getLeft());
        System.out.print(n.getInfo());
        inorderRecursion(n.getRight());
    }

    public void postorderRecursion() {
        postorderRecursion(root);
        System.out.println();
    }

    public void postorderRecursion(Node n) {
        if(n == null) return;
        postorderRecursion(n.getLeft());
        postorderRecursion(n.getRight());
        System.out.print(n.getInfo());

    }

    public void levelorderQueue(){
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()) {
            Node currNode = queue.remove();

            if(currNode.getLeft() != null)
                queue.add(currNode.getLeft());
            if(currNode.getRight() != null)
                queue.add(currNode.getRight());

            System.out.print(currNode.getInfo());
        }
        System.out.println();
    }

    public int heightRecursion(){
        return heightRecursion(root);
    }

    public int heightRecursion(Node n){
        if(n == null){
            return -1;
        }
        int left = heightRecursion(n.getLeft())+1;
        int right = heightRecursion(n.getRight())+1;
        return Math.max(left, right);
    }

    public void inorderStack() {
        Stack<Node> stack = new Stack<Node>();
        Node currNode = root;
        do {
            if(currNode.getLeft()==null&&currNode.getRight()==null){
                System.out.print(currNode.getInfo());
                currNode = stack.pop();
                System.out.print(currNode.getInfo());
                currNode = stack.pop();
            }
            if(currNode.getRight() != null)
                stack.push(currNode.getRight());
            stack.push(currNode);
            if(currNode.getLeft() != null)
                stack.push(currNode.getLeft());
            currNode = stack.pop();

            


        }while(!stack.empty());
        System.out.println();
    }

    public void postorderStack() {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.empty()) {
            Node currNode = stack.pop();

            if(currNode.getRight() != null)
                stack.push(currNode.getRight());
            if(currNode.getLeft() != null)
                stack.push(currNode.getLeft());

            System.out.print(currNode.getInfo());
        }
        System.out.println();
    }

    public void levelorderRecursion() {
        levelorderRecursion(root);
        System.out.println();
    }

    public void levelorderRecursion(Node n) {
        if(n == null) return;
        levelorderRecursion(n.getLeft());
        levelorderRecursion(n.getRight());
        System.out.print(n.getInfo());

    }
}
