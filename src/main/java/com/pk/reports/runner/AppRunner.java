package com.pk.reports.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.pk.reports.entity.EligibilityDetails;
import com.pk.reports.repo.EligibilityDetailsRepo;

@Component
public class AppRunner implements ApplicationRunner {

	@Autowired
	private EligibilityDetailsRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		EligibilityDetails e1 = new EligibilityDetails();
		
		e1.setEligId(1);
		e1.setName("PK");
		e1.setMobile(12365478l);
		e1.setGender('M');
		e1.setEmail("abc@gmail.com");
		e1.setSsn(799654l);
		e1.setPlanName("SNAP");
		e1.setPlanStatus("Approved");
		
		repo.save(e1);
		
		EligibilityDetails e2 = new EligibilityDetails();
		e2.setEligId(2);
		e2.setName("MK");
		e2.setMobile(12365478l);
		e2.setGender('F');
		e2.setEmail("abc@gmail.com");
		e2.setSsn(799654l);
		e2.setPlanName("ZNAP");
		e2.setPlanStatus("Approved");
		repo.save(e2);
		
		EligibilityDetails e3 = new EligibilityDetails();
		e3.setEligId(3);
		e3.setName("PK");
		e3.setMobile(12365478l);
		e3.setGender('F');
		e3.setEmail("abc@gmail.com");
		e3.setSsn(799654l);
		e3.setPlanName("CNAP");
		e3.setPlanStatus("Denied");
		repo.save(e3);

	}

}
