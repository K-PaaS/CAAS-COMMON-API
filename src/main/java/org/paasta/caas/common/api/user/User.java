package org.paasta.caas.common.api.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.paasta.caas.common.api.common.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * User Model 클래스
 *
 * @author REX
 * @version 1.0
 * @since 2018.08.02
 */
@Entity
@Table(name = "user")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "user_id", nullable = false)
    @NotNull(message = "USER ID cannot be null")
    @NotEmpty(message = "USER ID is mandatory")
    private String userId;

    @Column(name = "role_name", nullable = false)
    @NotNull(message = "ROLE NAME cannot be null")
    @NotEmpty(message = "ROLE NAME is mandatory")
    private String roleName;

    @Column(name = "role_set_code", nullable = false)
    @NotNull(message = "ROLE CODE cannot be null")
    @NotEmpty(message = "ROLE CODE is mandatory")
    private String roleSetCode;

    /*@Column(name = "role_description", nullable = false)
    private String roleDescription;*/

    @Column(name = "namespace", nullable = false)
    @NotNull(message = "NAMESPACE cannot be null")
    @NotEmpty(message = "NAMESPACE is mandatory")
    private String namespace;

    @Column(name = "description")
    private String description;

    @Column(name = "created", nullable = false, updatable = false)
    private String created;

    @Column(name = "last_modified", nullable = false)
    private String lastModified;

    @Transient
    private String resultCode;

    @Transient
    private String resultMessage;

    @PrePersist
    void preInsert() {
        if (this.created == null) {
            this.created = LocalDateTime.now(ZoneId.of(Constants.STRING_TIME_ZONE_ID)).format(DateTimeFormatter.ofPattern(Constants.STRING_DATE_TYPE));
        }

        if (this.lastModified == null) {
            this.lastModified = LocalDateTime.now(ZoneId.of(Constants.STRING_TIME_ZONE_ID)).format(DateTimeFormatter.ofPattern(Constants.STRING_DATE_TYPE));
        }
    }

    @PreUpdate
    void preUpdate() {
        if (this.lastModified == null) {
            this.lastModified = LocalDateTime.now(ZoneId.of(Constants.STRING_TIME_ZONE_ID)).format(DateTimeFormatter.ofPattern(Constants.STRING_DATE_TYPE));
        }
    }
}
