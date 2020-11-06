import mysql.connector
import csv
import sqlite3


def crearBBDD(bbdd):
    if bbdd == 1:
        con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
        sqlFile = open('ficheros_csv_xml_sql/olimpiadas.sql', 'r')
        comodin = "%s"
    elif bbdd == 2:
        con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')
        sqlFile = open('ficheros_csv_xml_sql/olimpiadas.sqlite', 'r')
        comodin = "?"

    cursor = con.cursor()

    r = cursor.execute(sqlFile.read(), multi=True)
    for results in r:
        if results.with_rows:
            results.fetchall()
    con.commit()

    with open("ficheros_csv_xml_sql/athlete_events-sort.csv", "r") as csvBase:
        reader = csv.reader(csvBase)

        dicOlimpiadas = {}
        ai_olim = 1 #Autoincremental para la tabla olimpiadas
        id_olim = 0 #ID de la Olimpiada que estamos tratando

        dicDeportes = {}
        ai_depor = 1  # Autoincremental para la tabla Deportes
        id_depor = 0  # ID del Deporte que estamos tratando

        dicEventos = {}
        ai_event = 1  # Autoincremental para la tabla Eventos
        id_event = 0  # ID del evento que estamos tratando

        dicEquipos = {}
        ai_equipo = 1  # Autoincremental para la tabla Equipos
        id_equipo = 0  # ID del equipo que estamos tratando

        dicDeportistas = {}
        ai_deportista = 1  # Autoincremental para la tabla deportista
        id_deportista = 0  # ID del deportista que estamos tratando

        dicParticipacion = {}
        ai_participacion = 1  # Autoincremental para la tabla participacion
        id_participacion = 0  # ID de la participacion que estamos tratando

        for row in reader:
            ###########OLIMPIADAS###############
            if not row[8] in dicOlimpiadas:
                dicOlimpiadas[row[8]] = (ai_olim, row[8], row[9], row[10], row[11])
                id_olim = ai_olim
                ai_olim += 1
            id_olim = dicOlimpiadas[row[8]][0]

            ###########DEPORTES###############
            if not row[12] in dicDeportes:
                dicDeportes[row[12]] = (ai_depor, row[12])
                id_depor = ai_depor
                ai_depor += 1
            id_depor = dicDeportes[row[12]][0]

            ###########EVENTOS###############
            if not str(id_olim)+"-"+row[13] in dicEventos:
                dicEventos[str(id_olim)+"-"+row[13]] = (ai_event, row[13], id_olim, id_depor)
                id_event = ai_event
                ai_event += 1
            id_event = dicEventos[str(id_olim)+"-"+row[13]][0]

            ###########EQUIPOS###############
            if not row[6] in dicEquipos:
                dicEquipos[row[6]] = (ai_equipo, row[6], row[7])
                id_equipo = ai_equipo
                ai_equipo += 1
            id_equipo = dicEquipos[row[6]][0]

            ###########DEPORTISTAS###############
            if not row[0] in dicDeportistas:
                dicDeportistas[row[0]] = (row[0], row[1], row[2], row[4], row[5])
                id_deportista = [row[0]]
            id_deportista = dicDeportistas[row[0]][0]

            ###########PARTICIPACIONES###############
            if not str(id_deportista)+"-"+str(id_event) in dicParticipacion:
                if row[3] == "NA":
                    row[3] = None
                dicParticipacion[str(id_deportista)+"-"+str(id_event)] = (id_deportista, id_event, id_equipo, row[3], row[14])
                id_participacion = ai_participacion
                ai_participacion += 1
            id_deportista = dicParticipacion[str(id_deportista)+"-"+str(id_event)][0]


        list_olimpiadas = dicOlimpiadas.values()
        cmd = "INSERT INTO Olimpiada(id_olimpiada, nombre, anio, temporada, ciudad) VALUES("+comodin+", "+comodin+", "+comodin+", "+comodin+", "+comodin+")"
        cursor.executemany(cmd, list_olimpiadas)

        list_deportes = dicDeportes.values()
        cmd = "INSERT INTO Deporte(id_deporte, nombre) VALUES("+comodin+", "+comodin+")"
        cursor.executemany(cmd, list_deportes)

        list_eventos = dicEventos.values()
        cmd = "INSERT INTO Evento(id_evento, nombre, id_olimpiada, id_deporte) VALUES("+comodin+", "+comodin+", "+comodin+", "+comodin+")"
        cursor.executemany(cmd, list_eventos)

        list_equipos = dicEquipos.values()
        cmd = "INSERT INTO Equipo(id_equipo, nombre, iniciales) VALUES("+comodin+", "+comodin+", "+comodin+")"
        cursor.executemany(cmd, list_equipos)

        list_deportistas = dicDeportistas.values()
        cmd = "INSERT INTO Deportista(id_deportista, nombre, sexo, peso, altura) VALUES("+comodin+", "+comodin+", "+comodin+", "+comodin+", "+comodin+")"
        cursor.executemany(cmd, list_deportistas)

        list_participaciones = dicParticipacion.values()
        cmd = "INSERT INTO Participacion(id_deportista, id_evento, id_equipo, edad, medalla) VALUES("+comodin+", "+comodin+", "+comodin+", "+comodin+", "+comodin+")"
        cursor.executemany(cmd, list_participaciones)

    cursor.close()
    con.commit()
    con.close()


def ListadoDeportistasDeportes():
    bbdd= int(input("Selecciona la bbdd que deseas utilizar\n1.-BBDD MySQL\n2.-BBDD SQLite"))

    if bbdd == 1:
        con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
    elif bbdd == 2:
        con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')

    cursor = con.cursor()

    cmd = "SELECT D.nombre, D.sexo, D.peso, D.altura, S.nombre, P.edad, Ev.nombre, E.nombre, P.medalla FROM Deportista D, Participacion P, Deporte S, Evento Ev, Equipo E WHERE S.id_deporte = Ev.id_deporte AND Ev.id_evento= P.id_evento AND E.id_equipo=P.id_equipo AND P.id_deportista=D.id_deportista"
    cursor.execute(cmd)
    deportistas = cursor.fetchall()

    for deportista in deportistas:
        print(deportista)

def ListadoDeportistasParticipantes():
    pass

def salir():
    exit(0)

def mostrarMenu():
    opcion = int(input("Selecciona la accion que deseas realizar\n1.-Crear BBDD MySQL\n2.-Crear BBDD SQLite\n3.-Listado de deportistas en diferentes deportes\n4.-Listado de deportistas participantes\n5.Modificar medalla deportista\n6.-Añadir deportista/participación\n7.-Eliminar participación\n0.-Salir del programa"))

    if opcion == 1:
        crearBBDD(1)
    if opcion == 2:
        crearBBDD(2)
    if opcion == 3:
        ListadoDeportistasDeportes()
    if opcion == 4:
        ListadoDeportistasParticipantes()
    if opcion == 0:
        salir()


mostrarMenu()
