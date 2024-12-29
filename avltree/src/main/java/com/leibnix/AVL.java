package com.leibnix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Methods are defined to define a tree.
 */
public interface AVL<T> {
    // Declaring abstract methods.
    void add(T value);
    
    int getHeight();

    boolean contains(T value);

    void print(); // VER

    boolean remove(T value);

    boolean isEmpty();

    boolean isLeaf();

    int getQuantity();

    void clear();

    boolean isFull();

    ArrayList preorder();

    ArrayList inorder();

    ArrayList postorder();

    T getRoot();

    HashSet<T> asHashSet();

    HashMap<T, Boolean> asHashMap();

    T[] toArray();

    boolean isBalanced();

    boolean isPerfect();

    boolean isDegenerate();

    boolean isComplete();

}
