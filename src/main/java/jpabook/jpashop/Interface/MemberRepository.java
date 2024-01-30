package jpabook.jpashop.Interface;

import jpabook.jpashop.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByUserName(String username);
}
