package com.cloudsoft.monterey.hello.impl;

import java.io.Serializable;

import com.cloudsoftcorp.monterey.network.api.MediationSegmentService;
import com.cloudsoftcorp.monterey.network.api.MediationSegmentServiceFactory;
import com.cloudsoftcorp.monterey.network.api.SegmentStateBackup;
import com.cloudsoftcorp.monterey.servicebean.api.AbstractBeanSegmentService;

/**
 * Generated by Cloudsoft Monterey.
 */
public class SegmentService extends AbstractBeanSegmentService<com.cloudsoft.monterey.hello.Hello> {
	public static class Factory implements MediationSegmentServiceFactory {
		public MediationSegmentService newSegmentService(String segment) {
			return new SegmentService();
		}
		public SegmentStateBackup newSegmentBackup(String segment) {
			return null; // Unsupported
		}
	}

    @Override
    protected com.cloudsoft.monterey.hello.Hello newBean(String segment) {
        return new com.cloudsoft.monterey.hello.impl.HelloImpl();
    }
    
    @Override
    protected com.cloudsoft.monterey.hello.Hello resumeBean(Object suspendedState) {
        // Note: please modify resume and suspend methods for custom serialization/lifecycle requirements
        return super.resumeBean(suspendedState);
    }

    @Override
    protected Serializable suspendBean(com.cloudsoft.monterey.hello.Hello delegate) {
        // Note: please modify resume and suspend methods for custom serialization/lifecycle requirements
        return super.suspendBean(delegate);
    }
}
