package spittr.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{
static{
System.out.println("SpittrWebAppInitializer created" );
}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] {WebConfig.class};
	}

	@Override
	//map DispatcherServlet to /
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	@Override
	protected void customizeRegistration(Dynamic registration) {
		registration.setInitParameter("initParameterName", "initParameterValue");
		
		//setting up multipart support to temporarily store uploaded files at /tmp/spittr/uploads
		registration.setMultipartConfig(
			new MultipartConfigElement("/tmp/spittr/uploads"));
	}
	
	 
}
