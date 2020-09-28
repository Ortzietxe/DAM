import os,shutil

def crearDirectorio():
    ruta = input("Introduce la ruta en la que quieres crear el directorio")
    directorio = input("Introduce el nombre del directorio")
    os.mkdir(ruta + "/" + directorio)

def listarDirectorio():
    ruta = input("Introduce la ruta de la que quieres listar el contenido")

    def ls(ruta=os.getcwd()):
        return [arch.name for arch in os.scandir(ruta) if arch.is_file()]

    print(ls(ruta))

def copiarArchivo():
    archivo = input("introduce el nombre del archivo que quieres copiar")
    ruta = input("introduce la ruta donde quieres copiar el archivo")
    shutil.copy(archivo, ruta + "/" + archivo)

def moverArchivo():
    archivo = input("introduce el nombre del archivo que quieres copiar")
    ruta = input("introduce la ruta donde quieres copiar el archivo")
    shutil.move(archivo, ruta + "/" + archivo)

def eliminarArchivoDirectorio():
    accion = int(input("Introduce '1' si lo que quieres borrar es un archivo y '2' si es una carpeta"))
    if accion == 1:
        archivo = input("introduce el nombre del archivo que quieres copiar")
        os.remove(archivo)
    if accion == 2:
        ruta = input("introduce la ruta donde quieres copiar el archivo")
        os.rmtree(ruta)

def salir():
    exit(0)


def mostrarMenu():
    opcion = int(input("Selecciona la accion que deseas realizar\n1.-Crear un directorio\n2.-Listar un directorio\n3.-Copiar un archivo\n4.-Mover un archivo\n5.-Eliminar un archivo/directorio\n6.-Salir del programa"))

    if opcion == 1:
        crearDirectorio()
    if opcion == 2:
        listarDirectorio()
    if opcion == 3:
        copiarArchivo()
    if opcion == 4:
        moverArchivo()
    if opcion == 5:
        eliminarArchivoDirectorio()
    if opcion == 6:
        salir()

mostrarMenu()
