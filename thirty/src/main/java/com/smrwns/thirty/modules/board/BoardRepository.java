package com.smrwns.thirty.modules.board;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.smrwns.thirty.domains.Board;
import com.smrwns.thirty.modules.board.support.BoardSearchContext;

@Repository
public interface BoardRepository {

	public long getTotalRowCountBySearchContext(BoardSearchContext searchContext);
	public List<Board> getListBySearchContext(BoardSearchContext searchContext);
	public Board getBoardById(long id);

}
