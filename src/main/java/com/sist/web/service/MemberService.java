package com.sist.web.service;

import com.sist.web.vo.MemberVO;

public interface MemberService {

	public MemberVO isLogin(String id, String pwd);
}
