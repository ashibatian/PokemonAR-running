package org.pokemonrun.serviceimpl;

import org.pokemonrun.dao.UserDao;
import org.pokemonrun.entity.User;
import org.pokemonrun.service.ModifyUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModifyUserInfoimpl implements ModifyUserInfo {
    @Autowired
    UserDao UserDao;
    @Override
    public boolean ModifyExp(String username, int num) {
        User temp=UserDao.findOne(username);
        if(temp==null)
        {
            return false;
        }
        else
        {
            int oldexp=temp.getExp();
            int newexp=oldexp+num;
            if(newexp<0)
            {
                return false;
            }
            temp.setExp(newexp);
            UserDao.save(temp);
        }
        return true;
    }

    @Override
    public boolean blockUser(String username) {
        User temp=UserDao.findOne(username);
        if(temp==null)
        {
            return false;
        }
        else
        {
            int star=temp.getStar();
            if(star==-1)
            {
                temp.setStar(0);
            }
            else
            {
                temp.setStar(-1);
            }
            UserDao.save(temp);
            return true;
        }
    }

    @Override
    public boolean SetPet(String username, int pet) {
        User temp=UserDao.findOne(username);
        if(temp==null)
        {
            return false;
        }
        else
        {
            temp.setPet(pet);
            UserDao.save(temp);
            return true;
        }
    }


}
