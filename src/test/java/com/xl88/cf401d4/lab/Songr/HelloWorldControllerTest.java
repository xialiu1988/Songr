package com.xl88.cf401d4.lab.Songr;



import org.junit.Test;

import static org.junit.Assert.*;

    public class HelloWorldControllerTest {

        @Test
        public void getHelloWorld() {

            HelloWorldController contr= new HelloWorldController();
            String s =  contr.getHelloWorld();
            assertEquals("This should return Hello, world","Hello, world",s);
        }

        @Test
        public void getCapitalize() {
            HelloWorldController contr= new HelloWorldController();
            String s = contr.getCapitalize("hello");
            assertEquals("Should return capitalize string","HELLO",s);
        }


        //input has capital letters
        @Test
        public void getCapitalizePartialCapital() {
            HelloWorldController contr= new HelloWorldController();
            String s = contr.getCapitalize("hEllo");
            assertEquals("Should return capitalize string","HELLO",s);
        }


        //input is number
        @Test
        public void getCapitalizeNumber() {
            HelloWorldController contr= new HelloWorldController();
            String s = contr.getCapitalize("11");
            assertEquals("Should return capitalize string","11",s);
        }

        // two words string

        @Test
        public void getReversedSentence() {
            HelloWorldController contr= new HelloWorldController();
            String s = contr.getReversedSentence("hello world");
            assertEquals("Should return the reverse the string","world hello",s);
        }


        //three words
        @Test
        public void getReversed3wordsSentence() {
            HelloWorldController contr= new HelloWorldController();
            String s = contr.getReversedSentence("hello world today");
            assertEquals("Should return the reverse the string","today world hello",s);
        }
        //one word
        @Test
        public void getReversedOnewordSentence() {
            HelloWorldController contr= new HelloWorldController();
            String s = contr.getReversedSentence("hello");
            assertEquals("Should return the reverse the string","hello",s);
        }

    }

