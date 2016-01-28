package chorustweet;

import java.security.SecureRandom;
import java.math.BigInteger;

public final class Nonce {
  private SecureRandom random = new SecureRandom();

  public String nextSessionId() {
    return new BigInteger(130, random).toString(32);
  }
}