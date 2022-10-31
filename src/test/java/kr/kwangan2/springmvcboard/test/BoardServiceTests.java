package kr.kwangan2.springmvcboard.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.service.BoardService;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Setter(onMethod_ = @Autowired)
	private BoardService service;

	@Test
	public void testExist() {
		log.info("service@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + service);
		assertNotNull(service);
	}

	@Test
	public void testInsertBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("Service 제목");
		boardVO.setContent("Service 내용");
		boardVO.setWriter("Service 작성자");
		service.insertBoardVO(boardVO);
		log.info("service Insert@@@@@@@@@@@@@@@@@@@@@@@@@@" + boardVO);
	}

	@Test
	public void testBoardVOList() {
		service.boardVOList()
				.forEach(boardVO -> log.info("서비스로도 잘 찍어 줍니까아~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + boardVO));
	}
	

	@Test
	public void testSelectBoardVO() {
		log.info("셀렉도 잘가져오나요~~~~~~~~~~~~~~~~~~~~~" + service.selectBoardVO(10L));
	}

	@Test
	public void testDeleteBoardVO() {
		log.info("캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇캇" + service.deleteBoardVO(10L));
	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(9L);
		boardVO.setTitle("update~~~~~~~~~ 제목");
		boardVO.setContent("update~~~~~~~~~ 내용");
		boardVO.setWriter("update~~~~~~~~~~~~ 작성자");
		service.insertBoardVO(boardVO);
		log.info("service Updateeeeeeeeeeeeeeeeeeeeee@@@@@@@@@@@@@@@@@@@@@@@@@@" + boardVO);
	}

}
