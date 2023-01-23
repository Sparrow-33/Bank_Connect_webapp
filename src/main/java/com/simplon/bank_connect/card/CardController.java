package com.simplon.bank_connect.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cards")
public class CardController {


    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }


    @GetMapping("/all")
    public Iterable<Card> getAllCards() {
        return cardService.getAllCards();
    }

    @PostMapping("/add")
    public Card saveCard(Card card) {
        return cardService.saveCard(card);
    }

    @GetMapping("/find")
    public Card getCardByCardNumber(@RequestBody String cardNumber) {
        return cardService.getCardByCardNumber(cardNumber);
    }


}
