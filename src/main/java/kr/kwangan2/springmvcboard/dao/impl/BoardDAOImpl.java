package kr.kwangan2.springmvcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;

/*
  서비스계층 -open 하는 계층
  dao계층 -숨겨야하는 계층

   그래서 파일 자체를 분리함 (라고하는데 뭔 소리임?ㅋㅋ)
 */
@Service
public class BoardDAOImpl extends AbstractBoardDAO {

	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;

	@Override
	public List<BoardVO> boardVOList() {
		return mapper.boardVOList();
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
	  return mapper.insertBoardVO(boardVO);
	}

	@Override
	public int insertBoardVOSelectKey(BoardVO boardVO) {
		return mapper.insertBoardVOSelectKey(boardVO);
	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		return mapper.selectBoardVO(bno);
	}

	@Override
	public int deleteBoardVO(Long bno) {
		return mapper.deleteBoardVO(bno);
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		return mapper.updateBoardVO(boardVO);
	}

}
