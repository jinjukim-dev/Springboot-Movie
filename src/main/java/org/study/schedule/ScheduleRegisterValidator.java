package org.study.schedule;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.study.admin.ScheduleVO;
import org.study.member.MemberVO;
import org.study.member.RegisterRequest;

public class ScheduleRegisterValidator implements Validator{
	
	Logger log = LoggerFactory.getLogger(ScheduleRegisterValidator.class);

	@Override
	public boolean supports(Class<?> clazz) {
		return ScheduleVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ScheduleVO scheduleVO = (ScheduleVO) target;
		
		if(scheduleVO.getStart_time() == null) {
				log.info("start_time error");
				errors.rejectValue("start_time", "required.time");
		}
		
		if(scheduleVO.getEnd_time() == null) {
				log.info("end_time error");
				errors.rejectValue("end_time", "required.time");			
		}
		
	}
	
}
