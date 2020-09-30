import csv
import sys

csvBase = open("Datos_Olimpiadas/athlete_events.csv")
reader = csv.reader(csvBase)

def generarFichero():
    csvDestino= open("Datos_Olimpiadas/olimpiadas.csv", "w")
    writer = csv.writer(csvDestino)
    for row in reader:
        writer.writerow(row[8],row[9],row[10],row[11])
        print(row[8],row[9],row[10],row[11])

def buscarNombreDeportista():
    nombre = input("Introduce el nombre del deportista que quieres buscar")
    for row in reader:
        if row[1] == nombre:
            print(row)
        else:
            print("El nombre introducido no coincide con el de ningun deportista")
            exit(0)


def buscarDeportistaPorOlimpiada():
    deporte = input("Introduce el deporte en el que participa el deportista que quieres buscar")
    ano = input("Introduce el año en el que participó el deportista que quieres buscar")
    temporada = input("Introduce la temporada en la que participó el deportista que quieres buscar")

    for row in reader:
        if row[8] == deporte & row[9] == ano & row[10] == temporada:
            print(row[1],row[8],row[9],row[12],row[13],row[14])
        else:
            print("El nobuscarDeportistaPorOlimpiadambre introducido no coincide con el de ningun deportista")
            exit(0)

def anadirDeportista():
    pass

def salir():
    exit(0)

def mostrarMenu():
    opcion = int(input("Selecciona la accion que deseas realizar\n1.-Crear fichero olimpiadas\n2.-Listar un directorio\n3.-Copiar un archivo\n4.-Mover un archivo\n5.-Eliminar un archivo/directorio\n6.-Salir del programa"))

    if opcion == 1:
        generarFichero()
    if opcion == 2:
        buscarNombreDeportista()
    if opcion == 3:
        buscarDeportistaPorOlimpiada()
    if opcion == 4:
        anadirDeportista()
    if opcion == 5:
        salir()

mostrarMenu()