package com.kh.mvc.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {

	
	private int num; //rownum을 num으로 해줘서 추가해줍
	private int no;
	private String title;
	private String content;
	private String writer;
	private Date regdate;
}
