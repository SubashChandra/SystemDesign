import java.util.*;

public class Main {

    public static void main(String[] args) {


        //arrayList -> on par with vector
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(3);
        list.add(25);

        for(Integer val: list){
            System.out.println(val);
        }

        System.out.println("-----------------------------------------------");

        //treeset -> on par with Set (ordered keys)
        TreeSet<String> al=new TreeSet<String>();
        al.add("Ravi");
        al.add("Vijay");
        al.add("Ravi");
        al.add("Ajay");
        //Traversing elements
        Iterator<String> itr=al.iterator();
        //Iterator i=set.descendingIterator();  for descending order
        while(itr.hasNext()){
            System.out.println(itr.next());
        }


        System.out.println("-----------------------------------------------");

        //hashmap - maintains no particular order -> on par with unordered_map

        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        System.out.println("Initial list of elements: "+hm);
        hm.put(100,"Amit");
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");
        hm.put(101, "dup");

        System.out.println("After invoking put() method ");
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        hm.putIfAbsent(103, "Gaurav");
        System.out.println("After invoking putIfAbsent() method ");
        for(Map.Entry m:hm.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }

        System.out.println("-----------------------------------------------");

        //treemap - maintains ascending order -> on par with map
        TreeMap<Integer,String> map=new TreeMap<Integer,String>();
        map.put(900,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");

        for(Map.Entry m:map.entrySet()){
            System.out.println(m.getKey()+" "+m.getValue());
        }
        System.out.println("-----------------------------------------------");

    }
}
