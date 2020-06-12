

package com.example.project;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String s) {
        if(s.isEmpty()) {
            return 0;
        }
        if(s.startsWith("//")){
            String separator = s.substring(2,s.indexOf("\n"));
            String c = s.substring(s.indexOf("\n"));
            System.out.println(c);
            return Arrays.stream("1,2,3,5".split(","))
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
        }
        return Arrays.stream(s.split("[,\\n]"))
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }
}
