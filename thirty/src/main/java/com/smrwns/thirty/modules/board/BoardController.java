package com.smrwns.thirty.modules.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
		if(searchContext.getOrderField() == null) {
			searchContext.setOrderField("A.CREATE_DT");
		}
		if(searchContext.getOrderDirection() == null) {
			searchContext.setOrderDirection("DESC");
		}
		
		List<Board> boardList = boardService.getBoardListByContext(searchContext);

		model.addAttribute("boardList", boardList);
		model.addAttribute("searchContext", searchContext);
		
		return "/board/list";
	}
	
	@RequestMapping("/{id}/view")
	public String view(@PathVariable("id") int id, BoardSearchContext searchContext, Model model) {
		//Board board = boardService.getById(id);
		
		model.addAttribute("board", null);
		model.addAttribute("searchContext", searchContext);
		
		return "/board/view";
	}
	
}
