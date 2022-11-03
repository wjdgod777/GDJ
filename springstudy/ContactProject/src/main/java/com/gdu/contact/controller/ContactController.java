package com.gdu.contact.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.contact.domain.ContactDTO;
import com.gdu.contact.service.ContactService;

@Controller
public class ContactController {

	@Autowired
	private ContactService contactService;
	
	@GetMapping({"/", "con/list"})
	public String list(Model model) {
		model.addAttribute("contacts", contactService.findAllContacts());
		return "contact/list";
	}
	
	@GetMapping("con/write")
	public String write() {
		return "contact/write";
	}
	
	@PostMapping("con/add")
	public String add(ContactDTO contact) {
		contactService.saveContact(contact);
		return "redirect:/con/list";
	}
	
	@GetMapping("con/detail")
	public String detail(@RequestParam(value="no", required=false, defaultValue="0") int no
			   		   , Model model) {
		model.addAttribute("contact", contactService.findContactByNo(no));
		return "contact/detail";
	}
	
	@PostMapping("con/edit")
	public String edit(int no
					 , Model model) {
		model.addAttribute("contact", contactService.findContactByNo(no));
		return "contact/edit";
	}
	
	@PostMapping("con/modify")
	public String modify(ContactDTO contact) {
		contactService.modifyContact(contact);
		return "redirect:/con/detail?no=" + contact.getNo();
	}
	
	@PostMapping("con/remove")
	public String remove(int no) {
		contactService.removeContact(no);
		return "redirect:/con/list";
	}
	
}
