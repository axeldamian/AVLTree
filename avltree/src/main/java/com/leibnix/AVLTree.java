package com.leibnix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class AVLTree<T> implements AVL<T> {

    private Node<T> root;
    /**
     * private helper class used only by BinaryTree.
     */
    private class Node<T> {
    
        private T value;

        private Node leftNode;

        private Node rightNode;

        private int balanceFactor;

        private Node<T> father;
    
        public Node() {
        }

        public Node(T value, Node<T> father) {
            this.value = value;
            this.father = father;
        }

        private boolean isInstanceOf(Class<T> clazz) {
            return clazz.isInstance(this);
        }
    
        public T getValue() {
            return (T) value;
        }
    
        public void setValue(T value) {
            this.value = value;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public Node<T> getFather(){
            return this.father;
        }

        public void changeFather(Node<T> newFather){
            this.father = newFather;
        }

        public int getBalanceFactor() {
            return balanceFactor;
        }

        public void updateBalanceFactor() {
            int leftHeight = height(this.leftNode);
            int rightHeight = height(this.rightNode);
            this.balanceFactor = rightHeight - leftHeight;
        }

        public boolean isRoot(){
            return this.father == null;
        }
        
    }

    @Override
    public void add(T value) {
        if (this.root == null) {
            this.root = new Node(value, null);
        } else {
            add(value, this.root);
        }
    }

    private void add(T value, Node<T> father) {
        if (value.hashCode() < father.getValue().hashCode()) { // It is searched for the direction in which the node to be added will go.
            if (father.getLeftNode() == null) { // if the left parent is null.
                father.setLeftNode(new Node(value, father)); // the new node is inserted there.
                father.leftNode.updateBalanceFactor(); // The FE of the last added node is updated.
                rebalance(father); // It is rebalanced from the parent to the root.
            } else {
                add(value, father.getLeftNode()); // recursion.
            }
        } else {
            if (father.getRightNode() == null) { // if the right parent is null.
                father.setRightNode(new Node(value, father)); // the new node is inserted there.
                father.rightNode.updateBalanceFactor(); // The FE of the last added node is updated.
                rebalance(father); // It is rebalanced from the parent to the root.
            } else {
                add(value, father.getRightNode()); // recursion.
            }
        }
    }

    private void rebalance(Node<T> node) {
        if ( node == null ) {
            return;
        }
        node.updateBalanceFactor();// update the FE of the parents up to and including the root of the last line of the added node
        if (node.getBalanceFactor() == 2) {
            if (node.getRightNode().getBalanceFactor() == -1) {
                rotateRight(node.getRightNode());
            }
            rotateLeft(node);
        } else if (node.getBalanceFactor() == -2) {
            if (node.getLeftNode().getBalanceFactor() == 1) {
                rotateLeft(node.getLeftNode());
            }
            rotateRight(node);
        }
        rebalance(node.getFather());
    }

    private void rotateRight(Node<T> node) {
        Node<T> left = node.getLeftNode();
        Node<T> father = node.getFather();
        if (father == null) {
            this.root = left;
        } else {
            if (father.getLeftNode() == node) {
                father.setLeftNode(left);
            } else {
                father.setRightNode(left);
            }
        }
        node.setLeftNode(left.getRightNode());
        left.setRightNode(node);
        left.changeFather(father);
        node.changeFather(left);
    }

    private void rotateLeft(Node<T> node) {
        Node<T> right = node.getRightNode();
        Node<T> father = node.getFather();
        if (father == null) {
            this.root = right;
        } else {
            if (father.getLeftNode() == node) {
                father.setLeftNode(right);
            } else {
                father.setRightNode(right);
            }
        }
        node.setRightNode(right.getLeftNode());
        right.setLeftNode(node);
        right.changeFather(father);
        node.changeFather(right);
    }

    @Override
    public int getHeight() {
        return height(this.root);
    }

    /**
     * Returns the height of the node of the tree.
     */
    private int height(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + Math.max(height(node.getLeftNode()), height(node.getRightNode()));
        }
    }

    @Override
    public boolean contains(T value) {
        return contains(value, root);
    }

    private boolean contains(T value, Node<T> node) {
        if (node == null) {
            return false;
        } else if (value.hashCode() == node.getValue().hashCode()) {
            return true;
        } else if (value.hashCode() < node.getValue().hashCode()) {
            return contains(value, node.getLeftNode());
        } else {
            return contains(value, node.getRightNode());
        }
    }

    @Override
    public void print() {
        print(root);
    }

    private void print(Node<T> node) {
        if (node != null) {
            print(node.getLeftNode());
            System.out.println(node.getValue());
            print(node.getRightNode());
        }
    }

    @Override
    public boolean remove(T value) {
        return remove(value, root);
    }

    private boolean remove(T value, Node<T> node) {
        if (node == null) {
            return false;
        } else if (value.hashCode() == node.getValue().hashCode()) {
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                node = null;
            } else if (node.getLeftNode() == null) {
                node = node.getRightNode();
            } else if (node.getRightNode() == null) {
                node = node.getLeftNode();
            } else {
                Node<T> temp = node.getRightNode();
                while (temp.getLeftNode() != null) {
                    temp = temp.getLeftNode();
                }
                node.setValue(temp.getValue());
                remove(temp.getValue(), node.getRightNode());
            }
            return true;
        } else if (value.hashCode() < node.getValue().hashCode()) {
            return remove(value, node.getLeftNode());
        } else {
            return remove(value, node.getRightNode());
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public boolean isLeaf() {
        return root.getLeftNode() == null && root.getRightNode() == null;
    }

    @Override
    public int getQuantity() {
        return getQuantity(root);
    }

    private int getQuantity(Node<T> node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + getQuantity(node.getLeftNode()) + getQuantity(node.getRightNode());
        }
    }

    @Override
    public void clear() {
        root = null;
    }

    @Override
    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(Node<T> node) {
        if (node == null) {
            return true;
        } else if (node.getLeftNode() == null && node.getRightNode() == null) {
            return true;
        } else if (node.getLeftNode() != null && node.getRightNode() != null) {
            return isFull(node.getLeftNode()) && isFull(node.getRightNode());
        } else {
            return false;
        }
    }

    /**
     * a list with root, left, rigth.
     */
    @Override
    public ArrayList< T > preorder() {
        ArrayList<T> list = new ArrayList<T>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node<T> node, ArrayList< T > list) {
        if (node != null) {
            list.add(node.value);
            preorder(node.getLeftNode(), list);
            preorder(node.getRightNode(), list);
        }
    }

    /**
     * a list with left, root, rigth.
     */
    @Override
    public ArrayList<T> inorder() {
        ArrayList<T> list = new ArrayList<T>();
        inorder(root, list);
        return list;
    }

    private void inorder(Node<T> node, ArrayList<T> list) {
        if (node != null) {
            inorder(node.getLeftNode(), list);
            list.add(node.value);
            inorder(node.getRightNode(), list);
        }
    }

    /**
     * a list with left, rigth, root.
     */
    @Override
    public ArrayList<T> postorder() {
        ArrayList<T> list = new ArrayList<T>();
        postorder(root, list);
        return list;
    }

    private void postorder(Node<T> node, ArrayList<T> list) {
        if (node != null) {
            postorder(node.getLeftNode(), list);
            postorder(node.getRightNode(), list);
            list.add(node.value);
        }
    }

    @Override
    public T getRoot() {
        return root.value;
    }

    @Override
    public HashSet<T> asHashSet() {
        HashSet<T> set = new HashSet<T>();
        getSet(root, set);
        return set;
    }

    public void getSet(Node<T> node, HashSet<T> set) {
        if (node != null) {
            set.add(node.getValue());
            getSet(node.getLeftNode(), set);
            getSet(node.getRightNode(), set);
        }
    }

    @Override
    public HashMap<T, Boolean> asHashMap() {
        HashMap<T, Boolean> map = new HashMap<T, Boolean>();
        getMap(root, map);
        return map;
    }

    private void getMap(Node<T> node, HashMap<T, Boolean> map) {
        if (node != null) {
            map.put(node.getValue(), true);
            getMap(node.getLeftNode(), map);
            getMap(node.getRightNode(), map);
        }
    }

    @Override
    public T[] toArray() {
        ArrayList<T> list = new ArrayList<T>();
        toArray(root, list);
        return list.toArray((T[]) Array.newInstance(list.get(0).getClass(), list.size()));
    }

    private void toArray(Node<T> node, ArrayList<T> list) {
        if (node != null) {
            toArray(node.getLeftNode(), list);
            list.add(node.getValue());
            toArray(node.getRightNode(), list);
        }
    }

    @Override
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node<T> node) {
        if (node == null) {
            return true;
        } else {
            int left = height(node.getLeftNode());
            int right = height(node.getRightNode());
            return Math.abs(left - right) <= 1 && isBalanced(node.getLeftNode()) && isBalanced(node.getRightNode());
        }
    }

    @Override
    public boolean isPerfect() {
        return isPerfect(root);
    }

    private boolean isPerfect(Node<T> node) {
        if (node == null) {
            return true;
        } else {
            return isFull(node) && isBalanced(node);
        }
    }

    @Override
    public boolean isDegenerate() {
        return isDegenerate(root.leftNode) && isDegenerate(root.rightNode);
    }

    private boolean isDegenerate(Node<T> node) {
        if (node == null) {
            return true;
        } else {

            if (node.leftNode != null && node.rightNode != null) {
                return false;
            }

            return isDegenerate(node.leftNode) && isDegenerate(node.rightNode);
        }
    }


    @Override
    public boolean isComplete() {
        
        if (isEmpty()) {
            return true;
        }

        if (isFull()) {
            return true;
        }

        int height = getHeight();

        int i = height - 1;
        int firstLevel = 1;
        boolean checkThatAllLevelsAreFullExceptTheLastOne = true;
        while (i >= firstLevel){
            checkThatAllLevelsAreFullExceptTheLastOne = checkThatAllLevelsAreFullExceptTheLastOne && isLevelFull(i);
            i = i - 1;
        }

        return checkThatAllLevelsAreFullExceptTheLastOne && isFilledFromLeft();
    }
    
    public int getHeight(T value) {
        return getHeight(value, root);
    }

    private int getHeight(T value, Node<T> node) {
        if (node == null) {
            return 0;
        } else if (value.hashCode() == node.getValue().hashCode()) {
            return 1;
        } else if (value.hashCode() < node.getValue().hashCode()) {
            return 1 + getHeight(value, node.getLeftNode());
        } else {
            return 1 + getHeight(value, node.getRightNode());
        }
    }


    public ArrayList<T> getLeafsInLastLevel() {
        ArrayList<T> list = new ArrayList<T>();
        int height = getHeight();
        getLeafsInLastLevel(root, list, height);
        return list;
    }

    private void getLeafsInLastLevel(Node<T> node, ArrayList<T> list, int height) {
        if (node != null) {
            if (node.getLeftNode() == null && node.getRightNode() == null && height== getHeight(node.getValue())) {
                list.add(node.getValue());
            } else {
                getLeafsInLastLevel(node.getLeftNode(), list, height);
                getLeafsInLastLevel(node.getRightNode(), list, height);
            }
        }
    }

    public int getQuantityOfLeafs() {
        return getQuantityOfLeafs(root);
    }

    private int getQuantityOfLeafs(Node<T> node) {
        if (node == null) {
            return 0;
        } else if (node.getLeftNode() == null && node.getRightNode() == null) {
            return 1;
        } else {
            return getQuantityOfLeafs(node.getLeftNode()) + getQuantityOfLeafs(node.getRightNode());
        }
    }

    public ArrayList<T> getLevel(int level) {
        ArrayList<T> list = new ArrayList<T>();
        getLevel(root, list, level, 1);
        return list;
    }

    private void getLevel(Node<T> node, ArrayList<T> list, int level, int currentLevel) {
        if (node != null) {
            if (currentLevel == level) {
                list.add(node.getValue());
            } else {
                getLevel(node.getLeftNode(), list, level, currentLevel + 1);
                getLevel(node.getRightNode(), list, level, currentLevel + 1);
            }
        }
    }

    public int getLevel(T value) {
        return getLevel(value, root);
    }

    private int getLevel(T value, Node<T> node) {
        if (node == null) {
            return 0;
        } else if (value.hashCode() == node.getValue().hashCode()) {
            return 1;
        } else if (value.hashCode() < node.getValue().hashCode()) {
            return 1 + getLevel(value, node.getLeftNode());
        } else {
            return 1 + getLevel(value, node.getRightNode());
        }
    }

    public boolean isLevelFull(int level) {
        if ( level == 0 && this.isEmpty()){
            return true;
        }
        if (level == 0) {
            return true;
        }
        return isLevelFull(root, level, 1);
    }
    
    private boolean isLevelFull(Node node, int level, int currentLevel) {
    
        if (currentLevel == level) {
            return node != null;
        }

        if (node == null) {
            return false;
        }
    
        return isLevelFull(node.leftNode, level, currentLevel + 1) &&
               isLevelFull(node.rightNode, level, currentLevel + 1);
    }

    public boolean isInstanceOf(Class<T> clazz) {
        return clazz.isInstance(this);
    }

    /**
     * Assuming that levels 1 to height-1 are completely filled.
     * and the last level is being filled from left to right.
     */
    public boolean isFilledFromLeft() {
        ArrayList<T> list = new ArrayList<T>();
        int height = getHeight();
        int penultimateLevel = height - 1;
        list = getLevel(penultimateLevel);
        int n = penultimateLevel - 1;
        int sizeOfNewArray = (int) Math.pow(2, n) * 2;
        T[] array = (T[]) Array.newInstance( list.get(0).getClass() , sizeOfNewArray );
        
        int i = 0;
        while (i < array.length - 1) {

            T v = list.get(i/2);
            Node<T> target = getNode(v);

            array[i] = null;
            array[i+1] = null;

            if (target.leftNode != null ){
                // TODO: fix what the warning says
                array[i] = (T) target.leftNode.getValue();
            }
            if (target.rightNode != null) {
                // TODO: fix what the warning says
                array[i+1] = (T) target.rightNode.getValue();
            }

            i = i + 2;
        }

        int h = 0;
        while (h < array.length - 1 && array[h] != null) {
            h++;
        }
        for (int j = h; j < array.length; j++) {
            if (array[j] != null) {
                return false;
            }
        }
        return true;

    }

    public boolean containsAFullSubtree() {
        return containsAFullSubtree(root);
    }

    private boolean containsAFullSubtree(Node<T> node) {
        if (node == null) {
            return false;
        } else {
            return isFull(node) || containsAFullSubtree(node.getLeftNode()) || containsAFullSubtree(node.getRightNode());
        }
    }

    /**
     * Given a value, the node that contains that value is searched for
     */
    private Node<T> getNode(T value) {
        return getNode(value, root);
    }

    private Node<T> getNode(T value, Node<T> node) {
        if (node == null) {
            return null;
        } else if (value.hashCode() == node.getValue().hashCode()) {
            return node;
        } else if (value.hashCode() < node.getValue().hashCode()) {
            return getNode(value, node.getLeftNode());
        } else {
            return getNode(value, node.getRightNode());
        }
    }
    
}
