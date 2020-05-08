package com.assignment.org.controller;

import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.IntrospectionException;
import javax.management.MBeanException;
import javax.management.MBeanInfo;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.ReflectionException;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ConfigController {
	
	@GetMapping("/api/getconfigdetails")
	@PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_ALL')")
	public List<Map<String, String>> getConfigDetails() throws MalformedObjectNameException, IntrospectionException, InstanceNotFoundException, ReflectionException, AttributeNotFoundException, MBeanException {
		MBeanServer server = ManagementFactory.getPlatformMBeanServer();

		
		Set<ObjectInstance> instances1 = server.queryMBeans(null, null);
		
        List<Map<String, String>> dsConfig = new ArrayList<>();
        if(instances1 != null && !instances1.isEmpty()) {
        for (ObjectInstance instance : instances1) {
        	
        	if(!instance.getClassName().equalsIgnoreCase("com.zaxxer.hikari.HikariDataSource")) {
        		continue;
        	}
        	
        	ObjectName mBeanName = instance.getObjectName();
            	
            MBeanInfo mbeanInfo = server.getMBeanInfo(mBeanName);
            for (int i = 0; i < mbeanInfo.getAttributes().length; i++) {
            	Map<String, String> attributeMap = new HashMap<String, String>();
            	String attributeName = null;
            	Object obj = null;
            	try {
                attributeName = mbeanInfo.getAttributes()[i].getName();
                obj = server.getAttribute(mBeanName, attributeName);
            	} catch(Exception e) {
            		System.out.println("Can not read "+mbeanInfo.getAttributes()[i]);
            	}
                if(obj != null) {
                   	String attributeValue = obj.toString();
                   	attributeMap.put(attributeName, attributeValue);
                   	dsConfig.add(attributeMap);
                    }
                }
    		}
		}
        
        
        return dsConfig;
}
}