cont = 0
lista = []
suma = 0
print("introduce 10 numeros al azar")

while(cont <= 9):
    num = int(input("introduce numero"))
    lista.insert(cont, num)
    cont = cont + 1
    #print(type(num))
    suma = suma + num
print(lista)

print("La suma de todos los numeros de la lista " + str(suma))


