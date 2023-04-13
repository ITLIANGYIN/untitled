package com.jxcia.factroy;

import com.jxcia.bean.Meet;

import java.util.HashMap;
import java.util.Map;

public class MeetFactory1 {
    static Map<String, Meet> map=new HashMap<String, Meet>();
    static {
        map.put("黄牛肉",new Meet(11,"黄牛肉",60.0));
        map.put("水牛肉",new Meet(12,"水牛肉",60.0));
        map.put("神户牛肉",new Meet(13,"神户牛肉",60.0));

    }
    public   Meet getMeet(String name){
        return  map.get(name);
    }
}
