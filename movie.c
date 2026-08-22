#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Movie {
    char title[40];
    float rating;
} Movie;

Movie* addMovie(char* title, float rating, Movie*** catalog, int* movie_count) {

    Movie* new_movie = malloc(sizeof(Movie));
    if (new_movie == NULL) {
        printf("Memory allocation failed for new suit!\n");
        return NULL;
    }

    strcpy(new_movie->title, title);
    new_movie->rating = rating;
    (*movie_count)++;
    
    Movie** temp = realloc(*catalog, sizeof(Movie*) * (*movie_count));
    if (temp == NULL) {
    printf("Memory reallocation failed!\n");
    free(new_movie);
    (*movie_count)--;
    return NULL;
    }

    *catalog = temp;
    (*catalog)[(*movie_count) - 1] = new_movie;
    return new_movie;
}

void printCatalog(Movie** catalog, int* movie_count) {
    for(int i = 0; i < *movie_count; i++) {
        printf("title: %s, rating: %f\n", catalog[i]->title, catalog[i]->rating);
    }
}

void freeMemory(Movie** catalog, int* movie_count) {
    if(catalog == NULL) {
        return;
    }
    for(int i = 0; i < *movie_count; i++) {
        free(catalog[i]);
    }
    free(catalog);
}

int main() {
    Movie** catalog = NULL;
    int movie_count = 0;
    
    addMovie("Inception", 10.1, &catalog, &movie_count);
    addMovie("Interstellar", 100, &catalog, &movie_count);

    printCatalog(catalog, &movie_count);
    freeMemory(catalog, &movie_count);

    return 0;
}