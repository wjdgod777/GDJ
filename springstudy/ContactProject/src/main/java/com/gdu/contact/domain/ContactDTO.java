package com.gdu.contact.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ContactDTO {

	private int no;
	private String name, tel, addr, email, note;
	
}
