package com.cloudsoft.monterey.hello.impl;

import com.cloudsoftcorp.monterey.servicebean.access.api.MontereyNetworkEndpoint;
import com.cloudsoftcorp.monterey.servicebean.api.ServiceBeanBot;

import com.cloudsoft.monterey.hello.ServiceLocatorImpl;
import com.cloudsoft.monterey.hello.Hello;

public class Bot implements ServiceBeanBot {

    private static final int SERVICE_CALL_TIMEOUT_MILLIS = 30*1000;
    
    private ServiceLocatorImpl locator;
    
    public void init(MontereyNetworkEndpoint endpoint) {
        locator = new ServiceLocatorImpl(endpoint);
        locator.setServiceCallsTimeoutInMillis(SERVICE_CALL_TIMEOUT_MILLIS);
    }

    public void shutdown() {
        // no-op
    }
    
    public void doRequest(String segment) {
        Hello service = locator.getService(segment);
        String message = service.sayHello(segment);
        System.out.println("Message Received:"+message);
    }
}
