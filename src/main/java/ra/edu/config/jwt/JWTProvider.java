package ra.edu.config.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
@Slf4j
public class JWTProvider {
    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.expired}")
    private long expired;
    // tạo token username
    public String generateToken(String username){
        Date now = new Date();
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime()+expired))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();
    }
    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
    // xác thực token
    public boolean validateToken(String token){
        try{
            Jwts.parserBuilder().setSigningKey(key()).build().parse(token);
            return true;
        }catch (MalformedJwtException e){
            log.error("Invalid token ",e.getMessage());
        }catch (ExpiredJwtException e){
            log.error("Expired token ",e.getMessage());
        }catch (UnsupportedJwtException e){
            log.error("Unsupported token ",e.getMessage());
        }catch (IllegalArgumentException e){
            log.error("Jwt key string invalid ",e.getMessage());
        }
        return false;
    }
    // giải mã token (username)
    public String getUsernameFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(token).getBody().getSubject();
    }

}
