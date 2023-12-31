package com.finalpj.backend.util;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtil {
    // application.properties에 사용된 값을 주입 받는다.
    @Value("${jwt.salt}")
    private  String salt;

    @Value("${jwt.expmin}")
    private  Long expireMin;

    public String createAuthToken(String user_id) {
    	System.out.println("ex:" + expireMin);
		return create(user_id, "authToken", expireMin);
	}
    /**
     * 로그인 성공 시 사용자 정보를 기반으로 JWTToken을 생성해서 반환한다.
     * JWT Token = Header + Payload + Signagure
     * 
     * @param email
     * @param subject
     * @param expireMin
     * @return
     */
    private String create(String user_id, String subject, long expireMin) {
        final JwtBuilder builder = Jwts.builder();
        
        // Header 설정
        //builder.setHeaderParam("typ", "JWT");// 토큰의 타입으로 고정 값
        // Payload 설정 - claim 정보 포함
        builder.setSubject(subject)// 토큰 제목 설정
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * expireMin));// 유효기간
        // 담고 싶은 정보 설정
        if (user_id != null) {
            builder.claim("user", user_id);
        }
    
        // signature - secret key를 이용한 암호화
        builder.signWith(SignatureAlgorithm.HS256, salt.getBytes());
        
        // 마지막 직렬화 처리
        final String jwt = builder.compact();
        log.debug("토큰 발행: {}", jwt);
        return jwt;
    }

    /**
     * jwt 토큰을 분석해서 필요한 정보를 반환한다.
     * 토큰에 문제가 있다면 Runtime 예외를 발생시킨다.
     * 
     * @param jwt
     * @return
     */
    public Map<String, Object> checkAndGetClaims(final String jwt) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(salt.getBytes()).parseClaimsJws(jwt);
        log.trace("claims: {}", claims);
        // Claims는 Map의 구현체이다.
        return claims.getBody();
    }
}