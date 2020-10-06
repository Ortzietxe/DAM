def mostrarMenu():
    opcion = int(input("Selecciona la accion que deseas realizar\n1.-Crear fichero serializable de olimpiadas\n2.-Añadir edición olímpica\n3.-Buscar olimpiadas por sede\n4.-Eliminar edición olímpica \n5.-Salir del programa"))

    if opcion == 1:
        generarFicheroSerializableOlimpiadas()
    if opcion == 2:
        anadirEdicionOlimpica()
    if opcion == 3:
        listadoOlimpiadas()
    if opcion == 5:
        salir()

mostrarMenu()
