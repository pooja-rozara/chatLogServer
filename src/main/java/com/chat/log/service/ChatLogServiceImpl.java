package com.chat.log.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chat.log.entities.Message;
import com.chat.log.exception.MessageNotFound;
import com.chat.log.exception.UserNotFound;
import com.chat.log.repository.MessageRepository;

import jakarta.transaction.Transactional;

@Service
public class ChatLogServiceImpl implements ChatLogService{
	
	@Autowired
	public MessageRepository messageRepo;

	@Override
	public int saveMessage(Message message) {
		Message msg = messageRepo.save(message);
		return msg.getMessageId();
	}

	@Override
	public List<String> getMessage(Integer userId, Integer limit, Integer messageId) {
		List<Message> msg = messageRepo.findAllByUserId(userId);
		if(msg.isEmpty()) {
			throw new UserNotFound("No record for this user");
		}
		return msg.stream().sorted(Comparator.comparingLong(Message::getTimeStamp)).map(m->m.getMessage()).limit(limit!=null?limit:10).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void deleteAllMessages(Integer userId) {
		if(messageRepo.deleteByUserId(userId)==0) {
			throw new UserNotFound("User doesn't exist");
		}
	}

	@Override
	public void deleteMessage(Integer userId, Integer messageId) {
		List<Message> msgs=messageRepo.findAllByUserId(userId);
		if(msgs.isEmpty()) {
			throw new UserNotFound("No user Found");
		}
		Optional<Message> msg = msgs.stream().filter(m-> m.getMessageId()==messageId).findFirst();
		if(msg.isPresent()) {
			messageRepo.delete(msg.get());
		}else {
			throw new MessageNotFound("No message found for the user");
		}
		
	}
	
}
