package hello.hellospring.domain;

import jakarta.persistence.*;

@Entity //JPA와 DB와 매칭
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //id는 pk, DB가 값 알아서 생성 identity
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
