package com.company;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//3.	Consider the code as follows.
// Write a program that supports functional concepts to calculate the total payment of the order.
// In an order, compute the 6% of each item and add 10% of service tax for the shopping order.
// Calculate the total payment of the order. Note: rounding up all the computed result.
//ITEM NAME	PRICE	TAX (6%)	SUB-TOTAL
//Soap	    3.9	    0.234	    4.134
//Plate	    15.9	0.954	    16.854
//Wok	    199.9	11.994	    211.894
//		GRAND TOTAL:	        232.882
//		SERVICE TAX (10%):	    23.2882
//		TOTAL PAYMENT:	        256.1702
public class Main {

    public static void main(String[] args) {

        Item i1 = new Item("Soap", 3.9);
        Item i2 = new Item("Plate", 15.9);
        Item i3 = new Item("Wok", 199.9);

        Order order = new Order();
        order.setItems(Arrays.asList(i1, i2, i3));

        //print the order details and the total payment of the order in the console window
//
        System.out.println("ITEM NAME\tPRICE \tTAX (6%)\tSUB-TOTAL");
        order.getItems().forEach(item -> System.out.println(item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getTax() + "\t\t" + item.getSubTotal()));
        System.out.println("GRAND TOTAL:	\t" + order.getGrandTotal());
        System.out.println("SERVICE TAX (10%):	" + order.getServiceTax());
        System.out.println("TOTAL PAYMENT:  \t" + order.getTotalPayment());


        String header = "ITEM NAME\tPRICE \tTAX (6%)\tSUB-TOTAL";
        String collect = order.getItems()
                .stream()
                .map(item -> item.getName() + "\t\t" + item.getPrice() + "\t\t" + item.getTax() + "\t\t" + item.getSubTotal())
                .collect(Collectors.joining("\n"));
        //calculate the grand total and service tax and total payment in functional way
        double grandTotal = order.getItems().stream().mapToDouble(Item::getSubTotal).sum();
        double serviceTax = grandTotal * 0.1;
        double totalPayment = grandTotal + serviceTax;

        System.out.println(header);
        System.out.println(collect);

        DecimalFormat df = new DecimalFormat("#.###");
        System.out.println("GRAND TOTAL:	\t" + df.format(grandTotal));
        System.out.println("SERVICE TAX (10%):	" + df.format(serviceTax));
        System.out.println("TOTAL PAYMENT:  \t" + df.format(totalPayment));


    }

}

class Order {

    List<Item> items = new ArrayList();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getGrandTotal() {
        return items.stream().mapToDouble(Item::getSubTotal).sum();
    }

    public double getServiceTax() {
        DecimalFormat df = new DecimalFormat("###.####");
        return Double.parseDouble(df.format(getGrandTotal() * 0.1));
    }

    public double getTotalPayment() {
        DecimalFormat df = new DecimalFormat("###.####");
        return Double.parseDouble(df.format(getGrandTotal() + getServiceTax()));
    }
}

class Item {

    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        DecimalFormat df = new DecimalFormat("###.###");
        return Double.parseDouble(df.format(price * 0.06));
    }

    public double getSubTotal() {
        DecimalFormat df = new DecimalFormat("###.###");
        return Double.parseDouble(df.format(price + getTax()));
    }
}

