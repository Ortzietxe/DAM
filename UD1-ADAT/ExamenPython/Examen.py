import csv
import xml
import pickle
import lxml.etree as ET
import xml.sax
from xml.dom import minidom

#clase paara crear objetos del tipo batalla
class Batalla:
    def __init__(self, id, nombre, anio, region, localizacion, rey_atacante, rey_defensor, gana_atacante):
        self.id = id
        self.nombre = nombre
        self.anio = anio
        self.region = region
        self.localizacion = localizacion
        self.rey_atacante = rey_atacante
        self.rey_defensor = rey_defensor
        self.gana_atacante = gana_atacante

    def __str__(self):
        return ("The " + self.nombre + " took place in " + self.localizacion + " in the year " + self.anio + ". The king(s) " + self.rey_atacante + " fought against " + self.rey_defensor + " and he/they " + self.gana_atacante)

#funcion para buscar y mostrar todas las batallas mediante la region introducida
def buscarBatalla():
    encontrado = False
    with open("Datos/battles.csv") as csvBase:
        reader = csv.reader(csvBase)

        region = input("Introduce la region en la que sucedio la batalla que quieres buscar: ")
        for row in reader:
            if row[23].lower().__contains__(region.lower()):
                print("\t" + row[23] + "," + row[22] + "," + row[0] + "," + row[1] + "," + row[3] + "," + row[4] + "," + row[13])
                encontrado = True

        if not encontrado:
            print("\tNo existe ninguna batalla en el que el nombre de la region contenga " + region)
        mostrarMenu()

#funcion que crea el XML de batallas
def crearXMLBatallas():
    with open("Datos/battles.csv") as csvBase:
        reader = csv.reader(csvBase)
        document = ET.Element("juego_tronos")
        for row in reader:
            batalla = ET.SubElement(document, "batalla", id=row[2])

            ET.SubElement(batalla, "nombre").text = row[0]
            ET.SubElement(batalla, "anio").text = row[1]
            ET.SubElement(batalla, "region").text = row[23]

            if row[22] == "":
                ET.SubElement(batalla, "localizacion").text = "no place"
            else:
                ET.SubElement(batalla, "localizacion").text = row[22]

            ataque = ET.SubElement(batalla, "ataque", tamanio=row[17], gana=row[13])

            if row[3] == "":
                ET.SubElement(ataque, "rey").text = "no king"
            else:
                ET.SubElement(ataque, "rey").text = row[3]

            ET.SubElement(ataque, "comandante").text = row[19]
            ET.SubElement(ataque, "familia").text = row[5]

            if row[6] != "":
                ET.SubElement(ataque, "familia").text = row[6]

            if row[7] != "":
                ET.SubElement(ataque, "familia").text = row[7]

            if row[8] != "":
                ET.SubElement(ataque, "familia").text = row[8]

            defensa = ET.SubElement(batalla, "defensa", tamanio=row[18], gana=row[13])

            if row[3] == "":
                ET.SubElement(defensa, "rey").text = "no king"
            else:
                ET.SubElement(defensa, "rey").text = row[4]

            ET.SubElement(defensa, "comandante").text = row[20]
            ET.SubElement(defensa, "familia").text = row[9]

            if row[6] != "":
                ET.SubElement(defensa, "familia").text = row[10]

            if row[7] != "":
                ET.SubElement(defensa, "familia").text = row[11]

            if row[8] != "":
                ET.SubElement(defensa, "familia").text = row[12]

        with open("Datos/batallas.xml", "wb") as xmlDestino:
            #tree = ET.ElementTree(document)
            xmlDestino.write(ET.tostring(document, pretty_print=True, xml_declaration=True, encoding='UTF-8'))

#funcion que genera el fichero binario
def crearFicheroPickle():
    doc = minidom.parse("Datos/batallas.xml")
    olimpiadas = doc.getElementsByTagName("batalla")
    for datos in olimpiadas:
        id = datos.getAttribute("id")
        print(id)
        nombre = datos.getElementsByTagName("nombre")[0].firstChild.data
        anio = datos.getElementsByTagName("anio")[0].firstChild.data
        region = datos.getElementsByTagName("region")[0].firstChild.data
        localizacion = datos.getElementsByTagName("localizacion")[0].firstChild.data

        ataque = datos.getElementsByTagName("ataque")
        for infoataque in ataque:
            ganador = infoataque.getAttribute("gana")
            if ganador == "win":
                gana_atacante ="S"
            else:
                gana_atacante = "N"

            rey_atacante = infoataque.getElementsByTagName("rey")[0].firstChild.data

        defensa = datos.getElementsByTagName("defensa")
        for infodefensa in defensa:
            print("Hola")
            rey_defensor = infodefensa.getElementsByTagName("rey")[0].firstChild.data

        objBatalla = Batalla(id, nombre, anio, region, localizacion, rey_atacante, rey_defensor, gana_atacante)
        with open("Datos/batallas.text", "ab") as ficheroPickle:
            pickle.dump(objBatalla, ficheroPickle)
    mostrarMenu()

def eliminarBatalla():
    lista = []
    id = input("introduce el identificador de la batalla")
    encontrado = False

    with open("Datos/batallas.text", "rb") as ficheroPickle:
        try:
            while True:
                objBatalla = pickle.load(ficheroPickle)
                if id == objBatalla.id:
                    print(str(objBatalla))
                    confirmar = input("es esta la batalla que quieres borrar[SI/NO]").lower()
                    if confirmar == "no":
                        lista.append(objBatalla)
                    encontrado = True
                else:
                    lista.append(objBatalla)
        except(EOFError):
            pass

    if not encontrado:
        print("No existe ninguna batalla con el identificador" + id)

    with open("Datos/batallas.text", "wb") as ficheroPickle:
        pickle.dump("", ficheroPickle)

    with open("Datos/batallas.text", "ab") as ficheroPickle:
        for batallas in lista:
            pickle.dump(batallas, ficheroPickle)

    mostrarMenu()

def salir():
    exit(0)

def mostrarMenu():
    opcion = int(input("\nSelecciona la accion que deseas realizar\n1.-Buscar batalla por region\n2.-Crear XML batallas\n3.-Crear fichero binario de objetos\n4.-Eliminar batallas del fichero binario de objetos\n\n0.-Salir del programa"))

    if opcion == 1:
        buscarBatalla()
    if opcion == 2:
        crearXMLBatallas()
    if opcion == 3:
        crearFicheroPickle()
    if opcion == 4:
        eliminarBatalla()
    if opcion == 0:
        salir()

mostrarMenu()
