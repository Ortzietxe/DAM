import pickle

from xml.dom import minidom

class Olimpiada:
    def __init__(self, y, j, t, c):
        self.year = y
        self.juegos = j
        self.temporada = t
        self.ciudad = c

    def __str__(self):
        return ("Año: "+self.year+"; Juegos: "+self.juegos+"; Temporada: "+self.temporada+"; Ciudad: "+self.ciudad)

def generarFicheroSerializableOlimpiadas():
    #with open("Datos_Olimpiadas/olimpiadas.xml", "rb") as xmlBase:
        #object = pickle.load(objOlimpiada)
    doc = minidom.parse("Datos_Olimpiadas/olimpiadas.xml")
    olimpiadas = doc.getElementsByTagName("olimpiada")
    for datos in olimpiadas:
        year = datos.getAttribute("year")
        juegos = datos.getElementsByTagName("juegos")[0]
        temporada = datos.getElementsByTagName("temporada")[0]
        ciudad = datos.getElementsByTagName("ciudad")[0]
        #print("year:'", year,"'juegos:'", juegos.firstChild.data,"'temporada:'", temporada.firstChild.data,"'ciudad:'", ciudad.firstChild.data)
        objOlimpiada = Olimpiada(year, juegos.firstChild.data , temporada.firstChild.data, ciudad.firstChild.data)
        with open("Datos_Olimpiadas/olimpiadas.text", "ab") as ficheroPickle:
            pickle.dump(objOlimpiada, ficheroPickle)
    mostrarMenu()
def anadirEdicionOlimpica():
    year = input("introduce el año de la olimpiada")
    juegos = input("introduce el juego de la olimpiada")
    temporada = input("introduce la temporada de la olimpiada")
    ciudad = input("introduce la ciudad de la olimpiada")

    objOlimpiada ={year, juegos, temporada, ciudad}
    with open("Datos_Olimpiadas/olimpiadas.text", "ab") as ficheroPickle:
        pickle.dump(objOlimpiada, ficheroPickle)
    mostrarMenu()

def buscarOlimpiadasPorSede():
    ciudad = input("introduce la ciudad de la olimpiada")
    encontrado = False
    with open("Datos_Olimpiadas/olimpiadas.text", "rb") as ficheroPickle:
        try:
            while True:
                objOlimpiada = pickle.load(ficheroPickle)
                if ciudad.lower() in objOlimpiada.ciudad.lower():
                    print(objOlimpiada)
                    encontrado = True
        except(EOFError):
            pass
    if not encontrado:
        print("No existe ninguna olimpiada en el que el nombre de la sede contenga " + ciudad)
    mostrarMenu()

def eliminarEdicionOlimpica():
    temporada = input("introduce la temporada de la olimpiada , 'summer o winter'")

    encontrado = False

    with open("Datos_Olimpiadas/olimpiadas.text", "rb") as ficheroPickle:
        try:
            while True:
                objOlimpiada = pickle.load(ficheroPickle)
                if temporada.lower() in objOlimpiada.temporada.lower():
                    print(objOlimpiada)
                    encontrado = True
        except(EOFError):
            pass
    if not encontrado:
        print("No existe ninguna olimpiada en el que el nombre de la sede contenga " + ciudad)
    mostrarMenu()

def salir():
    exit(0)

def mostrarMenu():
    opcion = int(input("Selecciona la accion que deseas realizar\n1.-Crear fichero serializable de olimpiadas\n2.-Añadir edición olímpica\n3.-Buscar olimpiadas por sede\n4.-Eliminar edición olímpica \n5.-Salir del programa"))

    if opcion == 1:
        generarFicheroSerializableOlimpiadas()
    if opcion == 2:
        anadirEdicionOlimpica()
    if opcion == 3:
        buscarOlimpiadasPorSede()
    if opcion == 4:
        eliminarEdicionOlimpica()
    if opcion == 5:
        salir()

mostrarMenu()
