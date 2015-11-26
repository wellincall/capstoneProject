package br.usp.poli.pcs.capstoneProject.handlers;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.Configuration;
import spark.template.freemarker.FreeMarkerEngine;
import spark.Request;
import spark.Response;
import java.util.Map;
import spark.ModelAndView;

public abstract class DefaultHandler {
	
	protected Request request;
	protected Response response;
	protected FreeMarkerEngine freeMarkerEngine;
	protected String filePath;
	
	public DefaultHandler(Request request, Response response) {
		this.request = request;
		this.response = response;
	}
	
	protected final void init() {
		freeMarkerEngine = new FreeMarkerEngine();
		Configuration freeMarkerConfiguration = new Configuration();
		freeMarkerConfiguration.setTemplateLoader(new ClassTemplateLoader(DefaultHandler.class, "/"));
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
