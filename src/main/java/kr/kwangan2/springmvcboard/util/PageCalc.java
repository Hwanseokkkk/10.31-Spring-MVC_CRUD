package kr.kwangan2.springmvcboard.util;

import kr.kwangan2.springmvcboard.domain.Criteria;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageCalc {

	public int total; //전체 게시물 수
	public int startPage; // 블록내 시작페이지 번호
	public int endPage; // 블럭내 끝페이지 번호
	public boolean prev; // 이전블럭이 있는지 여부
	public boolean next; // 다음 블럭이 있는지 여부
	
	public Criteria criteria;

	public PageCalc(Criteria criteria,int total) {
		this.criteria = criteria;
		this.total = total;
	}

	public PageCalc calcPage() {
		// 끝페이지 번호(단순히 한 블럭이 10페이지라 가정)
		this.endPage = (int) (Math.ceil(this.criteria.getPageNum() / 10.0)) * 10;
		// 시작 페이지 번호
		this.startPage = this.endPage - 9;

		// 실제 끝페이지 번호(만약 25페이자라면 3블럭은 21~25)
		int realEnd = (int) (Math.ceil((total * 1.0) / this.criteria.getAmount()));

		// 블럭내에 10개 페이지가 안되면 끝페이지 번호 설정
		if (realEnd < this.endPage) {
			this.endPage = realEnd;
		}

		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
		
		return this; //연산다하고 그 연산 객체를 던지겠다~

	}
}