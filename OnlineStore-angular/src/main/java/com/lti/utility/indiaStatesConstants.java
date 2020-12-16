package com.lti.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class indiaStatesConstants {

	public final static String indiaStates = "indiaStates";

	// 51 states
	public final static Map<String, String> mapOfindiaStates = new HashMap<String, String>() {
		{
			put("Andhra Pradesh", "Andhra Pradesh");
	        put("Arunachal Pradesh", "Arunachal Pradesh");
	        put("Assam", "Assam");
	        put("Bihar", "Bihar");
	        put("Chhattisgarh", "Chhattisgarh");
	        put("Goa", "Goa");
	        put("Gujarat", "Gujarat");
	        put("Haryana","Haryana");
	        put("Himachal Pradesh","Himachal Pradesh");
	        put("Jammu and Kashmir","Jammu and Kashmir");
	        put("Jharkhand","Jharkhand");
	        put("Karnataka","Karnataka");
	        put("Kerala","Kerala");
	     
	        put("Madhya Pradesh","Madhya Pradesh");
	        put("Maharashtra","Maharashtra");
	        put("Manipur","Manipur");
	        put("Meghalaya","Meghalaya");
	        put("Mizoram","Mizoram");
	        put("Nagaland","Nagaland");
	        put("Orissa","Orissa");
	        put("Punjab","Punjab");
	        put("Rajasthan","Rajasthan");
	        put("Sikkim","Sikkim");
	        put("Tamil Nadu","Tamil Nadu");
	        put("Tripura","Tripura");
	        put("Uttarakhand","Uttarakhand");
	        put("Uttar Pradesh","Uttar Pradesh");
	        put("West Bengal","West Bengal");
	        put("Andaman and Nicobar Islands","Andaman and Nicobar Islands");
	        put("Chandigarh","Chandigarh");
	        put("Dadra and Nagar Haveli","Dadra and Nagar Haveli");
	        put("Daman and Diu","Daman and Diu");
	        put("Delhi","Delhi");
	        put("Lakshadweep","Lakshadweep");
	        put("Pondicherry","Pondicherry");

		}
	};
	public final static List<String> listOfindiaStatesCode = new ArrayList<>(mapOfindiaStates.keySet());
	public final static List<String> listOfindiaStatesName = new ArrayList<>(mapOfindiaStates.values());

}

