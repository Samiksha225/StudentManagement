package ai.rnt.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletIntializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] confiFiles = { WebConfig.class };
		return confiFiles;
	}

	@Override
	protected String[] getServletMappings() {
		String[] mappings = { "/" };
		return mappings;
	}
}
