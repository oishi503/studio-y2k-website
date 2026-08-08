import java.util.ArrayList;

class BinaryTree{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryClassTree{
        public static Node insert(Node root, int val){
            if(root == null){
                return new Node(val);
            }
            if(root.data > val){
                root.left = insert(root.left, val);
            } else{
                root.right = insert(root.right, val);
            }
            return root;
        }
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data > key){
            return search(root.left, key);
        } else if(root.data == key){
            return true;
        } else{
            return search(root.right, key);
        }
    }


    public static Node delete(Node root, int val){
        //case 1--- search for the node to be deleted first in left subtree
        if(root.data > val){
            root.left = delete(root.left, val);
        } // case 2---search for the deleted node in right subtree
        else if(root.data < val){
            root.right = delete(root.right, val);
        } //case 3--- root is equals to val
        else{
            if(root.left == null && root.right == null){
                return null;
            } else if(root.left == null){
                return root.right;
            } else if(root.right == null){
                return root.left;
            } else{
                Node IS = inOrdersuccesor(root.right);
                root.data = IS.data;
                root.right = delete(root.right, IS.data);
            }
        }
        return root;
    }

    public static Node inOrdersuccesor(Node root){
        while(root.left !=null){
            root = root.left;
        }
        return root;
    }

    public static void printRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data>=x && root.data<=y){
            printRange(root.left, x, y);
            System.out.print(root.data + " ");
            printRange(root.right, x, y);
        } else if(x <root.data){
            printRange(root.left, x,y);
        } else{
            printRange(root.right, x, y);
        }
    }

    public static void printPath(ArrayList<Integer> path){
        for(int i = 0; i<path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }
    public static void printroot2leaf(Node root, ArrayList<Integer> path){

        if(root ==  null){
            return;
        }

        path.add(root.data);
        //leaf node
        if(root.left == null && root.right == null){
            printPath(path);
        } else{
            printroot2leaf(root.left, path);
            printroot2leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

  
