#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Suit {
    char suit_name[30];
    int web_fluid;
    struct Suit* next;
} Suit;


Suit* create_suit(char* suit_name, int web_fluid, Suit*** head, int* number_of_suits) {

    Suit* new_suit = malloc(sizeof(Suit));
    if (new_suit == NULL) {
        printf("Memory allocation failed for new suit!\n");
        return NULL;
    }

    strcpy(new_suit->suit_name, suit_name);
    new_suit->web_fluid = web_fluid;

    (*number_of_suits)++;
    Suit** temp = realloc(*head, sizeof(Suit*) * (*number_of_suits));
    if (temp == NULL) {
        printf("Memory allocation failed!\n");
        return NULL;
    }
    *head = temp;

    (*head)[*number_of_suits - 1] = new_suit;
    return new_suit;
}

void printCatalog(Suit** head, int* number_of_suits) {
    for(int i = 0; i < *number_of_suits; i++) {
        printf("Suit name: %s, Web fluid: %i\n", (head)[i]->suit_name, (head)[i]->web_fluid);
    }
}

void freeMemory(Suit** head, int* number_of_suits) {
    if(head == NULL) {
        return;
    }
    for (int i = 0; i < *number_of_suits; i++) {
        free(head[i]);
    }
    free(head);
}

int main() {
    int number_of_suits = 0;
    Suit** head = NULL;
    
    char* suit_name_1 = "Spider-Man";
    char* suit_name_2 = "Iron Man";
    
    create_suit(suit_name_1, 20, &head, &number_of_suits);
    create_suit(suit_name_2, 25, &head, &number_of_suits);

    printCatalog(head, &number_of_suits);
    freeMemory(head, &number_of_suits);

    return 0;
}
