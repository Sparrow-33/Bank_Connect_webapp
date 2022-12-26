package com.simplon.bank_connect.agent;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

   Agent findAgentByEmail(String email);
}
