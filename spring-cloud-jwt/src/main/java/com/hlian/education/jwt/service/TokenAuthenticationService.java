package com.hlian.education.jwt.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.hlian.education.util.JSONResult;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 1000;     //432_000_000 5天
    static final String SECRET = "P@ssw02d";            // JWT密码
    static final String TOKEN_PREFIX = "Bearer";        // Token前缀
    static final String HEADER_STRING = "Authorization";// 存放Token的Header Key

  // JWT生成方法  匹配/login地址
	public static void addAuthentication(HttpServletResponse response, String username,Collection<? extends GrantedAuthority> authorities) {

		//获取权限集合
    	 StringBuilder authoritiesStr = new StringBuilder() ;
    	 Iterator<? extends GrantedAuthority> iter = authorities.iterator();
    	 while(iter.hasNext()){
    	  authoritiesStr.append(iter.next().getAuthority());
    	  authoritiesStr.append(",");
    	 }
    	 
    	// 生成JWT
        String JWT = Jwts.builder()
                // 保存权限（角色）
                .claim("authorities", authoritiesStr.toString())
                // 用户名写入标题
                .setSubject(username)
                // 有效期设置
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                // 签名设置
                        .signWith(SignatureAlgorithm.HS512, SECRET)
                        .compact();

        // 将 JWT 写入 body
        try {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(JSONResult.fillResultString(0, "", JWT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

  // JWT验证方法
    public static Authentication getAuthentication(HttpServletRequest request) {
        // 从Header中拿到token
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // 解析 Token
            Claims claims = Jwts.parser()
                    // 验签
                    .setSigningKey(SECRET)
                    // 去掉 Bearer
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            // 拿用户名
            String user = claims.getSubject();

            // 得到 权限（角色）
            List<GrantedAuthority> authorities =  AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));
            
            // 返回验证令牌
            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
                    null;
        }
        return null;
    }
}