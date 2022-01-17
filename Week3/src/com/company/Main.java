package com.company;

import org.javatuples.Quartet;
import org.javatuples.Septet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Order {
    private String[] items;
    private LocalDateTime orderTime;
    private double paymentAmount;
    private String email;
    private String deliveryAddress;
    private String status;
    private LocalDateTime transactionDateTime;

    public Order() {

    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTransactionDateTime(LocalDateTime transactionDateTime) {
        this.transactionDateTime = transactionDateTime;
    }

    //toString
    @Override
    public String toString() {
        return "Order{" +
                "items=" + Arrays.toString(items) +
                ", orderTime=" + orderTime +
                ", paymentAmount=" + paymentAmount +
                ", email='" + email + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", status='" + status + '\'' +
                ", transactionDateTime=" + transactionDateTime +
                '}';
    }
}


public class Main {

    static ArrayList<String> record = new ArrayList<String>();

    public static void main(String[] args) {
        // add some records
        record.add("[1,2]|2020-05-20T15:43:05.870|200.00|apuemail@apu.edu.my|APU, TPM, BukitJalil|complete|2020-05-20T15:43:05.870");
        record.add("[2,3]|2020-05-21T16:53:05.870|300.00|myemail@apu.edu.my|Tmn Raya, Serdang|complete|2020-05-22T15:43:05.870");
        record.add("[1,3]|2020-05-22T17:30:05.870|400.00|youremail@apu.edu.my|Unit 101, Tmn Connaught, Cheras|complete|2020-05-23T15:43:05.870");
        record.add("[1,2,3]|2020-06-20T15:43:05.870|20.00|apuemail@apu.edu.my|APU, TPM, BukitJalil|complete|2020-06-20T15:43:05.870");
        record.add("[2]|2020-06-11T16:53:05.870|30.00|myemail@apu.edu.my|Tmn Raya, Serdang|incomplete|2020-06-11T16:53:05.870");
        record.add("[2,3]|2020-05-19T17:30:05.870|40.00|youremail@apu.edu.my|Unit 101, Tmn Connaught, Cheras|complete|2020-05-19T17:30:05.870");
        record.add("[1,2,2]|2019-05-20T15:43:05.870|200.00|apuemail@apu.edu.my|APU, TPM, BukitJalil|complete|2019-05-20T15:43:05.870");
        record.add("[1,1,2,3]|2019-05-21T16:53:05.870|300.00|myemail@apu.edu.my|Tmn Raya, Serdang|incomplete|2019-05-22T15:43:05.870");
        record.add("[1,3,3,3]|2019-05-22T17:30:05.870|400.00|youremail@apu.edu.my|Unit 101, Tmn Connaught, Cheras|incomplete|2019-05-23T15:43:05.870");

        //----------------------------------------------------------------------------------------------------------------------
        //Transform the data into a list of lines

        List<Septet> lines = record
                .stream()
                .map(rec -> Septet.fromCollection(Arrays.asList(rec.split("\\|"))))
                .collect(Collectors.toCollection(ArrayList::new));

        //----------------------------------------------------------------------------------------------------------------------
        //Transform list of lines into a list of orders
        List<Order> orders = lines
                .stream()
                .map(item -> {
                    Order order = new Order();
                    order.setItems(item.getValue0().toString().split(","));
                    order.setOrderTime(LocalDateTime.parse(item.getValue1().toString()));
                    order.setPaymentAmount(Double.parseDouble(item.getValue2().toString()));
                    order.setEmail(item.getValue3().toString());
                    order.setDeliveryAddress(item.getValue4().toString());
                    order.setStatus(item.getValue5().toString());
                    order.setTransactionDateTime(LocalDateTime.parse(item.getValue6().toString()));
                    return order;
                })
                .toList();

        System.out.println("2. Printing all orders that store as Order Object");
        orders.forEach(System.out::println);

        //----------------------------------------------------------------------------------------------------------------------
        //Calculate the total amount of orders
        double totalAmount = orders
                .stream()
                .mapToDouble(Order::getPaymentAmount)
                .sum();

        System.out.println("----------------------------------------------------");
        System.out.println("3. Printing the total amount of all orders");
        System.out.println("Total amount: " + totalAmount);

        //----------------------------------------------------------------------------------------------------------------------
        //Get only ORDERITEM, ORDERDATETIME, PAYMENTAMT, and STATUS from the list of orders
        List<Quartet<String, LocalDateTime, Double, String>> orderItems = orders
                .stream()
                .map(order -> Quartet.with(Arrays.toString(order.getItems()), order.getOrderTime(), order.getPaymentAmount(), order.getStatus()))
                .toList();

        System.out.println("----------------------------------------------------");
        System.out.println("4. Printing the order items and order date time, payment amount and status");
        orderItems.forEach(System.out::println);


        //----------------------------------------------------------------------------------------------------------------------
        //Printing the order items
        List<String> totalOrderItems = orders
                .stream()
                .map(order -> Arrays.toString(order.getItems()))
                .toList();

        System.out.println("----------------------------------------------------");
        System.out.println("5. Printing the total order items");
        totalOrderItems.forEach(System.out::println);
    }

}
