import java.util.ArrayList;
import java.util.Scanner;

class BinarySearchTree {
    /* Class containing left
       and right child of current node
     * and key value*/
    ArrayList arr = new ArrayList();
    class Node {
        int key;
        Node left, right;

        public Node(int item)
        {
            key = item;
            left = right = null;
        }
    }

    // Root of BST
    Node root;

    // Constructor
    BinarySearchTree() { root = null; }

    BinarySearchTree(int value) { root = new Node(value); }

    // This method mainly calls insertRec()
    void insert(int key) { root = insertRec(root, key); }

    /* A recursive function to
       insert a new key in BST */
    Node insertRec(Node root, int key)
    {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key){
            root.left = insertRec(root.left, key);
        }

        else if (key > root.key){
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void preorder() {
        preorderRec(root);
    }

    void preorderRec(Node root)
    {
        if (root != null) {
//            System.out.print(root.key + ",");
            arr.add(root.key);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Driver Code
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        while(n > 0){
            BinarySearchTree tree = new BinarySearchTree();
            String[] str = sc.nextLine().split(",");
            for(int i=0;i<str.length;i++){
                tree.insert(Integer.parseInt(str[i]));
            }

            tree.preorder();
            for(int i=0; i<tree.arr.size(); i++){
                if(i==tree.arr.size()-1)System.out.print(tree.arr.get(i));
                else System.out.print(tree.arr.get(i)+",");
            }
            System.out.println();

            n--;
        }
    }
}