package com.tekion.Cricket.util;

public class Toss {
    public static boolean toss(){
        return (int)(Math.random() * 2) == 0? true : false ;
    }
}

//controller -
//repo - this ll contain code related to db. no business logic
//service - all the business logic ... create instance of repo in service and use them


