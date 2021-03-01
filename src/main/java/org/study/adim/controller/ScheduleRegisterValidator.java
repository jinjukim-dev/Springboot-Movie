package org.study.adim.controller;

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
	
	/*
	 * private static final String emailRegExp =
	 * "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
	 * "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; private Pattern pattern;
	 * 
	 * public ScheduleRegisterValidator() { pattern = Pattern.compile(emailRegExp);
	 * }
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return ScheduleVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ScheduleVO scheduleVO = (ScheduleVO) target;
		
		/*ValidationUtils.rejectIfEmpty(errors, "cinema_code", "required");
		ValidationUtils.rejectIfEmpty(errors, "start_time", "required");
		ValidationUtils.rejectIfEmpty(errors, "end_time", "required");
		ValidationUtils.rejectIfEmpty(errors, "schedule_date", "required");
		*/
//		if(scheduleVO.getSeat_qnt() == 0) {
//			errors.rejectValue("seat_qnt", "required");
//		}
		
		if(scheduleVO.getStart_time() == null) {
			//if(errors.getFieldError("start_time") == null) {
				log.info("start_time error");
				errors.rejectValue("start_time", "required.time");
			//}
		}
		
		if(scheduleVO.getEnd_time() == null) {
			//if(errors.getFieldError("end_time") == null) {
				log.info("end_time error");
				errors.rejectValue("end_time", "required.time");
			//}
		}
		
		//ValidationUtils.rejectIfEmpty(errors, "confirmPassword", "required");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
	
		/*
		 * if(!scheduleVO.getPassword().isEmpty()) {
		 * if(!memberVO.getPassword().equals(memberVO.getConfirmPassword())) {
		 * errors.rejectValue("confirmPassword", "notMatching.currentPassword"); } }
		 */
	}
	
}
