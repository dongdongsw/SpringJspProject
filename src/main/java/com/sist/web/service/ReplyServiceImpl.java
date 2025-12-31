package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ReplyMapper;
import com.sist.web.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

	private final ReplyMapper mapper;

	@Override
	public List<ReplyVO> replyListData(int cno, int type) {
		// TODO Auto-generated method stub
		return mapper.replyListData(cno,type);
	}

	@Override
	public void replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.replyInsert(vo);
	}

	@Override
	public void replyDelete(int no) {
		// TODO Auto-generated method stub
		mapper.replyDelete(no);
	}

	@Override
	public void replyUpdate(ReplyVO vo) {
		// TODO Auto-generated method stub
		mapper.replyUpdate(vo);
	}
	
	
}
