package com.chat.log.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chat.log.entities.Message;
import com.chat.log.service.ChatLogService;

@RestController
@RequestMapping(value="chatlogs/")
public class ChatLogController {
	
	@Autowired
	public ChatLogService logService;

	@PostMapping(value="{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public int saveMessage(@PathVariable int userId, @RequestBody Message message) {
		message.setUserId(userId);
		return logService.saveMessage(message);
	}
	
	@GetMapping(value="{userId}")
	public List<String> getMessage(@PathVariable Integer userId,@RequestParam(name="limit",required=false) Integer limit,@RequestParam(name="start",required=false) Integer messageId ) {
		
		return logService.getMessage(userId,limit,messageId);
	}
	
	@DeleteMapping(value="{userId}")
	public void deleteAllMessages(@PathVariable Integer userId) {
		logService.deleteAllMessages(userId);
		
	}
	
	@DeleteMapping(value="{userId}/{messageId}")
	public void deleteMessage(@PathVariable Integer userId,@PathVariable Integer messageId) {
		logService.deleteMessage(userId,messageId);
	}
}
