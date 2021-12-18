package com.github.junbaor.jike

import com.github.junbaor.jike.client.JikeClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class JikeClientTest {
  @Test
  fun test() {
    val jike = JikeClient("+86", "1318881234", "password")
    val profile = jike.profile()
    Assertions.assertNotNull(profile)
  }
}
