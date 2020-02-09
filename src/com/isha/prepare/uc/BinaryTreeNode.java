package com.isha.prepare.uc;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeNode {

    /** A reference to the Node's left subtree. **/
    BinaryTreeNode left;
    /** A reference to the Node's right subtree. **/
    BinaryTreeNode right;
    /** The Node's contents. **/
    int index;
    int data;

    /** Construct a Node object.
     @param data The Node's contents.
     **/
    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.index = 0;
    }

    public void insert(WeightsHelper weightsHelper) {
        List<BinaryTreeNode> newNodes = new ArrayList<>();
        boolean addNode = true;
        if(left == null){
            int leftIndex = index+1;
            if(leftIndex >= weightsHelper.getNumberOfItems()){
                //weightsHelper.addOptionalSum(this.data);
                System.out.println("leftIndex reached end: "+leftIndex);
                addNode = false;
            }
            int leftValue = this.data + weightsHelper.getWeightValue(leftIndex);
            if(leftValue > weightsHelper.getSum()/2){
                //weightsHelper.addOptionalSum(this.data);
                System.out.println("Median reached left end: "+leftValue+" with data : "+this.data+" on index "+this.index);
                addNode = false;
            }
            if(addNode){
                left = new BinaryTreeNode(leftValue);
                left.index = leftIndex;
                newNodes.add(left);
            }
        }
        addNode = true;
        if(right == null){
            int rightIndex = index+2;
            if(rightIndex >= weightsHelper.getNumberOfItems()){
                //weightsHelper.addOptionalSum(this.data);
                System.out.println("rightIndex reached end: "+rightIndex);
                addNode = false;
            }
            int rightValue = this.data + weightsHelper.getWeightValue(rightIndex);
            if(rightValue > weightsHelper.getSum()/2){
                //weightsHelper.addOptionalSum(this.data);
                System.out.println("Median reached right end: "+rightValue+" with data : "+this.data+" on index "+this.index);
                addNode = false;
            }
            if(addNode) {
                right = new BinaryTreeNode(rightValue);
                right.index = rightIndex;
                newNodes.add(right);
            }
        }
        System.out.println("Node "+this.data+" with left : "+left.data+" and right : "+right.data+" on index : "+this.index+","+left.index+","+right.index);
        for(BinaryTreeNode newNode : newNodes){
            newNode.insert(weightsHelper);
        }
    }
    public List insert(int [] weights){
        List newNodes = new ArrayList();
        if(left == null){
            int leftIndex = this.index+1;
            if(leftIndex < weights.length) {
                left = new BinaryTreeNode(weights[leftIndex]);
                left.index = leftIndex;
                left.insert(weights);
                //newNodes.add(left);
            }
        }
        if(right == null){
            int rightIndex = this.index+2;
            right = new BinaryTreeNode(weights[rightIndex]);
            //newNodes.add(right);
            right.index = rightIndex;
        }
        return newNodes;
    }

}
