package org.study.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.javassist.bytecode.DuplicateMemberException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.study.admin.CinemaRoomVO;
import org.study.admin.CinemaVO;
import org.study.member.AuthInfo;
import org.study.member.AuthService;
import org.study.member.MemberDAO;
import org.study.member.MemberService;
import org.study.member.MemberVO;
import org.study.member.RegisterRequest;
import org.study.member.Exception.WrongIdPasswordException;
import org.study.member.Validator.LoginCommandValidator;
import org.study.member.Validator.MemberRegisterValidator;

@Controller
@RequestMapping("member")
public class MemberController {

	Logger log = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private AuthService authService;

	@Autowired
	MemberService memberService;

	@Autowired
	MemberDAO memberDAO;
	
	
	/* 로그인 */
	@GetMapping("loginForm")
	public String form(LoginCommand loginCommand, Model model) {
		model.addAttribute("center", "member/loginForm");
		return "home";
	}
	
	@PostMapping("loginForm")
	public String submit(LoginCommand loginCommand, Errors errors, Model model, HttpSession session) throws Exception {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			model.addAttribute("center", "member/loginForm");
			return "home";
		}
		try {
			
			log.info("loginCommand.getId() : "+loginCommand.getId());
			log.info("loginCommand.getPassword() : "+loginCommand.getPassword());
			
			AuthInfo authInfo = authService.authenticate(
					
					loginCommand.getId(),
					loginCommand.getPassword());
			
			//인증 후 인증정보 session에 담기
			session.setAttribute("authInfo", authInfo);
			log.info("authInfo.name : "+authInfo.getName());
			
			//관리자 페이지로 이동
			if(loginCommand.getId().equals("admin")) {
				
				return "redirect:http://localhost:8080/springteam04/admin";
				
			}
			
			//로그인 성공
			//model.addAttribute("center", "center");
			return "redirect:http://localhost:8080/springteam04/";
			
		} catch (WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			model.addAttribute("center", "member/loginForm");
			return "home";
		}		
	}
	
	/* 로그아웃 */
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	/* 회원가입 */
	@GetMapping("joinForm")
	public String memberReg(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		model.addAttribute("center", "member/joinForm");
		return "home";
	}

	@PostMapping("joinForm")
	public String memberRegDone(MemberVO memberVO, Model model, Errors errors)
			throws DuplicateMemberException, Exception {

		new MemberRegisterValidator().validate(memberVO, errors);

		// error 발생 시
		if (errors.hasErrors()) {
			log.info("회원가입 에러");
			model.addAttribute("center", "member/joinForm");
			return "home";
		}

		try {
			log.info("회원가입 성공");
			memberService.insert(memberVO);
			model.addAttribute("center", "member/joinSuccess");
			return "home";

		} catch (RuntimeException ex) {
			log.info("아이디 중복");
			errors.rejectValue("id", "duplicate.id");
			model.addAttribute("center", "member/joinForm");
			return "home";

		}

	}

	/* 회원 정보 수정 */
	@GetMapping("updateForm")
	public String update(MemberVO memberVO, Model model, HttpServletRequest request, HttpSession session)
			throws Exception {

		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		log.info("id:" + authInfo.getId());
		log.info("name:" + authInfo.getName());
		
		try {
			MemberVO member = memberDAO.selectById(authInfo.getId());
			 log.info("name : "+member.getName()); 
			 log.info("email : "+member.getEmail());
			 log.info("email : "+member.getRegDate());
			 model.addAttribute("member", member);
			 model.addAttribute("center", "member/updateForm");
			 return "home";
			
		} catch (NullPointerException e) {
			model.addAttribute("center", "member/loginForm");
			return "home";
		}
	}
	
	@PostMapping("updateForm")
	public String updateDone(@ModelAttribute MemberVO memberVO, HttpSession session, Model model, HttpServletResponse response) 
			throws Exception {
		
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");		
		memberService.update(memberVO);		
		model.addAttribute("center", "member/updateSuccess");
		return "home";
	}

	/* admin - 회원 리스트 */
	@GetMapping("memberList")
	public String memberList(Model model) throws Exception {
		List<MemberVO> memberList = memberDAO.selectAll();
		model.addAttribute("memberList", memberList);
		model.addAttribute("a_center", "member/memberList");
		return "a_home";
	}

	/* admin - 회원 삭제 */
	@PostMapping("memDelete")
	public String memDelete( Model model, HttpServletRequest request) throws Exception {
		String id=request.getParameter("id");
		MemberVO memberVO = new MemberVO();
		memberDAO.delete(id);
	    model.addAttribute("memberVO", memberVO);
		return "redirect:memberList";
	}
}