package kr.kwangan2.springmvcboard.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Test
	public void testGetList() {
		mapper.boardVOList().forEach(board -> log.info(board));
	}

	@Test
	public void testInsert() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새글~~~~~~");
		boardVO.setContent("새글 내용~~~~");
		boardVO.setWriter("글쟁이");
		mapper.insertBoardVO(boardVO);

		log.info(boardVO);
	}

	@Test
	public void testInsertSelectKey() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("새글~~~~~~select key");
		boardVO.setContent("새글 내용~~~~select key");
		boardVO.setWriter("글쟁이 select key");
		mapper.insertBoardVOSelectKey(boardVO);

		log.info(boardVO);
	}
	
	@Test
	public void testSelectBoardVO() {
		BoardVO boardVO = mapper.selectBoardVO(4L);
		log.info("select##############################"+boardVO);
	}
	
	@Test
	public void testDeleteBoardVO() {
		int result = mapper.deleteBoardVO(1L);
		log.info("delete@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+result);
	}
	
	@Test
	public void testUpdateBoardVO() {
		BoardVO boardVO = new BoardVO();
		boardVO.setBno(2);
		boardVO.setTitle("타이틀 업데이또~");
		boardVO.setContent("콘텐츠 업데이뜨~~");
		boardVO.setWriter("작성자 벼어언경~~");
		int result = mapper.updateBoardVO(boardVO);
		log.info("update&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+result);
	}
}
