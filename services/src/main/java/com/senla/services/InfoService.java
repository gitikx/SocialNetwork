package com.senla.services;

import com.senla.model.dao.api.IInfoDao;
import com.senla.model.entity.Info;
import com.senla.services.api.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoService implements IInfoService {
    @Autowired
    private IInfoDao infoDao;

    @Override
    @Transactional
    public Info getByUserId(Integer id) {
        return infoDao.getByUserId(id);
    }

    @Override
    @Transactional
    public void update(Info info) {
        Info info1 = infoDao.getByUserId(info.getUser().getId());
        info1.setSurname(info.getSurname());
        info1.setName(info.getName());
        info1.setCountry(info.getCountry());
        info1.setBirthday(info.getBirthday());
        info1.setAbout(info.getAbout());
        infoDao.update(info1);
    }
}
