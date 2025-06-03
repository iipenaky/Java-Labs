import random
def guess_game(seed: int) -> None:
    random.seed(5)
    print("""Welcome to the guessing Game!
    I'm thinking of a number between 1 and 100. Can you guess it?: 
    """)

    number = random.randint(1, 100)
    attempts = 0  

    while True:
        guess = int(input("Guess: "))
        attempts += 1  

        if guess < number:
            print("Good try, but that's too low. Try again.")
        elif guess > number:
            print("Good try, but that's too high. Try again.")
        else:
            if attempts == 1:
                print("Yes! You guessed correctly after", attempts, "try! Congratulations.")
                break
            else:
                print("Yes! You guessed correctly after", attempts, "tries! Congratulations.")
            
            break
        
guess_game(5)
