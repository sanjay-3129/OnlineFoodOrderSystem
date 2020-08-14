package com.foodorder.bo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.foodorder.models.CustomerForgetModel;

public class SerDeser {

	static FileOutputStream out = null;
	static ObjectOutputStream obj = null;
	static FileInputStream in = null;
	static ObjectInputStream objIn = null;
	
	public static boolean serializeObjectData(String customerId, String mail, String password) {
		CustomerForgetModel cred = new CustomerForgetModel(customerId, password);
		//serialization
		
		try {
			out = new FileOutputStream("D://Cognizant Training(27.07.2020)//Project//OnlineFoodOrderSystem//SerializedCustomerDatas//" + customerId + ".ser");
			obj = new ObjectOutputStream(out);
			obj.writeObject(cred); 
			
			System.out.println("Info is serialzied");
			obj.close();
			
			return true;
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static CustomerForgetModel deSerializeObjectData(String customerId) {
		//deserialization
		CustomerForgetModel cred = null;
		try {
			in = new FileInputStream("D://Cognizant Training(27.07.2020)//Project//OnlineFoodOrderSystem//SerializedCustomerDatas//" + customerId + ".ser");
			objIn = new ObjectInputStream(in);

			cred = (CustomerForgetModel) objIn.readObject();
			
			if(cred != null) {
				System.out.println("De-Serialized");
			}
			
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return cred;
	}

}
