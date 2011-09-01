package com.cloudsoft.monterey.hello.impl;

import com.cloudsoftcorp.monterey.network.api.LppClientGateway;
import com.cloudsoftcorp.monterey.network.api.LppClientGatewayFactory;
import com.cloudsoftcorp.monterey.network.api.LppStateBackup;
import com.cloudsoftcorp.monterey.servicebean.api.BeanLppClientGateway;

public class Gateway extends BeanLppClientGateway {

    public static class Factory implements LppClientGatewayFactory {
        public LppClientGateway newClientGateway() {
            return new Gateway();
        }
        public LppStateBackup newClientGatewayBackup() {
            return null; // Unsupported
        }
    }
    
    public Gateway() {
        addBot(new Bot());
        setSupportsProxyingLpp(true);
    }
}
