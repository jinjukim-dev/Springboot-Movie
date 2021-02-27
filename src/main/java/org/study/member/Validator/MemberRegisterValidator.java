package org.study.member.Validator;

import java.util.DuplicateFormatFlagsException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.study.member.MemberDAO;
import org.study.member.MemberVO;
import org.study.member.RegisterRequest;
import org.study.member.Exception.DuplicateMemberException;

public class MemberRegisterValidator implements Validator{
	
	@Autowired
	private MemberDAO memberDao;
	
	private static final String emailRegExp = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
			"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	private Pattern pattern;
	
	public MemberRegisterValidator() {
		pattern = Pattern.compile(emailRegExp);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberVO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberVO memberVO = (MemberVO) target;
		
		//아이디 검사
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
			
		//비밀번호 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");
		
		//이름
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
				
		//이메일 형식 검사
		if(memberVO.getEmail() == null || memberVO.getEmail().trim().isEmpty()) {
			errors.rejectValue("email", "required");
		} else {
			Matcher matcher = pattern.matcher(memberVO.getEmail());
			if(!matcher.matches()) {
				//이메일 올바르지 않음
				errors.rejectValue("email", "bad.email");
			}
		}
		
		
	}
	
}
