package com.medicine.control.handler;

public class VerificationCurrentTime {

	private static final int THIRTY_MINUTES = 30 * 60 * 1000; //30 minutos
	
	public static boolean isThirtyMinutes(long currentTimestamp){
		long thirtyAgo = System.currentTimeMillis() - THIRTY_MINUTES;
		if (currentTimestamp < thirtyAgo) {
		    return true; //Se passou 30 minutos;
		}
		return false; //Não passou 30 minutos.
	}
}
