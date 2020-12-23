package org.hyperskill;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Data {
    private Map<Integer, String> list;
    private Map<String, ArrayList<Integer>> map;
    private SearchInterface search;
    private Scanner scanner;
    public Data(Scanner scanner) {
        this.list = new HashMap<>();
        this.map = new HashMap<>();
        this.scanner = scanner;
    }

    public void fileStoring(String fileName) {

        File file = new File(fileName);
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
            int j = 0;
            while(scanner.hasNextLine()) {
                String str = scanner.nextLine().trim();
                this.list.put(j, str);
                j++;
                String[] s = str.split(" ");

                for (int i = 0; i < s.length; i++) {
                    ArrayList<Integer> count = new ArrayList<>();
                    for (Integer k : list.keySet()) {
                        if (list.get(k).contains(s[i])) {
                            if (map.containsKey(s[i])) {

                                ArrayList<Integer> c = map.get(s[i].toLowerCase());
                                c.add(k);
                                map.put(s[i].toLowerCase(), c);
                            }
                            count.add(k);
                        }
                    }
                    map.put(s[i].toLowerCase(), count);
                }
            }

            scanner.close();
            //file.delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

//    public void print(ArrayList<String> result) {
//        if (result.isEmpty()) {
//            System.out.println("No matching people found.");
//            return;
//        }
//        System.out.println("Found people:");
//        for (String i : result) {
//            System.out.println(i);
//        }
//    }

    public void menu() {
        boolean flag = true;
        while (flag) {

            System.out.println("=== Menu ===");
            System.out.println("1. Find a person\n" +
                    "2. Print all people\n" +
                    "0. Exit");
            int ch = scanner.nextInt();
            scanner.nextLine();
            switch (ch) {
                case 1:
                    System.out.println("Select a matching strategy: ALL, ANY, NONE");
                    String choice  = scanner.nextLine().toLowerCase();

                    System.out.println("Enter a name or email to search all suitable people.");
                    String str = scanner.nextLine();
                    ArrayList<String> content = new ArrayList<>();
                    switch (choice) {
                        case "all":
                            this.search = new All(list, map, str);
                            content = search.find();
                            break;
                        case "any":
                            this.search = new Any(list, map, str);
                            content = search.find();
                            break;
                        case "none":
                            this.search = new None(list, map, str);
                            content = search.find();
                            break;
                        default:
                            System.out.println("Wrong choice");
                    }
//                    ArrayList<String> content = this.search.find(list, map, str);
                    if (content.isEmpty()) {
                        System.out.println("No matching found.");
                        break;
                    }
                    System.out.println(content.size() + " persons found:");
                    for (String i: content) {
                        System.out.println(i);
                    }
                    break;
                case 2:
                    System.out.println("=== List of people ===");
                    for (String i : list.values()) {
                        System.out.println(i);
                    }
                    break;
                case 0:
                    System.out.println("Bye!");
                    flag = false;
                    break;
                default:
                    System.out.println("Incorrect option! Try again.");
            }
        }

    }

}
