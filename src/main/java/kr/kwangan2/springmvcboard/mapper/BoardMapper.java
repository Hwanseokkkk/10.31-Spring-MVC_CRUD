package kr.kwangan2.springmvcboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.domain.Criteria;

public interface BoardMapper {
	
//	@Select(" select * from board where bno>0 ")
	public List<BoardVO> boardVOList();
	
	public List<BoardVO> boardVOList(Criteria criteria);
	
	public int boardVOListCount(Criteria criteria);
	
	public int insertBoardVO(BoardVO boardVO);
	
	public int insertBoardVOSelectKey(BoardVO boardVO);
	
	public BoardVO selectBoardVO(Long bno); //Mapper에서 이렇게 하면 xml에 #{bno}로 쓸수있게 해줌 ㅎ 

	public int deleteBoardVO(Long bno);
	
	public int updateBoardVO(BoardVO boardVO);
}
