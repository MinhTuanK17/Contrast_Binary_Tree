
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package contrast_binarytree;

/**
 *
 * @author MINH TUAN
 *
 *
 */

import java.util.*;

public class Using_Loop {

    static class Node {

        char data;
        Node left, right;
  
        Node(char x) {
            data = x;
            left = right = null;
        }
    }

    static Node buildTree(char inorder[], char postorder[], int n) {

        Stack<Node> st = new Stack<>();

        int postIndex = n - 1, inIndex = n - 1;
        boolean flag = false ;

        Node root = new Node(postorder[postIndex]);
        Node prev = root;

        postIndex--;
        st.push(root);

        while (postIndex >= 0) {
            if (!st.isEmpty() && inorder[inIndex] == st.peek().data) {
                prev = st.pop();
                inIndex--;
                flag = true;
            } else {
                Node node = new Node(postorder[postIndex]);
                if (!flag) {
                    prev.right = node;
                    prev = prev.right;
                } else {
                    prev.left = node;
                    prev = prev.left;
                    flag = false;
                }
                st.push(node);
                postIndex--;
            }
        }
        return root;
    }

    static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.printf("%c ", node.data);
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {

        char inorder[] = new char[]{'T', 'D', 'L', 'N', 'A', 'H', 'M', 'E'};
        char postorder[] = new char[]{'T', 'L', 'D', 'A', 'H', 'E', 'M', 'N'};
        int n = inorder.length;

        Node root = buildTree(inorder, postorder, n);
        System.out.print("Preorder of the constructed tree : \n");
        preOrder(root);
    }
}
