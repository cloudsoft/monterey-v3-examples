package com.cloudsoft.monterey.hello.impl;

import java.util.Map;
import java.util.HashMap;

/**
 * Generated by Cloudsoft Monterey.
 */
public class LocalServiceLocatorImpl implements com.cloudsoft.monterey.hello.ServiceLocator {

    private final Map<String,com.cloudsoft.monterey.hello.Hello> services = new HashMap<String,com.cloudsoft.monterey.hello.Hello>();
    
    public com.cloudsoft.monterey.hello.Hello getService(String name) {
        synchronized (services) {
            com.cloudsoft.monterey.hello.Hello result = services.get(name);
            if (result == null) {
                result = new com.cloudsoft.monterey.hello.impl.HelloImpl();
                services.put(name, result);
            }
            return result;
        }
    }
}