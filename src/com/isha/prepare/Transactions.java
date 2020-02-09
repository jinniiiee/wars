package com.isha.prepare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transactions {
    public static class Consumer {
        private String firstName;
        private String lastName;
        private String email;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public int hashCode() {
            return getFirstName().hashCode();
        }

        @Override
        public boolean equals(Object obj){
            if(obj == null) {
                return false;
            }
            Consumer otherConsumer = (Consumer)obj;
            if(getFirstName().equals(otherConsumer.getFirstName()) && getLastName().equals(otherConsumer.getLastName()) && getEmail().equals(otherConsumer.getEmail())){
                return true;
            }
            return false;
        }
    };

    public static class Transaction {

        private String transactionId;
        private Consumer consumer;
        private int amount;

        public static Transaction parse(String transaction) {
            Transaction trn = null;
            if (transaction != null && !transaction.trim().isEmpty()) {
                String[] fields = transaction.split("\\,");
                if (fields.length >= 5) {
                    trn = new Transaction();
                    Consumer consumer = new Consumer();
                    consumer.setFirstName(fields[0]);
                    consumer.setLastName(fields[1]);
                    consumer.setEmail(fields[2]);
                    trn.setConsumer(consumer);
                    trn.setAmount(Integer.parseInt(fields[3]));
                    trn.setTransactionId(fields[4]);
                }
            }
            return trn;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public Consumer getConsumer() {
            return consumer;
        }

        public void setConsumer(Consumer consumer) {
            this.consumer = consumer;
        }

        public int getAmount() {
            return amount;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }
    }

    public static List<String> findRejectedTransactions(List<String> transactions, int creditLimit) {
        List rejectedTransactions = new ArrayList();
        if(creditLimit < 0 || transactions == null || transactions.isEmpty()){
            return rejectedTransactions;
        }
        Map<Consumer, Integer> transEntry = new HashMap<>();
        for (String trans : transactions) {
            Transaction transaction = Transaction.parse(trans);
            if(transaction == null){
                return rejectedTransactions;
            }
            Integer consumedLimit = transEntry.get(transaction.getConsumer());
            if (consumedLimit == null) {
                if(transaction.getAmount() <= creditLimit) {
                    transEntry.put(transaction.getConsumer(), transaction.getAmount());
                }else {
                    rejectedTransactions.add(transaction.getTransactionId());
                }
            } else {
                int newTotal = consumedLimit + transaction.getAmount();
                if (newTotal <= creditLimit) {
                    transEntry.put(transaction.getConsumer(), newTotal);
                } else {
                    rejectedTransactions.add(transaction.getTransactionId());
                }
            }
        }
        return rejectedTransactions;
    }
    public static void main(String[] args){
        List<String> trns = new ArrayList<>();
        trns.add("Ram,Kumar,ram@kumar,20,T1");
        trns.add("Rajesh,Kumar,ram@kumar,20,T2");
        trns.add("Ram,Kumar,ram@kumar,10,T9");
        trns.add("Mohan,Kumar,ram@kumar,40,T13");
        trns.add("Kisan,Kumar,ram@kumar,32,T24");
        long startTime = System.nanoTime();
        List rejectedTransactions = findRejectedTransactions(trns, 30);
        System.out.println(rejectedTransactions.toString());
        System.out.println(System.nanoTime()-startTime);
    }
}
