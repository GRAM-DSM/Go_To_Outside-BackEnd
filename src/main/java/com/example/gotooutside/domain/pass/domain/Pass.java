package com.example.gotooutside.domain.pass.domain;

import com.example.gotooutside.domain.user.domain.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Pass {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pass")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 300, nullable = false)
    private String reason;

    @Column(length = 5, nullable = false)
    private String outingTime;

    @Column(length = 5, nullable = false)
    private String incomingTime;

    @Column(nullable = false)
    private boolean permitStatus;

    @Builder
    public Pass(User user, String reason, String outingTime, String incomingTime, boolean permitStatus) {
        this.user = user;
        this.reason = reason;
        this.outingTime = outingTime;
        this.incomingTime = incomingTime;
        this.permitStatus = permitStatus;
    }
}
