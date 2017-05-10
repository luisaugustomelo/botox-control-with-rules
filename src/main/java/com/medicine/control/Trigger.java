package com.medicine.control;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.medicine.control.handler.CountDownProcessEventListener;

import java.util.Random;

public class Trigger{

	public static void main(String[] args) {
		try {
			KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-process");
			
			CountDownProcessEventListener countdown = new CountDownProcessEventListener("timer", 1);
			
			Random gerador = new Random();
			double temp = (gerador.nextInt(7) + 4) * -1;		
			
        	Temperature t1 = new Temperature(temp);
        	kSession.insert(t1);
            
        	kSession.fireAllRules();
            
            countdown.waitTillCompleted();
	        
			
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}
