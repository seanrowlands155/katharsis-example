package com.sean.katharsis;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.sean.katharsis.client.GreetingClient;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringKatharsisApplicationTest {

  @Autowired
  GreetingClient greetingClient;

  @Test
  public void testFindOne() {
    Assertions.assertThat(greetingClient.findOne(1L).getContent()).isEqualTo("Hello World!");
  }
}
