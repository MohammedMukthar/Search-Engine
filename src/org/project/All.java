package org.hyperskill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

public class All implements SearchInterface{
    private Map<Integer, String> list;
    private Map<String, ArrayList<Integer>> map;
    private String str;
    private ArrayList<Integer> index;
    public All(Map<Integer, String> list, Map<String, ArrayList<Integer>> map, String str) {
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
        boolean flag = false;
        for (Integer i : index) {
            for (String s : str1) {
                if (list.get(i).toLowerCase().contains(s)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                found.add(list.get(i));
            }
        }

        return found;
    }
}
