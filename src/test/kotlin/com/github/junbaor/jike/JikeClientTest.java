package com.github.junbaor.jike;

import com.github.junbaor.jike.client.JikeClient;
import com.github.junbaor.jike.model.ProfileResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class JikeClientTest {

  @Test
  public void test() {
    JikeClient jike = new JikeClient("+86", "1318881234", "password");
    ProfileResponse profile = jike.profile();
    Assertions.assertNotNull(profile);
  }

}
