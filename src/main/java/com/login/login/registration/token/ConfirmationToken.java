package com.login.login.registration.token;

import com.login.login.appuser.AppUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ConfirmationToken {
    @Id
    @SequenceGenerator(
            name="Token_sequence" ,
            sequenceName="Token_sequence",
            allocationSize=1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE ,
            generator ="Token_sequence")
    private Long id;
    @Column(nullable=false)
    private String token ;
    @Column(nullable=false)
    private LocalDateTime CreatedAt;
    @Column(nullable=false)
    private LocalDateTime expiredAt;

    private LocalDateTime confirmedAt;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "app_user_id"
    )
    private AppUser appUser;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiredAt, AppUser appUser) {
        this.token = token;
        CreatedAt = createdAt;
        this.expiredAt = expiredAt;
        this.confirmedAt = confirmedAt;
        this.appUser=appUser;
    }
}
