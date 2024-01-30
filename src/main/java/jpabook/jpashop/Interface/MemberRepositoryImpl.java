package jpabook.jpashop.Interface;

import jakarta.transaction.Transactional;
import jpabook.jpashop.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

@Service
@EnableJpaRepositories
@Transactional
public interface MemberRepositoryImpl extends JpaRepository<Member, Long> {
    Member findByUserName(String userName);
}
