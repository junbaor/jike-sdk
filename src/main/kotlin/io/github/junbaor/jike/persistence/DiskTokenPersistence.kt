package io.github.junbaor.jike.persistence

import io.github.junbaor.jike.common.Constants
import io.github.junbaor.jike.model.Token
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.*

class DiskTokenPersistence(private val configFile: String) : TokenPersistence {

  private val properties: Properties = Properties()

  init {
    val file = File(configFile)
    val exists = file.exists()
    if (!exists) {
      file.createNewFile()
    }
    properties.load(FileInputStream(file))
  }

  override fun getToken(mobile: String): Token {
    val accessToken = properties.getProperty(Constants.ACCESS_TOKEN)
    val refreshToken = properties.getProperty(Constants.REFRESH_TOKEN)
    return Token(accessToken, refreshToken)
  }

  override fun setToken(mobile: String, token: Token) {
    properties.setProperty(Constants.ACCESS_TOKEN, token.accessToken)
    properties.setProperty(Constants.REFRESH_TOKEN, token.refreshToken)
    properties.store(FileOutputStream(configFile), null)
  }

}
