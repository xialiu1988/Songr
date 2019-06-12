package com.xl88.cf401d4.lab.Songr;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public  String getHelloWorld(){
        return "Hello, world";
    }

    @GetMapping("/capitalize/{sentence}")
    public String getCapitalize(@PathVariable String sentence){
        return sentence.toUpperCase();
    }

    @GetMapping("/reverse")
    @ResponseBody
    public String getReversedSentence(@RequestParam(name="sentence") String sentence){

        String[] arr = sentence.split(" ");
        String s="";
        for(int i=0;i<arr.length/2;i++){
            String temp="";
            temp = arr[i];
            arr[i]=arr[arr.length-1];
            arr[arr.length-1]=temp;
        }
        for(String t : arr){
            s= s+" "+t;
        }
         return  s.trim();
    }

}
