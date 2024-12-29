package com.leibnix;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

/**
 * Test class that uses the JUnit 4 framework.
 */
public class AVLTreeTests {

  /**
   * Test to verify that BinaryTree Heighth is correct.
   */
  @Test
  public void testCheckHeight() {

    // Creating an instance of the BinaryTree String class
    AVLTree<String> b = new AVLTree<String>();

    // Input parameters
    String param1 = "a";
    String param2 = "b";
    
    // Calling the sum method with parameters param1 and param2
    b.add(param1);
    b.add(param2);

    // Expected result of adding param1 and param2
    int expectedResult = 2;

     // Verification of the expected result
    assertEquals(expectedResult, b.getHeight());
  }

  /**
   * Test to verify that BinaryTree Heighth is correct with Integers.
   */
  @Test
  public void testCheckHeightWithIntegers() {

    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    int expectedResult = 4;

     // Verification of the expected result
    assertEquals(expectedResult, b.getHeight());
  }

  @Test
  public void testCheckHeightOfVoidTree() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Expected result of adding parameters
    int expectedResult = 0;

     // Verification of the expected result
    assertEquals(expectedResult, b.getHeight());
  }

  @Test
  public void testCheckContains() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    boolean expectedResult = true;

     // Verification of the expected result
    assertEquals(expectedResult, b.contains(param3));
  }

  @Test
  public void testCheckRemoveAItem() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    boolean expectedResult = true;

     // Verification of the expected result
    assertEquals(expectedResult, b.remove(param3));
  }

  @Test
  public void testCheckIsEmpty() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Expected result of adding parameters
    boolean expectedResult = true;

     // Verification of the expected result
    assertEquals(expectedResult, b.isEmpty());
  }

  @Test
  public void testCheckIsNotEmpty() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    boolean expectedResult = false;

     // Verification of the expected result
    assertEquals(expectedResult, b.isEmpty());
  }

  @Test
  public void testCheckIsLeaf() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    
    // Calling the sum method with parameters
    b.add(param1);

    // Expected result of adding parameters
    boolean expectedResult = true;

     // Verification of the expected result
    assertEquals(expectedResult, b.isLeaf());
  }

  @Test
  public void testCheckIsNotLeaf() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    boolean expectedResult = false;

     // Verification of the expected result
    assertEquals(expectedResult, b.isLeaf());
  }

  @Test
  public void testCheckQuantity() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    int expectedResult = 4;

     // Verification of the expected result
    assertEquals(expectedResult, b.getQuantity());
  }

  @Test
  public void testEmptyTreeQuantity() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Expected result of adding parameters
    int expectedResult = 0;

     // Verification of the expected result
    assertEquals(expectedResult, b.getQuantity());
  }

  @Test
  public void testCheckAnotherQuantityTest() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    Integer param5 = 5;
    Integer param6 = 6;
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    
    // Calling the add method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);
    b.add(param5);
    b.add(param6);
    b.add(param7);
    b.add(param8);
    b.add(param9);
    b.add(param10);

    // Expected result of adding parameters
    int expectedResult = 10;

     // Verification of the expected result
    assertEquals(expectedResult, b.getQuantity());
  }

  @Test
  public void testCheckClear() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    b.clear();
    int expectedResult = 0;

     // Verification of the expected result
    assertEquals(expectedResult, b.getQuantity());
  }

  @Test
  public void testCheckIsNotFull() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    
    // Calling the sum method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);

    // Expected result of adding parameters
    boolean expectedResult = false;

     // Verification of the expected result
    assertEquals(expectedResult, b.isFull());
  }

  @Test
  public void testCheckIsFull() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    
    // Calling the add method with parameters
    b.add(param2);
    b.add(param1);
    b.add(param3);

    // Expected result of adding parameters
    boolean expectedResult = true;

     // Verification of the expected result
    assertEquals(expectedResult, b.isFull());
  }

  @Test
  public void testCheckAnotherTestIsFull() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    Integer param13 = 13;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);
    b.add(param13);

    // Expected result of adding parameters
    boolean expectedResult = true;

     // Verification of the expected result
    assertEquals(expectedResult, b.isFull());
  }

  @Test
  public void testCheckPreOrder() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    // [10, 8, 7, 9, 12, 11]
    ArrayList<Integer> expectedResult = new ArrayList<>();

    expectedResult.add(10);
    expectedResult.add(8);
    expectedResult.add(7);
    expectedResult.add(9);
    expectedResult.add(12);
    expectedResult.add(11);

     // Verification of the expected result

    ArrayList<Integer> result = b.preorder();

     // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckInOrder() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    // [7, 8, 9, 10, 11, 12]
    ArrayList<Integer> expectedResult = new ArrayList<>();

    expectedResult.add(7);
    expectedResult.add(8);
    expectedResult.add(9);
    expectedResult.add(10);
    expectedResult.add(11);
    expectedResult.add(12);

    ArrayList<Integer> result = b.inorder();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckPostOrder() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    // [7, 9, 8, 11, 12, 10]
    ArrayList<Integer> expectedResult = new ArrayList<>();

    expectedResult.add(7);
    expectedResult.add(9);
    expectedResult.add(8);
    expectedResult.add(11);
    expectedResult.add(12);
    expectedResult.add(10);

    ArrayList<Integer> result = b.postorder();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckGetRoot() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    Integer expectedResult = 10;

    Integer result = b.getRoot();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckAsHashSet() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    // [7, 8, 9, 10, 11, 12]
    HashSet<Integer> expectedResult = new HashSet();

    expectedResult.add(7);
    expectedResult.add(8);
    expectedResult.add(9);
    expectedResult.add(10);
    expectedResult.add(11);
    expectedResult.add(12);

    HashSet<Integer> result = b.asHashSet();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckAsHashMap() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    // [7, 8, 9, 10, 11, 12]
    HashMap<Integer, Boolean> expectedResult = new HashMap<>();

    expectedResult.put(7, true);
    expectedResult.put(8, true);
    expectedResult.put(9, true);
    expectedResult.put(10, true);
    expectedResult.put(11, true);
    expectedResult.put(12, true);

    HashMap<Integer, Boolean> result = b.asHashMap();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckAsArray() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    // [7, 8, 9, 10, 11, 12]
    Integer[] expectedResult = new Integer[6];

    expectedResult[0] = 7;
    expectedResult[1] = 8;
    expectedResult[2] = 9;
    expectedResult[3] = 10;
    expectedResult[4] = 11;
    expectedResult[5] = 12;

    Integer[] result = b.toArray();

    // Verification of the expected result
    // You can also use JUnit's assertArrayEquals() method, which is specifically designed for comparing arrays.
    assertTrue(Arrays.equals(result, expectedResult));
  }

  @Test
  public void testCheckIsBalanced() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    boolean expectedResult = true;

    boolean result = b.isBalanced();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckIsNotBalanced() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    Integer param13 = 13;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param13);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    boolean expectedResult = false;

    boolean result = b.isBalanced();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckIsPerfect() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    Integer param13 = 13;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);
    b.add(param13);

    // Expected result of adding parameters
    boolean expectedResult = true;

    boolean result = b.isPerfect();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckIsNotPerfect() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    Integer param11 = 11;
    Integer param12 = 12;
    
    // Calling the add method with parameters
    b.add(param10);
    b.add(param8);
    b.add(param7);
    b.add(param9);
    b.add(param12);
    b.add(param11);

    // Expected result of adding parameters
    boolean expectedResult = false;

    boolean result = b.isPerfect();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckIsDegenerate() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    Integer param5 = 5;
    Integer param6 = 6;
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    
    // Calling the add method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);
    b.add(param5);
    b.add(param6);
    b.add(param7);
    b.add(param8);
    b.add(param9);
    b.add(param10);

    // Expected result of adding parameters
    boolean expectedResult = true;

    boolean result = b.isDegenerate();

    // Verification of the expected result
    assertEquals(expectedResult, result);
  }

  @Test
  public void testCheckIsDegeneratePassingThroughTheRoot() {


    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

       // Input parameters
       Integer param1 = 1;
       Integer param2 = 2;
       Integer param3 = 3;
       Integer param4 = 4;

           
    // Calling the add method with parameters
    b.add(param3);
    b.add(param4);
    b.add(param2);
    b.add(param1);

    boolean result = b.isDegenerate();

    // Verification of the result
    assertTrue(result);
  }

  @Test
  public void testCheckIsNotDegenerate() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    Integer param5 = 5;
    Integer param6 = 6;
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    
    // Calling the add method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);
    b.add(param5);
    b.add(param6);

    b.add(param9);
    b.add(param10);
    b.add(param8);

    b.add(param7);

    boolean result = b.isDegenerate();

    // Verification of the result
    assertFalse(result);
  }

  @Test
  public void testCheckIsComplete() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    Integer param5 = 5;
    Integer param6 = 6;
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    
    // Calling the add method with parameters
    b.add(param6);

    b.add(param4);
    b.add(param8);

    b.add(param3);
    b.add(param5);
    b.add(param7);
    b.add(param9);

    b.add(param2);

    boolean result = b.isComplete();
    // Verification of the result
    assertTrue(result);
  }


  @Test
  public void testCheckIfIsFullIsComplete() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param3 = 3;
    Integer param4 = 4;
    Integer param5 = 5;
    Integer param6 = 6;
    Integer param7 = 7;
    Integer param8 = 8;
    Integer param9 = 9;
    
    // Calling the add method with parameters
    b.add(param6);

    b.add(param4);
    b.add(param8);

    b.add(param3);
    b.add(param5);
    b.add(param7);
    b.add(param9);

    boolean result = b.isComplete();

    // Verification of the result
    assertTrue(result);
  }

  @Test
  public void testCheckIsNotComplete() {
    
    // Creating an instance of the BinaryTree int class
    AVLTree<Integer> b = new AVLTree<Integer>();

    // Input parameters
    Integer param1 = 1;
    Integer param2 = 2;
    Integer param3 = 3;
    Integer param4 = 4;
    Integer param5 = 5;
    Integer param6 = 6;
    Integer param8 = 8;
    Integer param9 = 9;
    Integer param10 = 10;
    
    // Calling the add method with parameters
    b.add(param1);
    b.add(param2);
    b.add(param3);
    b.add(param4);
    b.add(param5);
    b.add(param6);
    b.add(param10);
    b.add(param9);
    b.add(param8);

    boolean result = b.isComplete();

    // Verification of the result
    assertFalse(result);
  }

}