package client.core;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class CapamTestBase {
	
	private ATUTestRecorder recorder;
	 private String videoRecordsPath = System.getProperty("user.dir")+"/src/testRecords";
	 private String beforeClassFilename;    
	
	 @BeforeMethod
	public void beforeCclass(Method method) throws ATUTestRecorderException{
		  String filename = method.getDeclaringClass().getName() + "." + method.getName();
		  beforeClassFilename = getTestClassName() + ".beforeClass";
		 recorder = new ATUTestRecorder(videoRecordsPath, beforeClassFilename, false);
	       System.out.println(("Start recording for class: " + beforeClassFilename));
	        recorder.start();
	}
	 
	 private String getTestClassName() {
	        return this.getClass().getSimpleName();
	    }
	 
	 public void stopTestRecording(String filename, ITestResult result) {
	        try {
	            if (filename != null) {
	                System.out.println(("Stop recording for method: " + filename));
	            }
	            
				if (null != recorder) {
					recorder.stop();
				}
	            
				if (result != null) {
					if (result.getStatus() == ITestResult.SUCCESS) {
						System.out.println("Deleting recording for method: " + filename);
						//DeviceAccessAndOperations.deleteFileIfExists(videoRecordsPath, filename);
					} else {
						if (null != filename) {
							System.out.println("Test '" + filename + "' has failed.");
						}
					}
	            }
	        } catch (Exception e) {        	
	        	System.out.println("Exception occurred in stopTestRecording." + e.getMessage() );
	        	e.printStackTrace();
	        }
	        
	        recorder = null;
	    }
}
