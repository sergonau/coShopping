package com.dao;

import com.model.Users;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDAOImpl extends AbstractDAOImpl<Users> implements UserDAO {

    @Override
    public Users saveUser(Users user) {
        return save(user);
    }

//    @Override
    public Users getByEmai(String email) {
        String requestToDb = "from Users t where t.email = :emailParam";
        Query query = getSession().createQuery(requestToDb);
        query.setParameter("emailParam", email);

        //another option
      /*  Map<String, Object> map = new HashMap<>();
        map.put("emailParam", email);
        map.put("userNameParam", userName);
        for (String name : map.keySet()) {
            query.setParameter(name, map.get(name));
        }*/
        return (Users) query.uniqueResult();
    }

    @Override
    public Users getByEmail(String email) {
        String requestToDb = "from Users t where t.email = :email";
        Query query = getSession().createQuery(requestToDb);
        query.setParameter("email", email);
        return (Users) query.uniqueResult();
    }

    @Override
    public Users getByEmailAndPassword(String email, String password) {
        String requestToDb = "from Users t where t.email = :email and t.password = :password";
        Query query = getSession().createQuery(requestToDb);
        query.setParameter("email", email);
        query.setParameter("password", password);
        return (Users) query.uniqueResult();
    }
}
