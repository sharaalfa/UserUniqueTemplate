package edu.sharafutdinov.artur;

import java.util.*;


public class UserAndMailUnique {

    private int count;


    private HashMap<String, ArrayList<String>> map = new HashMap<>();
    private ArrayList<String> list;
    private ArrayList<String> list1 = new ArrayList<>();




    public ArrayList<String> getList1() {
        return list1;
    }

    public void setList1(ArrayList<String> list1) {
        this.list1 = list1;
    }



    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }
    public void getMapUniques(String user, String email) {

        if (!map.containsKey(user)) {
            list = new ArrayList<>();
            list.add(email);
            map.put(user, list);



        }
        else  if (map.containsKey(user)
                && !map.get(user).contains(email)) {
            AddingNonUnique addingNonUnique = new AddingNonUnique(map, user, email);
            map = new HashMap<>(addingNonUnique.getUniqueMap());
            try {
                list1.add(addingNonUnique.getDub().toString());
            } catch (NullPointerException e) {

            }
            map.get(user).add(email);
            map.put(user, map.get(user));

        }


    }

    public  void printUserUnique() {
        count = 0;
        for (String key: map.keySet()) {
            count++;
            if(count > 1) {
                map.get(key).remove(0);
            }
            //map = new HashMap<>(new RemoveNonUnique(map,getSet()).clean());
            if(!map.get(key)
                    .toString()
                    .replaceAll(",|\\d|!|\\?", ",").equalsIgnoreCase(getList1().toString()
                            .replaceAll("^\\[|\\]$", "")
                            .replaceAll(",|\\d|!|\\?", ","))) {
                System.out.println(key + " -> " + map.get(key)
                        .toString()
                        .replaceAll("^\\[|\\]$", "")
                        .replaceAll(",|\\d|!|\\?", ","));
            }
        }

    }
}
