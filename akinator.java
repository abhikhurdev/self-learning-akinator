import java.util.Scanner;
import java.io.*;

/**
 * twenty questions/self-learning akinator
 *
 * @author Abhi K
 * @version 2 5 24
 */
public class akinator
{
    public static void main(String args[]) throws IOException{
        Scanner scan = new Scanner(System.in);
        //Questions import later
        BinaryTree qs = makeTree();
        Node currNode = qs.getRoot();
        boolean isRunning = true;
        // ends when 
        while(isRunning){
            System.out.println("Think of a TV show.");
            currNode = qs.getRoot();
            while(currNode.getRight()!=null){
                System.out.println(currNode.getInfo() + " n/y");
                String input = scan.nextLine();
                switch(input){
                    case "n": 
                        currNode = currNode.getLeft();
                        continue;
                    case "y":
                        currNode = currNode.getRight();
                        continue;
                    default: 
                        System.out.println("invalid input please try again");
                        continue;
                }
            }    
            System.out.println("Thank you for playing, are you thinking of " + currNode.getInfo() + "? n/y (q to quit)");
            String input = scan.nextLine();
            switch(input){
                case "n": 
                    System.out.println("What were you thinking of?");
                    String thought = scan.nextLine();
                    System.out.println("What is a distinguishing question between " + thought + " and " + currNode.getInfo() + "?");
                    String nqs = scan.nextLine();
                    System.out.println("Is " + thought + " a n/y to this question?");
                    String answer = scan.nextLine();
                    learnQ(currNode, nqs, thought, answer);
                    continue;
                case "y":
                    continue;
                case "q":
                    isRunning = false;
                    break;
                default: 
                    System.out.println("invalid input please try again");
                    continue;
            }
            writeFile(qs.getRoot());
        }
    }
    private static void learnQ(Node n, String q, String t, String a){
        String temp = (String)n.getInfo();
        n.setInfo(q);
        while(true) {
            switch(a){
                case "n": 
                    n.setLeft(new Node<String>(t));
                    n.setRight(new Node<String>(temp));
                    break;
                case "y":
                    n.setLeft(new Node<String>(temp));
                    n.setRight(new Node<String>(t));
                    break;
                default:
                    n.setInfo(temp);
                    break;
            }
            break;
        }
    }

    private static BinaryTree makeTree()throws IOException{
        Scanner file = new Scanner(new File("tree.txt"));
        BinaryTree<String> qs = new BinaryTree<String>("");
        Node currNode = qs.getRoot();
        readFile(file, currNode);        

        return qs;
    }

    private static void readFile(Scanner s, Node n){
        if(n==null)return;
        String next = s.nextLine();
        if(next.substring(0,1).equals("Q")){
            n.setInfo(next.substring(1));
            readFile(s, n.setLeft(new Node("")));
            readFile(s, n.setRight(new Node("")));
            return;
        }
        
        n.setInfo(next.substring(1));
    }
    private static void writeFile(Node root)throws IOException{
        PrintWriter writer = new PrintWriter(new File("tree.txt"));
        preorderRecursion(writer, root);
        writer.close();

    }

    private static void preorderRecursion(PrintWriter pw, Node n){
        if(n == null) return;
        if(n.getLeft()!=null)
        pw.print("Q");
        else
        pw.print("A");
        
        pw.println(n.getInfo());
    
        preorderRecursion(pw, n.getLeft());
        preorderRecursion(pw, n.getRight());
    }
}