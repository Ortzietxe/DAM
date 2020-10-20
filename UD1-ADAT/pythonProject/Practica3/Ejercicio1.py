import mysql.connector
import csv


def crearBBDDMySQL():
    con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")

    cursor = con.cursor()

    id = 0

    with open()
    with open("ficheros_csv_xml_sql/athlete_events-sort.csv", "r") as csvBase:
        reader = csv.reader(csvBase)
        for row in reader:
            if id != row[0]:
                id = row[0]
                if row[4] == "NA":
                    row[4] = 0
                if row[5] == "NA":
                    row[5] = 0
                #cursor.execute("INSERT INTO Deportista(id_deportista, nombre, sexo, peso, altura) VALUES(" + row[0] + ",'" + row[1] + "','" + row[2] + "'," + row[4] + "," + row[5] + ");")
                cmd = "INSERT INTO Deportista(id_deportista, nombre, sexo, peso, altura) VALUES(%s , %s, %s, %s, %s)"
                cursor.execute(cmd, (row[0], row[1], row[2], row[4], row[5]))
    con.commit()
    con.close()


def mostrarMenu():
    opcion = int(input(
        "Selecciona la accion que deseas realizar\n1.-Crear BBDD MySQL\n2.-Crear BBDD SQLite\n3.-Listado de deportistas en diferentes deportes\n4.-Listado de deportistas participantes \n5.-Salir del programa"))

    if opcion == 1:
        crearBBDDMySQL()
    # if opcion == 2:
    #    crearBBDDSQLite()
    # if opcion == 3:
    #    ListadoDeportistasDeportes()
    # if opcion == 4:
    #    ListadoDeportistasParticipantes()
    # if opcion == 5:
    #    salir()


mostrarMenu()
