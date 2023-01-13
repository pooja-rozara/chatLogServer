package com.chat.log.service;

import java.util.List;

import com.chat.log.entities.Message;

public interface ChatLogService {

	int saveMessage(Message message);

	List<String> getMessage(Integer userId, Integer limit, Integer messageId);

	void deleteAllMessages(Integer userId);

	void deleteMessage(Integer userId, Integer messageId);

}
