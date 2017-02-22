package aJavaProject;

import java.util.Date;

public class JavaProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("hi");
		
		
		IndexEventGenerator ieg = new LinearIndexEventGenerator();
		
		ieg.addHanler(new IIndexEventHandler() {
			@Override
			public void HandleEvent(Date dateTime, double value) {
				System.out.println(dateTime + ", " + value);
			}
		});
		
		ieg.start();
	}

}
