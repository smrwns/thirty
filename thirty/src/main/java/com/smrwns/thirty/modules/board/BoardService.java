package com.smrwns.thirty.modules.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smrwns.thirty.domains.Board;
import com.smrwns.thirty.modules.board.support.BoardSearchContext;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional(readOnly = true)
	public List<Board> getBoardListByContext(BoardSearchContext searchContext) {
		
		long totalRowCount = boardRepository.getTotalRowCountBySearchContext(searchContext);
		searchContext.setTotalRowCount(totalRowCount);
		List<Board> boardList = boardRepository.getListBySearchContext(searchContext);
		
		return boardList;
	}

	public Board getBoardById(long id) {
		return boardRepository.getBoardById(id);
	}

}
