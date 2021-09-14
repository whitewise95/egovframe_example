package egovframework.example.sample.web;




import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.sample.service.BoardService;
import egovframework.example.sample.service.BoardVO;

@Controller("boardController")
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping(value="/main.do")
	public String main() {
		return "sample/main";
	}
	@RequestMapping(value="/bList.do")
	public String bList(ModelMap model) throws Exception {
		List<?> bdto= boardService.getBoardList();
		model.addAttribute("bdto",bdto);
		
		return "sample/bList";
	}
	@RequestMapping(value="/bWrite.do")
	public String bWrite() {
		return "sample/bWrite";
	}
	@RequestMapping(value="/bWritePro.do", method = RequestMethod.POST)
	public ResponseEntity<Object> bWritePro(BoardVO bdto, HttpServletRequest request) throws Exception{
		String message = "";
		message = "<script>";
		message += "alert('게시글이 작성되었습니다.');";
		message += "location.href='"+request.getContextPath()+"/bList.do';";
		message += "</script>";
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		
		boardService.insertBoard(bdto);
		
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
	}
	
	@RequestMapping(value="/bInfo.do")
	public String bInfo(@RequestParam("num")int num, Model model) throws Exception{
		BoardVO bd = boardService.getInfo(num);
		model.addAttribute("bd",bd);
		
		
		return "sample/bInfo";
	}
	@RequestMapping(value="/bUpdate.do")
	public String bUpdate(@RequestParam("num")int num, Model model) throws Exception{
		BoardVO bd = boardService.getInfo(num);
		model.addAttribute("bd",bd);
		
		return "sample/bUpdate";
	}
	@RequestMapping(value="/bDelete.do")
	public String bDelete(@RequestParam("num")int num, Model model) throws Exception{
		BoardVO bd = boardService.getInfo(num);
		model.addAttribute("bd",bd);
		
		return "sample/bDelete";
	}
	@RequestMapping(value="/bUpdatePro.do")
	public  ResponseEntity<Object> bUpdatePro(BoardVO bdto,HttpServletRequest request)  throws Exception{
		String message = "";
		System.out.println(bdto.getPassword());
		if(boardService.userCheck(bdto)) {
			boardService.boardUpdate(bdto);
			message = "<script>";
			message += "alert('게시글이 수정되었습니다.');";
			message += "location.href='"+request.getContextPath()+"/bList.do';";
			message += "</script>";
			
		}
		else {
			message = "<script>";
			message += "alert('패스워드가 틀렸습니다.');";
			message += "history.go(-1);";
			message += "</script>";
	
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
	}
	@RequestMapping(value="/bDeletePro.do")
	public  ResponseEntity<Object> bDelete(BoardVO bdto,HttpServletRequest request)  throws Exception{
		String message = "";
		System.out.println(bdto.getPassword());
		if(boardService.userCheck(bdto)) {
			boardService.boardDelete(bdto);
			message = "<script>";
			message += "alert('게시글이 삭제되었습니다.');";
			message += "location.href='"+request.getContextPath()+"/bList.do';";
			message += "</script>";
			
		}
		else {
			message = "<script>";
			message += "alert('패스워드가 틀렸습니다.');";
			message += "history.go(-1);";
			message += "</script>";
			
		}
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		return new ResponseEntity<Object>(message,responseHeaders,HttpStatus.OK);
	}
}
