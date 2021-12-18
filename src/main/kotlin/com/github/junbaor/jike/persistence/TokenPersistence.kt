package com.github.junbaor.jike.persistence

import com.github.junbaor.jike.model.Token

interface TokenPersistence {
  fun getToken(mobile: String): Token
  fun setToken(mobile: String, token: Token)
}
