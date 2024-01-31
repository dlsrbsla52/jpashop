package jpabook.jpashop.Interface;

import jakarta.persistence.QueryHint;
import jakarta.transaction.Transactional;
import jpabook.jpashop.Entity.Member;
import jpabook.jpashop.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface MemberRepositorCustom {

    public List<Member> findMemberCustom();

}
