package com.tstproject.config.database;

import java.util.HashMap;
import java.util.Map;

public class User {
    public String name;
    public String password;
    public String role;

    public static Map<String, User> users = new HashMap<String, User>() {
        {
            User a = new User();
            a.name = "a";
            a.password = "a";
            a.role = "ADMIN";
            put("a", a);

            User b = new User();
            b.name = "b";
            b.password = "b";
            b.role = "DBA";
            put("b", b);
        }
    };
}
