package com.isha.prepare.uc;

import java.util.Scanner;


public class TreeStyleSum {
    public static void main(String []args) {
        Scanner scanner = new Scanner(System.in);
        int trips = 0;
        int numberOfItems = 0;
        do {
            numberOfItems = scanner.nextInt();
            WeightsHelper weightsHelper = new WeightsHelper(numberOfItems);
            //[] weights = new int[numberOfItems];
            readWeights(scanner, numberOfItems, weightsHelper);
            int sum = weightsHelper.getSum();
            int median  =  sum/2;
            BinaryTreeNode root = new BinaryTreeNode(weightsHelper.getWeightValue(0));
            BinaryTreeNode node = root;
            //List<BinaryTreeNode> nodes = new ArrayList();
            //nodes.add(root);
            //for(BinaryTreeNode node : nodes){
            node.insert(weightsHelper);
            //System.out.println(weightsHelper.getMaxSumValue());
            //System.out.println(sum-weightsHelper.getMaxSumValue());
            //}

            //while()
            //root.insert(weights);
        } while (numberOfItems != 0 && trips <= 150);
    }



    private static void readWeights(Scanner scanner, int numberOfItems, WeightsHelper weightsHelper) {
        for (int i = 0; i < numberOfItems; i++) {
            if(numberOfItems >= 1 && numberOfItems <= 20) {
                weightsHelper.setWeights(i, scanner.nextInt());
            }
        }
        //weightsHelper.sortWeights();
    }
}
