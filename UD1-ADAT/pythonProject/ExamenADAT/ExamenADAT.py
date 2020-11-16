import mysql.connector
con = mysql.connector.connect(user='ex2', password='adat', host='172.20.132.100', database="examen2")

#funcion para listar todos los alumnos
def listarAlumnos():
    cursor = con.cursor()

    cmd = "SELECT A.APENOM, N.NOTA, S.ABREVIATURA FROM ALUMNOS A, NOTAS N, ASIGNATURAS S WHERE A.DNI = N.DNI AND N.COD = S.COD;"

    cursor.execute(cmd)
    alumnos = cursor.fetchall()
    nom = ""
    for alumno in alumnos:
        if alumno[0] != nom:
            print("\n")
            print(alumno[0])
            print("------------------------------------------------------------------")
        print(alumno[2] + "        " + str(alumno[1]))
        nom = alumno[0]

    con.close()
    cursor.close()

    mostrarMenu()

#funcion para modificar el nombre de un alumno
def modificarNombre():
    cursor = con.cursor()

    cmd = "SELECT * FROM ALUMNOS;"

    cursor.execute(cmd)
    alumnos = cursor.fetchall()
    for alumno in alumnos:
        print(alumno)

    dni = input("escribe el dni del alumno que deseas modificar \n")

    cmd = "SELECT APENOM FROM ALUMNOS WHERE DNI = %s;"

    cursor.execute(cmd, (dni,))
    alumno = cursor.fetchone()
    print(alumno)

    nom = input("escribe el nuevo nombre para el alumno \n")

    if nom == "":
        cmd = "UPDATE ALUMNOS SET APENOM = %s WHERE DNI = %s"
        cursor.execute(cmd, (nom, dni))

        print("Alumno modificado correctamente")

    con.close()
    con.commit()
    cursor.close()

    mostrarMenu()

#funcion para modificar o añadir una modificacion
def modificarAñadirCalificacion():
    cursor = con.cursor()

    cmd = "SELECT * FROM ALUMNOS;"

    cursor.execute(cmd)
    alumnos = cursor.fetchall()
    for alumno in alumnos:
        print(alumno)

    dni = input("escribe el dni del alumno que deseas calificar \n")

    cmd = "SELECT APENOM FROM ALUMNOS WHERE DNI = %s;"

    cursor.execute(cmd, (dni,))
    alumno = cursor.fetchone()
    print(alumno[0])

    cmd = "SELECT * FROM ASIGNATURAS;"

    cursor.execute(cmd)
    asignaturas = cursor.fetchall()
    for asignatura in asignaturas:
        print(asignatura)

    cod = input("Escribe el codigo de la asignatura a evaluar \n")

    cmd = "SELECT * FROM NOTAS WHERE COD = %s AND dni = %s;"

    cursor.execute(cmd, (cod, dni))
    numNota = cursor.fetchone()

    nota = input("Escribe la nota del alumno \n")
    if numNota == None:
        cmd = "INSERT INTO NOTAS(DNI,COD,NOTA) VALUES(%s,%s,%s);"
        cursor.execute(cmd, (dni, cod, nota))

        print("La nota se ha añadido")
    else:
        cmd = "UPDATE NOTAS SET NOTA = %s WHERE COD = %s AND DNI = %s;"
        cursor.execute(cmd, (nota, cod, dni))

        print("La nota se ha modificado")

    con.close()
    con.commit()
    cursor.close()

    mostrarMenu()

#funcion para acceder a la funcion almacenada que se llama insertar
def funcionAlmacenada():
    cursor = con.cursor()

    cmd = "SELECT * FROM ALUMNOS;"

    cursor.execute(cmd)
    alumnos = cursor.fetchall()
    for alumno in alumnos:
        print(alumno)

    dni = input("escribe el dni del alumno que deseas calificar \n")

    cmd = "SELECT APENOM FROM ALUMNOS WHERE DNI = %s;"

    cursor.execute(cmd, (dni,))
    alumno = cursor.fetchone()
    print(alumno[0])

    cmd = "SELECT * FROM ASIGNATURAS;"

    cursor.execute(cmd)
    asignaturas = cursor.fetchall()
    for asignatura in asignaturas:
        print(asignatura)

    cod = input("Escribe el codigo de la asignatura a evaluar \n")

    cmd = "SELECT * FROM NOTAS WHERE COD = %s AND dni = %s;"

    cursor.execute(cmd, (cod, dni))

    nota = input("Escribe la nota del alumno \n")

    cmd = "USE insertar_nota;GO SET cod = %s, dni = %s, nota = %s;"
    cursor.execute(cmd, (cod,dni,nota))

    con.close()
    con.commit()
    cursor.close()
    mostrarMenu()


#funcion para salir de la aplicacion
def salir():
    exit(0)

#Menu en el cual elegiras la accion que quieres realizar
def mostrarMenu():
    opcion = int(input("\nSelecciona la accion que deseas realizar\n\t1.-Listar alumnos\n\t2.-Modificar nombre de almuno\n\t3.-Añadir o modificar calificacion\n\t4.-Usar funcion almacenada insertar\n\t0.-Salir del programa"))

    if opcion == 1:
        listarAlumnos()
    if opcion == 2:
        modificarNombre()
    if opcion == 3:
        modificarAñadirCalificacion()
    if opcion == 4:
        funcionAlmacenada()
    if opcion == 0:
        salir()

mostrarMenu()