package com.dao;

import com.model.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AdDAOImpl extends AbstractDAOImpl<Ad> implements AdDAO {

    @Autowired
    UserDAO userDAO;

    @Override
    public Ad saveAd(Ad ad) {
        return save(ad);
    }
}