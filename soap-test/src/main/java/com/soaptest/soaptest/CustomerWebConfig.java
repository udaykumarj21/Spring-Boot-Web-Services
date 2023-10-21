package com.soaptest.soaptest;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class CustomerWebConfig {
	
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet messageDispatcherServlet= new MessageDispatcherServlet();
		
		messageDispatcherServlet.setApplicationContext(context);
		messageDispatcherServlet.setTransformWsdlLocations(true);
		
		return new ServletRegistrationBean(messageDispatcherServlet, "/ws/*");
	}
	
	@Bean(name="customer")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema custSchema) {
		
		DefaultWsdl11Definition defaultWsdl11Definition= new DefaultWsdl11Definition();
		defaultWsdl11Definition.setPortTypeName("getCustomerDetails");
		defaultWsdl11Definition.setTargetNamespace("http://www.example.org/customer-details");
		defaultWsdl11Definition.setLocationUri("/ws");
		defaultWsdl11Definition.setSchema(custSchema);
		
		return defaultWsdl11Definition;
	}
	
	@Bean
	public XsdSchema custSchema() {
		return new SimpleXsdSchema(new ClassPathResource("customer-details.xsd"));
	}
}
