package aJavaProject;

import java.util.Date;

public class LinearIndexEventGenerator extends IndexEventGenerator {

	@Override
	public void start(){
		
		for(int i = 0;i<100;i++){
			this.triggerEvent(new Date(), i);
		}
		
	}
}
