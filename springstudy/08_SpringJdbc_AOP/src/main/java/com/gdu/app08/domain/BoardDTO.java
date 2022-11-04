package com.gdu.app08.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BoardDTO {

	private int board_no;
	private String title, content, writer, create_date, modify_date;
	
}
