cont = 0
lista = []
suma = 0
media = 0
maximo = 0
minimo = 0
print("introduce 10 numeros al azar")

while(cont <= 9):
    num = int(input("introduce numero"))
    if(cont == 0):
        maximo = num
        minimo = num
    if(num%2 != 0):
        lista.insert(cont, num)
        cont = cont + 1
        suma = suma + num
        if(num>maximo):
            maximo = num
        if(num<minimo):
            minimo = num
    #print(type(num))
print(lista)

def sumar():
    print("La suma de todos los numeros de la lista " + str(suma))
def sacarMedia():
    media = suma/10
    print("La media de todos los numeros de la lista " + str(media))
def sacarMaximo():
    print("El maximo de todos los numeros de la lista " + str(maximo))
def sacarMinimo():
    print("El minimo de todos los numeros de la lista " + str(minimo))
def exit():
    print("se acabo")
    exit(0)

opcion = int(input("Que desea hacer con la lista \n1.-Sumatorio \n2.-Media \n3.-Maximo \n4.-Minimo \n \n0.-Salir"))

if(opcion == 1):
    sumar()
if(opcion == 2):
    sacarMedia()
if(opcion == 3):
    sacarMaximo()
if(opcion == 4):
    sacarMinimo()
if(opcion == 0):
    exit()

