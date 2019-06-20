package com.zx.office.tools;

import lombok.var;

import java.util.List;

public class ListProcess {

    private ListProcess(){}

    public static int FirstMissVal(List<String> list){
        if (list.size() == 0)
            return 0;
        for (int i = 1; i <= list.size(); i++) {
            if (i != Integer.parseInt(list.get(i-1)))
                return i;
        }
        return Integer.parseInt(list.get(list.size()-1)) + 1;
    }
}
