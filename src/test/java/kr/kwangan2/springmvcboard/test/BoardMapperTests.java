package kr.kwangan2.springmvcboard.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@ContextConfiguration({ 
	    "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
	    })
@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
public class BoardMapperTests {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = {@Autowired})
	private WebApplicationContext ctx;
	private MockMvc mockMvc;

//	@Test
//	public void testGetList() {
//		mapper.boardVOList().forEach(board -> log.info(board));
//	}
//
//	@Test
//	public void testInsert() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("새글~~~~~~");
//		boardVO.setContent("새글 내용~~~~");
//		boardVO.setWriter("글쟁이");
//		mapper.insertBoardVO(boardVO);
//
//		log.info(boardVO);
//	}
//
//	@Test
//	public void testInsertSelectKey() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setTitle("새글~~~~~~select key");
//		boardVO.setContent("새글 내용~~~~select key");
//		boardVO.setWriter("글쟁이 select key");
//		mapper.insertBoardVOSelectKey(boardVO);
//
//		log.info(boardVO);
//	}
//	
//	@Test
//	public void testSelectBoardVO() {
//		BoardVO boardVO = mapper.selectBoardVO(4L);
//		log.info("select##############################"+boardVO);
//	}
//	
//	@Test
//	public void testDeleteBoardVO() {
//		int result = mapper.deleteBoardVO(1L);
//		log.info("delete@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+result);
//	}
//	
//	@Test
//	public void testUpdateBoardVO() {
//		BoardVO boardVO = new BoardVO();
//		boardVO.setBno(2);
//		boardVO.setTitle("타이틀 업데이또~");
//		boardVO.setContent("콘텐츠 업데이뜨~~");
//		boardVO.setWriter("작성자 벼어언경~~");
//		int result = mapper.updateBoardVO(boardVO);
//		log.info("update&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+result);
//	}
	
//	@Test
//	public void testPaging() {
//		Criteria criteria = new Criteria();
//		criteria.setPageNum(3);
//		criteria.setAmount(10);
//		List<BoardVO> list = mapper.boardVOList(criteria);
//		list.forEach(boardVO -> log.info("Paging============================================>>>>>>"+boardVO));
//	}
	
	@Before
	public void setup() {
		this.mockMvc 
		= MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	
	@Test
	public void testListPaging() throws Exception{
		log.info(
		    mockMvc.perform(
		    		MockMvcRequestBuilders.get("/board/list")
		    		.param("pageNum","2")
		    		  .param("amount","10"))
		                .andReturn().getModelAndView().getModelMap()
		);
	}
	
}//class
