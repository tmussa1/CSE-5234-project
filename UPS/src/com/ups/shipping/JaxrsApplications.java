package com.ups.shipping;

import java.util.HashSet;
import java.util.Set;

public class JaxrsApplications extends javax.ws.rs.core.Application{
	
	@Override
	public Set<Class<?>> getClasses() {
	Set<Class<?>> classes = new HashSet<>();
	classes.add(ShippingInitiation.class);
	return classes;
	}
	

}
