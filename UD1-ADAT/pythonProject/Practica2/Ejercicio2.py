import csv

# def crearcsv():
#     csvBase = open("Datos_Olimpiadas/athlete_events.csv")
#     reader = csv.reader(csvBase)

def generarFichero():
    with open("Datos_Olimpiadas/athlete_events.csv") as csvBase:
        reader = csv.reader(csvBase)

        with open("Datos_Olimpiadas/athlete_events.csv", "w") as csvDestino:
            writer = csv.writer(csvDestino)
            for row in reader:
                writer.writerow((row[8],row[9],row[10],row[11]))
            mostrarMenu()

def buscarNombreDeportista():
    with open("Datos_Olimpiadas/athlete_events.csv") as csvBase:
        reader = csv.reader(csvBase)

        nombre = input("Introduce el nombre del deportista que quieres buscar")
        for row in reader:
            if row[1].__contains__(nombre) :
                print(row)
            #else:
                #print("El nombre introducido no coincide con el de ningun deportista")
                #exit(0)
        mostrarMenu()


def buscarDeportistaPorOlimpiada():
    with open("Datos_Olimpiadas/athlete_events.csv") as csvBase:
        reader = csv.reader(csvBase)

        deporte = input("Introduce el deporte en el que participa el deportista que quieres buscar")
        ano = input("Introduce el año en el que participó el deportista que quieres buscar")
        temporada = input("Introduce la temporada en la que participó el deportista que quieres buscar")

        for row in reader:
            if row[12] == deporte and row[9] == ano and row[10] == temporada:
                print(row[1],row[8],row[9],row[12],row[13],row[14])
           # else:
                #print("El nombre introducido no coincide con el de ningun deportista")
               # exit(0)
        mostrarMenu()

def anadirDeportista():
    with open("Datos_Olimpiadas/athlete_events.csv") as csvBase:
        reader = csv.reader(csvBase)

        nombre = input("Introduce el nombre del deportista que quieres añadir")
        sexo = input("Introduce el sexo del deportista que quieres añadir")
        edad = input("Introduce la edad del deportista que quieres añadir")
        altura = input("Introduce la altura del deportista que quieres añadir")
        peso = input("Introduce el peso en el que participó el deportista que quieres añadir")
        equipo = input("Introduce el equipo del deportista que quieres añadir")
        noc = input("Introduce la noc del equipo del deportista que quieres añadir")
        juego = input("Introduce el juego en el que participó el deportista que quieres añadir")
        ano = input("Introduce el año en el que participó el deportista que quieres añadir")
        temporada = input("Introduce la temporada en la que participó el deportista que quieres añadir")
        ciudad = input("Introduce la ciudad del deportista que quieres añadir")
        deporte = input("Introduce el deporte en el que participó el deportista que quieres añadir")
        evento = input("Introduce el evento en el que participó el deportista que quieres añadir")
        medalla = input("Introduce la medallaque gano el deportista que quieres añadir")

        with open("Datos_Olimpiadas/athlete_events.csv", "a") as csvDestino:
            writer = csv.writer(csvDestino)

            writer.writerow(nombre + "," + sexo + "," + edad + "," + altura + "," + peso + "," + equipo + "," + noc + "," + juego + "," + ano + "," + temporada + "," + ciudad + "," + deporte + "," + evento + "," + medalla)

            mostrarMenu()

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