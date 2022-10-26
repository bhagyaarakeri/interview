package general.interview;

import java.util.*;

public class SortArrayElements {
    public static void main(String[] args) {
        System.out.println("starting!");

        // intiialize users
        List<Attorney> attorney = new ArrayList<Attorney>();

        attorney.add(new Attorney("Miguel Migs", 72));
        attorney.add(new Attorney("Lars", 55));
        attorney.add(new Attorney("John Smith", 21));
        attorney.add(new Attorney("John Smith", 23));
        attorney.add(new Attorney("tim jenkins", 1));
        attorney.add(new Attorney("Michelle Banks", 3));
        attorney.add(new Attorney("Mike Jones", 5));

        // sort Attorney by last name
        /********* good answer here *********/

        /************************************/
        List<String> names = new ArrayList<>();
        Set<String> uniqueNames = new TreeSet<>();
        for(Attorney att : attorney){
            String attName = "";
            if(null != att.getName() && "" != att.getName() && att.getName().length() > 0){
                String[] name = att.getName().split(" ");
                if(name.length > 1) {
                    if (name[1] != null && name[1] != "") attName = attName + name[1] + " ";
                } else attName = " ";
                if(name[0]!=null && name[0]!="") attName = attName + name[0];
            }
            names.add(attName.toUpperCase());
            uniqueNames.add(attName.toUpperCase());
        }

        Collections.sort(names);
        //Collections.sort(uniqueNames); cannot sort use tree set
        System.out.println("Sort using an Collections.sort of an array");
        System.out.println(names);
        System.out.println();
        System.out.println("Sort using an Tree set - Remove duplicates and sorted order");
        System.out.println(uniqueNames);
        System.out.println();
        //Sort the attorney list using Comparator - Compare the last names
        System.out.println("Sort using comparator");
        Collections.sort(attorney);
        attorney.forEach(u -> System.out.println(u.getName()));
    }
}

class Attorney implements Comparable<Attorney>{
    private String name;
    private int rank;

    public Attorney (String name, int rank) {
        this.name = name;
        this.rank = rank;
    }


    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    /*@Override
    public int compare(Object o1, Object o2) {
        Attorney a1 = (Attorney) o1;
        Attorney a2 = (Attorney) o2;
        String name1 = a1.getName();
        String name2 = a2.getName();
        if(null != name1 && "" != name1 && null != name2 && "" != name2){
            String[] s1 = name1.split(" ");
            String[] s2 = name2.split(" ");
            String lastName1 = "", lastName2 = "";
            if(s1.length > 1 && null != s1[1] && "" != s1[1]) lastName1 = s1[1];
            if(s2.length > 1 && null != s2[1] && "" != s2[1]) lastName1 = s2[1];
            return lastName1.compareTo(lastName2);
        }
        return -1;
    }*/

    @Override
    public int compareTo(Attorney a) {
        String name1 = a.getName();
        String name2 = this.getName();
        if(null != name1 && "" != name1 && null != name2 && "" != name2){
            String[] s1 = name1.split(" ");
            String[] s2 = name2.split(" ");
            String lastName1 = "", lastName2 = "";
            if(s1.length > 1 && null != s1[1] && "" != s1[1]) lastName1 = s1[1].toUpperCase();
            if(s2.length > 1 && null != s2[1] && "" != s2[1]) lastName2 = s2[1].toUpperCase();
            return lastName2.compareTo(lastName1);
        }
        return 0;
    }
}
