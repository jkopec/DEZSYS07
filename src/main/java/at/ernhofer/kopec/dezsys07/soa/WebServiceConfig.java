package at.ernhofer.kopec.dezsys07.soa;

import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/data/search/*");
    }
    

    @Bean(name = "Data")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema dataRecordsSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("DataPort");
        wsdl11Definition.setLocationUri("/data/search");
        wsdl11Definition.setTargetNamespace(DataEndpoint.NAMESPACE_URI);
        wsdl11Definition.setSchema(dataRecordsSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema dataRecordsSchema() {
        return new SimpleXsdSchema(new ClassPathResource("/contracts/data.xsd"));
    }
}