package Q5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Property> propLst = new ArrayList();
        addNew(propLst, new Residential());
        List<Agricultural> agriLst = new ArrayList();
//        addNew( agriLst, new Residential() );
        List<Residential> resLst = new ArrayList();
//        addNew( resLst, new Residential() );

        List<Property> propLst2 = new ArrayList();
        Residential res = new Residential();
        res.name = "Residential";
        res.price = 200000;
        addNew(propLst2, res);

        Commercial com = new Commercial();
        com.name = "Commercial";
        com.price = 400000;
        addNew(propLst2, com);

        PalmOil land = new PalmOil();
        land.name = "Agricultural";
        land.price = 2000000;
        addNew(propLst2, land);

        //display and filter the property price with 100,000
        disp(propLst2, 100000);
    }

    public static void addNew(List<Property> propLst, Property prop) {
        propLst.add(prop);
    }

    public static void disp(List<Property> propLst, int price) {
        propLst.stream().filter(p -> p.price > price).forEach(p -> System.out.println(p.name + " " + p.price));
    }
}
