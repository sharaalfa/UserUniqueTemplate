package edu.sharafutdinov.artur;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddingNonUnique {
    private HashMap<String, ArrayList<String>> map;
    private ArrayList<String> list;
    private String user;
    private String email;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public  AddingNonUnique(HashMap<String, ArrayList<String>> map,
                            String user, String email) {
        this.map=map;
        this.user=user;
        this.email=email;
    }



    public HashMap<String, ArrayList<String>> getUniqueMap() {
        if(!map.isEmpty()) {
            for (String key: map.keySet()) {
                if(map.get(key).contains(email)) {
                    map.get(key).remove(email);
                    ArrayList<String> list5 = new ArrayList<>(map.get(user));
                    ArrayList<String> list7 = new ArrayList<>(map.get(key));
                    setList(list7);
                    list5.addAll(list7);
                    map.put(user, list5);
                }
            }
        }
        return map;
    }
    public List<String> getDub(){
        try {
            return getList();
        } catch (NullPointerException e) {

        }
        return null;

    }
}
