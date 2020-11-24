package solution.dao.impl;

import java.util.List;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import solution.dao.UserDao;
import solution.exception.DataProcessingException;
import solution.model.User;

@Repository
public class UserDaoImpl implements UserDao {
    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<User> getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Query<User> query =
                    session.createQuery("FROM User WHERE id = :userId ", User.class);
            query.setParameter("userId", id);
            return query.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException(
                    "User has not been found: id[" + id + "]", e);
        }
    }

    @Override
    public void save(List<User> userList) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            for (User user : userList) {
                session.save(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Users have not been added\n", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
