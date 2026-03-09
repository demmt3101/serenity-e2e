package com.tcs.utils;

import java.util.List;

public class SauceData {
    public String url;
    public User user;
    public Purchase purchase;

    public static class User {
        public String username;
        public String password;
    }

    public static class Purchase {
        public List<String> products;   // slugs: sauce-labs-backpack
        public String firstName;
        public String lastName;
        public String postalCode;
    }
}