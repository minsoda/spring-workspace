package com.kh.mvc.model.vo;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

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
	
	// 업로드 파일(컨트롤러때문에 추가함)
	private MultipartFile uploadFile;
	// 저장공간(데이터베이스떄문에 추가함)
	private String url;
}
