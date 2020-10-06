import csv
import lxml.etree as ET
import xml.sax


class OlimpiadasHandler(xml.sax.ContentHandler):
    def __init__(self):
        xml.sax.ContentHandler.__init__(self)
        self.year = ""
        self.games = ""
        self.CurrentData = ""

    def startElement(self, tag, attrs):
        self.CurrentData = tag
        if tag == "olimpiada":
            print("*****Olimpiada*****")
            print("Año: "+ attrs.getValue("year"))


    def endElement(self, tag):
        if self.CurrentData == "juegos":
            print("Juegos:", self.games)


    def characters(self, content):
        if self.CurrentData == "juegos":
            self.games = content

def generarFicheroOlimpiadas():
    with open("Datos_Olimpiadas/olimpiadas.csv") as csvBase:
        reader = csv.reader(csvBase)
        document = ET.Element("olimpiadas")
        for row in reader:
            #print(row)
            node = ET.SubElement(document, "olimpiada", year=row[1])

            ET.SubElement(node, "juegos").text = row[0]
            ET.SubElement(node, "temporada").text = row[2]
            ET.SubElement(node, "ciudad").text = row[3]

        with open("Datos_Olimpiadas/olimpiadas.xml", "wb") as xmlDestino:
            #tree = ET.ElementTree(document)
            xmlDestino.write(ET.tostring(document, pretty_print=True, xml_declaration=True, encoding='UTF-8'))

def generarFicheroDeportistas():
    with open("Datos_Olimpiadas/athlete_eventscorto.csv") as csvBase:
        reader = csv.reader(csvBase)
        document = ET.Element("deportistas")
        id = 0;
        for row in reader:
            # print(row)
            if id != row[0]:
                node = ET.SubElement(document, "deportista", id=row[0])
                id = str(row[0])
                ET.SubElement(node, "nombre").text = row[1]
                ET.SubElement(node, "sexo").text = row[2]
                ET.SubElement(node, "altura").text = row[4]
                ET.SubElement(node, "peso").text = row[5]


            node2 = ET.SubElement(node, "participaciones")
            node3 = ET.SubElement(node2, "deporte", nombre=row[12])
            ET.SubElement(node3, "edad", edad=row[3])


            ET.SubElement(node3, "equipo").text = row[6]
            ET.SubElement(node3, "juegos").text = row[8]
            ET.SubElement(node3, "evento").text = row[13]
            ET.SubElement(node3, "medalla").text = row[14]

            with open("Datos_Olimpiadas/deportistas.xml", "wb") as xmlDestino:
                xmlDestino.write(ET.tostring(document, pretty_print=True, xml_declaration=True, encoding='UTF-8'))


def listadoOlimpiadas():
    #parser = xml.sax.make_parser()
    #parser.setFeature(xml.sax.handler.feature_namespaces, 0)
    #Handler = OlimpiadasHandler()
    #parser.setContentHandler(Handler)
    file = open("Datos_Olimpiadas/olimpiadas.xml", "rb")
    xml.sax.parse(file, OlimpiadasHandler())

def salir():
    exit(0)

def mostrarMenu():
    opcion = int(input("Selecciona la accion que deseas realizar\n1.-Crear fichero olimpiadas\n2.-Crear fichero deportistas\n3.-Listar olimpiadas\n4.-Salir del programa"))

    if opcion == 1:
        generarFicheroOlimpiadas()
    if opcion == 2:
        generarFicheroDeportistas()
    if opcion == 3:
        listadoOlimpiadas()
    if opcion == 5:
        salir()

mostrarMenu()
