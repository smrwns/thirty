package com.smrwns.thirty.modules.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smrwns.thirty.domains.Board;
import com.smrwns.thirty.modules.board.support.BoardSearchContext;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public String list(BoardSearchContext searchContext, Model model) {
		if(searchContext.getOrder_field() == null) {
			searchContext.setOrder_field("A.CREATE_DT");
		}
		if(searchContext.getOrder_direction() == null) {
			searchContext.setOrder_direction("DESC");
		}
		
		List<Board> boardList = boardService.getBoardListByContext(searchContext);

		model.addAttribute("boardList", boardList);
		model.addAttribute("searchContext", searchContext);
		
		return "/board/list";
	}
	
	
}
