package services;

import dao.UserMessageDao;
import models.UserMessage;

import java.util.List;

public class UserService {

    private UserMessageDao userMessageDao = new UserMessageDao();

    public UserService() {
    }

    public UserMessage findUser(int id) {
        return userMessageDao.findById(id);
    }

    public void saveUser(UserMessage userMessage) {
        userMessageDao.save(userMessage);
    }

    public List<UserMessage> findAllUsers() {
        return userMessageDao.findAll();
    }


}
