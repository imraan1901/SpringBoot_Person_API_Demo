package com.demo.person.hobby;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class HobbyRepositoryTest {

    @Autowired
    private HobbyRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void TestFindHobbyByNameExists() {
        // given
        Hobby hobby = new Hobby(
                "running"
        );

        // when
        underTest.save(hobby);

        // then
        assert(underTest.findHobbyBy("running").get().getName().equals("running"));

    }


}