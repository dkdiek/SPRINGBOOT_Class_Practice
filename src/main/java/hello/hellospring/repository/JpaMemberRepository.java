package hello.hellospring.repository;


import hello.hellospring.domain.Member;
import jakarta.persistence.EntityManager;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //JPA쓰려면 em을 주입받아야된다

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }


    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        //PK 기반이 아닌건 JPQL 작성 위에 id는 PK name은 PK가아님
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //Member entity를 조회해 alias m, m은 객체 자체 JPQL
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
