package aJavaProject;

import java.util.ArrayList;
import java.util.Date;

public abstract class IndexEventGenerator {
	
	private ArrayList<IIndexEventHandler> handlers;
	
	public IndexEventGenerator() {
		handlers = new ArrayList<IIndexEventHandler>();
	}
	
	public void start(){
	}
	
	public void addHanler(IIndexEventHandler handler){
		handlers.add(handler);
	}
	
	//@SuppressWarnings("unused")
	void triggerEvent(Date dateTime, double value){
		for(IIndexEventHandler h : handlers){
			h.HandleEvent(dateTime, value);
		}
	}
	
}
