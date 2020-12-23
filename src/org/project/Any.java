package org.hyperskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class Any implements SearchInterface{
    private Map<Integer, String> list;
    private Map<String, ArrayList<Integer>> map;
    private String str;
    private ArrayList<Integer> index;
    public Any(Map<Integer, String> list, Map<String, ArrayList<Integer>> map, String str) {
        this.list = list;
        this.map = map;
        this.str = str;
        this.index = new ArrayList<>();
    }

    public ArrayList<String> find() {
        ArrayList<String> found = new ArrayList<>();
        String[] str1 = str.toLowerCase().trim().split(" ");
        ArrayList<Integer> l = new ArrayList<>();
        for (String s : str1) {
            l = map.get(s);
            if (l == null) {
                continue;
            }
            for (Integer i : l) {
                if (index.isEmpty()) {
                    index.add(i);
                    continue;
                }
                if (index.contains(i)) {
                    continue;
                }
                index.add(i);
            }
        }
        for (Integer i : index) {
            found.add(list.get(i));
        }

        return found;
    }
}
