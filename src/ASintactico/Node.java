/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ASintactico;

public class Node {
    private String value;
    private String type;
    private Boolean visited;
    private Node leftChild, rightChild;

    public Node() {
        value = "";
        type = "";
        visited = false;
    }

    public Node(String value, String type, Boolean visited, Node leftChild, Node rightChild) {
        this.value = value;
        this.type = type;
        this.visited = visited;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Node(String value, String type, Boolean visited) {
        this.value = value;
        this.type = type;
        this.visited = visited;
    }

    public Node(String value, String type, Boolean visited, Node leftChild) {
        this.value = value;
        this.type = type;
        this.visited = visited;
        this.leftChild = leftChild;
        this.rightChild = null;
    }

    public Node(String value, String type, Node leftChild) {
        this.value = value;
        this.type = type;
        this.visited = false;
        this.leftChild = leftChild;
        this.rightChild = null;
    }

    public void SetValue(String value) {
        this.value = value;
    }

    public String GetValue() {
        return value;
    }

    public void SetType(String type) {
        this.type = type;
    }

    public String GetType() {
        return type;
    }

    public void SetVisited(Boolean visited) {
        this.visited = visited;
    }

    public Boolean GetVisited() {
        return visited;
    }

    public Node GetLeftChild() {
        return leftChild;
    }

    public void SetLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public void SetRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public Node GetRightChild() {
        return rightChild;
    }
    
    public String toString(){
        return this.EvaluateToString();
    }

    public String EvaluateToString() {
        String temp = "";
        if (leftChild != null) {
            temp += leftChild.EvaluateToString();
        }
        temp += value;
        if (rightChild != null) {
            temp += rightChild.EvaluateToString();
        }
        return temp;
    }
}
