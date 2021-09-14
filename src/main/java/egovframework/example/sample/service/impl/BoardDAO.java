package egovframework.example.sample.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.BoardVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("boardDAO")
public class BoardDAO extends EgovAbstractDAO {

	public String boardInsert(BoardVO bdto) {
		
		return (String) insert("boardDAO.insertBoard",bdto);
	}


	
	public List<?> SelectBoardList() {
		return list("boardDAO.selectBoardList");
	}



	public BoardVO selectBoardInfo(int num) {
		return (BoardVO) select("boardDAO.selectBoardInfo",num);
	}



	public String vailCheckUser(BoardVO bdto) {
		
		return (String) select("boardDAO.selectPassWord",bdto);
	}



	public void boardUpdate(BoardVO bdto) {
		update("boardDAO.updateBoard",bdto);
		
	}



	public void boardDelete(BoardVO bdto) {
		delete("boardDAO.deleteBoard",bdto);
		
	}

}
