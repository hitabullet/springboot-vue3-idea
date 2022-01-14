package com.end.project.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author root
 * @version 1.0
 * @description: TODO
 * @date 2021/12/9 15:48
 */
@Data
@Component
public class JWTUtils {

  @Value("${project.jwt.expire}")
  private  long expire;

  @Value("${project.jwt.secret}")

  private  String secret;
  @Value("${project.jwt.header}")
  private  String header;

  public String generateToken(String username) {
    // 设置过期时间
    Date date = new Date(System.currentTimeMillis() + expire);

    // 返回token字符串
    return Jwts.builder()
        .setHeaderParam("typ", "JWT")
        .setSubject(username) // 发证时间
        .setExpiration(date)
        .signWith(SignatureAlgorithm.HS512, secret)
        .compact();
  }

  public Claims getClaimsByToken(String jwt) {
    try {
      return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwt).getBody();
    } catch (Exception e) {
      return null;
    }
  }

  public boolean isTokenExpired(Claims claims) {
    return claims.getExpiration().before(new Date());
  }
}
