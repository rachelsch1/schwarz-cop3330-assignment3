package assignment3.ex46.base;

/*
UCF COP3330 Summer 2021 Assignment 3 Solution
Copyright 2021 Rachel Schwarz
 */

/* plan
- open input file, declare delimiter, read each word as a separate entry in a list
- convert list to map using map.compute()
- method: sortMap()
    sort map descending by value so that the word with the highest amnt of occurrences will be first in the list
- print each key with appropriate amount of asterisks
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class ex46 {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("C:\\Users\\rachel\\Desktop\\code\\oop\\exercise46_input.txt");
        Scanner input = new Scanner(inputFile);
        input.useDelimiter("\\W+");
        List<String> list = new ArrayList<>();
        Map<String, Integer> counterMap = new HashMap<>();

        while(input.hasNext()) {
            list.add(input.next());
        }

        for (String str : list) {
           counterMap.compute(str, (s1, count) -> count == null ? 1 : count + 1);
        }

        Map<String, Integer> sortedMap = sortMap(counterMap);

        for (String name : sortedMap.keySet()) {
            System.out.format("%-10s", name + ": ");
            int val = sortedMap.get(name);
            for(int i = 1; i <= val; i++) {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }

    public static HashMap<String, Integer> sortMap(Map<String, Integer> map)
    {
        HashMap<String, Integer> temp
                = map.entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e2, LinkedHashMap::new));

        return temp;
    }
}
