package com.company;

import java.util.ArrayList;
import java.util.List;

class Membership {
    int point;

    Membership(int pt) {
        this.point = pt;
    }

    public String toString() {
        return "com.company.Membership: " + this.point;

    }
}

public class Q8 {

    public static void main(String[] args) {
        List<Membership> list = new ArrayList();
        list.add(new Membership(100));
        list.add(new Membership(200));
        list.add(new Membership(300));
        list.add(new Membership(400));

//Write a functional code to top up the membership points by 10.
//After increasing the membership points, populate all membership objects in a new List.
//Display the old (note: immutable list) and new List containing com.company.Membership points.
        list
                .stream()
                .map(m -> m.point += 10)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
                .forEach(System.out::println);

    }
}
