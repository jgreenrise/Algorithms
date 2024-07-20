import random

class DeckOfCards:
    def __init__(self):
        suits = ["Diamonds", "Clubs", "Hearts", "Spades"]
        ranks = ["King", "Queen", "Jack", "Ten", "Nine", "Eight", "Seven", "Six", "Five", "Four", "Three", "Deuce", "Ace"]
        self.deck_of_cards = [self.Pair(s, r) for s in suits for r in ranks]

    def show_cards(self):
        print("---------------------------------------------")
        for card in self.deck_of_cards:
            print(f"{card.u} of {card.v}")
        print("---------------------------------------------")

    def shuffle(self):
        for i in range(52):
            random1 = random.randint(0, 51)
            random2 = random.randint(0, 51)
            print("*******Random range:", random1, ",", random2)
            self.swap(random1, random2)

    def swap(self, left_idx, right_idx):
        self.deck_of_cards[left_idx], self.deck_of_cards[right_idx] = self.deck_of_cards[right_idx], self.deck_of_cards[left_idx]

    class Pair:
        def __init__(self, u, v):
            self.u = u
            self.v = v

if __name__ == "__main__":
    cards = DeckOfCards()
    cards.show_cards()

    print("**********************\nShuffling cards")
    cards.shuffle()
    cards.show_cards()