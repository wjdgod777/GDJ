package com.gdu.contact.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.repository.ContactDAO;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDAO dao;
	
	@Override
	public List<ContactDTO> findAllContacts() {
		return dao.selectAllContacts();
	}
	
	@Override
	public ContactDTO findContactByNo(int no) {
		// TODO Auto-generated method stub
		return dao.selectContactByNo(no);
	}

	@Override
	public int saveContact(ContactDTO contact) {
		return dao.insertContact(contact);
	}

	@Override
	public int modifyContact(ContactDTO contact) {
		// TODO Auto-generated method stub
		return dao.updateContact(contact);
	}

	@Override
	public int removeContact(int no) {
		// TODO Auto-generated method stub
		return dao.deleteContact(no);
	}

}
