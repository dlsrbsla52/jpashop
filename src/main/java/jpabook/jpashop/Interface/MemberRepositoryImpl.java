package jpabook.jpashop.Interface;

import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import jpabook.jpashop.Entity.Member;
import jpabook.jpashop.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.config.*;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@EnableJpaRepositories
public interface MemberRepositoryImpl extends JpaRepository<Member, Long>, MemberRepositorCustom {

    Optional<Member> findById(Long id);

    Member save(Member member);

    void deleteById(Long id);

    List<Member> findByUserNameContains(@Param("username")String userName);

    Page<Member> findByUserNameContains(@Param("username")String userName, Pageable pageable);

//    @Query(name = "Member.SearchNameMemberTestTest")
    List<Member> findByUserName(@Param("userName") String userName);

//    @Query(name = "Member.SearchNameMemberTestTest")
//    List<Member> SearchNameMemberTestTest (@Param("userName") String username);

    @Query(value = "select * from Member AS M where username = :userName",
    nativeQuery = true )
    List<Member> findByUsernametest(@Param("userName") String userName);

    Product save(Product product);

    @Modifying
    @Query("update Product p set p.price = p.price * 1.1 where p.stockAmount < :stockAmount")
    int bulkPriceUp(@Param("stockAmount") Double stockAmount);

    //count 쿼리 사용
//    Page<Member> findByUserName(String name, Pageable pageable);

    //count 쿼리 사용 안함
    List<Member> findByUserName(String name, Pageable pageable);

    List<Member> findByUserName(String name, Sort sort);


    @QueryHints(value = {@QueryHint(name = "org.hibernate.redOnly",
            value = "true")},
    forCounting = true)
    Page<Member> findByUserNameHints(String username, Pageable pageable);

}
