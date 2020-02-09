package com.isha.prepare.uc;

public class CircularLinkedList {
    private Node head = null;
    private Node tail = null;

    public void addNode(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
        } else {
            tail.nextNode = newNode;
        }

        tail = newNode;
        tail.nextNode = head;
    }

    public boolean containsNode(int searchValue) {
        Node currentNode = head;

        if (head == null) {
            return false;
        } else {
            do {
                if (currentNode.value == searchValue) {
                    return true;
                }
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
            return false;
        }
    }

    public void deleteNode(int valueToDelete) {
        Node currentNode = head;

        if (head != null) {
            if (currentNode.value == valueToDelete) {
                head = head.nextNode;
                tail.nextNode = head;
            } else {
                do {
                    Node nextNode = currentNode.nextNode;
                    if (nextNode.value == valueToDelete) {
                        currentNode.nextNode = nextNode.nextNode;
                        break;
                    }
                    currentNode = currentNode.nextNode;
                } while (currentNode != head);
            }
        }
    }

    public void traverseList() {
        Node currentNode = head;

        if (head != null) {
            do {
                System.out.println(currentNode.value + " ");
                currentNode = currentNode.nextNode;
            } while (currentNode != head);
        }
    }
}

