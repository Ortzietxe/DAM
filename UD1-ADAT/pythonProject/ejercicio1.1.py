#con while

cont = 0
lista = []

print("introduce 10 numeros al azar")

while(cont <= 9):
    num = input("introduce numero")
    lista.insert(cont, num)
    cont = cont + 1
    continue
print(lista)

