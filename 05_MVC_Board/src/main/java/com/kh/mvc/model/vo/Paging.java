package com.kh.mvc.model.vo;

import lombok.Getter;

@Getter
public class Paging {

	private int startPage; // 화면의 네모 첫페이지
	private int endPage; // 화면의 네모 마지막 페이지
	private boolean prev; // 화면의 네모 이전 페이지
	private boolean next; // 화면의 네모 이후 페이지
	private int num = 10; // 한페이지의 네모 보여질 갯수
	
	private int total; // 먼저 전체 갯수가 필요하고
	private Criteria cri; // 현재페이지의 양은 얘가 가지고 있어서 추가!
	
	public Paging(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
	
		this.endPage = (int)Math.ceil((double)cri.getPage() / this.num) * this.num;
		this.startPage = this.endPage - this.num + 1;
		
		int lastPage = (int)Math.ceil((double) total / cri.getAmount());
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}
	
}
