package com.sanemizci.starter.Repository;

import com.sanemizci.starter.Model.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,String> {
    Optional<RefreshToken> findRefreshTokenBy(String refreshToken);
}
