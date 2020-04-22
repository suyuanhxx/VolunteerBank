package com.vb.service;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class BasicService {
	protected ClassPathResource  resource = new ClassPathResource("../applicationContext.xml");
	protected BeanFactory factory = new XmlBeanFactory(resource);

}
