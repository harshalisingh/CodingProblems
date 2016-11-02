package leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * http://www.geeksforgeeks.org/iterative-preorder-traversal/
 */
public class BinaryTreeTraversal {

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }
    
    public void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    public void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //Iterative Inorder Traversal
    public void inorderItr(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode node = root;
        while(true){
            if(node != null){
                stack.push(node);
                node = node.left;
            }
            else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();
                System.out.println(node.data);
                node = node.right;
            }
        }
    }
    
    //Iterative Preorder Traversal
    public void preOrderItr(TreeNode root){
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            System.out.print(root.data + " ");
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left!= null){
                stack.push(root.left);
            }
        }
    }
    
    //Iterative Postorder Traversal
    public void postOrderItr(TreeNode root){
        Deque<TreeNode> stack1 = new ArrayDeque<TreeNode>();
        Deque<TreeNode> stack2 = new ArrayDeque<TreeNode>();
        stack1.push(root);
        while(!stack1.isEmpty()){
            root = stack1.pop();
            if(root.left != null){
                stack1.push(root.left);
            }
            if(root.right != null){
                stack1.push(root.right);
            }
            stack2.push(root);
        }
        while(!stack2.isEmpty()){
            System.out.print(stack2.pop().data + " ");
        }
    }
    
  //Iterative Postorder Traversal - One Stack
    public void postOrderItrOneStack(TreeNode root){
        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while(current != null || !stack.isEmpty()){
            if(current != null){
                stack.addFirst(current);
                current = current.left;
            }else{
            	TreeNode temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.poll();
                    System.out.print(temp.data + " ");
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.poll();
                        System.out.print(temp.data + " ");
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
}
