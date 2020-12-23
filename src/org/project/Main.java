package org.hyperskill;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Data data = new Data(scanner);
        data.fileStoring("C:\\Users\\india\\Desktop\\SearchEngine\\src\\text.txt");
        data.menu();
    }
}
