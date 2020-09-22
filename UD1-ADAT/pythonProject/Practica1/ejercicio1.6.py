class criptografo:
    def __init__(self):
        pass

    def encriptar(self):
        texto = input("introduce un texto")
        palabraEncriptada = "";
        for letra in texto:
            numEncriptado = int(ord(letra)) + 1
            letraEncriptada = chr(numEncriptado)
            palabraEncriptada = palabraEncriptada + letraEncriptada

        print(palabraEncriptada)

    def desencriptar(self):
        texto = input("introduce un texto")

        palabraEncriptada = "";
        for letra in texto:
            numEncriptado = int(ord(letra)) - 1
            letraEncriptada = chr(numEncriptado)
            palabraEncriptada = palabraEncriptada + letraEncriptada

        print(palabraEncriptada)


opcion = int(input("Que desea hacer con el texto introducido \n 1.-Encriptar \n 2.-Desencriptar"))
cr = criptografo()
if opcion == 1:
    cr.encriptar()
if opcion == 2:
    cr.desencriptar()
