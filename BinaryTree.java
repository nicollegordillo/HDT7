class BinaryTree<E> {
    private Node root;

    private static class Node {
        Association value;
        Node left, right;

        Node(Association value) {
            this.value = value;
        }
    }

    public void insert(Association value) {
        root = insert(root, value);
    }

    private Node insert(Node node, Association value) {
        if (node == null) {
            node = new Node(value);
        } else if (value.getKey().compareTo(node.value.getKey()) < 0) {
            node.left = insert(node.left, value);
        } else if (value.getKey().compareTo(node.value.getKey()) > 0) {
            node.right = insert(node.right, value);
        }
        return node;
    }

    public boolean contains(String key) {
        return contains(root, key);
    }

    private boolean contains(Node node, String key) {
        if (node == null) {
            return false;
        } else if (key.equals(node.value.getKey())) {
            return true;
        } else if (key.compareTo(node.value.getKey()) < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
    }

    public Association<String, String> getValue(String key) {
        return getValue(root, key);
    }
    
    private Association<String, String> getValue(Node node, String key) {
        if (node == null) {
            return null;
        } else if (key.equals(node.value.getKey())) {
            return node.value;
        } else if (key.compareTo(node.value.getKey()) < 0) {
            return getValue(node.left, key);
        } else {
            return getValue(node.right, key);
        }
    }

    public void printInOrder() {
        printInOrder(root);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.println("("+node.value.getKey() + ", " + node.value.getValue1() + ", " + node.value.getValue2()+")");
            printInOrder(node.right);
        }
    }
}