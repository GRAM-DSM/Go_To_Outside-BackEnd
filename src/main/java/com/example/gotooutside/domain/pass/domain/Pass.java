package com.example.gotooutside.domain.pass.domain;

import com.example.gotooutside.domain.pass.domain.types.PermitStatus;
import com.example.gotooutside.domain.user.domain.User;
import com.example.gotooutside.global.entity.BaseTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Pass extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(length = 15)
    private String permitter;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PermitStatus permitStatus;

    @Builder
    public Pass(User user, String reason, String outingTime, String incomingTime, String permitter, PermitStatus permitStatus) {
        this.user = user;
        this.reason = reason;
        this.outingTime = outingTime;
        this.incomingTime = incomingTime;
        this.permitter = permitter;
        this.permitStatus = permitStatus;
    }

    public void permit(String incomingTime, String permitter) {
        this.incomingTime = incomingTime;
        this.permitter = permitter;
        this.permitStatus = PermitStatus.PERMIT;
    }

    public void unPermit() {
        this.permitStatus = PermitStatus.UNPERMIT;
    }
}
