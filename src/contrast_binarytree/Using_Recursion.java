

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author MINH TUAN
 *
 *
 */
class Node {

    char data;
    Node left, right;

    public Node(char data) {
        this.data = data;
        left = right = null;
    }
}

public class Using_Recursion {

    Node constructTree(char postorder[], char inorder[], int[] postIndex, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        if (postIndex[0] < 0) {
            return null;
        }
        Node node = new Node(postorder[postIndex[0]]);
        postIndex[0]--;

        if (inStart == inEnd) {
            return node;  
        }
        
        int iIndex = search(inorder, inStart, inEnd, node.data);
        node.right = constructTree(postorder, inorder, postIndex, iIndex + 1, inEnd);
        node.left = constructTree(postorder, inorder, postIndex, inStart, iIndex - 1);

        return node;
    }

    int search(char arr[], int strt, int end, int value) {
        int i;
        for (i = strt; i <= end; i++) {
            if (arr[i] == value) {
                break;
            }
        }
        return i;          
    }

    void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        Using_Recursion tree = new Using_Recursion();
        char inorder[] = new char[]{'T', 'D', 'L', 'N', 'A', 'H', 'M', 'E'};
        char postorder[] = new char[]{'T', 'L', 'D', 'A', 'H', 'E', 'M', 'N'};
        int[] postIndex = {postorder.length - 1};
        Node root = tree.constructTree(postorder, inorder, postIndex, 0, inorder.length - 1);

        System.out.println("Preorder of the constructed tree : ");
        tree.preOrder(root);
    }
}
