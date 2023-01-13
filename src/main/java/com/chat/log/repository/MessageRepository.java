package com.chat.log.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chat.log.entities.Message;

public interface MessageRepository extends JpaRepository<Message,Integer>{


	List<Message> findAllByUserId(Integer userId);

	int deleteByUserId(Integer userId);

}
