#include <iostream>

typedef struct {
    int *data;      
    int size;         
    int capacity;      
} DynamicArray;

void init(DynamicArray *arr) {
    arr->size = 0;
    arr->data = NULL;
    arr->capacity = 0;
}

void push_back(DynamicArray *arr, int value) {
    if(arr->capacity == arr->size) {
        int *temp = (int*)realloc(arr->data, arr->capacity * 2);
        
        if(temp == NULL) {
            printf("Kill yourself");
            return;
        }  

        arr->capacity *= 2;
        arr->data = temp;
        (arr->data)[arr->size] = value;
        arr->size += 1;

    } else {
        (arr->data)[arr->size] = value;
        arr->size = arr->size + 1;
    }
}



void free_array(DynamicArray *arr) {

    free(arr->data);
};


int main() {

    int capacity = 4;

    int* data = (int*) malloc(sizeof(int) * capacity);

    for(int i = 0; i < 4; i++) {
        data[i] = i * 10;
    } 

    int size = 4;
    DynamicArray array = {data, size, capacity};
    DynamicArray *arrayPtr = &array;

    
    for(int i = 0; i < array.size; i++) {
        printf("data is %d \n", data[i]);
        printf("size is %d \n", array.size);
        printf("capacity is %d \n", array.capacity);
        if(i >= 3 && i < 6) {
            push_back(arrayPtr, 6);
        }
    } 

    free_array(arrayPtr);

    return 0;
    
}




