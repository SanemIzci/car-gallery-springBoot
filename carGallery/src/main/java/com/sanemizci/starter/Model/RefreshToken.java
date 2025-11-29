package com.sanemizci.starter.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "refresh_token")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefreshToken extends BaseEntity {
    @Column(name = "refresh_token")
    private String refreshToken;
    @Column(name = "expire_date")
    private Date expireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

}
