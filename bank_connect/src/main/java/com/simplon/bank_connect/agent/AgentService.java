package com.simplon.bank_connect.agent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {


    private final AgentRepository agentRepository;

    @Autowired
    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    // TODO: Add Agent methods here

    // getAgentById
    public Agent getAgentById(Long id) {
        return agentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Agent with id " + id + " does not exist"));
    }

   public Agent getAgentByEmail(String email) {
        return agentRepository.findAgentByEmail(email);
   }


}
