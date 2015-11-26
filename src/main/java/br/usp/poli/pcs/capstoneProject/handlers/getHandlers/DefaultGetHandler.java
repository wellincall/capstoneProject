package br.usp.poli.pcs.capstoneProject.handlers.getHandlers;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Request;
import spark.Response;
import java.util.Map;

import br.usp.poli.pcs.capstoneProject.handlers.DefaultHandler;
import spark.ModelAndView;

public abstract class DefaultGetHandler extends DefaultHandler{
	
	protected FreeMarkerEngine freeMarkerEngine;
	protected String filePath;
	
	public DefaultGetHandler(Request request, Response response) {
		super(request, response);
	}
	
	protected final void init() {
		freeMarkerEngine = new FreeMarkerEngine();
		Configuration freeMarkerConfiguration = new Configuration();
		freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(DefaultGetHandler.class, "/"));
		freeMarkerEngine.setConfiguration(freeMarkerConfiguration);
	}
	
	public final String call() {
		init();
		return render(process(), filePath);
	}
	
	protected final String render(Map<String, Object> parameters, String filePath) {
		return freeMarkerEngine.render(new ModelAndView(parameters, filePath));
	}
	
	protected abstract Map<String, Object> process();
	
	
	
	
}
