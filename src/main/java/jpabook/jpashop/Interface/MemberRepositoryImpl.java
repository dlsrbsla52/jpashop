package jpabook.jpashop.Interface;

import jakarta.transaction.Transactional;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@EnableJpaRepositories
public interface MemberRepositoryImpl extends JpaRepository<Member, Long> {
//    Optional<Member> findByUserName(String userName);

    Optional<Member> findById(Long id);

    Member save(Member member);

    void deleteById(Long id);

    List<Member> findByUserNameContains(@Param("username")String username);
//    Member findAllBy

    @Query(name = "Member.SearchNameMemberTestTest")
    List<Member> findByUsername(@Param("username") String username);

//    @Query(name = "Member.SearchNameMemberTestTest")
//    List<Member> SearchNameMemberTestTest (@Param("userName") String username);

}
