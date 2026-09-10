
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char **strings; 
    int size;
    int capacity;
} StringArray;

void init(StringArray *arr) {
    arr->capacity = 0;
    arr->size = 0;
    arr->strings = NULL;
}

void push_back(StringArray *arr, char *str) {
    if(arr->capacity == arr->size) {
        int blud = arr->capacity * 2;
        char **temp = realloc(arr->strings, blud * sizeof(*(arr->strings)));
        if(temp == NULL) {
            printf("Fuck yourself");
            return;
        } else { 
            arr->capacity *= 2;
            arr->strings = temp;
            arr->strings[arr->size] = str;
            arr->size += 1;
        }
       
    } else {
        arr->strings[arr->size] = str;
        arr->size += 1;
    }
}

void freeMemory(StringArray *arr) {
    for(int i = 0; i < arr->size; i++) {
        free(arr->strings[i]);
    }
    free(arr->strings);
}


int main() {

    int capacity = 3;
    int size = 3;

    char** str = malloc(capacity * sizeof(char*));

    str[0] = "b";
    str[1] = "c";
    str[2] = "d";

    StringArray string = {str, size, capacity};

    char* nigger = "c";
    push_back(&string, nigger);
    push_back(&string, "blah");

    for(int i = 0; i < string.size; i++) {
        printf("%p \n", (string.strings)[i]);
    }

    freeMemory(&string);
}
