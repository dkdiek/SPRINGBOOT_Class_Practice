package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//extends JpaRepositroy를 하면 스프링에 interface 구현체를 자동으로 만들어 스프링 빈에 만들어 놓기 때문에 인젝션 받아 쓸 수 있음
public interface SpringDataMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    //JPQL로 변환해준다 select m from Member m where m.name =?
    //규칙 findBy and 등
    @Override
    Optional<Member> findByName(String name);

}
