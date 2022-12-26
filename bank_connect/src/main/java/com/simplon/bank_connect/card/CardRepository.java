package com.simplon.bank_connect.card;

import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository
                    extends org.springframework.data.jpa.repository.JpaRepository<Card, Long> {

}
