package br.usp.poli.pcs.capstoneProject.dataHandler;

import java.util.Map;
import spark.Request;

public interface IDataHandlerService {
	public Map<String, Object> call(Request request);
}