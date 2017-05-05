package com.team.mvc.controller;



public class Flag {
    private static boolean flag = false;



    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Flag.flag = flag;
    }
}
