
package ASintactico;

public class Nodo {
    private String value;
    private String type;
    private Boolean visited;
    private Nodo leftChild, rightChild;

    public Nodo() {
        value = "";
        type = "";
        visited = false;
    }

    public Nodo(String value, String type, Boolean visited, Nodo leftChild, Nodo rightChild) {
        this.value = value;
        this.type = type;
        this.visited = visited;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public Nodo(String value, String type, Boolean visited) {
        this.value = value;
        this.type = type;
        this.visited = visited;
    }

    public Nodo(String value, String type, Boolean visited, Nodo leftChild) {
        this.value = value;
        this.type = type;
        this.visited = visited;
        this.leftChild = leftChild;
        this.rightChild = null;
    }

    public Nodo(String value, String type, Nodo leftChild) {
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

    public Nodo GetLeftChild() {
        return leftChild;
    }

    public void SetLeftChild(Nodo leftChild) {
        this.leftChild = leftChild;
    }

    public void SetRightChild(Nodo rightChild) {
        this.rightChild = rightChild;
    }

    public Nodo GetRightChild() {
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
