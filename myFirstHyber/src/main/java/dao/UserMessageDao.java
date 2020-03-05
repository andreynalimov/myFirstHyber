package dao;

import models.UserMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserMessageDao {

    public UserMessage findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserMessage.class, id);
    }

    public void save(UserMessage userMessage) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(userMessage);
        tx1.commit();
        session.close();
    }

    public List<UserMessage> findAll() {
        List<UserMessage> name = (List<UserMessage>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From usermessage").list();
        return name;
    }
}