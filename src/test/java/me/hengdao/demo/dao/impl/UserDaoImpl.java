package me.hengdao.demo.dao.impl;

import me.hengdao.ShardParam;
import me.hengdao.demo.dao.UserDao;
import me.hengdao.demo.dao.entity.UserEntity;
import me.hengdao.support.SqlSessionDaoSupport;

/**
 * @author wangdi5
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    @Override
    public boolean insertUser(UserEntity user) {
        ShardParam shardParam = new ShardParam("Shard-User", user.getId(), user);

        return getSqlSession().insert("NS-User.insertUser", shardParam) > 0;
    }
}
