package kr.kwangan2.springmvcboard.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import kr.kwangan2.springmvcboard.dao.BoardDAO;
import kr.kwangan2.springmvcboard.domain.BoardVO;
import kr.kwangan2.springmvcboard.mapper.BoardMapper;
import lombok.Setter;

public abstract class AbstractBoardDAO implements BoardDAO {
	
	@Override
	public List<BoardVO> boardVOList() {
		return null;
	}

	@Override
	public int insertBoardVO(BoardVO boardVO) {
		return 0;

	}

	@Override
	public int insertBoardVOSelectKey(BoardVO boardVO) {
		return 0;

	}

	@Override
	public BoardVO selectBoardVO(Long bno) {
		return null;
	}

	@Override
	public int deleteBoardVO(Long bno) {
		return 0;
	}

	@Override
	public int updateBoardVO(BoardVO boardVO) {
		return 0;
	}

}
