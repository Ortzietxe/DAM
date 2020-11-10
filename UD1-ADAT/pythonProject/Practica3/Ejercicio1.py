import mysql.connector
import csv
import sqlite3

#Funcion que crea la base de datos de olimpidas en sql si se pulsa 1 en el menu, y en sqlite si se pulsa 2 en el menu. Aparte tambien rellena las tablas en base al CSV
def crearBBDD(bbdd):
    if bbdd == 1:
        con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
        sqlFile = open('ficheros_csv_xml_sql/olimpiadas.sql', 'r')
        comodin = "%s"
        cursor = con.cursor()
        r = cursor.execute(sqlFile.read(), multi=True)
        for results in r:
            if results.with_rows:
                results.fetchall()

    elif bbdd == 2:
        con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')
        sqlFile = open('ficheros_csv_xml_sql/olimpiadas.sqlite.sql', 'r')
        comodin = "?"
        cursor = con.cursor()
        cursor.executescript(sqlFile.read())

    con.commit()

    with open("ficheros_csv_xml_sql/athlete_events.csv", "r") as csvBase:
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

    mostrarMenu()

#Funcion que lista los deportistas con todos sus datos y sus participaciones en eventos
def listadoDeportistasDeportes():
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

    cursor.close()
    con.commit()
    con.close()

    mostrarMenu()

#funcion que filtra deportistas en base a 5 filtros que pediremos como entrada de datos
def listadoDeportistasParticipantes():
    bbdd = int(input("Elige la BBDD que quieres utilizar\n\t1.-BBDD MySQL\n\t2.-BBDD SQLite"))
    temporada = input("Introduce la temporada en la que participo el deportista 'W/S'\n")

    if temporada.lower() == "w":
        temp = "Winter"

    if temporada.lower() == "s":
        temp = "Summer"

    if bbdd == 1:
        con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
        comodin = "%s"
    elif bbdd == 2:
        con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')
        comodin = "?"

    cursor = con.cursor()

    cmd = "SELECT id_olimpiada, nombre FROM Olimpiada WHERE temporada = " + comodin + ";"

    cursor.execute(cmd, (temp, ))
    olimpiadas = cursor.fetchall()

    for olimpiada in olimpiadas:
        print(olimpiada)

    ediOlim = input("Introduce el numero de id de la olimpiada en la que participo el deportista\n")

    cmd = "SELECT d.id_deporte, d.nombre FROM Deporte d, Evento e WHERE d.id_deporte = e.id_deporte AND e.id_olimpiada = " + comodin + ";"

    cursor.execute(cmd, (ediOlim,))
    deportes = cursor.fetchall()

    for deporte in deportes:
        print(deporte)

    idDeporte = input("Introduce el numero de id del deporte en el que participo el deportista\n")

    cmd = "SELECT o.temporada, o.nombre, s.nombre, ev.nombre, d.nombre, d.altura, d.peso, p.edad, e.nombre, p.medalla FROM Equipo e, Deporte s, Olimpiada o, Participacion p, Evento ev, Deportista d WHERE s.id_deporte = ev.id_deporte AND ev.id_evento = p.id_evento AND p.id_deportista = d.id_deportista AND p.id_equipo = e.id_equipo AND ev.id_olimpiada = " + comodin + " AND s.id_deporte = " + comodin + ";"

    cursor.execute(cmd, (ediOlim, idDeporte))
    participaciones = cursor.fetchall()

    for participacion in participaciones:
        print(participacion)

    cursor.close()
    con.commit()
    con.close()

    mostrarMenu()

def modificarMedallaDeportista():
    con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
    cursor = con.cursor()

    deportista = input("Introduce el nombre del deportista\n")

    cmd = "SELECT id_deportista, nombre FROM Deportista WHERE nombre LIKE %s;"

    cursor.execute(cmd, ("%"+deportista+"%",))
    deportistas = cursor.fetchall()

    for deportista in deportistas:
        print(deportista)

    idDeportista = input("Introduce el numero de id del deportista\n")

    cmd = "SELECT ev.id_evento, ev.nombre FROM Participacion p, Evento ev, Deportista d WHERE  ev.id_evento = p.id_evento AND p.id_deportista = d.id_deportista  AND d.id_deportista = %s;"

    cursor.execute(cmd, (idDeportista,))
    eventos = cursor.fetchall()

    for evento in eventos:
        print(evento)

    idEvento = input("Introduce el numero de id del evento del deportista al que quieres cambiar la medalla")
    medalla = input("Introduce la medalla que ha gano el deportista 'GOLD/SILVER/BRONZE\n")

    cmd = "UPDATE Participacion SET medalla = %s WHERE id_evento = %s AND id_deportista = %s;"
    cursor.execute(cmd, (medalla, idEvento, idDeportista))

    con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')
    cursor = con.cursor()
    cmd = "UPDATE Participacion SET medalla = ? WHERE id_evento = ? AND id_deportista = ?;"
    cursor.execute(cmd, (medalla, idEvento, idDeportista))

    cursor.close()
    con.commit()
    con.close()

    mostrarMenu()

#funcion para añadir una participacion y deportista
def anadirDeportistaoParticipacion():
    con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
    cursor = con.cursor()

    deportista = input("Introduce el nombre del deportista\n")

    cmd = "SELECT id_deportista, nombre FROM Deportista WHERE nombre LIKE %s;"

    cursor.execute(cmd, ("%" + deportista + "%",))
    deportistas = cursor.fetchall()

    if len(deportistas) == 0:
        print("El deportista buscado no existe rellena los datos para crearlo")

        nombre = input("Introduce el nombre completo del deportista")
        sexo = input("Introduce el sexo del deportista")
        peso = input("Introduce el peso del deportista")
        altura = input("Introduce la altura del deportista")

        cmd = "INSERT INTO Deportista(nombre, sexo, peso, altura) VALUES(%s, %s, %s, %s, %s);"
        cursor.execute(cmd, (nombre, sexo, peso, altura))
    else:
        for deportista in deportistas:
            print(deportista)

    idDeportista = input("Introduce el numero de id del deportista\n")

    temporada = input("Introduce la temporada en la que participo el deportista 'W/S'\n")

    if temporada.lower() == "w":
        temp = "Winter"

    if temporada.lower() == "s":
        temp = "Summer"

    cmd = "SELECT id_olimpiada, nombre FROM Olimpiada WHERE temporada = %s;"

    cursor.execute(cmd, (temp,))
    olimpiadas = cursor.fetchall()

    for olimpiada in olimpiadas:
        print(olimpiada)

    ediOlim = input("Introduce el numero de id de la olimpiada en la que participo el deportista\n")

    cmd = "SELECT d.id_deporte, d.nombre FROM Deporte d, Evento e WHERE d.id_deporte = e.id_deporte AND e.id_olimpiada = %s;"

    cursor.execute(cmd, (ediOlim,))
    deportes = cursor.fetchall()

    for deporte in deportes:
        print(deporte)

    idDeporte = input("Introduce el numero de id del deporte en el que participo el deportista\n")

    cmd = "SELECT id_evento, nombre FROM Evento WHERE id_deporte = %s AND id_olimpiada = %s;"

    cursor.execute(cmd, (idDeporte, ediOlim))
    eventos = cursor.fetchall()

    for evento in eventos:
        print(evento)

    idEvento = input("Introduce el numero de id del evento en el que participo el deportista\n")

    cmd = "SELECT * FROM Equipo;"

    cursor.execute(cmd)
    equipos = cursor.fetchall()

    for equipo in equipos:
        print(equipo)

    idEquipo = input("Introduce el numero de id del equipo en el que participo el deportista\n")

    edad = input("Introduce la edad que twnia el deportista cuando paricipo en el evento\n")

    medalla = input("Introduce la medalla que ha gano el deportista 'GOLD/SILVER/BRONZE\n")

    cmd = "INSERT INTO Participacion(id_deportista, id_evento, id_equipo, edad, medalla) VALUES(%s, %s, %s, %s, %s);"
    cursor.execute(cmd, (idDeportista, idEvento, idEquipo, edad, medalla))

    con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')
    cursor = con.cursor()
    cmd = "INSERT INTO Participacion(id_deportista, id_evento, id_equipo, edad, medalla) VALUES(?, ?, ?, ?, ?);"
    cursor.execute(cmd, (idDeportista, idEvento, idEquipo, edad, medalla))

    cursor.close()
    con.commit()
    con.close()

#Funcion para eliminar una participacion
def eliminarParticipacion():
    con = mysql.connector.connect(user='ortzi', password='1234', host='127.0.0.1', database="OLIMPIADAS")
    cursor = con.cursor()

    deportista = input("Introduce el nombre del deportista\n")

    cmd = "SELECT id_deportista, nombre FROM Deportista WHERE nombre LIKE %s;"

    cursor.execute(cmd, ("%" + deportista + "%",))
    deportistas = cursor.fetchall()

    for deportista in deportistas:
        print(deportista)

    idDeportista = input("Introduce el numero de id del deportista\n")

    cmd = "SELECT id_evento, nombre FROM Evento;"

    cursor.execute(cmd)
    eventos = cursor.fetchall()

    for evento in eventos:
        print(evento)

    idEvento = input("Introduce el numero de id del evento en el que participo el deportista\n")

    cmd = "DELETE FROM Participacion WHERE id_evento = %s AND id_deportista = %s;"
    cursor.execute(cmd, (idEvento, idDeportista))

    con = sqlite3.connect('ficheros_csv_xml_sql/olimpiadas.sqlite')
    cursor = con.cursor()
    cmd = "DELETE FROM Participacion WHERE id_evento = ? AND id_deportista = ?;"
    cursor.execute(cmd, (idEvento, idDeportista))

    cursor.close()
    con.commit()
    con.close()

def salir():
    exit(0)

def mostrarMenu():
    opcion = int(input("\nSelecciona la accion que deseas realizar\n\t1.-Crear BBDD MySQL\n\t2.-Crear BBDD SQLite\n\t3.-Listado de deportistas en diferentes deportes\n\t4.-Listado de deportistas participantes\n\t5.Modificar medalla deportista\n\t6.-Añadir deportista/participación\n\t7.-Eliminar participación\n\t0.-Salir del programa"))

    if opcion == 1:
        crearBBDD(1)
    if opcion == 2:
        crearBBDD(2)
    if opcion == 3:
        listadoDeportistasDeportes()
    if opcion == 4:
        listadoDeportistasParticipantes()
    if opcion == 5:
        modificarMedallaDeportista()
    if opcion == 6:
        anadirDeportistaoParticipacion()
    if opcion == 7:
        eliminarParticipacion()
    if opcion == 0:
        salir()


mostrarMenu()
