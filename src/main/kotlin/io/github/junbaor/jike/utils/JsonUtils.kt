package io.github.junbaor.jike.utils

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule

object JsonUtils {

  private val mapper = default
  private val default: ObjectMapper
    get() {
      val mapper = ObjectMapper()
      mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL)
      mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
      mapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true)
      mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
      mapper.registerModule(KotlinModule())
      return mapper
    }

  fun <T> asObject(json: String?, tClass: Class<T>?): T {
    return try {
      mapper.readValue(json, tClass)
    } catch (e: JsonProcessingException) {
      throw RuntimeException(e)
    }
  }

  fun toJson(`object`: Any?): String {
    return try {
      mapper.writeValueAsString(`object`)
    } catch (e: JsonProcessingException) {
      throw RuntimeException(e)
    }
  }
}
