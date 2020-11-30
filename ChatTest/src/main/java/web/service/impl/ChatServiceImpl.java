package web.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.dao.face.ChatDao;
import web.service.face.ChatService;

@Service
public class ChatServiceImpl implements ChatService{

	private static final Logger logger = LoggerFactory.getLogger(ChatServiceImpl.class);
	@Autowired private ChatDao chatDao;
}
