package egovframework.example.sample.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egovframework.example.sample.service.BoardService;
import egovframework.example.sample.service.BoardVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("boardService")
public class BoardServiceImpl extends EgovAbstractServiceImpl implements BoardService {

	@Resource(name="boardDAO")
	private BoardDAO boardDAO;
	
	@Override
	public String insertBoard(BoardVO bdto) throws Exception {
		
		return boardDAO.boardInsert(bdto);
	}

	@Override
	public List<?> getBoardList() throws Exception {
		
		return boardDAO.SelectBoardList();
	}

	@Override
	public BoardVO getInfo(int num) throws Exception {
		
		return boardDAO.selectBoardInfo(num);
	}

	@Override
	public boolean userCheck(BoardVO bdto) throws Exception {
		boolean isCheck = false;
		System.out.println(bdto.getNum());
		String subject= boardDAO.vailCheckUser(bdto);
		System.out.println(subject);
		if(subject != null) {
			isCheck = true;
		}
		
		return isCheck;
	}

	@Override
	public void boardUpdate(BoardVO bdto) throws Exception {
		boardDAO.boardUpdate(bdto);
		
	}

	@Override
	public void boardDelete(BoardVO bdto) throws Exception {
		boardDAO.boardDelete(bdto);
		
	}

}
