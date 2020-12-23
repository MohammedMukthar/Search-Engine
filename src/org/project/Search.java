package org.hyperskill;

import java.util.ArrayList;
import java.util.Map;

public class Search {

    public ArrayList<String> find(Map<Integer, String> list, Map<String, ArrayList<Integer>> map, String search) {
        ArrayList<String> found = new ArrayList<>();
        if (map.get(search.toLowerCase().trim()) == null) {
//            for (Integer i : list.keySet()) {
//                if (list.get(i).contains(search.toLowerCase())) {
//                    found.add(list.get(i));
//                }
//            }
            return found;
        }
        ArrayList<Integer> index = map.get(search.toLowerCase().trim());
//        System.out.println(found.toString());
        for (Integer i : index) {
            found.add(list.get(i));
        }

        return found;
    }
}
