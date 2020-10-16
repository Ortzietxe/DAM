//ejemploPuntero.c
#include <stdio.h>

int main(){
    //'*' apuntado por
    //'&' direccion de

    int a = 8, b = 3;//definimos dos variables enteras que se crearan en memoria
    int *dir_x, *dir_y;
    printf ("El valor de variable a es : %i\n ", a);
    printf ("El valor de variable b es : %i\n ", b);

    printf("La direccion de memoria de a:%p\n", &a);

    dir_x = &a;
    printf("El valor de dir_x:%p\n", dir_x);

    *dir_x = b + 2;
    printf ("El valor de variable a es : %i\n ", a);
    printf("El valor de dir_x:%p\n", dir_x);
    dir_y = dir_x;
    printf("El valor de dir_x:%p\n", dir_x);
    printf("El valor de dir_y:%p\n", dir_y);
    *dir_y = *dir_x + a;
    printf(a);*/
}
