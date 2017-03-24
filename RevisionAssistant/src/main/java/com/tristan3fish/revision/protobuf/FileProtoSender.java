package com.tristan3fish.revision.protobuf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.protobuf.Message;

public class FileProtoSender implements ProtoSender {

	private String fileName;
	
	public FileProtoSender(String fileName) {
		this.fileName = fileName;
	}
	
	@Override
	public void send(Message proto) {
		File f = new File(fileName);
    	if(!f.exists()){
    		try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
    	}

		try {
			
			FileOutputStream output = new FileOutputStream(fileName);
	        proto.writeTo(output);
	        output.close();
	        
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
