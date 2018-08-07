package com.airy.saltedfish.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Airy on 2018/8/6
 */

public class TokenUtil {
    private TokenUtil(){}

    private static final String SECRET = "salted-fish-power-by-airy";

    public static String createToken(int uid) throws UnsupportedEncodingException {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR,999999); // 过期时间
        Date expireDate = calendar.getTime();
        Map<String,Object> map = new HashMap<>(4);
        map.put("alg","HS256");
        map.put("type","JWT");
        try {
            return JWT.create()
                    .withHeader(map)
                    .withClaim("uid",uid)
                    .withIssuedAt(date)
                    .withExpiresAt(expireDate)
                    .sign(Algorithm.HMAC256(SECRET));
        }catch (UnsupportedEncodingException e){
            throw new UnsupportedEncodingException("Token create failed");
        }
    }

    public static String createTokenSimply(int uid) {
        return "" + uid;
    }

    public static boolean verifyTokenSimply(String token){
        return true;
    }

    public static Map<String, Claim> verifyToken(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            return verifier.verify(token).getClaims();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean isCloseToExpire(Map<String,Claim> claims){
        Long exp = claims.get("exp").asDate().getTime();
        Long now = System.currentTimeMillis();
        int diff = 300000;
        return exp - now <= diff;
    }


}
