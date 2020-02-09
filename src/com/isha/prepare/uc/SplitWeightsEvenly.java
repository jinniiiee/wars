package com.isha.prepare.uc;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SplitWeightsEvenly {

    public static void main(String []args) {
        PrintWriter bout = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String line;
            int trips = 0;
            int numberOfItems = 0;
            List<Map<Integer,Integer>> bestOptions = new ArrayList();
            while ((line = br.readLine()) != null) {
                trips++;
                String input [] = line.split(" ");
                numberOfItems = Integer.parseInt(input[0]);
                if(numberOfItems == 0 || trips > 150 || numberOfItems != input.length-1){
                    break;
                }else{
                    WeightsHelper weightsHelper = new WeightsHelper(numberOfItems);
                    int ctr = readWeights(input, numberOfItems, weightsHelper);
                    if(ctr != numberOfItems){
                        break;
                    }
                    int rootValue = weightsHelper.getWeightValue(numberOfItems-1);
                    GraphNode root = new GraphNode(rootValue);
                    root.index = numberOfItems-1;
                    weightsHelper.setBestOption(rootValue);
                    root.insert(weightsHelper);
                    Map<Integer,Integer> bestOption = new HashMap();
                    int secondValue = weightsHelper.getSum() - weightsHelper.getBestOption();
                    if(secondValue > weightsHelper.getBestOption()){
                        bestOption.put(secondValue, weightsHelper.getBestOption());
                    }else{
                        bestOption.put(weightsHelper.getBestOption(), secondValue);
                    }
                    bestOptions.add(bestOption);
                }
            }
            for (Map<Integer, Integer> bestOption : bestOptions){
                bestOption.forEach((k,v)->{
                    System.out.println(k + " " + v);
                });
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br != null) br.close();
                if (bout != null) {
                    bout.flush();
                    bout.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static int readWeights(String [] input, int numberOfItems, WeightsHelper weightsHelper) {
        int ctr = 0;
        for (int i = 0; i < numberOfItems; i++) {
            if(numberOfItems >= 1 && numberOfItems <= 20) {
                int weight = Integer.parseInt(input[i+1]);
                if(weight >= 10 && weight <= 600) {
                    ctr++;
                    weightsHelper.setWeights(i, weight);
                }
            }
        }
        weightsHelper.sortWeights();
        weightsHelper.setSum();
        return ctr;
    }

}
