package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class A {


    static List<String> strings = new ArrayList<>();

    static{
        strings.add("dfgg");
        strings.add("ukyuk");
        strings.add("yuktk");
        strings.add("weweg");
    }

    public static void main(String[] args) {

        for( String s: strings){
            System.out.println(s);
        }
        System.out.println("-----------------");
        Iterator<String> iterator = strings.iterator();

        while( iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
            if( s.startsWith("d")){
                iterator.remove();
            }
        }

        System.out.println("-----------------");
        iterator = strings.iterator();

        while( iterator.hasNext()){
            String s = iterator.next();
            System.out.println(s);
            if( s.startsWith("d")){
                iterator.remove();
            }
        }


    }
}
