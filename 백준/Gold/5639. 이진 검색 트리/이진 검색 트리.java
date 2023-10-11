
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static Node root = null;
    public static class Node{
        Node left = null;
        Node right = null;
        int key;
    }
    public static void add(int key) {
        Node newNode = new Node();
        newNode.key = key;

        if(root == null) {
            root = newNode;
        } else {
            root = addNode(root, newNode);
        }
    }
    public static Node addNode(Node node, Node newNode) {
        if(node == null) {
            return newNode;
        } else if(node.key > newNode.key) {
            node.left = addNode(node.left, newNode);
        } else if(node.key < newNode.key){
            node.right = addNode(node.right, newNode);
        }
        return node;
    }
    public static void printNode(Node node) {
        if(node.left != null) {
            printNode(node.left);
        }
        if(node.right != null) {
            printNode(node.right);
        }
        System.out.println(node.key);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String line = br.readLine();
            if(line == null || line.equals("")) {
                break;
            }
            add(Integer.parseInt(line));
        }
        printNode(root);
    }
}
