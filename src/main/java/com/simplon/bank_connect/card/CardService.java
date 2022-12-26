package com.simplon.bank_connect.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {


    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }

    public Card getCardByCardNumber(String cardNumber) {
        return cardRepository.findByNumeroCarte(cardNumber);
    }

    public boolean isCardExist(String cardNumber) {
        return cardRepository.existsByNumeroCarte(cardNumber);
    }
}
