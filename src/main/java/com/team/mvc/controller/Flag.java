package com.team.mvc.controller;

/**
 * Created by Nick on 08.04.2017.
 */
public class Flag {
    private static boolean flag = false;



    public static boolean isFlag() {
        return flag;
    }

    public static void setFlag(boolean flag) {
        Flag.flag = flag;
    }
}
