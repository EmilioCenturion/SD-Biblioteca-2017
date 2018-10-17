package com.sd.uni.biblioteca.service.programables;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.biblioteca.service.invitacion.IInvitacionService;



@Service
@Transactional
@EnableScheduling
public class InvitacionCron {
	@Autowired
	private IInvitacionService invitacionService;
	
	@Value("false")
	private String enableCron;
	
	@Scheduled(cron = "*/60 * * * * ?" )
    public void sendNotification(){
		try {
			if (enableCron.equalsIgnoreCase("true")){
				invitacionService.enviarInvitaciones();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}