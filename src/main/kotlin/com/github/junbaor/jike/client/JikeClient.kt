package com.github.junbaor.jike.client;

import com.github.junbaor.jike.api.JikeApi;
import com.github.junbaor.jike.api.JikeApiFactory;
import com.github.junbaor.jike.exception.NoLoginException;
import com.github.junbaor.jike.model.PasswordLoginRequest;
import com.github.junbaor.jike.model.ProfileResponse;
import com.github.junbaor.jike.persistence.DiskTokenPersistence;
import com.github.junbaor.jike.persistence.TokenPersistence;

public class JikeClient {

  public final String areaCode;
  public final String mobile;
  private final String password;
  public final TokenPersistence tokenStore;

  public final JikeApi jikeApi;

  public JikeClient(String areaCode, String mobile, String password) {
    this(areaCode, mobile, password, new DiskTokenPersistence(System.getProperty("user.home") + "/.jike/" + mobile + ".ini"));
  }

  public JikeClient(String areaCode, String mobile, String password, TokenPersistence tokenStore) {
    this.areaCode = areaCode;
    this.mobile = mobile;
    this.password = password;
    this.tokenStore = tokenStore;
    jikeApi = JikeApiFactory.Companion.create(this);

    init();
  }

  public void init() {
    try {
      this.jikeApi.profile();
    } catch (NoLoginException e) {
      PasswordLoginRequest request = new PasswordLoginRequest(areaCode, mobile, password);
      this.jikeApi.loginWithPhoneAndPassword(request);
      this.jikeApi.profile();
    }
  }

  public ProfileResponse profile() {
    return jikeApi.profile();
  }

}
