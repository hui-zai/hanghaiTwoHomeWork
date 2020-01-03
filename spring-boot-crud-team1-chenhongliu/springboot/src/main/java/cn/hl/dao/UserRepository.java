package cn.hl.dao;

import cn.hl.bean.User;
import org.hibernate.jpa.event.internal.core.JpaSaveEventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
