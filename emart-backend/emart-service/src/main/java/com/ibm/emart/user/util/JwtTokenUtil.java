package com.ibm.emart.user.util;

import com.ibm.emart.user.entity.EncryptBaseSecert;
import java.security.Key;
import java.util.Date;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {

  private static Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);

  public static final String AUTH_HEADER_KEY = "Authorization";

  public static final String TOKEN_PREFIX = "Bearer ";

  public static Claims parseJWT(String jsonWebToken, String base64Security) {
    try {
      Claims claims = Jwts.parser()
          .setSigningKey(DatatypeConverter.parseBase64Binary(base64Security))
          .parseClaimsJws(jsonWebToken).getBody();
      return claims;
    } catch (ExpiredJwtException e) {
      log.error("Overdue", e);
    } catch (Exception e) {
      log.error("Exception", e);
    }
    return null;
  }

  public static String createJWT(String userId, String username, String role, EncryptBaseSecert encryptBaseSecert) {
    try {
      SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
      long nowMillis = System.currentTimeMillis();
      Date now = new Date(nowMillis);
      byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(encryptBaseSecert.getBase64Secret());
      Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
      String encryId = Base64Util.encode(userId);
      JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
          .claim("role", role)
          .claim("userId", userId)
          .setSubject(username)
          .setIssuer(encryptBaseSecert.getClientId())
          .setIssuedAt(new Date())
          .setAudience(encryptBaseSecert.getName())
          .signWith(signatureAlgorithm, signingKey);
      int TTLMillis = encryptBaseSecert.getExpiresSecond();
      if (TTLMillis >= 0) {
        long expMillis = nowMillis + TTLMillis;
        Date exp = new Date(expMillis);
        builder.setExpiration(exp)
            .setNotBefore(now);
      }
      return builder.compact();
    } catch (Exception e) {
      log.error("Exception", e);
    }
    return null;
  }

  public static String getUsername(String token, String base64Security) {
    return parseJWT(token, base64Security).getSubject();
  }

  public static String getUserId(String token, String base64Security) {
    String userId = parseJWT(token, base64Security).get("userId", String.class);
    return Base64Util.decode(userId);
  }

  public static boolean isExpiration(String token, String base64Security) {
    return parseJWT(token, base64Security).getExpiration().before(new Date());
  }
}
