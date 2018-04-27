package org.opendevup.controller;

import org.opendevup.model.Note;
import org.opendevup.repository.InoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NoteController {
	@Autowired
private InoteRepository noteRepository;
	@RequestMapping("/test")
	public String test(){
		return "test";
	}
	@RequestMapping("/save")
	public Note saveNote(Note n){
		noteRepository.save(n);
		return n;
	}
	@RequestMapping("/all")
	public java.util.List<Note>  getNote(){
		return noteRepository.findAll();
	}
}
