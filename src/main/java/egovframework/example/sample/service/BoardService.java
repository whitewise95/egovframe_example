package egovframework.example.sample.service;

import java.util.List;

public interface BoardService {

	String insertBoard(BoardVO bdto)throws Exception;

	List<?> getBoardList()throws Exception;

	BoardVO getInfo(int num)throws Exception;

	boolean userCheck(BoardVO bdto)throws Exception;

	void boardUpdate(BoardVO bdto)throws Exception;

	void boardDelete(BoardVO bdto)throws Exception;

}
