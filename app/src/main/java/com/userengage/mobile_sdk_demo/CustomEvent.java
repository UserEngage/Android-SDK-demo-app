package com.userengage.mobile_sdk_demo;


import com.userengage.userengagesdk.events.Event;
import com.userengage.userengagesdk.events.UserEngageProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jaroslawmichalik on 09.01.2018
 */
@Event(name = "custom_event")
public class CustomEvent implements UserEngageProperty {

    private final String id;
    private final int number;

    public CustomEvent(String id, int number){
        this.id = id;
        this.number = number;
    }

    @Override
    public Map<String, Object> toFlat() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("number", number);
        return map;
    }
}
