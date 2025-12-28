package com.nailong.websdk.dao;

import com.nailong.websdk.domain.dto.UserInput;
import com.nailong.websdk.domain.po.Tables;
import com.nailong.websdk.domain.po.User;
import com.nailong.websdk.domain.po.UserTable;
import lombok.RequiredArgsConstructor;
import org.babyfish.jimmer.sql.JSqlClient;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserRepository {

    private final JSqlClient sqlClient;

    UserTable userTable = Tables.USER_TABLE;

    public long saveUserObj(UserInput user) {
        return sqlClient
                .getEntities()
                .save(user)
                .getModifiedEntity()
                // 如果`user.id`为null，返回自动分配的id
                .id();
    }

    public long updateUserName(Long userId, String name) {
        return sqlClient
                .createUpdate(userTable)
                .set(userTable.nickName(), name)
                .where(userTable.id().eq(userId))
                .execute();
    }

    /**
     * 根据 id 删除 user 对象
     *
     * @param id 自增 id
     */
    public void delUserById(long id) {
        sqlClient.deleteById(User.class, id);
    }

    /**
     * 根据账号删除 user 对象
     *
     * @param openId 账号
     * @return 删除的数量
     */
    public int delUserByOpenId(String openId) {
        return sqlClient.createDelete(userTable).where(userTable.openId().eq(openId)).execute();
    }

    public User queryUserByOpenId(String openId) {
        return sqlClient.createQuery(userTable)
                .where(userTable.openId().eq(openId))
                .select(userTable)
                .execute()
                .getFirst();
    }
}
