package com.example.passbatch.repository.booking;

import com.example.passbatch.repository.BaseEntity;
import com.example.passbatch.repository.pass.PassEntity;
import com.example.passbatch.repository.user.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "booking")
public class BookingEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingSeq;

    private Integer passSeq;

    private String userId;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    private boolean usedPass;

    private boolean attended;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    private LocalDateTime cancelledAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    @ToString.Exclude
    private UserEntity userEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passSeq", insertable = false, updatable = false)
    @ToString.Exclude
    private PassEntity passEntity;

    public LocalDateTime getStatisticsAt() {
        return this.endedAt.withHour(0).withMinute(0).withSecond(0).withNano(0);
    }
}
