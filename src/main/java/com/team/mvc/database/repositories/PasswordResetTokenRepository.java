package com.team.mvc.database.repositories;

import com.team.mvc.database.entities.PasswordResetToken;
import com.team.mvc.database.entities.Persons;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.stream.Stream;


/**

 */
@Repository
@Transactional
public class PasswordResetTokenRepository extends AbstractRepository<PasswordResetToken>{
    public PasswordResetTokenRepository() {
        super(PasswordResetToken.class);
    }
/*
    PasswordResetToken findByToken(String token);

    PasswordResetToken findByUser(Persons persons);

    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);*/
}
