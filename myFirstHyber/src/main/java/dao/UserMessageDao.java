package dao;

import models.UserMessage;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;
import java.util.List;

public class UserDao {

    public UserMessage findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(UserMessage.class, id);
    }

    public void save(UserMessage user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(user);
        tx1.commit();
        session.close();
    }

    public void update(UserMessage user) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(user);
        tx1.commit();
        session.close();
    }


    public List<UserMessage> findAll() {
        List<UserMessage> users = (List<UserMessage>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From usermessage").list();
        return users;
    }
}